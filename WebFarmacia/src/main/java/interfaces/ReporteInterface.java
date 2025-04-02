package interfaces;

import java.util.List;

import entidades.Reporte;

public interface ReporteInterface {
	
	List<Reporte> ListadoReporte(String idProducto);
	
	public Reporte obtenerReporte(String idReporte);
	
	public List<Reporte> obtenerReportePorFechas(String startDate, String endDate);
	
	public List<Reporte> obtenerReporteVenta(String sDate, String eDate);
}
