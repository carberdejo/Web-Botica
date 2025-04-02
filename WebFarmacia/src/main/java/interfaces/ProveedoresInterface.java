package interfaces;

import java.util.List;

import entidades.Proveedores;

public interface ProveedoresInterface {
	
	List<Proveedores> listadoProveedores();
	
	public int EliminarProveedor(String idProveedor);
	
	public int nuevoProveedor( Proveedores prov);
	
	public int modificarProveedor(Proveedores prov);
	
	public Proveedores obtenerProv(String idProv);
}
