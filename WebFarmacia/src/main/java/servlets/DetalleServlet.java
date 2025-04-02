package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.DAOFactory;
import entidades.Producto;
import interfaces.ProductoInterface;

/**
 * Servlet implementation class DetalleServlet
 */
@WebServlet("/DetalleServlet")
public class DetalleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetalleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigoProducto=request.getParameter("codigoProducto");
		String codigoCategoria=request.getParameter("idCategoria");
		System.out.println("Estoy en DetalleServlet"+codigoProducto+codigoCategoria);
		DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProductoInterface detalleDAO = daoFactory.getProductoDAO();
		Producto pro = detalleDAO.obtenerProducto(codigoProducto);
		HttpSession session = request.getSession();
		session.setAttribute("detalleProducto", pro);
		request.getRequestDispatcher("Detalle.jsp").forward(request, response);
	}

}
