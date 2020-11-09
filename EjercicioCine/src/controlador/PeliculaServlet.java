package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;
import dao.PeliculaDAO;
import modelo.Admin;
import modelo.Pelicula;

/**
 * Servlet implementation class PeliculaServlet
 */
@WebServlet("/PeliculaServlet")
public class PeliculaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PeliculaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		switch (action) {
		case "info":
			paginaInfo(request, response);
			break;
		case "gestionPeliculas":
			try {
				listarPeliculasSinDirector(request,response);
			} catch (SQLException | IOException | ServletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "inicio":
			paginaInicio(request, response);
		case "formDirector":
			paginaConsulta(request, response);
		case "login":
			paginaLogin(request, response);
		case "consultarPorDirector":
			try {
				listarPeliculas(request, response);
			} catch (SQLException | IOException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case "inicioDefecto":
			paginaInicioDefecto(request,response);
			break;
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		switch (action) {

		case "login":
			paginaLogin(request, response);

		}
		doGet(request, response);
	}

	private void paginaInfo(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/info.jsp");
		dispatcher.forward(request, response);

	}

	private void paginaInicio(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		boolean logged = false;
		AdminDAO admindao = new AdminDAO();
		String nombre = request.getParameter("nombre");
		String contrasena = request.getParameter("contrasena");
		List<Admin> admins = admindao.listarAdmins();
		
		for (int i = 0; i < admins.size(); i++) {

			
				if (nombre.equals(admins.get(i).getNombre()) && contrasena.equals(admins.get(i).getContrasena())) {
					logged = true;
				}
				
			
		}
		
		if (logged == true) {
			request.setAttribute("logeado", logged);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/errorLogin.jsp");
			dispatcher.forward(request, response);
		}

	}

	private void paginaConsulta(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/formDirector.jsp");
		dispatcher.forward(request, response);

	}

	private void listarPeliculas(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String director = request.getParameter("director");
		PeliculaDAO peliculaDAO = new PeliculaDAO();
		List<Pelicula> peliculas = peliculaDAO.listarPeliculas(director);
		if (peliculas.isEmpty()) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/listavacia.jsp");
			dispatcher.forward(request, response);
		} else {
			System.out.println(peliculas);
			request.setAttribute("listaPeliculas", peliculas);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/listaPelis.jsp");
			dispatcher.forward(request, response);
		}

	}

	private void paginaLogin(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/login.jsp");
		dispatcher.forward(request, response);

	}
	private void paginaInicioDefecto(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);

	}
	
	private void listarPeliculasSinDirector(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		
		PeliculaDAO peliculaDAO = new PeliculaDAO();
		List<Pelicula> peliculas = peliculaDAO.listarPeliculas();
		if (peliculas.isEmpty()) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/listavacia.jsp");
			dispatcher.forward(request, response);
		} else {
			System.out.println(peliculas);
			request.setAttribute("listaPeliculas", peliculas);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/listaPeliculas.jsp");
			dispatcher.forward(request, response);
		}

	}
	private void eliminarEmpleado(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		PeliculaDAO peliculaDAO = new PeliculaDAO();
		
		String titulo = request.getParameter("titulo");
		peliculaDAO.eliminarPelicula(titulo);
		listarPeliculasSinDirector(request, response);

	}
	
}
