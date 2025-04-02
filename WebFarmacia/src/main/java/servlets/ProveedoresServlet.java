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
import entidades.Proveedores;
import interfaces.ProveedoresInterface;

/**
 * Servlet implementation class ProveedoresServlet
 */
@WebServlet("/ProveedoresServlet")
public class ProveedoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	ProveedoresInterface proveedorDAO = daoFactory.getProveedoresDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProveedoresServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String caso = request.getParameter("caso");
		System.out.println("ProveedoresServlet  "+caso);
		
		switch(caso) {
		case "ListarProv": ListarProv(request, response);
		break;
		case "EliminarProv" :EliminarProv(request, response);
		break;
		case "RegistrarProv" : RegistrarProv(request, response);
		break;
		case "ModificarProv": ModificarProv(request, response); break;
		default :
			request.setAttribute("mensaje", "ocurrio unproblema");
			request.getRequestDispatcher("Principal.jsp").forward(request, response);
		}
	}
	
	private void ListarProv(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("Estoy en ListarProv");
		
		List<Proveedores> listaProveedor = proveedorDAO.listadoProveedores();
		HttpSession session = request.getSession();
		session.setAttribute("listaProveedor", listaProveedor);
		request.getRequestDispatcher("Proveedores.jsp").forward(request, response);;
	}
	private void EliminarProv(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("Estoy en EliminarProv");
		String codigo = request.getParameter("codigo");
		int valor = proveedorDAO.EliminarProveedor(codigo);
		if(valor != 0) {
			System.out.println("Elimino Proveedor de BD");
			request.getRequestDispatcher("ProveedoresServlet?caso=ListarProv").forward(request, response);
		}
	}
	private void RegistrarProv(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("Estoy en RegistrarProv");
		String nombre = request.getParameter("txtNombre"),
				numero = request.getParameter("txtNumero"),
				correo = request.getParameter("txtCorreo"),
				encargado = request.getParameter("txtEncargado"),
				pais = request.getParameter("txtPais"),
				imagen = request.getParameter("fileimagen");
		
		Proveedores prov = new Proveedores();
		prov.setNombreProveedor(nombre);
		prov.setNumProveedor(numero);
		prov.setCorreo(correo);
		prov.setEncargado(encargado);
		prov.setPais(pais);
		prov.setImagen(imagen);
		
		int valor = proveedorDAO.nuevoProveedor(prov);
		if(valor ==1){
			System.out.println("Insertó proveedor en BD");
			request.getRequestDispatcher("ProveedoresServlet?caso=ListarProv").forward(request, response);
		}
	}
	private void ModificarProv(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("Estoy en ModificarProv");
		String nombre = request.getParameter("txtNombre"),
				numero = request.getParameter("txtNumero"),
				correo = request.getParameter("txtCorreo"),
				encargado = request.getParameter("txtEncargado"),
				pais = request.getParameter("txtPais"),
				imagen = request.getParameter("fileimagen"),
				cod = request.getParameter("txtCodigo");
		
		Proveedores prov = new Proveedores();
		prov.setCodProveedor(cod);
		prov.setNombreProveedor(nombre);
		prov.setNumProveedor(numero);
		prov.setCorreo(correo);
		prov.setEncargado(encargado);
		prov.setPais(pais);
		prov.setImagen(imagen);
		
		int valor = proveedorDAO.modificarProveedor(prov);
		if(valor ==1) {
			System.out.println("Modifico en BD");
			request.getRequestDispatcher("ProveedoresServlet?caso=ListarProv").forward(request, response);
		}else {
			request.setAttribute("mensaje", "ocurrio unproblema");
			request.getRequestDispatcher("AddProveedor.jsp").forward(request, response);
		}
	}
}
