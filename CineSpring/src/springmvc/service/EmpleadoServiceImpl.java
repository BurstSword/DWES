package springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvc.entity.Pelicula;
import springmvc.entity.Nomina;
import springmvc.repository.CineRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

    @Autowired
    private CineRepository empleadoRepository;

    @Override
    @Transactional
    public Pelicula traerEmpleado(int id) {
    	Optional <Pelicula> optionalEmpleado = empleadoRepository.findById(id);
    	
    	Pelicula empleado = optionalEmpleado.get();
    	
        return empleado;
    }

    @Override
    @Transactional
    public Nomina traerSueldo(String dni) {

        return empleadoRepository.getNomina(dni);
    }

    @Override
    @Transactional
    public List<Pelicula> listaEmpleados() {

        return empleadoRepository.findAll();
    }

    @Override
    @Transactional
    public void guardarEmpleado(Pelicula empleado) {

    	empleadoRepository.save(empleado);
    }

    @Override
    @Transactional
    public void eliminarEmpleado(int id) {

    	empleadoRepository.deleteById(id);;
    }
}
