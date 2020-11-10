package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Admin;
import modelo.Pelicula;


public class AdminDAO {
private static Connection dbConnection;

	

	private static final String extraerYComprobarUsuarios = "select * from admin";
	private static final String insertarAdmin = "INSERT INTO admin"
			+ "  (nombre, contrasena) VALUES " + " (?, ?);";
	

	public static Connection getDBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {
			dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/cine", "root", "");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}
	
	public  List<Admin> listarAdmins() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<Admin> admins = new ArrayList<>();

		try {
			
			connection = getDBConnection();
			
			preparedStatement = connection.prepareStatement(extraerYComprobarUsuarios);
		
			
			rs = preparedStatement.executeQuery();

			
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				String contrasena = rs.getString("contrasena");
				
				
				admins.add(new Admin(nombre,contrasena));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admins;
	}
public  void insertarAdmin(Admin admin) throws SQLException {

		
		try {
			Connection connection = getDBConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(insertarAdmin);
			preparedStatement.setString(1, admin.getNombre());
			preparedStatement.setString(2, admin.getContrasena());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar el admin");
		}
	}
}
