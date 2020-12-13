package springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springmvc.entity.Pelicula;
import springmvc.service.PeliculaService;

@Controller
@RequestMapping("/controlador")
public class Controlador {

	@Autowired
	private PeliculaService peliculaService;

	@GetMapping("/paginaPrincipal")
	public String paginaPrincipal() {

		return "pagina-principal";
	}
	
	@GetMapping("/lista")
	public String listaPeliculas(Model model) {

		List<Pelicula> peliculas = peliculaService.listarPeliculas();

		model.addAttribute("peliculas", peliculas);

		return "lista-peliculas";
	}
}
