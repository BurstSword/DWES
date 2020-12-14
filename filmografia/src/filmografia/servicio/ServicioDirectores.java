package filmografia.servicio;

import java.util.List;

import filmografia.entidades.Director;


public interface ServicioDirectores {
	public List<Director> listarDirectores();
	public void guardarDirector(Director director);
}
