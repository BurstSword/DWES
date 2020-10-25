package servlet;

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
import model.Empleado;

/**
 * Servlet implementation class EmpleadoServlet
 */
@WebServlet("/")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String action = request.getServletPath();

	        try {
	            switch (action) {
	                case "/insert":
	                    insertarEmpleado(request, response);
	                    break;
	                case "/lista":
	                	listarEmpleados(request, response);
	                    break;
	                
	                case "/update":
	                    //updateUser(request, response);
	                    break;
	                default:
	                    
	                    break;
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void listarEmpleados(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List < Empleado > listUser = EmpleadoDAO.listarEmpleados();
		        request.setAttribute("listUser", listUser);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		        dispatcher.forward(request, response);
		    }
	
	 private void insertarEmpleado(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        String nombre = request.getParameter("nombre");
			        String dni = request.getParameter("dni");
			        String sexo = request.getParameter("sexo");
			        int anyos =Integer.parseInt(request.getParameter("anyos")) ;
			        int categoria = Integer.parseInt(request.getParameter("categoria")) ;
			        Empleado empleado = new Empleado(nombre, dni, sexo, anyos, categoria);
			        EmpleadoDAO.insertarEmpleado(empleado);
			        response.sendRedirect("list");
			    }
}
