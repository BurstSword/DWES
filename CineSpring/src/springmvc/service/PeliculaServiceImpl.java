package springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvc.entity.Pelicula;
import springmvc.entity.Admin;
import springmvc.repository.CineRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServiceImpl implements PeliculaService {

	@Autowired
	private CineRepository cineRepository;

	@Override
	@Transactional
	public List<Pelicula> traerPeliculaPorAutor(String director) {
		
		Optional<Pelicula> peliculas = cineRepository.findById(director);
		
		return null;
	}

	@Override
	@Transactional
	public List<Pelicula> listarPeliculas() {
		List<Pelicula> peliculas = cineRepository.findAll();

		return peliculas;
	}

	@Override
	@Transactional
	public void guardarPelicula(Pelicula pelicula) {
		cineRepository.save(pelicula);

	}

	@Override
	@Transactional
	public void eliminarPelicula(Pelicula pelicula) {
		cineRepository.delete(pelicula);

	}

}
