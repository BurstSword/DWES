package filmografia.servicio;

import java.util.List;

import filmografia.entidades.Admin;
import filmografia.entidades.Director;


public interface ServicioAdmin {
	public List<Admin> listarAdmins();
	public void introducirAdmin(Admin admin);
}
