package service;


import entity.Empleado;
import entity.Nomina;

import java.util.List;

public interface EmpleadoService {

    public Empleado traerEmpleado(int id);
    public Nomina traerSueldo(String dni);
    public List<Empleado> listarEmpleados();
    public void guardarEmpleado(Empleado empleado);
    public void eliminarEmpleado(int id);
}
