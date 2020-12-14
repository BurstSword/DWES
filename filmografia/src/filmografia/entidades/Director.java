package filmografia.entidades;

/**
 * Clase director con atributo nombre
 * @author usuario
 *
 */


public class Director {

	
	private String nombre;

	public Director() {
		this.nombre = "";
	}

	public Director(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
