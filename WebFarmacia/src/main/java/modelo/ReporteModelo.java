package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bd.MySQLConexion;
import entidades.Reporte;
import interfaces.ReporteInterface;

public class ReporteModelo implements ReporteInterface {
	
	@Override
	public List<Reporte> ListadoReporte (String idProducto) {
		List<Reporte> listaReporte = new ArrayList<Reporte>();
		Connection con = null;
		CallableStatement castm = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexionMySQL();
			String sql ="{CALL sp_listadoReporte(?)}";
			castm = con.prepareCall(sql);
			castm.setString(1, idProducto);
			rs = castm.executeQuery();
			while(rs.next()) {
				Reporte reporte = new Reporte();
				reporte = new Reporte();
				reporte.setIdReporte(rs.getString("idReporte"));
				reporte.setFechaInicio(rs.getString("fechaInicio"));
				reporte.setFechaFin(rs.getString("fechaFin"));
				reporte.setTotalVentas(rs.getString("totalVentas"));
				reporte.setCantidadVentas(rs.getString("cantidadVentas"));
				reporte.setProductosVendidos(rs.getString("productosVendidos"));
				listaReporte.add(reporte);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con !=null)con.close();
				if(castm !=null)castm.close();
				if(rs !=null)rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return listaReporte;
	
	}
	@Override
	public Reporte obtenerReporte (String idReporte) {
		Reporte reporte = null;
		Connection con = null;
		CallableStatement castm = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexionMySQL();
			String sql ="{CALL sp_obtenerProductos(?)}";
			castm = con.prepareCall(sql);
			castm.setString(1, idReporte);
			rs= castm.executeQuery();
			while(rs.next()) {
				reporte = new Reporte();
				reporte.setIdReporte(rs.getString("idReporte"));
				reporte.setFechaInicio(rs.getString("fechaInicio"));
				reporte.setFechaFin(rs.getString("fechaFin"));
				reporte.setTotalVentas(rs.getString("totalVentas"));
				reporte.setCantidadVentas(rs.getString("cantidadVentas"));
				reporte.setProductosVendidos(rs.getString("productosVendidos"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con !=null)con.close();
				if(castm !=null)castm.close();
				if(rs !=null)rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}	
		return reporte;
	}
	@Override
	public List<Reporte> obtenerReportePorFechas(String startDate, String endDate) {
		
		
		
		
		String sql = "SELECT SUM(dv.importe) AS totalVentas, COUNT(DISTINCT v.codVenta) AS cantidadVentas, SUM(dv.cantidad) AS productosVendidos  FROM venta as v INNER JOIN detalleVenta dv ON v.codVenta = dv.codVenta  WHERE v.fecha BETWEEN ? AND ?";
		 //String sql = "SELECT * FROM Reporte WHERE fechaInicio >= ? AND fechaFin <= ?";
		System.out.print("Query:");
		System.out.print(sql);
	    List<Reporte> listaReporte = new ArrayList<>();
	    try (Connection con = MySQLConexion.getConexionMySQL();
	         PreparedStatement ps = con.prepareStatement(sql)) {
	        
	        ps.setString(1, startDate);
	        ps.setString(2, endDate);
	        System.out.print(ps);
	        ResultSet rs = ps.executeQuery();
	        
	        while (rs.next()) {
	            Reporte reporte = new Reporte();
	            reporte.setIdReporte("1");
	            reporte.setFechaInicio(startDate);
	            reporte.setFechaFin(endDate);
	            reporte.setTotalVentas(rs.getString("totalVentas"));
	            reporte.setCantidadVentas(rs.getString("cantidadVentas"));
	            reporte.setProductosVendidos(rs.getString("productosVendidos"));
	            listaReporte.add(reporte);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return listaReporte;
	}
	
	@Override
	public List<Reporte> obtenerReporteVenta(String sDate, String eDate) {
		Connection con = null;
		CallableStatement castm = null;
		
	    List<Reporte> listaReporte = new ArrayList<>();
	    try { 
	    	con =  MySQLConexion.getConexionMySQL();
	    	String sql = "{CALL sp_obtenerReporte(?,?)}";
	    	castm = con.prepareCall(sql);  
	    	castm.setString(1, sDate);
	    	castm.setString(2, eDate);
	        ResultSet rs = castm.executeQuery();
	        
	        while (rs.next()) {
	            Reporte reporte = new Reporte();
	            reporte.setIdReporte("1");
	            reporte.setFechaInicio(sDate);
	            reporte.setFechaFin(eDate);
	            reporte.setIdProducto(rs.getString("idProducto"));
	            reporte.setNombreProducto(rs.getString("nombreProducto"));
	            reporte.setCantidadVendida(rs.getString("cantidadVendida"));
	            reporte.setTotalGenerado(rs.getString("totalGenerado"));
	            listaReporte.add(reporte);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return listaReporte;
	}
	
	
	
	
}
