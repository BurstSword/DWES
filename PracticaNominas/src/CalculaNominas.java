public class CalculaNominas {
    public static void main(String[] args) {

        Empleado empleado1 = new Empleado("James Cosling", "32000032G", 'M', 4, 7);
        Empleado empleado2 = new Empleado("Ada Lovelace", "32000031R", 'M');

        escribe(empleado1, empleado2);
        empleado2.incrAnyo();
        empleado1.setCategoria(11);
        escribe(empleado1, empleado2);

    }

    private static void escribe(Empleado empleado1, Empleado empleado2) {
        empleado1.imprime();
        System.out.println("El sueldo de " + empleado1.nombre + " es de " + Nomina.sueldo(empleado1) + " euros");

        empleado2.imprime();
        System.out.println("El sueldo de " + empleado2.nombre + " es de " + Nomina.sueldo(empleado2) + " euros");
    }


}
