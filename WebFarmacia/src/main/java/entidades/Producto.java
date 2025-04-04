package entidades;

import java.text.DecimalFormat;

public class Producto {
	private String codigoProducto,nombreProducto,descripcion,precio,
	cantidadStock,cantidadMinima,idCategoria,nombreCategoria,marca,idProveedor,laboratorio,
	fechaIngreso,fechaVencimiento,imagen,descuento;

	public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getCantidadStock() {
		return cantidadStock;
	}

	public void setCantidadStock(String cantidadStock) {
		this.cantidadStock = cantidadStock;
	}

	public String getCantidadMinima() {
		return cantidadMinima;
	}

	public void setCantidadMinima(String cantidadMinima) {
		this.cantidadMinima = cantidadMinima;
	}

	public String getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
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

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public String getDescuento() {
		return descuento;
	}

	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}
	
	//METODOS DE OPERACION
	public double precioDSCT() {
		double dsct = Double.parseDouble(precio)*Double.parseDouble(descuento)/100;
		double precioDsct = Double.parseDouble(precio)-dsct;
		return Math.round(precioDsct*100.0)/100.0;
	}

	public String getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
	}
	
	
}
