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
@WebServlet("/GenerarReporteServlet")
public class GenerarReporteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerarReporteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	    ReporteInterface reporteDAO = daoFactory.getReporteDAO();
	    HttpSession session = request.getSession();

	    String startDate = request.getParameter("startDate");
	    String endDate = request.getParameter("endDate");

	    if (startDate != null && endDate != null) {
	        List<Reporte> reportePorFechas = reporteDAO.obtenerReportePorFechas(startDate, endDate);
	        session.setAttribute("listaReportePorFecha", reportePorFechas);
	    }

	    request.getRequestDispatcher("Reporte.jsp").forward(request, response);
	}
	
}
