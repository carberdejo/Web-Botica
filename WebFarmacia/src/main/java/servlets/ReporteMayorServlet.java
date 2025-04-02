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
 * Servlet implementation class ReporteMayorServlet
 */
public class ReporteMayorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReporteMayorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ReporteInterface producDAO = daoFactory.getReporteDAO();
		
		
		HttpSession session = request.getSession();
		
		 String sDate = request.getParameter("sDate");
         String eDate = request.getParameter("eDate");
         
         System.out.print("start date");
         System.out.print(sDate);
         System.out.print("params");
         System.out.print(request.getQueryString());
         
         if (sDate != null && eDate != null) {
 			
 			System.out.print("emtro se guardo datos -> reporteServlet");
 			List<Reporte> reporteVenta = (List<Reporte>) producDAO.obtenerReporteVenta(request.getParameter("sDate"), request.getParameter("eDate"));
 			session.setAttribute("listaReporteVenta", reporteVenta);
 			
 			System.out.print("se guardo datos -> reporteServlet");
         }
         request.getRequestDispatcher("ReporteProducto.jsp").forward(request, response);
	}
	
}
