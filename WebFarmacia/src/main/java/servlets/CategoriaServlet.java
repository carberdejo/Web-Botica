package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import dao.DAOFactory;
import entidades.Categorias;
import interfaces.CategoriaInterface;

/**
 * Servlet implementation class CategoriaServlet
 */
@WebServlet("/CategoriaServlet")
public class CategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		CategoriaInterface daoCategory = daoFactory.getCategoriaDAO();
		HttpSession session= request.getSession();
		if(session.getAttribute("listaCategoria")==null) {
			List<Categorias>listaCategoria = daoCategory.ListadoCategoria();
			session.setAttribute("listaCategoria", listaCategoria);		}
		request.getRequestDispatcher("Principal.jsp").forward(request, response);
		
		
	}

}
