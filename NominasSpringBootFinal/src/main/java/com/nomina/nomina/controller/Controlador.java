package com.nomina.nomina.controller;


import com.nomina.nomina.entity.Empleado;
import com.nomina.nomina.entity.Nomina;
import com.nomina.nomina.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/controlador")
public class Controlador {

	@Autowired
	private EmpleadoService empleadoService;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

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
	public String guardar(@Valid @ModelAttribute("empleado") Empleado empleado, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {

			model.addAttribute("empleado", empleado);

			return "formulario";

		} else {

			int sueldo;

			if (empleado.getNomina().getDni() == null || empleado.getNomina().getDni().isEmpty()) {

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
	}

	@GetMapping("/actualizar")
	public String recogerEmpleado(@RequestParam("id") int id, Model model) {
		Empleado empleado = empleadoService.traerEmpleado(id);

		model.addAttribute("empleado", empleado);

		return "formulario";
	}

	@GetMapping("/eliminar")
	public String eliminarEmpleado(@RequestParam("id") int id) {

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
