<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.util.List" %>
<%@page import = "entidades.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Carrito</title>
<style type="text/css">
	#imagencarrito{
		height: 100px;
		widows: 100px;
		 object-fit: cover;
	}
	#imagencarrito img{
	widows: 100%;
	height: 100%;
	object-fit: cover;
	}
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>

<% if(session.getAttribute("listaCategoria")==null){
	%>
	<script> window.location.href="CategoriaServlet"</script>
	<%
}	
%>
<% User datosUser=(User) session.getAttribute("user");%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="Principal.jsp">MichiFarma</a>
    
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          	<a class="navbar-brand d-flex align-items-center" href="#">
     		 <img src="img/logo.png" alt="Logo" width="40" height="	40" class="me-2">
    		</a>
        </li>
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="AccionServlet?tipo=ListarTodo">Productos</a>
        </li>
        <%if(datosUser.getRole().equals("admin")){ %>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="Reporte.jsp">Reportes</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="ClienteServlet?accion=ListarCli">Clientes</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="ProveedoresServlet?caso=ListarProv">Proveedores</a>
        </li>
        <%} %>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Categorías
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
          
          	<% List<Categorias> listaCategoria =(List<Categorias>) session.getAttribute("listaCategoria"); %>
          		<%if(listaCategoria != null){
					for(Categorias item:listaCategoria){
				%>		
						
						<li><a class="dropdown-item" href="ProductoServlet?type=info&idCategoria=<%=item.getIdCategoria()%>">
							<%=item.getNombreCategoria() %>
						</a></li>	
						<%
					}
				}
				%>
          </ul>
        </li>
        <li class="nav-item">
          <a class="btn btn-outline-success" aria-current="page" href="VentaServlet?tipo=listarCarrito&usuario=<%=datosUser.getId()%>">Carrito</a>
        </li>
      </ul>
      <!-- Elementos alineados a la derecha -->
      
      <ul class="navbar-nav ms-auto">
        <li class="nav-item dropdown">
          <a class="btn btn-success" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Bienvenido
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <a class="dropdown-item">
            <%if(datosUser.getRole().equals("admin")){ %>
              <img src="img/admin.png" alt="60" width="60">
           	<%} else{%>
           		<img src="img/cliente.png" alt="60" width="60">
           	<%} %>
            </a>
            <a class="dropdown-item" href="#"><%=datosUser.getRole()%></a>
            <a class="dropdown-item" href="#"><%=datosUser.getName() %></a>
            <a class="dropdown-item" href="#"><%=datosUser.getEmail() %></a>
            
             <a name="xxxxxxxxx" value="Salir" class="dropdown-item" href="Login.jsp">Salir</a>
           
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>


	<%double importe = 0; %>

  <div class="container mt-4">
    <h3>Mi Bolsa</h3>
    <div class="list-group">
        <% List<Carrito> listaCarrito = (List<Carrito>) session.getAttribute("listaCarrito"); 
        if(listaCarrito != null){
            for(Carrito car : listaCarrito){
        %>	
        <div class="list-group-item d-flex justify-content-between align-items-center">
            <div class="d-flex align-items-center">
                <div id="imagencarrito">
                    <img src="img/<%=car.getImagen() %>" class="img-thumbnail me-3 product-img" alt="Producto">
                </div>
                <div>
                    <h6><%=car.getNomProducto() %></h6>
                    <span class="text-muted"><%=car.getCantidad() %> unidad</span>
                </div>
            </div>
            <div class="text-end">
                <span class="text-danger">S/.<%=car.Descuento() %></span>
                <span class="text-danger">S/.<%=car.ImporteDescuento() %></span>
                <span class="text-danger">S/.<%=car.getPrecio() %></span>
                <a href="VentaServlet?tipo=EliminarProdCarrito&codCarrito=<%=car.getIdCarrito() %>&usuario=<%=datosUser.getId() %>" 
                   class="btn btn-outline-danger btn-sm ms-2">X</a>
            </div>
        </div>
        <% } %>
    </div>
    <% 
        for(Carrito car : listaCarrito){
            importe += car.ImporteDescuento();  	
        }
    %>

    <div class="mt-3">
        <h6>Total: S/.<%=importe %></h6>
        <% } %>
        <!-- Botón que activa el modal -->
        <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#confirmarCompraModal">
            Ir a mi compra
        </button>
    </div>
</div>

<!-- Modal de confirmación -->
<div class="modal fade" id="confirmarCompraModal" tabindex="-1" aria-labelledby="confirmarCompraModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="confirmarCompraModalLabel">Confirmar Compra</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Cerrar"></button>
            </div>
            <div class="modal-body">
                <p>¿Está seguro de que desea confirmar su compra por un total de <strong>S/.<%=importe %></strong>?</p>
                <ul>
                    <% for(Carrito car : listaCarrito) { %>
                    <li><%=car.getNomProducto() %> - <%=car.getCantidad() %> unidad(es)</li>
                    <% } %>
                </ul>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                <a href="VentaServlet?tipo=GenerarVenta&usuario=<%=datosUser.getId()%>" class="btn btn-success">Confirmar</a>
            </div>
        </div>
    </div>
</div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>