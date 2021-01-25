package com.nominas.nominas.service;




import com.nominas.nominas.entity.Empleado;
import com.nominas.nominas.entity.Nomina;

import java.util.List;

public interface EmpleadoService {

    Empleado traerEmpleado(int id);
    Nomina traerSueldo(String dni);
    List<Empleado> listarEmpleados();
    boolean guardarEmpleado(Empleado empleado);
    boolean eliminarEmpleado(int id);
}
