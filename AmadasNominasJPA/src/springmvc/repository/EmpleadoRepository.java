package springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import springmvc.entity.Empleado;
import springmvc.entity.Nomina;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{
	
	@Query("FROM Nomina WHERE dni = ?1")
	public Pelicula getNomina(String dni);
	
}
