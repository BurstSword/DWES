/**
 * Clase encargas de almacenar los sueldos en funcion de la categoria
 */
public class Nomina {

    private static final int[] SUELDO_BASE = {50000, 70000, 90000, 110000, 130000,
            150000, 170000, 190000, 210000, 230000};

    /**
     * Metodo que se encarga de calcular el sueldo de un empleado
     * @param empleado El empleado al que se le calcula el sueldo
     * @return El sueldo del empleado enviado ya calculado
     */
     public static int sueldo(Empleado empleado){
        int sueldo;
        sueldo = SUELDO_BASE[empleado.getCategoria()-1]+5000*empleado.anyos;
        return sueldo;
    }
}
