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

import dao.EmpleadoDAO;
import dao.NominaDAO;
import model.Empleado;
import model.Nomina;

/**
 * Servlet implementation class EmpleadoServlet
 */
@WebServlet("/EmpleadoServlet")
public class EmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpleadoServlet() {
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

		try {
			switch (action) {
			case "nuevoEmpleado":
				nuevoEmpleado(request, response);
				break;
			case "lista":
				listarEmpleados(request, response);
				break;
			case "eliminar":
				eliminarEmpleado(request, response);
				break;
			case "editar":
				actualizarEmpleado(request, response);
				break;
			case "menu":
				paginaPrincipal(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
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

		try {
			switch (action) {

			case "insertar":
				insertarEmpleado(request, response);
				break;
			case "modificar":
				modificarEmpleado(request, response);
				break;

			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		doGet(request, response);
	}

	private void listarEmpleados(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		EmpleadoDAO empleadoDAO = new EmpleadoDAO();
		List<Empleado> listaEmpleado = empleadoDAO.listarEmpleados();
		request.setAttribute("listaEmpleado", listaEmpleado);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/lista.jsp");
		dispatcher.forward(request, response);
	}

	private void insertarEmpleado(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		EmpleadoDAO empleadoDAO = new EmpleadoDAO();
		String nombre = request.getParameter("nombre");
		String dni = request.getParameter("dni");
		String sexo = request.getParameter("sexo");
		String anyosStr = request.getParameter("anyos");
		String categoriaStr = request.getParameter("categoria");

		int anyos = Integer.parseInt(anyosStr);
		int categoria = Integer.parseInt(categoriaStr);
		Empleado empleado = new Empleado(nombre, dni, sexo, anyos, categoria);
		Nomina nomina = new Nomina(Nomina.sueldo(empleado), dni);
		NominaDAO.insertarNomina(nomina);
		empleadoDAO.insertarEmpleado(empleado);
		
		
		listarEmpleados(request, response);

	}

	private void paginaPrincipal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	private void eliminarEmpleado(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		EmpleadoDAO empleadoDAO = new EmpleadoDAO();
		NominaDAO nominaDAO = new NominaDAO();
		String dni = request.getParameter("dni");
		empleadoDAO.eliminarEmpleado(dni);
		nominaDAO.eliminarNomina(dni);
		listarEmpleados(request, response);

	}

	private void modificarEmpleado(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		EmpleadoDAO empleadoDAO = new EmpleadoDAO();
		NominaDAO nominaDAO = new NominaDAO();
		String nombre = request.getParameter("nombre");
		String dni = request.getParameter("dni");
		String sexo = request.getParameter("sexo");
		String anyosStr = request.getParameter("anyos");
		String categoriaStr = request.getParameter("categoria");

		int anyos = Integer.parseInt(anyosStr);
		int categoria = Integer.parseInt(categoriaStr);
		Empleado empleado = new Empleado(nombre, dni, sexo, anyos, categoria);
		Nomina nomina = new Nomina(Nomina.sueldo(empleado),dni);
		empleadoDAO.actualizarEmpleado(empleado);
		nominaDAO.actualizarNomina(nomina);
		listarEmpleados(request, response);
	}

	private void actualizarEmpleado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
			 {
		EmpleadoDAO empleadoDAO = new EmpleadoDAO();
		String dni = request.getParameter("dni");

		Empleado empleado = empleadoDAO.extraerEmpleado(dni);
		request.setAttribute("empleado", empleado);
		Nomina nomina = NominaDAO.extraerNomina(dni);
		request.setAttribute("nomina", nomina);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/editarEmpleado.jsp");
		dispatcher.forward(request, response);

	}

	private void nuevoEmpleado(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/nuevoEmpleado.jsp");
		dispatcher.forward(request, response);
	}
	private void paginaError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/error.jsp");
		dispatcher.forward(request, response);
	}
}
