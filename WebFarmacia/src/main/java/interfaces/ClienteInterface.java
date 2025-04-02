package interfaces;

import java.util.List;

import entidades.Proveedores;
import entidades.User;

public interface ClienteInterface {
	
	public List<User> listadoCliente( String icCLiente);
	
	public int ModiificarCliente( User user);
	
	public User obtenerCliente(String idCliente  );
}
