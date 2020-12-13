package springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import springmvc.entity.Pelicula;
import springmvc.entity.Nomina;

public interface CineRepository extends JpaRepository<Pelicula, Integer>{
	
	@Query("FROM Nomina WHERE dni = ?1")
	public Nomina getNomina(String dni);
	
}
