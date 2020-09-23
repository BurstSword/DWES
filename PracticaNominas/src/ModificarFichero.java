import java.io.*;


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


    public void escribirFichero() {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("..\\salarios.txt");
            pw = new PrintWriter(fichero);


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
