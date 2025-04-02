package dao;

import interfaces.CategoriaInterface;
import interfaces.ClienteInterface;
import interfaces.LoginInterface;
import interfaces.ProductoInterface;
import interfaces.ProveedoresInterface;
import interfaces.ReporteInterface;
import interfaces.VentaInterface;

public abstract class DAOFactory {
	public static final int MYSQL = 1;
	public static final int SQLSERVER = 2;
	public static final int ORACLE = 3;
	
	public abstract CategoriaInterface getCategoriaDAO();
	public abstract ProductoInterface getProductoDAO();
	public abstract VentaInterface getVentaDAO();
	 public abstract LoginInterface getLoginDAO();
	 public abstract ReporteInterface getReporteDAO();
	 public abstract ProveedoresInterface getProveedoresDAO();;
	 public abstract ClienteInterface getClienteDAO();
	
	public static DAOFactory getDAOFactory(int tipo) {
		switch(tipo){
		case MYSQL : return new MySQLDAOFactory() ;
		case SQLSERVER: return null;
		case ORACLE : return null;
		default: return null;
		}
	}
}
