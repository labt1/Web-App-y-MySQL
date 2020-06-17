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

import com.articulos.dao.ArticuloDAO;
import com.articulos.model.Articulo;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArticuloDAO articuloDAO;
	
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {
 
			articuloDAO = new ArticuloDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Hola Servlet..");
		String action = request.getParameter("action");
		System.out.println(action);
		try {
			switch (action) {
			case "index":
				index(request, response);
				break;
			case "nuevo":
				nuevo(request, response);
				break;
			case "register":
				System.out.println("entro");
				register(request, response);
				break;
			case "mostrar":
				mostrar(request, response);
				break;
			case "showedit":
				showEditar(request, response);
				break;	
			case "editar":
				editar(request, response);
				break;
			case "eliminar":
				eliminar(request, response);
				break;
			default:
				break;
			}			
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servlet..");
		doGet(request, response);
	}
	
	
	private void index (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		//mostrar(request, response);
		RequestDispatcher dispatcher= request.getRequestDispatcher("/JSP/index.jsp");
		dispatcher.forward(request, response);
	}
 
	private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Articulo articulo = new Articulo(0, request.getParameter("codigo"), request.getParameter("nombre"), request.getParameter("descripcion"), Double.parseDouble(request.getParameter("cantidad")), Double.parseDouble(request.getParameter("precio")));
		System.out.println("test_articulo");
		articuloDAO.insertar(articulo);
		System.out.println("test_insert");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/index.jsp");
		dispatcher.forward(request, response);
	}
	
	private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/vistas/register.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/vistas/mostrar.jsp");
		List<Articulo> listaArticulos= articuloDAO.listarArticulos();
		request.setAttribute("lista", listaArticulos);
		dispatcher.forward(request, response);
	}	
	
	private void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Articulo articulo = articuloDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("articulo", articulo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/vistas/editar.jsp");
		dispatcher.forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		Articulo articulo = new Articulo(Integer.parseInt(request.getParameter("id")), request.getParameter("codigo"), request.getParameter("nombre"), request.getParameter("descripcion"), Double.parseDouble(request.getParameter("existencia")), Double.parseDouble(request.getParameter("precio")));
		articuloDAO.actualizar(articulo);
		index(request, response);
	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		Articulo articulo = articuloDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));
		articuloDAO.eliminar(articulo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/index.jsp");
		dispatcher.forward(request, response);
		
	}

}
