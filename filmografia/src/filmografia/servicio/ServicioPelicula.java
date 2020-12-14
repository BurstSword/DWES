package filmografia.servicio;

import java.util.List;

import filmografia.entidades.Pelicula;

public interface ServicioPelicula {

	public List<Pelicula> buscarPeliculaPorDirector(String director); 
	public List<Pelicula> listarPeliculas(); 
	public Pelicula pedirPelicula(int id);
	public void guardarPelicula(Pelicula Pelicula);
	public void borrarPelicula(int id);
}
