package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bd.MySQLConexion;
import entidades.Proveedores;
import interfaces.ProveedoresInterface;

public class ProveedoresModelo implements ProveedoresInterface {

	@Override
	public List<Proveedores> listadoProveedores() {
		List<Proveedores> listaProveedores = new ArrayList<Proveedores>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexionMySQL();
			String sql = "SELECT * FROM proveedores";
			pstm= con.prepareStatement(sql);
			rs= pstm.executeQuery();
			while(rs.next()) {
				Proveedores prov = new Proveedores();
				prov.setCodProveedor(rs.getString(1));
				prov.setNombreProveedor(rs.getString(2));
				prov.setNumProveedor(rs.getString(3));
				prov.setCorreo(rs.getString(4));
				prov.setEncargado(rs.getString(5));
				prov.setPais(rs.getString(6));
				prov.setImagen(rs.getString(7));
				listaProveedores.add(prov);
				System.out.println("nombre "+prov.getNombreProveedor());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con !=null)con.close();
				if(pstm !=null)pstm.close();
				if(rs !=null)rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		
		return listaProveedores;
	}

	@Override
	public int EliminarProveedor(String idProveedor) {
		int valor = 0;
		Connection con = null;
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexionMySQL();
			String sql = "{CALL sp_eliminarProveedores(?)}";
			cstm=con.prepareCall(sql);
			cstm.setString(1, idProveedor);
			valor = cstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(cstm!=null) cstm.close();
				if(con!=null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return valor;
	}

	@Override
	public int nuevoProveedor(Proveedores prov) {
		int valor = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySQLConexion.getConexionMySQL();
			String sql = "INSERT INTO proveedores VALUES (null,?,?,?,?,?,?)";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, prov.getNombreProveedor());
			pstm.setString(2, prov.getNumProveedor());
			pstm.setString(3, prov.getCorreo());
			pstm.setString(4, prov.getEncargado());
			pstm.setString(5, prov.getPais());
			pstm.setString(6, prov.getImagen());
			valor = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) pstm.close();
				if(con!=null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return valor;
	}

	@Override
	public int modificarProveedor(Proveedores prov) {
		int valor = 0;
		Connection con = null;
		CallableStatement cstm = null;
		try {
			con = MySQLConexion.getConexionMySQL();
			String sql = "{CALL sp_modificarProveedor(?,?,?,?,?,?,?)}";
			cstm = con.prepareCall(sql);
			cstm.setString(1, prov.getCodProveedor());
			cstm.setString(2, prov.getNombreProveedor());
			cstm.setString(3, prov.getNumProveedor());
			cstm.setString(4, prov.getCorreo());
			cstm.setString(5, prov.getEncargado());
			cstm.setString(6, prov.getPais());
			cstm.setString(7, prov.getImagen());
			valor = cstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(cstm!=null) cstm.close();
				if(con!=null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return valor;
	}

	@Override
	public Proveedores obtenerProv(String idProv) {
		Proveedores prov = null;
		Connection con = null;
		CallableStatement castm = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexionMySQL();
			String sql ="{CALL sp_obtenerProveedores(?)}";
			castm = con.prepareCall(sql);
			castm.setString(1, idProv);
			rs= castm.executeQuery();
			while(rs.next()) {
				prov = new  Proveedores();
				prov.setCodProveedor(rs.getString(1));
				prov.setNombreProveedor(rs.getString(2));
				prov.setNumProveedor(rs.getString(3));
				prov.setCorreo(rs.getString(4));
				prov.setEncargado(rs.getString(5));
				prov.setPais(rs.getString(6));
				prov.setImagen(rs.getString(7));
			}
		}catch (Exception e) {
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
		return prov;
	}

}
