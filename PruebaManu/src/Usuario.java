/*Bibliografía utilizada:
 * Material didactico de la asignatura
 * https://www.udemy.com/course/fundamentos-de-java-aprende-a-programar-java-desde-cero-sin-misterios/?ranMID=39197&ranEAID=hL3Qp0zRBOc&ranSiteID=hL3Qp0zRBOc-BCezaPKFa1oDDdvKNK38qQ&LSNPUBID=hL3Qp0zRBOc&awc=6554_1603217600_822f2f391a496d1154a3e7018166b8eb&utm_source=Growth-Affiliate&utm_medium=Affiliate-Window&utm_campaign=Campaign-Name&utm_term=375095&utm_content=Placement&ranMID=39197&ranEAID=hL3Qp0zRBOc&ranSiteID=hL3Qp0zRBOc-P8VLOZ7rLpz4WhSiuEBaFg&LSNPUBID=hL3Qp0zRBOc&utm_source=aff-campaign&utm_medium=udemyads
 * http://prof.mfbarcell.es/programacion-orientada-objetos/
 * https://www.udemy.com/course/aprende-programacion-en-java-desde-cero/
 * Pildoras Informáticas https://www.youtube.com/watch?v=coK4jM5wvko
*/

import java.util.regex.Pattern;

public class Usuario {

	//Atributos
	private String nombre;
	private int edad;
	private String dni;

	//constructor
	public Usuario() {
	}

	//Getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDNI() {
		return this.dni;
	}

	public boolean setDNI(String DNI) {

		boolean salir = false;
		// con la condición, le daría valor a DNI cambiando el booleano a dni
		if (validarDNI(DNI)) {
			this.dni = DNI;
			salir = true;
		}

		return salir;
	}

	@Override
	public String toString() {
		return " Usuario: " + getNombre() + ", edad: " + this.getEdad() + ", DNI: " + this.getDNI();
	}

	
	 //Metodo para validar DNI
	 
	private boolean validarDNI(String DNI) {
	final String patron = "^\\d{8}-?[A-Z]$";
		
		return Pattern.matches(patron, DNI);
	}
	
}
