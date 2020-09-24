import java.util.ArrayList;

public class CalculaNominas {
    public static void main(String[] args) {
        GestionBBDD gestionBBDD = new GestionBBDD();
        ModificarFichero modificarFichero = new ModificarFichero();
        Empleado empleado1 = null;
        Empleado empleado2 = null;
        Empleado empleado3=null;
        ArrayList<Empleado> empleados = new ArrayList<>();
        try {
            empleado1 = new Empleado("James Cosling", "32000032G", 'M', 4, 7);
            empleado3 = new Empleado("James Cosling", "32000032P", 'M', 4, 7);
            empleado2 = new Empleado("Ada Lovelace", "32000031R", 'M');


        } catch (DatosNoCorrectosException e) {
            System.out.println("Introduce los datos correctamente");
        }
/*
        if (empleado1 != null && empleado2 != null) {
            gestionBBDD.actualizarCategoria(empleado2,9);
            gestionBBDD.actualizarSueldo(empleado2);
            gestionBBDD.actualizarSueldo(empleado1);
            gestionBBDD.insertarEmpleado(empleado3);

        }
*/
        empleados.add(empleado1);
        empleados.add(empleado2);
        empleados.add(empleado3);

        modificarFichero.escribirFichero(empleados);
    }
/*
    private static void escribe(Empleado empleado1, Empleado empleado2) {
        empleado1.imprime();
        System.out.println("El sueldo de " + empleado1.nombre + " es de " + Nomina.sueldo(empleado1) + " euros");

        empleado2.imprime();
        System.out.println("El sueldo de " + empleado2.nombre + " es de " + Nomina.sueldo(empleado2) + " euros");
    }
*/

}
