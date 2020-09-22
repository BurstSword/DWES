import Laboral.Persona;

import java.util.regex.Pattern;

/**
 * Esta clase Empleado hereda de Persona los atributos nombre, dni y sexo y como atributos propios tiene categoria y anyos
 */
public class Empleado extends Persona {
    private int categoria;
    public int anyos;

    /**
     * Este constructor inicializa los valores de persona que hereda por parámetros y los propios de categoría y años a 0
     * @param nombre El nombre del empleado
     * @param dni El dni del empleado
     * @param sexo El sexo del empleado
     * @throws DatosNoCorrectosException Excepción
     */
    public Empleado(String nombre, String dni, char sexo) throws DatosNoCorrectosException {
        super(nombre, dni, sexo);
        if (!Pattern.matches(("^[HMhm]"), sexo + "") || !Pattern.matches(("(\\d{8})([-]?)([A-Z]{1})"),dni)) {
            throw new DatosNoCorrectosException();
        }
        this.categoria = 1;
        this.anyos = 0;
    }

    /**
     * Este constructor inicializa un empleado con los valores traídos por parámetros
     * @param nombre El nombre del empleado
     * @param dni El dni del empleado
     * @param sexo El sexo del empleado
     * @param categoria La categoria salarial del empleado
     * @param anyos Los años de antigüedad del empleado
     * @throws DatosNoCorrectosException
     */
    public Empleado(String nombre, String dni, char sexo, int categoria, int anyos) throws DatosNoCorrectosException {
        super(nombre, dni, sexo);

        /*Comprobamos que el sexo sea solo H o M y que la categoria no sea inferior a 1 ni superior a 10 */
        if (!Pattern.matches(("^[HMhm]"), sexo + "")  || !Pattern.matches(("(\\d{8})([-]?)([A-Z]{1})"),dni) || anyos<0) {
            throw new DatosNoCorrectosException();
        }

        setCategoria(categoria);

        this.anyos = anyos;
    }

    public int getCategoria() {
        return categoria;
    }


    public void setCategoria(int categoria) throws DatosNoCorrectosException {
        if (categoria < 1 || categoria > 10) {
            throw new DatosNoCorrectosException();
        }
        this.categoria = categoria;


    }

    /**
     * Metodo que se encarga de aumentar los años de antigüedad del empleado en 1
     */
    public void incrAnyo() {
        this.anyos += 1;
    }

    /**
     *
     */
    public void imprime() {
        System.out.println("Nombre: " + this.nombre + " DNI: " + this.dni + " Sexo: " + this.sexo + " Años trabajados: " + this.anyos + " Categoria: " + this.getCategoria());
    }
}
