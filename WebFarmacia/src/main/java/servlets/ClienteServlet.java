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
import entidades.User;
import interfaces.ClienteInterface;

/**
 * Servlet implementation class ClienteServlet
 */
@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    ClienteInterface clienteDAO = daoFactory.getClienteDAO();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		System.out.println("Estor en ClienteServlet "+ accion);
		switch(accion) {
		case "ListarCli":ListarCli(request, response);break;
		case"ModificarCLi":ModificarCLi(request, response);break;
		}
	}
	private void ListarCli(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("Estor en ListarCli ");
		List<User> listaCliente = clienteDAO.listadoCliente("user");
		HttpSession session = request.getSession();
		session.setAttribute("listaCliente", listaCliente);
		request.getRequestDispatcher("Cliente.jsp").forward(request, response);
	}
	private void ModificarCLi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("Estor en ModificarCLi ");
		int codigo = Integer.parseInt(request.getParameter("txtId"));
		String 	name = request.getParameter("txtName"),
				correo = request.getParameter("txtHotmail"),
				pasword = request.getParameter("txtpassword");
		
		User user = new User();
		user.setId(codigo);
		user.setName(name);
		user.setEmail(correo);
		user.setPassword(pasword);
		
		int valor = clienteDAO.ModiificarCliente(user);
		if(valor ==1) {
			System.out.println("Modifico cliente en BD");
			request.getRequestDispatcher("ClienteServlet?accion=ListarCli").forward(request, response);
		}else {
			request.setAttribute("mensaje", "ocurrio unproblema");
			request.getRequestDispatcher("AddCliente.jsp").forward(request, response);
		}
	}	
}
