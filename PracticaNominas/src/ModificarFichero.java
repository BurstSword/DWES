import java.io.*;
import java.util.ArrayList;


public class ModificarFichero {
    public Empleado leerFichero() {
        Empleado empleado = null;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {

            archivo = new File("..\\empleados.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return empleado;
    }


    public void escribirFichero(ArrayList<Empleado> empleados) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("..\\empleados.txt");
            pw = new PrintWriter(fichero);

            for (Empleado empleado:
                 empleados) {
                pw.println(empleado.getNombre());
                pw.println(empleado.getDni());
                pw.println(empleado.getSexo());
                pw.println(""+empleado.getCategoria());
                pw.println(""+empleado.getAnyos());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}
