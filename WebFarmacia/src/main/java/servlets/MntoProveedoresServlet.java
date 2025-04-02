package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.DAOFactory;
import entidades.Proveedores;
import interfaces.ProveedoresInterface;

/**
 * Servlet implementation class MntoProveedoresServlet
 */
@WebServlet("/MntoProveedoresServlet")
public class MntoProveedoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MntoProveedoresServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		String caso = request.getParameter("caso");
		System.out.println("caso "+caso);
		HttpSession session = request.getSession();
		session.setAttribute("caso", caso);
		if(codigo != null) {
			DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			ProveedoresInterface provDAO = daoFactory.getProveedoresDAO();
			Proveedores prov = provDAO.obtenerProv(codigo);
			session.setAttribute("prov", prov);
		}
		request.getRequestDispatcher("AddProveedor.jsp").forward(request, response);
		
	}

}
