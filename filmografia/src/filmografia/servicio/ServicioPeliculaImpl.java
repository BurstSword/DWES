package filmografia.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import filmografia.entidades.Pelicula;
import filmografia.repositorio.FilmografiaRepositorio;

@Service
public class ServicioPeliculaImpl implements ServicioPelicula{

	@Autowired
	private FilmografiaRepositorio repositorio;
	
	@Override
	@Transactional
	public List<Pelicula> buscarPeliculaPorDirector(String director) {
		
		List<Pelicula> peliculas = repositorio.getPelicula(director);
		return peliculas;
		
	}

	@Override
	public List<Pelicula> listarPeliculas() {
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
	public Pelicula pedirPelicula(int id) {
		Optional <Pelicula> peliculaOp = repositorio.findById(id);
		Pelicula pelicula = peliculaOp.get();
		return pelicula;
	}

}
