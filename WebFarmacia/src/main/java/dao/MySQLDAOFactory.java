package dao;

import interfaces.CategoriaInterface;
import interfaces.ClienteInterface;
import interfaces.LoginInterface;
import interfaces.ProductoInterface;
import interfaces.ProveedoresInterface;
import interfaces.ReporteInterface;
import interfaces.VentaInterface;
import modelo.CategoriaModelo;
import modelo.ClienteModelo;
import modelo.LoginModelo;
import modelo.ProductoModelo;
import modelo.ProveedoresModelo;
import modelo.ReporteModelo;
import modelo.VentaModelo;

public class MySQLDAOFactory extends DAOFactory {

	@Override
	public CategoriaInterface getCategoriaDAO() {

		return new CategoriaModelo();
	}

	@Override
	public ProductoInterface getProductoDAO() {
		return new ProductoModelo();
	}

	@Override
	public VentaInterface getVentaDAO() {
		
		return new VentaModelo();
	}

	@Override
	public LoginInterface getLoginDAO() {
		
		return new LoginModelo();
	}

	@Override
	public ReporteInterface getReporteDAO() {
		
		return new ReporteModelo();
	}

	@Override
	public ProveedoresInterface getProveedoresDAO() {
		
		return new  ProveedoresModelo();
	}

	@Override
	public ClienteInterface getClienteDAO() {
		
		return new ClienteModelo();
	}

}
