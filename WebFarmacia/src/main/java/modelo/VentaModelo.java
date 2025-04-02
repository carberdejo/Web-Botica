package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bd.MySQLConexion;
import entidades.Carrito;
import entidades.DetalleVenta;
import entidades.Producto;
import entidades.Venta;
import interfaces.VentaInterface;

public class VentaModelo implements VentaInterface{

	@Override
	public int registrarCarrito(Carrito nuevo_Carrito) {
		int data=0;
		Connection con=null;
		PreparedStatement pstm=null;
		try {
			con=MySQLConexion.getConexionMySQL();
			String sql="INSERT INTO carritoCompra VALUES (null,?,?,?,?,?,?,?,?,?)";
			pstm=con.prepareStatement(sql);
			pstm.setString(1,nuevo_Carrito.getIdUsuario());
			pstm.setString(2,nuevo_Carrito.getCodProducto());
			pstm.setString(3,nuevo_Carrito.getNomProducto());
			pstm.setString(4,nuevo_Carrito.getCantidad());
			pstm.setString(5,nuevo_Carrito.getPrecio());
			pstm.setString(6,nuevo_Carrito.getDescuento());
			pstm.setString(7,nuevo_Carrito.getMarca());
			pstm.setString(8,nuevo_Carrito.getFechaVencimiento());
			pstm.setString(9,nuevo_Carrito.getImagen());
			
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
	public List<Carrito> listadoCarrito(String usuario) {
		List<Carrito> listadoCarrito = new ArrayList<Carrito>();
		Connection con = null;
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexionMySQL();
			String sql = "{call sp_listadoCarritoCliente(?)}";
			cstm = con.prepareCall(sql);
			cstm.setString(1, usuario);
			rs = cstm.executeQuery();
			while(rs.next()) {
				Carrito car = new Carrito();
				car.setIdCarrito(rs.getString(1));
				car.setIdUsuario(rs.getString(2));
				car.setCodProducto(rs.getString(3));
				car.setNomProducto(rs.getString(4));
				car.setCantidad(rs.getString(5));
				car.setPrecio(rs.getString(6));
				car.setDescuento(rs.getString(7));
				car.setMarca(rs.getString(8));
				car.setFechaVencimiento(rs.getString(9));
				car.setImagen(rs.getString(10));
				listadoCarrito.add(car);
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
		return listadoCarrito;
	}

	@Override
	public int eliminarProdCarrito(int codCarrito) {
		int data = 0;
		Connection con = null;
		CallableStatement castm = null;
		
		try {
			con= MySQLConexion.getConexionMySQL();
			String sql = "{call sp_eliminarProducCarrito(?)}";
			castm = con.prepareCall(sql);
			castm.setInt(1, codCarrito);
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
	public int generarCompra(Venta venta, List<DetalleVenta> ListadetVentas) {
		int valor = 0;
		Connection con = null;
		PreparedStatement pstmVenta = null;
		PreparedStatement pstmDetVenta = null;
		CallableStatement cstmtStock = null;
		CallableStatement cstmtDeleteCarrito = null;
		String codVenta = null;
		try {
			con = MySQLConexion.getConexionMySQL();
			con.setAutoCommit(false);
			
			String sqlVenta ="INSERT INTO venta(codUsuario,fecha) VALUES (?,?)";
			pstmVenta = con.prepareStatement(sqlVenta,PreparedStatement.RETURN_GENERATED_KEYS);
			pstmVenta.setString(1, venta.getCodUsuario());
			pstmVenta.setString(2, venta.getFecha());
			int filasInsertadas = pstmVenta.executeUpdate();
			
			if( filasInsertadas  >0 ) {
				ResultSet rs = pstmVenta.getGeneratedKeys();
				System.out.println("getGeneratedKeys "+rs);
				if(rs.next()) {
					codVenta =rs.getString(1);
					System.out.println("codVenta "+codVenta);
					String sqlDetVenta="INSERT INTO detalleVenta(codVenta,codProducto,nombreProducto,cantidad,precio,descuento,importe) VALUES(?,?,?,?,?,?,?)";
					pstmDetVenta= con.prepareStatement(sqlDetVenta);
					
					for(DetalleVenta detVenta : ListadetVentas ) {
						pstmDetVenta.setString(1, codVenta);
						pstmDetVenta.setString(2, detVenta.getCodProducto());
						pstmDetVenta.setString(3, detVenta.getNombreProducto());
						pstmDetVenta.setString(4, detVenta.getCantidad());
						pstmDetVenta.setString(5, detVenta.getPrecio());
						pstmDetVenta.setString(6, detVenta.getDescuento());
						pstmDetVenta.setString(7, detVenta.getImporte());
						pstmDetVenta.addBatch();  
					}
					
					pstmDetVenta.executeBatch();
					
	                for (DetalleVenta detVenta : ListadetVentas) {
	                	String sqlActualizarStock = "{CALL sp_ActualizarStockCompra(?,?)}";
		                cstmtStock = con.prepareCall(sqlActualizarStock);
	                    cstmtStock.setString(1, detVenta.getCodProducto());
	                    cstmtStock.setString(2, detVenta.getCantidad());
	                    cstmtStock.execute();
	                }
	                String sqllimpiarCar = "{ CALL sp_EliminarCarritoCliente(?)}";
					cstmtDeleteCarrito= con.prepareCall(sqllimpiarCar);
					cstmtDeleteCarrito.setString(1, venta.getCodUsuario());
					cstmtDeleteCarrito.execute();
					con.commit();
					valor = 1;
				}
			}
		} catch (Exception e) {
			valor = 0;
			e.printStackTrace();
			try {
				if(con !=null) con.rollback();
				if( codVenta !=null) {
					System.out.println("codVenta  : "+codVenta);
					PreparedStatement pstmDelete = con.prepareStatement("DELETE FROM venta WHERE codVenta = ?");
	                pstmDelete.setString(1, codVenta);
	                pstmDelete.executeUpdate();
	                pstmDelete.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}finally {
			try {
				if(pstmVenta !=null) pstmVenta.close();
				if(pstmDetVenta !=null) pstmDetVenta.close();
				if(con !=null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}		
		return valor;
	}

	@Override
	public List<DetalleVenta> ListadetVentas(List<Carrito> listCar) {
		List<DetalleVenta> listaDetVentas = new ArrayList<DetalleVenta>();
		for(Carrito car :listCar ) {
			DetalleVenta detV = new DetalleVenta();
			detV.setCodProducto(car.getCodProducto());
			detV.setNombreProducto(car.getNomProducto());
			detV.setPrecio(car.getPrecio());
			detV.setCantidad(car.getCantidad());
			detV.setImporte(""+car.ImporteDescuento());
			detV.setDescuento(""+car.Descuento());
			 listaDetVentas.add(detV);
		}
		return listaDetVentas;
	}

}
