package filmografia.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import filmografia.entidades.Admin;
import filmografia.entidades.Director;
import filmografia.repositorio.AdminRepositorio;


@Service
public class ServicioAdminImpl implements ServicioAdmin {

	@Autowired
	AdminRepositorio repositorio;

	@Override
	@Transactional
	public List<Admin> listarAdmins() {
		List<Admin> admins = repositorio.findAll();
		return admins;
	}

	@Override
	@Transactional
	public void introducirAdmin(Admin admin) {
		repositorio.save(admin);
		
	} 
	
	

}
