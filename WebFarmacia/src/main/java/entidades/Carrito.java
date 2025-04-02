package entidades;

public class Carrito {
	private String idCarrito,idUsuario,codProducto,nomProducto,cantidad,precio,descuento,marca,fechaVencimiento,imagen;

	
	
	

	public String getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}

	public String getNomProducto() {
		return nomProducto;
	}

	public void setNomProducto(String nomProducto) {
		this.nomProducto = nomProducto;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getDescuento() {
		return descuento;
	}

	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(String idCarrito) {
		this.idCarrito = idCarrito;
	}
	
	//METODOS
	public double Importe() {
		
		return Double.parseDouble(precio)*Integer.parseInt(cantidad);
	}
	public double Descuento() {
		return Importe()*Double.parseDouble(descuento)/100;
	}
	public double ImporteDescuento() {
		return Importe()-Descuento();
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	
}
