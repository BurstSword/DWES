package springmvc.entity;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {

	@Column(name="nombre")
	private String nombre;
	
	@Column(name="contrasena")
	private String pass;

	public Admin() {
		this.nombre = "";
		this.pass = "";
	}

	public Admin(String nombre, String pass) {
		this.nombre = nombre;
		this.pass = pass;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
