package cinemvc.servicio;

import java.util.List;

import cinemvc.entidades.Pelicula;

public interface ServicioPelicula {

	public List<Pelicula> buscarPelicula(String director); 
	public List<Pelicula> mostrarPeliculas(); 
	public Pelicula traerPelicula(int id);
	public void guardarPelicula(Pelicula Pelicula);
	public void borrarPelicula(int id);
}
