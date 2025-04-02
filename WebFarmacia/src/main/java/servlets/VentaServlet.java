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
import entidades.Carrito;
import entidades.DetalleVenta;
import entidades.Producto;
import entidades.User;
import entidades.Venta;
import interfaces.ClienteInterface;
import interfaces.ProductoInterface;
import interfaces.VentaInterface;

/**
 * Servlet implementation class VentaServlet
 */
@WebServlet("/VentaServlet")
public class VentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	VentaInterface ventaDAO = daoFactory.getVentaDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VentaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mitipo = request.getParameter("tipo");
		System.out.println("Estor en VentaServlet "+mitipo);
		System.out.println(mitipo);
		switch(mitipo) {
		case "agregarCarrito" : agregarCarrito(request, response);
		break;
		case "listarCarrito" : listarCarrito(request, response);
		break;
		case "EliminarProdCarrito" : EliminarProdCarrito(request, response);
		break;
		case "GenerarVenta":GenerarVenta(request, response);
		break;
		default :
			request.setAttribute("mensaje", "ocurrio unproblema");
			request.getRequestDispatcher("Productos.jsp").forward(request, response);
		
		}
	}
	private void agregarCarrito(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String usuario=request.getParameter("usuario");
		String codigoProducto=request.getParameter("codigoProducto");
		String cantidad=request.getParameter("cantidad");
		System.out.println("codigoProducto "+codigoProducto);
		System.out.println("cantidad "+cantidad);
		
		ProductoInterface productoDAO = daoFactory.getProductoDAO();
		Producto pro = productoDAO.obtenerProducto(codigoProducto);
		Carrito car = new Carrito();
		car.setIdUsuario(usuario);
		car.setCodProducto(pro.getCodigoProducto()); 
		car.setNomProducto( pro.getNombreProducto());
		car.setCantidad(cantidad);
		car.setPrecio(pro.getPrecio()); 
		car.setDescuento(pro.getDescuento()); 
		car.setMarca( pro.getMarca());
		car.setFechaVencimiento(pro.getFechaVencimiento());
		car.setImagen(pro.getImagen()); 
		
		
		int valor = ventaDAO.registrarCarrito(car);
		if(valor ==1) {
			System.out.println("Insertó en BD");
			
			HttpSession session = request.getSession();
			session.setAttribute("detalleProducto", car);
			request.getRequestDispatcher("VentaServlet?tipo=listarCarrito&usuario="+usuario).forward(request, response);
		}
	}
	private void listarCarrito(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String usuario = request.getParameter("usuario");
		HttpSession session = request.getSession();
		List<Carrito>listaCarrito = ventaDAO.listadoCarrito(usuario);
		session.setAttribute("listaCarrito", listaCarrito);
		
		request.getRequestDispatcher("Carrito.jsp").forward(request, response);
	}
	
	private void EliminarProdCarrito(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String usuario = request.getParameter("usuario");
		int codProducto = Integer.parseInt(request.getParameter("codCarrito"));
		int valor = ventaDAO.eliminarProdCarrito(codProducto);
		if(valor != 0) {
			System.out.println("Elimino producto carrito de BD"+valor);
			request.getRequestDispatcher("VentaServlet?tipo=listarCarrito&usuario="+usuario).forward(request, response);
		}
	}
	
	private void GenerarVenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String usuario = request.getParameter("usuario");
		List<Carrito> listaCarrito = ventaDAO.listadoCarrito(usuario);
		List<DetalleVenta> listaDetalleventa = ventaDAO.ListadetVentas(listaCarrito);
		System.out.println("Estoy en GenerarVenta => usuario "+usuario);
		System.out.println("Estoy en GenerarVenta => listaCarrito "+listaCarrito);
		System.out.println("Estoy en GenerarVenta => listaDetalleventa "+listaDetalleventa);
		Venta venta = new Venta();
		venta.setCodUsuario(usuario);
		venta.setFecha("2024-12-10");
		HttpSession session = request.getSession();
		int valor = ventaDAO.generarCompra(venta, listaDetalleventa);
		if(valor==1) {
			System.out.println("Insertó venta en BD");
			ClienteInterface clieDAO = daoFactory.getClienteDAO();
			User cliente = clieDAO.obtenerCliente(usuario);
			session.setAttribute("cliente", cliente);
			session.setAttribute("listaDetalleventa", listaDetalleventa);
			request.getRequestDispatcher("Boleta.jsp").forward(request, response);
		}else {
			System.out.println("No Inserto venta en BD");
			request.getRequestDispatcher("Principal.jsp").forward(request, response);
		}
	}
}
