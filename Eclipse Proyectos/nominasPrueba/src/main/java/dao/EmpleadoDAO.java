package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Empleado;
import model.Nomina;

public class EmpleadoDAO {

	private static Connection dbConnection;

	private static final String insertarEmpleadoSQL = "INSERT INTO empleado"
			+ "  (nombre, dni, sexo, anyos, categoria) VALUES " + " (?, ?, ?, ? , ?);";

	private static final String extraerEmpleado = "select nombre, dni, sexo, anyos, categoria from empleado where dni =?";
	private static final String listarEmpleados = "select * from empleado";


	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ejercicionominas?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";

    /**
     * Metodo para crear la conexion con la base de datos
     * @return la conexion con mysql
     */
    public static Connection getDBConnection() {
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (ClassNotFoundException e) {
            System.out.println("Loading driver error");
            e.printStackTrace(System.out);
        } catch (SQLException e) {
            System.out.println("Connection error");
            e.printStackTrace(System.out);
        }
        return conn;
    }

	public static void insertarEmpleado(Empleado empleado) throws SQLException {

		// try-with-resource statement will auto close the connection.
		try (Connection connection = getDBConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(insertarEmpleadoSQL)) {
			preparedStatement.setString(1, empleado.getNombre());
			preparedStatement.setString(2, empleado.getDni());
			preparedStatement.setString(3, empleado.getSexo());
			preparedStatement.setInt(4, empleado.getAnyos());
			preparedStatement.setInt(5, empleado.getCategoria());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar el empleado");
		}
	}

	public Empleado pedirEmpleado(int id) {
		Empleado empleado = null;

		try (Connection connection = getDBConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(extraerEmpleado);) {

			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String nombre = rs.getString("nombre");
				String dni = rs.getString("dni");
				String sexo = rs.getString("sexo");
				int anyos = rs.getInt("anyos");
				int categoria = rs.getInt("categoria");
				empleado = new Empleado(nombre, dni, sexo, anyos, categoria);
			}
		} catch (SQLException e) {
			System.out.println("Error al extraer el empleado");
		}
		return empleado;
	}

	public static List<Empleado> listarEmpleados() {

		List<Empleado> empleados = new ArrayList<>();

		try (Connection connection = getDBConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(listarEmpleados);) {
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String nombre = rs.getString("nombre");
				String dni = rs.getString("dni");
				String sexo = rs.getString("sexo");
				int anyos = rs.getInt("anyos");
				int categoria = rs.getInt("categoria");
				empleados.add(new Empleado(nombre, dni, sexo, anyos, categoria));
			}
		} catch (SQLException e) {
			System.out.println("Error al listar los empleados");
		}
		return empleados;
	}
}
