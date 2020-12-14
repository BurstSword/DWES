package filmografia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import filmografia.entidades.Director;
import filmografia.entidades.Pelicula;

public interface DirectoresRepositorio extends JpaRepository<Director, String> {

	
	@Query(value = "SELECT * FROM directores", nativeQuery = true)
	public List<Director> getDirector();

	
	
}
