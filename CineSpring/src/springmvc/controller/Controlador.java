package springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.entity.Pelicula;
import springmvc.entity.Nomina;
import springmvc.service.EmpleadoService;

@Controller
@RequestMapping("/controlador")
public class Controlador {

	@Autowired
	private EmpleadoService empleadoService;

	@GetMapping("/paginaPrincipal")
	public String paginaPrincipal() {

		return "pagina-principal";
	}

	@GetMapping("/lista")
	public String listaEmpleados(Model model) {

		List<Pelicula> empleados = empleadoService.listaEmpleados();

		model.addAttribute("empleados", empleados);

		return "lista-empleados";
	}

	@GetMapping("/formulario")
	public String formulario(Model model) {

		Pelicula empleado = new Pelicula();

		model.addAttribute("empleado", empleado);

		return "formulario";
	}

	@PostMapping("/guardarEmpleado")
	public String guardar(@ModelAttribute("empleado") Pelicula empleado) {

		int sueldo;

		if (empleado.getNomina().getDni().isEmpty()) {
			Nomina nomina = new Nomina();

			sueldo = nomina.sueldo(empleado.getCategoria(), empleado.getAntiguedad());

			nomina.setDni(empleado.getDni());
			nomina.setSueldo(sueldo);

			empleado.setNomina(nomina);
			empleadoService.guardarEmpleado(empleado);

		} else {
			sueldo = empleado.getNomina().sueldo(empleado.getCategoria(), empleado.getAntiguedad());
			empleado.getNomina().setId(empleado.getId());
			empleado.getNomina().setSueldo(sueldo);
			empleadoService.guardarEmpleado(empleado);
		}

		return "redirect:/controlador/lista";
	}

	@GetMapping("/actualizar")
	public String recogerEmpleado(@RequestParam("empleadoId") int id, Model model) {

		Pelicula empleado = empleadoService.traerEmpleado(id);

		model.addAttribute("empleado", empleado);

		return "formulario";
	}

	@GetMapping("/eliminar")
	public String eliminarEmpleado(@RequestParam("empleadoId") int id) {

		empleadoService.eliminarEmpleado(id);

		return "redirect:/controlador/lista";
	}

	@PostMapping("/sueldo")
	public String pruebaEmpleado(@RequestParam("dni") String dni, Model model) {

		Nomina nomina = empleadoService.traerSueldo(dni);

		model.addAttribute("nombre", nomina.getEmpleado().getNombre());
		model.addAttribute("sueldo", nomina.getSueldo());

		return "pagina-principal";
	}
}
