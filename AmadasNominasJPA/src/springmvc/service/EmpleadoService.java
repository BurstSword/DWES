package springmvc.service;

import springmvc.entity.Empleado;
import springmvc.entity.Nomina;

import java.util.List;
import java.util.Optional;

public interface EmpleadoService {

    public Empleado traerEmpleado(int id);
    public Nomina traerSueldo(String dni);
    public List<Empleado> listarEmpleados();
    public void guardarEmpleado(Empleado empleado);
    public void eliminarEmpleado(int id);
}