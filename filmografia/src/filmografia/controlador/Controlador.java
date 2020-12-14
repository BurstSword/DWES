package filmografia.controlador;

import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import filmografia.entidades.*;
import filmografia.servicio.*;

@Controller
@RequestMapping("/controlador")
public class Controlador {
	
	private HttpSession sesion;
	private List<Director> directores = new ArrayList<Director>();
	@Autowired
	private ServicioPelicula servicioPeliculas;

	

	@Autowired
	private ServicioAdmin servicioAdmin;

	@GetMapping("/paginaPrincipal")
	public String paginaPrincipal(Model model,HttpServletRequest request) {

		sesion=request.getSession();
		

		return "paginaPrincipal";
	}

	@GetMapping("/lista")
	public String listaPeliculas(@RequestParam("director") String director, Model model,HttpServletRequest request) {
		List<Pelicula> peliculas = servicioPeliculas.buscarPeliculaPorDirector(director);
		sesion.setAttribute("directores", directores);
		
		if (!peliculas.isEmpty()) {
			model.addAttribute("peliculas", peliculas);
			Director director2 = new Director(peliculas.get(0).getDirector());
			directores.add(director2);
			sesion.setAttribute("directores", directores);
		} else {
			return "paginaError";
		}

		return "/lista";

	}

	@GetMapping("/formulario")
	public String crearPelicula(Model model) {

		Pelicula pelicula = new Pelicula();

		model.addAttribute("pelicula", pelicula);

		return "formulario";
	}

	@GetMapping("/actualizar")
	public String actualizarPelicula(@RequestParam("id") int id, Model model) {

		Pelicula pelicula = servicioPeliculas.pedirPelicula(id);

		model.addAttribute("pelicula", pelicula);

		return "formulario";
	}

	@PostMapping("/guardarPelicula")
	public String guardar(@ModelAttribute("pelicula") Pelicula pelicula) {
		boolean existe = false;
		List<Pelicula> peliculas = servicioPeliculas.listarPeliculas();

		for (Pelicula pelicula2 : peliculas) {
			if (pelicula2.getId() == pelicula.getId()) {
				existe = true;
			}
		}
		if (existe == true) {
			servicioPeliculas.guardarPelicula(pelicula);
		} else {
			Pelicula peliculaNueva = new Pelicula();

			peliculaNueva.setDirector(pelicula.getDirector());
			peliculaNueva.setFecha(pelicula.getFecha());
			peliculaNueva.setTitulo(pelicula.getTitulo());
			servicioPeliculas.guardarPelicula(peliculaNueva);
		}

		return "redirect:/controlador/paginaPrincipal";
	}

	@GetMapping("/eliminar")
	public String eliminarEmpleado(@RequestParam("id") int id) {

		servicioPeliculas.borrarPelicula(id);

		return "redirect:/controlador/paginaPrincipal";
	}

	@GetMapping("/info")
	public String irAInfo() {

		return "info";
	}

	@GetMapping("/listaDirectoresConsultados")
	public String listaDirectores(Model model) {
		
		return "listaDirectores";
	}

	@GetMapping("/login")
	public String irLogin(Model model) {

		return "login";
	}

	@GetMapping("/logger")
	public String log(@RequestParam("nombre") String nombre, @RequestParam("pass") String pass,HttpServletRequest request) {
		sesion=request.getSession();
		
		
		List<Admin> admins = servicioAdmin.listarAdmins();
		for (int i = 0; i < admins.size(); i++) {

			if (admins.get(i).getNombre().equals(nombre) && admins.get(i).getPass().equals(pass)) {
				
				sesion.setAttribute("logged", true);
			}
		}

		
		return "redirect:/controlador/paginaPrincipal";
	}

	@GetMapping("/listarPeliculasAdmin")
	public String listarPelis(Model model) {
		List<Pelicula> peliculas = servicioPeliculas.listarPeliculas();
		model.addAttribute("peliculas", peliculas);
		return "listaPeliculas";
	}

	@GetMapping("/nuevoAdmin")
	public String nuevoAdmin(Model model) {

		Admin admin = new Admin();
		model.addAttribute("admin", admin);

		return "formularioAdmin";
	}

	@PostMapping("/insertarAdmin")
	public String insertarAdmin(@ModelAttribute("admin") Admin admin) {

		servicioAdmin.introducirAdmin(admin);

		return "redirect:/controlador/paginaPrincipal";
	}

	@GetMapping("/logout")
	public String Logout(Model model,HttpServletRequest request) {
		sesion=request.getSession();
		sesion.setAttribute("logged", false);
		sesion.invalidate();
		return "redirect:/controlador/paginaPrincipal";
	}
}
