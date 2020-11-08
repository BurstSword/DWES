package springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springmvc.service.EmpleadoService;

@Controller
@RequestMapping("/controlador")
public class Controlador {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/paginaPrincipal")
    public String paginaPrincipal(){

        return "pagina-principal";
    }
}
