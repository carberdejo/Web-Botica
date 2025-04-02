package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.ProductoModelo;

import java.io.IOException;
import java.util.List;

import dao.DAOFactory;
import entidades.Producto;
import interfaces.ProductoInterface;

/**
 * Servlet implementation class ProductoServlet
 */
@WebServlet("/ProductoServlet")
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigoCategoria=request.getParameter("idCategoria");
		System.out.println("Estoy en productoServlet"+codigoCategoria);
		DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProductoInterface producDAO = daoFactory.getProductoDAO();
		List<Producto> listaProducto = producDAO.ListadoProducto(codigoCategoria);
		HttpSession session = request.getSession();
		session.setAttribute("listaProducto", listaProducto);
		request.getRequestDispatcher("Productos.jsp").forward(request, response);
		
	}
}
