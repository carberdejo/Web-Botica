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
 * Servlet implementation class AccionServlet
 */
@WebServlet("/AccionServlet")
public class AccionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	ProductoInterface producDAO = daoFactory.getProductoDAO();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mitipo = request.getParameter("tipo");
		System.out.println("Estor en accionservlet"+mitipo);
		System.out.println(mitipo);
		switch(mitipo) {
		case "Ingresar" : Ingresar(request, response);
		break;
		case "Eliminar": Eliminar(request, response);
		break;
		case "Listar":Listar(request, response);
		break;
		case "ListarTodo":ListarTodo(request, response);
		break;
		case "Modificar": Modificar(request, response);
		break;
		case "ProducModi" :ProducModi(request, response);
		break;
		case "ActualizarStock":ActualizarStock(request, response);
		break;
		default :
			request.setAttribute("mensaje", "ocurrio unproblema");
			request.getRequestDispatcher("Productos.jsp").forward(request, response);
		}
	}
	
	private void Ingresar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//Datos de entrada
		String nombre = request.getParameter("txtNombre");
		String descripcion = request.getParameter("txtDescripcion");
		String Precio = request.getParameter("txtPrecio");
		String Stock = request.getParameter("txtcantidadStock");
		String Minima = request.getParameter("txtcantidadMinima");
		String idCategoria = request.getParameter("cboCategoria");
		String Marca = request.getParameter("txtmarca");
		String Laboratorio = request.getParameter("txtlaboratorio");
		String FIngreso = request.getParameter("txtfechaIngreso");
		String FVencimiento = request.getParameter("txtfechaVencimiento");
		String Descuento  = request.getParameter("txtdescuento");
		String imagen = request.getParameter("fileimagen");
		
		System.out.println(nombre);
		System.out.println(descripcion);
		System.out.println(Precio);
		System.out.println(Stock);
		System.out.println(Minima);
		System.out.println(idCategoria);
		System.out.println(Marca);
		System.out.println(Laboratorio);
		System.out.println(FIngreso);
		System.out.println(FVencimiento);
		System.out.println(Descuento);
		System.out.println(imagen);
		
		Producto pro = new Producto();
		pro.setNombreProducto(nombre);
		pro.setDescripcion(descripcion);
		pro.setPrecio(Precio);
		pro.setCantidadStock(Stock);
		pro.setCantidadMinima(Minima);
		pro.setIdCategoria(idCategoria);
		pro.setMarca(Marca);
		pro.setIdProveedor(Laboratorio);
		pro.setFechaIngreso(FIngreso);
		pro.setFechaVencimiento(FVencimiento);
		pro.setDescuento(Descuento);
		pro.setImagen(imagen);	
		
		//Procesamos
		ProductoModelo promodel = new ProductoModelo();
		int valor = promodel.registrarProducto(pro);
		
		if(valor ==1) {
			System.out.println("Insertó en BD");
			request.getRequestDispatcher("AccionServlet?tipo=Listar&idCategoria="+idCategoria).forward(request, response);
		}
	}
	
	private void Eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int codProducto = Integer.parseInt(request.getParameter("cProducto"));
	
		int valor = producDAO.eliminarProducto(codProducto);
		if(valor != 0) {
			System.out.println("Elimino de BD");
			request.getRequestDispatcher("AccionServlet?tipo=Listar").forward(request, response);
		}
	}
	
	private void Listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			
		String codigoCategoria=request.getParameter("idCategoria");
		System.out.println("Estoy en AccionListarServlet"+codigoCategoria);
		List<Producto> listaProducto = producDAO.ListadoProducto(codigoCategoria);
		HttpSession session = request.getSession();
		session.setAttribute("listaProducto", listaProducto);
		request.getRequestDispatcher("Productos.jsp").forward(request, response);
	}
	
	private void Modificar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String codigo = request.getParameter("codigoPro");
		String nombre = request.getParameter("txtNombre");
		String descripcion = request.getParameter("txtDescripcion");
		String Precio = request.getParameter("txtPrecio");
		String Stock = request.getParameter("txtcantidadStock");
		String Minima = request.getParameter("txtcantidadMinima");
		String idCategoria = request.getParameter("cboCategoria");
		String Marca = request.getParameter("txtmarca");
		String Laboratorio = request.getParameter("txtlaboratorio");
		String FIngreso = request.getParameter("txtfechaIngreso");
		String FVencimiento = request.getParameter("txtfechaVencimiento");
		String Descuento  = request.getParameter("txtdescuento");
		String imagen = request.getParameter("fileimagen");
		
		Producto pro = new Producto();
		pro.setCodigoProducto(codigo);
		pro.setNombreProducto(nombre);
		pro.setDescripcion(descripcion);
		pro.setPrecio(Precio);
		pro.setCantidadStock(Stock);
		pro.setCantidadMinima(Minima);
		pro.setIdCategoria(idCategoria);
		pro.setMarca(Marca);
		pro.setIdProveedor(Laboratorio);
		pro.setFechaIngreso(FIngreso);
		pro.setFechaVencimiento(FVencimiento);
		pro.setDescuento(Descuento);
		pro.setImagen(imagen);	
		
		//Procesamos
		
		int valor = producDAO.modificarProducto(pro);
		
		if(valor == 1) {
			System.out.println("Modifico en BD");
			request.getRequestDispatcher("AccionServlet?tipo=Listar&idCategoria="+idCategoria).forward(request, response);
		}
	}
	
	private void ProducModi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String codigoProducto=request.getParameter("codigoProducto");
		String codigoCategoria=request.getParameter("idCategoria");
		System.out.println("Estoy en DetalleServlet"+codigoProducto+"  "+codigoCategoria);
		ProductoInterface detalleDAO = daoFactory.getProductoDAO();
		Producto pro = detalleDAO.obtenerProducto(codigoProducto);
		HttpSession session = request.getSession();
		session.setAttribute("detalleProducto", pro);
	
		request.getRequestDispatcher("ModiProducto.jsp").forward(request, response);
	}
	private void ListarTodo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("Estoy en ListarTodo");
		List<Producto> ListadoGeneralProducto = producDAO.ListadoGeneralProducto();
		HttpSession session = request.getSession();
		session.setAttribute("ListadoGeneralProducto", ListadoGeneralProducto);
		request.getRequestDispatcher("Producto.jsp").forward(request, response);
	}
	
	private void ActualizarStock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("Estoy en ActualizarStock");
		String codProducto = request.getParameter("codigoProducto");
		String cantidad = request.getParameter("cantidad");
		int valor = producDAO.ActualizarStock(cantidad, codProducto);
		if(valor !=0) {
			System.out.println("Actualizo Producto en BD");
			
			Producto pro = producDAO.obtenerProducto(codProducto);
			HttpSession session = request.getSession();
			session.setAttribute("detalleProducto", pro);
			request.getRequestDispatcher("Detalle.jsp").forward(request, response);
			//request.getRequestDispatcher("AccionServlet?tipo=Listar&idCategoria=").forward(request, response);
			
		}
		
	}
}


