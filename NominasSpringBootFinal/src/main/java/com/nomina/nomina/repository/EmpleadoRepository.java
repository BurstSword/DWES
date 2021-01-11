package com.nomina.nomina.repository;



import com.nomina.nomina.entity.Empleado;
import com.nomina.nomina.entity.Nomina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Integer> {
	
	@Query("FROM Nomina WHERE dni = ?1")
	public Nomina getNomina(String dni);
	
}
