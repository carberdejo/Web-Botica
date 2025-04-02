package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bd.MySQLConexion;
import entidades.Categorias;
import interfaces.CategoriaInterface;

public class CategoriaModelo implements CategoriaInterface {

	@Override
	public List<Categorias> ListadoCategoria() {
		List<Categorias> listaCategoria = new ArrayList<Categorias>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			con = MySQLConexion.getConexionMySQL();
			String sql = "SELECT * FROM categorias";
			pstm = con.prepareStatement(sql);
			rs= pstm.executeQuery();
			
			while(rs.next()) {
				Categorias cat = new Categorias();
				cat.setIdCategoria(rs.getString(1));
				cat.setNombreCategoria(rs.getString(2));
				listaCategoria.add(cat);
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
		return listaCategoria;
	}

}
