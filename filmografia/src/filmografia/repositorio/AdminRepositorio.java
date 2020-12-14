package filmografia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import filmografia.entidades.Admin;
import filmografia.entidades.Pelicula;

public interface AdminRepositorio extends JpaRepository<Admin, String> {

	
	@Query(value = "SELECT * FROM admin", nativeQuery = true)
	public List<Admin> getAdmin();
	
}
