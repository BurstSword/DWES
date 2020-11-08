package springmvc.service;

import springmvc.entity.Empleado;

import java.util.List;

public interface EmpleadoService {

    public Empleado recogerEmpleado(int id);
    public int recogerSueldo(String dni);
    public List<Empleado> listaEmpleado();
    public void guardarEmpleado (Empleado empleado);
    public void eliminarEmpleado(int id);
}
