package com.nominas.nominas.controller;


import com.nominas.nominas.entity.Empleado;
import com.nominas.nominas.entity.Nomina;
import com.nominas.nominas.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/controlador")
public class Controlador {

	@Autowired
	private EmpleadoService empleadoService;


	@GetMapping("lista")
	public List<Empleado> listaEmpleados() {

		 return empleadoService.listarEmpleados();
	}


	@PostMapping("/guardarEmpleado")
	public boolean guardar(@Valid @RequestBody Empleado empleado,BindingResult bindingResult) {

		if(bindingResult.hasErrors()){
			return false;
		}else{
			return empleadoService.guardarEmpleado(empleado);
		}

	}

	@GetMapping("traerEmpleado/{id}")
	public Empleado recogerEmpleado(@PathVariable("id") int id) {

		 return empleadoService.traerEmpleado(id);
	}

	@GetMapping("/eliminar/{id}")
	public boolean eliminarEmpleado(@PathVariable("id") int id) {

		return empleadoService.eliminarEmpleado(id);
	}

	@PostMapping("/sueldo")
	public Nomina pruebaEmpleado(@RequestParam String dni) {

		return empleadoService.traerSueldo(dni);


	}
}
