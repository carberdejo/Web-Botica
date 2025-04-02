<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.util.List" %>
<%@page import = "entidades.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modificar producto</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<% if(session.getAttribute("listaCategoria")==null){
	%>
	<script> window.location.href="CategoriaServlet"</script>
	<%
	}	
	%>
	
	<%
	Producto dProducto=(Producto) session.getAttribute("detalleProducto");
	%>
	 <div class="container mt-5">
        <h2 class="text-center mb-4">Agregar Producto</h2>
        <form action="AccionServlet?tipo=Modificar&codigoPro=<%=dProducto.getCodigoProducto() %>" id="productoForm" method="post">
        	<input type = "hidden" id = "campoTipo" name="tipo" value="">
            
            <div class="mb-3">
                <label for="nombreProducto" class="form-label">Nombre del Producto</label>
                <input type="text" class="form-control" name="txtNombre" id="nombreProducto" value="<%=dProducto.getNombreProducto() %>" placeholder="Nombre del producto" >
            </div>
            <div class="mb-3">
                <label for="descripcion" class="form-label">Descripción</label>
                <input class="form-control" name="txtDescripcion" value="<%=dProducto.getDescripcion()%>" id="descripcion" rows="3" placeholder="Descripción del producto">
            </div>
            <div class="mb-3">
                <label for="precio" class="form-label">Precio</label>
                <input type="text" class="form-control" name="txtPrecio" value="<%=dProducto.getPrecio()%>" id="precio" step="0.01" placeholder="Precio en soles" >
            </div>
            <div class="mb-3">
                <label for="cantidadStock" class="form-label">Cantidad en Stock</label>
                <input type="text" class="form-control" name="txtcantidadStock" value="<%=dProducto.getCantidadStock()%>" id="cantidadStock" placeholder="Cantidad disponible" >
            </div>
            <div class="mb-3">
                <label for="cantidadMinima" class="form-label">Cantidad Mínima</label>
                <input type="text" class="form-control" name="txtcantidadMinima" value="<%=dProducto.getCantidadMinima() %>" id="cantidadMinima" placeholder="Cantidad mínima permitida" >
            </div>
            <div class="mb-3">
                <label for="idCategoria"  class="form-label">Categoría</label>
                <select class="form-select" name="cboCategoria"  id="cboCategoria" required>
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
                <input type="text" class="form-control" name="txtmarca" value="<%=dProducto.getMarca() %>" id="marca" placeholder="Marca del producto" >
            </div>
            <div class="mb-3">
                <label for="laboratorio" class="form-label">Laboratorio</label>
                <input type="text" class="form-control" name="txtlaboratorio" value="<%=dProducto.getIdProveedor() %>" id="laboratorio" placeholder="Laboratorio o proveedor" >
            </div>
            <div class="mb-3">
                <label for="fechaIngreso" class="form-label">Fecha de Ingreso</label>
                <input type="date" class="form-control" name="txtfechaIngreso" value="<%=dProducto.getFechaIngreso() %>" id="fechaIngreso" >
            </div>
            <div class="mb-3">
                <label for="fechaVencimiento" class="form-label">Fecha de Vencimiento</label>
                <input type="date" class="form-control" name="txtfechaVencimiento" value="<%=dProducto.getFechaVencimiento() %>" id="fechaVencimiento">
            </div>
            <div class="mb-3">
                <label for="descuento" class="form-label">Descuento (%)</label>
                <input type="text" class="form-control" name="txtdescuento" value="<%=dProducto.getDescuento()%>" id="descuento" step="0.01" placeholder="Descuento en porcentaje">
            </div>
            <div class="mb-3">
    			<label for="imagen" class="form-label">Imagen</label>
   				 <input type="text" class="form-control" name="fileimagen" value="<%= dProducto.getImagen() %>" id="imagen" accept="image/*">
    
   				 <!-- Mostrar la imagen actual si existe -->
   				 <% if (dProducto.getImagen() != null && !dProducto.getImagen().isEmpty()) { %>
     			   <p>Imagen actual:</p>
       			 <img src="img/<%= dProducto.getImagen() %>" alt="Imagen actual" style="max-width: 200px; height: auto;">
       			 <input type="hidden" name="imagenActual" value="<%= dProducto.getImagen() %>">
   					 <% } %>
			</div>

            <input type="submit"  class="btn btn-primary w-100"value="Ingresar">
        </form>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>