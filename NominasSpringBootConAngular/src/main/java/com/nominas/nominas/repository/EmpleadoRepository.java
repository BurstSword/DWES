package com.nominas.nominas.repository;



import com.nominas.nominas.entity.Empleado;
import com.nominas.nominas.entity.Nomina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Integer> {
	
	@Query("FROM Nomina WHERE dni = ?1")
	Nomina getNomina(String dni);
	
}
