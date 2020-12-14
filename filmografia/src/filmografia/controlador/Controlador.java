package filmografia.controlador;


import java.util.List;

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
	boolean logged=false;
	
	@Autowired
	private ServicioPelicula servicioPeliculas;
	
	@Autowired
	private ServicioDirectores servicioDirectores;
	
	@Autowired
	private ServicioAdmin servicioAdmin;
	
	@GetMapping("/paginaPrincipal")
	public String paginaPrincipal(Model model) {

		
			model.addAttribute("logged", logged);
		
		
		return "paginaPrincipal";
	}
	
	@GetMapping("/lista")
	public String listaPeliculas(@RequestParam("director") String director, Model model) {
		List<Pelicula> peliculas = servicioPeliculas.buscarPeliculaPorDirector(director);
		
			if(!peliculas.isEmpty()) {
				model.addAttribute("peliculas", peliculas);
				Director directorCine = new Director(director);
				servicioDirectores.guardarDirector(directorCine);
			}else {
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

		Pelicula peliculaNueva = new Pelicula();
			
			peliculaNueva.setDirector(pelicula.getDirector());
			peliculaNueva.setFecha(pelicula.getFecha());
			peliculaNueva.setTitulo(pelicula.getTitulo());
			servicioPeliculas.guardarPelicula(peliculaNueva);

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
	public String listaDirectores (Model model) {
		List<Director> directores = servicioDirectores.listarDirectores();
		
		model.addAttribute("directores", directores);
		return "listaDirectores";
	}
	
	@GetMapping("/login")
	public String irLogin(Model model) {
	
		
		return "login";
	}
	@GetMapping("/logger")
	public String log(@RequestParam("nombre") String nombre,@RequestParam("pass") String pass) {
		
		System.out.println(nombre);
		System.out.println(pass);
		List<Admin> admins = servicioAdmin.listarAdmins();
		for (int i = 0; i < admins.size(); i++) {
			System.out.println(admins.get(0).getNombre());
			if(admins.get(i).getNombre().equals(nombre) && admins.get(i).getPass().equals(pass)) {
				logged = true;
			}
		}
			
		
		return "redirect:/controlador/paginaPrincipal";
	}
	
}
