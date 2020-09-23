package Laboral;


/**
 * Clase utilizada para ser heredada por empleado ya que todos los empleados utilizan sus atributos
 * Tiene los atributos de dni, nombre y sexo
 *
 */
public class Persona {
    public String nombre;
    public String dni;
    public char sexo;

    /**
     * Constructor que inicializa una persona con valores traídos por parámetros
     * @param nombre El nombre de la persona
     * @param dni El dni de la persona
     * @param sexo El sexo de la persona
     */
    public Persona(String nombre, String dni, char sexo) {
        this.nombre = nombre;
        this.dni = dni;
        this.sexo=sexo;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Persona(String nombre, char sexo) {
        this.nombre = nombre;
        this.sexo = sexo;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Procedimiento que muestra los datos de la persona
     */
    public void imprime() {
        System.out.println("Nombre: " + this.nombre + " y DNI: " + this.dni);
    }
}
