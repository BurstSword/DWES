package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import modelo.Pelicula;

public class PeliculaDAO {
	private static Connection dbConnection;

	

	private static final String extraerPeliculaPorDirector = "select * from pelicula where director =?";
	private static final String listarPeliculas = "select * from pelicula";
	private static final String eliminarPelicula = "delete from pelicula where titulo=?";
	private static final String insertarPelicula = "INSERT INTO pelicula"
			+ "  (director, titulo, fecha) VALUES " + " (?, ?, ?);";
	

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
	
	public  List<Pelicula> listarPeliculas(String directorConsulta) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<Pelicula> peliculas = new ArrayList<>();

		try {
			
			connection = getDBConnection();
			
			preparedStatement = connection.prepareStatement(extraerPeliculaPorDirector);
			preparedStatement.setString(1, directorConsulta);
			
			rs = preparedStatement.executeQuery();

			
			while (rs.next()) {
				String director = rs.getString("director");
				String titulo = rs.getString("titulo");
				String fecha = rs.getString("fecha");
				
				peliculas.add(new Pelicula(director,titulo,fecha));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return peliculas;
	}
	
	public  List<Pelicula> listarPeliculas() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<Pelicula> peliculas = new ArrayList<>();

		try {
			
			connection = getDBConnection();
			
			preparedStatement = connection.prepareStatement(listarPeliculas);
			
			
			rs = preparedStatement.executeQuery();

			
			while (rs.next()) {
				String director = rs.getString("director");
				String titulo = rs.getString("titulo");
				String fecha = rs.getString("fecha");
				
				peliculas.add(new Pelicula(director,titulo,fecha));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return peliculas;
	}
	
	public  boolean eliminarPelicula(String titulo) throws SQLException {
        boolean rowDeleted;
        try {
        	Connection connection = getDBConnection(); 
        	PreparedStatement statement = connection.prepareStatement(eliminarPelicula);
        	
            statement.setString(1, titulo);
            
            rowDeleted = statement.executeUpdate() > 0;
            
        return rowDeleted;
    }finally {
    	
    }
	}
	
public  void insertarPelicula(Pelicula pelicula) throws SQLException {

		
		try {
			Connection connection = getDBConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(insertarPelicula);
			preparedStatement.setString(1, pelicula.getDirector());
			preparedStatement.setString(2, pelicula.getTitulo());
			preparedStatement.setString(3, pelicula.getFecha());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar el empleado");
		}
	}
}
