package interfaces;

import java.util.List;

import entidades.Producto;

public interface ProductoInterface {
	
	public List<Producto> ListadoProducto(String idCategoria);
	public List<Producto> ListadoGeneralProducto();
	
	public Producto obtenerProducto(String codProducto);
	
	public int registrarProducto(Producto nuevo_Producto); 
	
	public int eliminarProducto(int codProducto);
	
	public int modificarProducto(Producto midifiProduc);
	
	public int ActualizarStock(String cantidad, String codProducto);
}
