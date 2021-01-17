package springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvc.entity.Empleado;
import springmvc.entity.Nomina;
import springmvc.repository.EmpleadoRepository;

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
    	
    	Empleado empleado = optionalEmpleado.get();
    	
        return empleado;
    }

    @Override
    @Transactional
    public Nomina traerSueldo(String dni) {

        return empleadoRepository.getNomina(dni);
    }

    @Override
    @Transactional
    public List<Empleado> listarEmpleados() {

        return empleadoRepository.findAll();
    }

    @Override
    @Transactional
    public void guardarEmpleado(Empleado empleado) {

    	empleadoRepository.save(empleado);
    }

    @Override
    @Transactional
    public void eliminarEmpleado(int id) {

    	empleadoRepository.deleteById(id);;
    }
}
