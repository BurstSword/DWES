package com.nominas.nominas.service;

import com.nominas.nominas.entity.Empleado;
import com.nominas.nominas.entity.Nomina;
import com.nominas.nominas.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    @Transactional
    public Empleado traerEmpleado(int id) {
    	Optional <Empleado> optionalEmpleado = empleadoRepository.findById(id);

    	if(optionalEmpleado.isPresent()){
            return optionalEmpleado.get();
        }else{
            return null;
        }

    }

    @Override
    @Transactional
    public Nomina traerSueldo(String dni) {

        return empleadoRepository.getNomina(dni);
    }

    @Override
    @Transactional
    public List<Empleado> listarEmpleados() {

        return (List<Empleado>) empleadoRepository.findAll();
    }

    @Override
    @Transactional
    public boolean guardarEmpleado(Empleado empleado) {
        boolean status = false;
        try {
            empleadoRepository.save(empleado);
            status =true;
        }catch (Exception e){
                e.printStackTrace();
        }
    	return status;
    }

    @Override
    @Transactional
    public boolean eliminarEmpleado(int id) {
        boolean status = false;
        try {
            empleadoRepository.deleteById(id);
            status =true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;

    }
}
