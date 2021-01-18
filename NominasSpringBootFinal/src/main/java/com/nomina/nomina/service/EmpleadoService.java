package com.nomina.nomina.service;




import com.nomina.nomina.entity.Empleado;
import com.nomina.nomina.entity.Nomina;

import java.util.List;

public interface EmpleadoService {

    Empleado traerEmpleado(int id);
    Nomina traerSueldo(String dni);
    List<Empleado> listarEmpleados();
    void guardarEmpleado(Empleado empleado);
    void eliminarEmpleado(int id);
}
