package springmvc.service;

import springmvc.entity.Pelicula;
import springmvc.entity.Nomina;

import java.util.List;
import java.util.Optional;

public interface EmpleadoService {

    public Pelicula traerEmpleado(int id);
    public Nomina traerSueldo(String dni);
    public List<Pelicula> listaEmpleados();
    public void guardarEmpleado(Pelicula empleado);
    public void eliminarEmpleado(int id);
}
