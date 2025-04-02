package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bd.MySQLConexion;

import entidades.User;
import interfaces.ClienteInterface;

public class ClienteModelo implements ClienteInterface {

	@Override
	public List<User> listadoCliente(String icCLiente) {
		List<User> listaCliente = new ArrayList<User>();
		Connection con = null;
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexionMySQL();
			String sql = "{CALL sp_listadoCliente(?)}";
			cstm = con.prepareCall(sql);
			cstm.setString(1, icCLiente);
			rs =cstm.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(Integer.parseInt(rs.getString(1)));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setRole(rs.getString(5));
				listaCliente.add(user);
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

		return listaCliente;
	}

	@Override
	public int ModiificarCliente( User user) {
		 int value = 0;
		    Connection con=null;
			CallableStatement cstm = null;
			try {
				con = MySQLConexion.getConexionMySQL();
				String sql = "{CALL sp_modificarCliente(?,?,?,?)}";
				cstm = con.prepareCall(sql);
				cstm.setInt(1, user.getId());
				cstm.setString(2, user.getName());
				cstm.setString(3, user.getEmail());
				cstm.setString(4, user.getPassword());
				value = cstm.executeUpdate();
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
		return value;
	}

	@Override
	public User obtenerCliente(String idCliente) {
		User user=null;
		Connection con = null;
		CallableStatement castm = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexionMySQL();
			String sql = "{CALL sp_obtenerClientes(?)}";
			castm = con.prepareCall(sql);
			castm.setString(1, idCliente);
			rs= castm.executeQuery();
			while(rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setRole(rs.getString(5));
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
		}return user;
	}

	
	
}
