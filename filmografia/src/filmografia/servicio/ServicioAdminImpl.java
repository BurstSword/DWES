package filmografia.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import filmografia.entidades.Admin;
import filmografia.entidades.Director;
import filmografia.repositorio.AdminRepositorio;

/**
 * Clase que opera con la tabla Admin de la bbdd
 * @author usuario
 *
 */
@Service
public class ServicioAdminImpl implements ServicioAdmin {

	@Autowired
	AdminRepositorio repositorio;

	/**
	 * Lista los Admins de la base de datos.
	 */
	@Override
	@Transactional
	public List<Admin> listarAdmins() {
		List<Admin> admins = repositorio.findAll();
		return admins;
	}

	/**
	 * Introduce un admin en la base de datos.
	 */
	@Override
	@Transactional
	public void introducirAdmin(Admin admin) {
		repositorio.save(admin);
		
	} 
	
	

}
