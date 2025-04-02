package entidades;

public class DetalleVenta {
	private String codVenta,codProducto,nombreProducto,cantidad,precio,descuento,importe;

	public String getCodVenta() {
		return codVenta;
	}

	public void setCodVenta(String codVenta) {
		this.codVenta = codVenta;
	}

	public String getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
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

	public String getImporte() {
		return importe;
	}

	public void setImporte(String improte) {
		this.importe = improte;
	}

	public String getDescuento() {
		return descuento;
	}

	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}
	
	
	
}
