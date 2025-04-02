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
import entidades.Reporte;
import interfaces.ReporteInterface;

/**
 * Servlet implementation class ReporteServlet
 */
@WebServlet("/ReporteServlet")
public class ReporteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReporteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String codigoProducto=request.getParameter("idProducto");
		System.out.println("Estoy en reporteServlet"+codigoProducto);
		DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ReporteInterface producDAO = daoFactory.getReporteDAO();
		List<Reporte> listaReporte = producDAO.ListadoReporte(codigoProducto);
		
		HttpSession session = request.getSession();
		session.setAttribute("listaReporte", listaReporte);
		
		
		request.getRequestDispatcher("Reporte.jsp").forward(request, response);
	}
	
//	
//	String startDate = request.getParameter("startDate");
//    String endDate = request.getParameter("endDate");
//
//    if (startDate != null && endDate != null) {
//        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
//        ReporteInterface reporteDAO = daoFactory.getReporteDAO();
//
//        List<Reporte> reportes = reporteDAO.ListadoReporte(startDate, endDate);
//
//        out.println("<table border='1'>");
//        out.println("<tr><th>ID</th><th>Fecha Inicio</th><th>Fecha Fin</th><th>Total Ventas</th><th>Cantidad Ventas</th><th>Productos Vendidos</th></tr>");
//
//        for (Reporte reporte : reportes) {
//            out.println("<tr>");
//            out.println("<td>" + reporte.getIdReporte() + "</td>");
//            out.println("<td>" + reporte.getFechaInicio() + "</td>");
//            out.println("<td>" + reporte.getFechaFin() + "</td>");
//            out.println("<td>" + reporte.getTotalVentas() + "</td>");
//            out.println("<td>" + reporte.getCantidadVentas() + "</td>");
//            out.println("<td>" + reporte.getProductosVendidos() + "</td>");
//            out.println("</tr>");
//        }
//
//        out.println("</table>");
//    } else {
//        out.println("<p>Por favor, ingrese un rango de fechas para generar el reporte.</p>");
//    }

}
