package cinemvc.entidades;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idAdmin")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="pass")
	private String pass;
	
	public Admin() {
		
	}
	
	public Admin(String nombre, String pass) {
		this.nombre = nombre;
		this.pass = pass;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
