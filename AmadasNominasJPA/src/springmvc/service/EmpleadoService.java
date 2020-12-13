package springmvc.service;

import springmvc.entity.Empleado;
import springmvc.entity.Nomina;

import java.util.List;
import java.util.Optional;

public interface EmpleadoService {

    public Empleado recogerEmpleado(int id);
    public Nomina recogerSueldo(String dni);
    public List<Empleado> listaEmpleados();
    public void guardarEmpleado(Empleado empleado);
    public void eliminarEmpleado(int id);
}
