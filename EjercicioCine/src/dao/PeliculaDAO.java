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
}
