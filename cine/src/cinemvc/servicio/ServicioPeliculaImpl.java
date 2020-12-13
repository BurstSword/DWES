package cinemvc.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import cinemvc.entidades.Pelicula;
import cinemvc.repositorio.CineRepositorio;

@Service
public class ServicioPeliculaImpl implements ServicioPelicula{

	@Autowired
	private CineRepositorio repositorio;
	
	@Override
	@Transactional
	public List<Pelicula> buscarPelicula(String director) {
		
		List<Pelicula> peliculas = repositorio.getPelicula(director);
		return peliculas;
		
	}

	@Override
	public List<Pelicula> mostrarPeliculas() {
		return repositorio.findAll();
	}

	@Override
	@Transactional
	public void guardarPelicula(Pelicula pelicula) {
		repositorio.save(pelicula);
	}

	@Override
	public void borrarPelicula(int id) {
		repositorio.deleteById(id);
	}

	@Override
	public Pelicula traerPelicula(int id) {
		Optional <Pelicula> peliculaOp = repositorio.findById(id);
		Pelicula pelicula = peliculaOp.get();
		return pelicula;
	}

}
