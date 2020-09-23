import java.sql.*;

public class GestionBBDD {
    private Connection dbConnection;
    private Statement st;
    private ResultSet rs;


    public Connection getDBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/nominas", "root", "");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

    public void actualizarCategoria(Empleado empleado, int categoria) {
        dbConnection = getDBConnection();

        try {
            st = dbConnection.createStatement();
            st.executeUpdate("Update empleado set categoria = " + categoria + " where Dni=" + '"' + empleado.getDni() + '"');

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void actualizarSueldo(Empleado empleado) {
        dbConnection = getDBConnection();
        int categoria=0;
        try {
            st = dbConnection.createStatement();
            try {
                st = dbConnection.createStatement();
                rs = st.executeQuery("Select categoria from empleado where Dni = " + '"'+ empleado.getDni()+ '"');
                while(rs.next()){
                    categoria=rs.getInt(1);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            st.executeUpdate("Update nominas set sueldo = " + Nomina.sueldo(empleado,categoria) + " where DniEmpleado=" + '"' + empleado.getDni() + '"');

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void insertarEmpleado(Empleado empleado) {
        dbConnection = getDBConnection();


        try {
            st = dbConnection.createStatement();
            st.executeUpdate("Insert into empleado values ('"+empleado.getNombre()+"', '"+empleado.getDni() +"', '"+empleado.getSexo()+"'," +
                    "'"+empleado.getCategoria()+"', '"+empleado.getAnyos() +"')");
            System.out.println("Insercion realizada");
            st.executeUpdate("Insert into nominas values ('"+ empleado.getDni()+"', '" + Nomina.sueldo(empleado,empleado.getCategoria())+"')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
