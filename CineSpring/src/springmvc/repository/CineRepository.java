package springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import springmvc.entity.Pelicula;
import springmvc.entity.Admin;

public interface CineRepository extends JpaRepository<Pelicula, String>{
	
	@Query("FROM pelicula where director=?1")
	public Pelicula getPelicula(String director);
	
}
