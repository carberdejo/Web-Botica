package entidades;

public class Reporte {
	
	private String idReporte;
    private String fechaInicio;
    private String fechaFin;
    private String totalVentas;
    private String cantidadVentas;
    private String productosVendidos;
    
    private String idProducto;
    private String nombreProducto;
    private String cantidadVendida;
    private String totalGenerado;
    
   
    
	public String getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getCantidadVendida() {
		return cantidadVendida;
	}
	public void setCantidadVendida(String cantidadVendida) {
		this.cantidadVendida = cantidadVendida;
	}
	public String getTotalGenerado() {
		return totalGenerado;
	}
	public void setTotalGenerado(String totalGenerado) {
		this.totalGenerado = totalGenerado;
	}
	
	
	public String getIdReporte() {
		return idReporte;
	}
	public void setIdReporte(String idReporte) {
		this.idReporte = idReporte;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getTotalVentas() {
		return totalVentas;
	}
	public void setTotalVentas(String totalVentas) {
		this.totalVentas = totalVentas;
	}
	public String getCantidadVentas() {
		return cantidadVentas;
	}
	public void setCantidadVentas(String cantidadVentas) {
		this.cantidadVentas = cantidadVentas;
	}
	public String getProductosVendidos() {
		return productosVendidos;
	}
	public void setProductosVendidos(String productosVendidos) {
		this.productosVendidos = productosVendidos;
	}
}
