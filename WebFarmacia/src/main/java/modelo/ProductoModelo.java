package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bd.MySQLConexion;
import entidades.Producto;
import interfaces.ProductoInterface;

public class ProductoModelo implements ProductoInterface {

	@Override
	public List<Producto> ListadoProducto(String idCategoria) {
		List<Producto> listaProducto = new ArrayList<Producto>();
		Connection con = null;
		CallableStatement castm = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexionMySQL();
			String sql ="{CALL sp_listadoProductos(?)}";
			castm = con.prepareCall(sql);
			castm.setString(1, idCategoria);
			rs = castm.executeQuery();
			while(rs.next()) {
				Producto pro = new Producto();
				pro = new Producto();
				pro.setCodigoProducto(rs.getString("codigoProducto"));
				pro.setNombreProducto(rs.getString("nombreProducto"));
				pro.setDescripcion(rs.getString("descripcion"));
				pro.setPrecio(rs.getString("precio"));
				pro.setCantidadStock(rs.getString("cantidadStock"));
				pro.setCantidadMinima(rs.getString("cantidadMinima"));
				pro.setIdCategoria(rs.getString("idCategoria"));
				pro.setNombreCategoria(rs.getString("nombreCategoria")); 
				pro.setMarca(rs.getString("marca"));
				pro.setFechaIngreso(rs.getString("fechaIngreso"));
				pro.setFechaVencimiento(rs.getString("fechaVencimiento"));
				System.out.println("fechavencimiento : "+pro.getFechaVencimiento());
				pro.setDescuento(rs.getString("descuento"));
				pro.setImagen(rs.getString("imagen"));
				pro.setIdProveedor(rs.getString("idProveedor"));
				pro.setLaboratorio(rs.getString("NombreProveedor"));
				listaProducto.add(pro);
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
		
		return listaProducto;
	}

	@Override
	public Producto obtenerProducto(String codProducto) {
		Producto pro = null;
		Connection con = null;
		CallableStatement castm = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexionMySQL();
			String sql ="{CALL sp_obtenerProductos(?)}";
			castm = con.prepareCall(sql);
			castm.setString(1, codProducto);
			rs= castm.executeQuery();
			while(rs.next()) {
				pro = new Producto();
				pro.setCodigoProducto(rs.getString("codigoProducto"));
				pro.setNombreProducto(rs.getString("nombreProducto"));
				pro.setDescripcion(rs.getString("descripcion"));
				pro.setPrecio(rs.getString("precio"));
				pro.setCantidadStock(rs.getString("cantidadStock"));
				pro.setCantidadMinima(rs.getString("cantidadMinima"));
				pro.setIdCategoria(rs.getString("idCategoria"));
				pro.setNombreCategoria(rs.getString("nombreCategoria")); 
				pro.setMarca(rs.getString("marca"));
				pro.setFechaIngreso(rs.getString("fechaIngreso"));
				pro.setFechaVencimiento(rs.getString("fechaVencimiento"));
				pro.setDescuento(rs.getString("descuento"));
				pro.setImagen(rs.getString("imagen"));
				pro.setIdProveedor(rs.getString("idProveedor"));
				pro.setLaboratorio(rs.getString("NombreProveedor"));
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
		return pro;
	}

	@Override
	public int registrarProducto(Producto nuevoProduc) {
		int data=0;
		Connection con=null;
		PreparedStatement pstm=null;
		try {
			con=MySQLConexion.getConexionMySQL();
			String sql="INSERT INTO producto VALUES (null,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstm=con.prepareStatement(sql);
			pstm.setString(1,nuevoProduc.getNombreProducto());
			pstm.setString(2,nuevoProduc.getDescripcion());
			pstm.setString(3,nuevoProduc.getPrecio());
			pstm.setString(4,nuevoProduc.getCantidadStock());
			pstm.setString(5,nuevoProduc.getCantidadMinima());
			pstm.setString(6,nuevoProduc.getIdCategoria());
			pstm.setString(7,nuevoProduc.getMarca());
			pstm.setString(8,nuevoProduc.getIdProveedor());
			pstm.setString(9,nuevoProduc.getFechaIngreso());
			pstm.setString(10,nuevoProduc.getFechaVencimiento());
			pstm.setString(11,nuevoProduc.getDescuento());
			pstm.setString(12,nuevoProduc.getImagen());
			data=pstm.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) pstm.close();
				if(con!=null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return data;
	}

	@Override
	public int eliminarProducto(int codProducto) {
		int data = 0;
		Connection con = null;
		CallableStatement castm = null;
		
		try {
			con= MySQLConexion.getConexionMySQL();
			String sql = "{call sp_eliminarProducto(?)}";
			castm = con.prepareCall(sql);
			castm.setInt(1, codProducto);
			data= castm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(castm!=null) castm.close();
				if(con!=null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return data;
	}

	@Override
	public int modificarProducto(Producto midifiProduc) {
		int data=0;
		Connection con=null;
		PreparedStatement pstm=null;
		try {
			con=MySQLConexion.getConexionMySQL();
			String sql="{call sp_modificarProducto(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			pstm=con.prepareStatement(sql);
			pstm.setString(1,midifiProduc.getCodigoProducto());
			pstm.setString(2,midifiProduc.getNombreProducto());
			pstm.setString(3,midifiProduc.getDescripcion());
			pstm.setString(4,midifiProduc.getPrecio());
			pstm.setString(5,midifiProduc.getCantidadStock());
			pstm.setString(6,midifiProduc.getCantidadMinima());
			pstm.setString(7,midifiProduc.getIdCategoria());
			pstm.setString(8,midifiProduc.getMarca());
			pstm.setString(9,midifiProduc.getIdProveedor());
			pstm.setString(10,midifiProduc.getFechaIngreso());
			pstm.setString(11,midifiProduc.getFechaVencimiento());
			pstm.setString(12,midifiProduc.getDescuento());
			pstm.setString(13,midifiProduc.getImagen());
			data=pstm.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) pstm.close();
				if(con!=null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return data;
	}

	@Override
	public List<Producto> ListadoGeneralProducto() {
		List<Producto> ListadoGeneralProducto = new ArrayList<Producto>();
		Connection con = null;
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexionMySQL();
			String sql ="{CALL sp_listadoProductosGeneral()}";
			cstm = con.prepareCall(sql);
			rs = cstm.executeQuery();
			while(rs.next()) {
				Producto pro = new Producto();
				pro = new Producto();
				pro.setCodigoProducto(rs.getString("codigoProducto"));
				pro.setNombreProducto(rs.getString("nombreProducto"));
				pro.setDescripcion(rs.getString("descripcion"));
				pro.setPrecio(rs.getString("precio"));
				pro.setCantidadStock(rs.getString("cantidadStock"));
				pro.setCantidadMinima(rs.getString("cantidadMinima"));
				pro.setIdCategoria(rs.getString("idCategoria"));
				pro.setNombreCategoria(rs.getString("nombreCategoria")); 
				pro.setMarca(rs.getString("marca"));
				pro.setFechaIngreso(rs.getString("fechaIngreso"));
				pro.setFechaVencimiento(rs.getString("fechaVencimiento"));
				pro.setDescuento(rs.getString("descuento"));
				pro.setImagen(rs.getString("imagen"));
				pro.setIdProveedor(rs.getString("idProveedor"));
				pro.setLaboratorio(rs.getString("NombreProveedor"));
				ListadoGeneralProducto.add(pro);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con !=null)con.close();
				if(cstm !=null)cstm.close();
				if(rs !=null)rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return ListadoGeneralProducto;
	}
	
	@Override
	public int ActualizarStock(String cantidad , String codProducto ) {
		Producto pro = null;
		Connection con = null;
		CallableStatement cstm = null;
		int valor = 0;
		try {
			con= MySQLConexion.getConexionMySQL();
			String sql = "{CALL sp_MantenimientoStock(?,?)}";
			cstm = con.prepareCall(sql);
			cstm.setString(1,codProducto );
			cstm.setString(2,cantidad );
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
	
}
