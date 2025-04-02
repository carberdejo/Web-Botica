<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entidades.*"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ingresar producto</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<% if(session.getAttribute("listaCategoria")==null){
	%>
	<script> window.location.href="CategoriaServlet"</script>
	<%
}	
%>
	 <div class="container mt-5">
        <h2 class="text-center mb-4">Agregar Producto</h2>
        <form action="AccionServlet?tipo=Ingresar" id="productoForm" method="post">
        	<input type = "hidden" id = "campoTipo" name="tipo" value="">
            
            <div class="mb-3">
                <label for="nombreProducto" class="form-label">Nombre del Producto</label>
                <input type="text" class="form-control" name="txtNombre" id="nombreProducto" placeholder="Nombre del producto" >
            </div>
            <div class="mb-3">
                <label for="descripcion" class="form-label">Descripción</label>
                <textarea class="form-control" name="txtDescripcion" id="descripcion" rows="3" placeholder="Descripción del producto"></textarea>
            </div>
            <div class="mb-3">
                <label for="precio" class="form-label">Precio</label>
                <input type="number" class="form-control" name="txtPrecio" id="precio" step="0.01" placeholder="Precio en soles" >
            </div>
            <div class="mb-3">
                <label for="cantidadStock" class="form-label">Cantidad en Stock</label>
                <input type="number" class="form-control" name="txtcantidadStock" id="cantidadStock" placeholder="Cantidad disponible" >
            </div>
            <div class="mb-3">
                <label for="cantidadMinima" class="form-label">Cantidad Mínima</label>
                <input type="number" class="form-control" name="txtcantidadMinima" id="cantidadMinima" placeholder="Cantidad mínima permitida" >
            </div>
            <div class="mb-3">
                <label for="idCategoria"  class="form-label">Categoría</label>
                <select class="form-select" name="cboCategoria" id="cboCategoria" required>
                    <option selected disabled>Seleccione una categoría</option>
                    
                     <% List<Categorias> listaCategoria =(List<Categorias>) session.getAttribute("listaCategoria"); %>
          		<%if(listaCategoria != null){
					for(Categorias item:listaCategoria){
				%>
						<option value="<%=item.getIdCategoria()%>"><%=item.getNombreCategoria() %></option>	
						<%
					}
				}
				%>
                </select>
            </div>
            <div class="mb-3">
                <label for="marca" class="form-label">Marca</label>
                <input type="text" class="form-control" name="txtmarca" id="marca" placeholder="Marca del producto" >
            </div>
            <div class="mb-3">
                <label for="laboratorio" class="form-label">Laboratorio</label>
                <input type="text" class="form-control" name="txtlaboratorio" id="laboratorio" placeholder="Laboratorio o proveedor" >
            </div>
            <div class="mb-3">
                <label for="fechaIngreso" class="form-label">Fecha de Ingreso</label>
                <input type="date" class="form-control" name="txtfechaIngreso" id="fechaIngreso" >
            </div>
            <div class="mb-3">
                <label for="fechaVencimiento" class="form-label">Fecha de Vencimiento</label>
                <input type="date" class="form-control" name="txtfechaVencimiento" id="fechaVencimiento">
            </div>
            <div class="mb-3">
                <label for="descuento" class="form-label">Descuento (%)</label>
                <input type="number" class="form-control" name="txtdescuento" id="descuento" step="0.01" placeholder="Descuento en porcentaje">
            </div>
            <div class="mb-3">
                <label for="imagen" class="form-label">Imagen</label>
                <input type="file" class="form-control" name="fileimagen" id="imagen" accept="image/*">
            </div>
            <input type="submit"  class="btn btn-primary w-100"value="Ingresar">
        </form>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>