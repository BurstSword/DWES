package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Empleado;
import model.Nomina;

public class NominaDAO {
	private static Connection dbConnection;

	
	private static final String extraerNomina = "select sueldo from nominas where dniEmpleados =?";
	private static final String insertarNomina = "INSERT INTO nominas"
			+ "  (sueldo, dniEmpleado) VALUES " + " (?, ?);";
	private static final String actualizarNomina = "update nominas set sueldo = ? where dni = ?;";

	public static Connection getDBConnection() {
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
	
public static void insertarNomina(Nomina nomina) throws SQLException {
		try (Connection connection = getDBConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(insertarNomina)) {
			preparedStatement.setInt(1, nomina.getSueldo());
			preparedStatement.setString(2, nomina.getDniEmp());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar el empleado");
		}
	}

public static Nomina extraerNomina(String dniEmpleado) {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet rs = null;
	Nomina nomina = null;

	try {
		connection = getDBConnection();

		preparedStatement = connection.prepareStatement(extraerNomina);
		
		preparedStatement.setString(1, dniEmpleado);
		
		rs = preparedStatement.executeQuery();

		rs.absolute(1);
			int sueldo = rs.getInt("sueldo");
			
			nomina =new Nomina(sueldo,dniEmpleado);
		

	} catch (SQLException e) {
		e.printStackTrace();
	}
	return nomina;
}
public static boolean actualizarNomina(Nomina nomina) throws SQLException {
    boolean filaActualizada;
    try (Connection connection = getDBConnection(); PreparedStatement statement = connection.prepareStatement(actualizarNomina);) {
    	statement.setString(1, nomina.getDniEmp());
    	
        statement.setInt(1, nomina.getSueldo());
       
        
        
        filaActualizada = statement.executeUpdate() > 0;
    }
    return filaActualizada;
}
}
