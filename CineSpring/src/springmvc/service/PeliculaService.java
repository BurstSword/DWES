package springmvc.service;

import springmvc.entity.Pelicula;
import springmvc.entity.Admin;

import java.util.List;
import java.util.Optional;

public interface PeliculaService {

    public List<Pelicula> traerPeliculaPorAutor(String director);
    public List<Pelicula> listarPeliculas();
    public void guardarPelicula(Pelicula pelicula);
    public void eliminarPelicula(Pelicula pelicula);
}
