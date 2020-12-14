package filmografia.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import filmografia.entidades.Director;
import filmografia.repositorio.DirectoresRepositorio;

@Service
public class ServicioDirectoresImpl implements ServicioDirectores {

	@Autowired
	DirectoresRepositorio repositorio; 
	
	@Override
	@Transactional
	public List<Director> listarDirectores() {
		List<Director> directores = repositorio.findAll();
		
		return directores;
	}

	@Override
	@Transactional
	public void guardarDirector(Director director) {
		repositorio.save(director);
		
	}

}
