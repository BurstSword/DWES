package controller;

import java.util.List;

import entity.Empleado;
import entity.Nomina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import service.EmpleadoService;

@Controller
public class Controlador {

	@Autowired
	private EmpleadoService empleadoService;

	@GetMapping("/index")
	public String Index() {

		return "pagina-principal";
	}

	@GetMapping("/paginaPrincipal")
	public String paginaPrincipal() {

		return "pagina-principal";
	}

	@GetMapping("/lista")
	public String listaEmpleados(Model model) {

		List<Empleado> empleados = empleadoService.listarEmpleados();

		model.addAttribute("empleados", empleados);

		return "lista-empleados";
	}

	@GetMapping("/formulario")
	public String formulario(Model model) {

		Empleado empleado = new Empleado();

		model.addAttribute("empleado", empleado);

		return "formulario";
	}

	@PostMapping("/guardarEmpleado")
	public String guardar(@ModelAttribute("empleado") Empleado empleado) {

		int sueldo;

		if (empleado.getNomina().getDni()==null|| empleado.getNomina().getDni().isEmpty()) {
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

		Empleado empleado = empleadoService.traerEmpleado(id);

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

		if(nomina!=null) {
			model.addAttribute("nombre", nomina.getEmpleado().getNombre());
			model.addAttribute("sueldo", nomina.getSueldo());
		}else {
			return "error";
		}

		return "pagina-principal";
	}
}
