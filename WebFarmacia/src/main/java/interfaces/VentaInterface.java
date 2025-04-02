package interfaces;

import java.util.List;

import entidades.Carrito;
import entidades.DetalleVenta;
import entidades.Venta;

public interface VentaInterface {
	
	public int registrarCarrito(Carrito nuevo_Carrito); 
	
	List<Carrito> listadoCarrito(String usuario);
	
	public int eliminarProdCarrito(int codCarrito);
	
	public int generarCompra( Venta venta, List<DetalleVenta> ListadetVentas);
	
	List<DetalleVenta> ListadetVentas(List<Carrito> listCar);
}
