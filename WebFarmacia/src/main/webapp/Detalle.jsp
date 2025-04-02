<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="entidades.*" %>
 <%@page import = "java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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


	<%
	Producto detProd=(Producto) session.getAttribute("detalleProducto");
	%>
<div class="container mt-5">
    <div class="row">
      <!-- Imagen del producto -->
      <div class="col-md-4">
        <div id="carouselExample" class="carousel slide">
          <div class="carousel-inner">
            <div class="carousel-item active">
              <img src="img/<%=detProd.getImagen() %>" class="d-block w-100" alt="Producto principal">
            </div>
            <div class="carousel-item">
              <img src="https://via.placeholder.com/300" class="d-block w-100" alt="Producto alternativo">
            </div>
          </div>
          <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
          </button>
          <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
          </button>
        </div>
      </div>
      
      <!-- Detalles del producto -->
      <div class="col-md-8">
        <h5 class="text-uppercase"><%=detProd.getMarca() %></h5>
        <h3><%=detProd.getNombreProducto() %></h3>
        <div class="d-flex align-items-center mb-3">
          <span class="badge bg-success me-2"><%=detProd.getDescuento()%>% OFF</span>
          <span class="text-muted text-decoration-line-through">S/.<%=detProd.getPrecio() %></span>
          <span class="text-danger ms-2 fs-4">S/.<%=detProd.precioDSCT() %></span>
        </div>
         <%if(datosUser.getRole().equals("admin")){ %>
       
        <p class="mb-3">Stock disponible: <strong><%=detProd.getCantidadStock() %></strong></p>
        <p class="mb-3">Cantidad mínima de compra: <strong><%=detProd.getCantidadMinima() %></strong></p>
        <%} %>
        <p class="mb-3">Categoría: <strong><%=detProd.getNombreCategoria() %> (ID: <%=detProd.getIdCategoria() %>)</strong></p>
        <p class="mb-3">Laboratorio: <strong><%=detProd.getLaboratorio() %></strong></p>
        <p class="mb-3">Fecha de ingreso: <strong><%=detProd.getFechaIngreso() %></strong></p>
        <p class="mb-3">Fecha de vencimiento: <strong><%=detProd.getFechaVencimiento() %></strong></p>
        <p class="mb-3">Producto general</p>
        
        <!-- Cantidad y botón -->
         <%if(!datosUser.getRole().equals("admin")){ %>
        <form action="VentaServlet?tipo=agregarCarrito&usuario=<%=datosUser.getId()%>" method="post">
        <%}else{ %>
        <form action="AccionServlet?tipo=ActualizarStock" method="post">
        <%} %>
        <input type="hidden" name="codigoProducto" value="<%= detProd.getCodigoProducto() %>">   
        <div class="d-flex align-items-center mb-3">
          <label for="quantity" class="me-3">Cantidad:</label>
          <div class="input-group" style="width: 120px;">
            <button class="btn btn-outline-secondary" type="button"  onclick="adjustQuantity(-1)">-</button>
   				 <input type="number" name="cantidad" class="form-control text-center" id="quantity" value="1" min="1" >
    		<button class="btn btn-outline-secondary" type="button" onclick="adjustQuantity(1)" >+</button>
          </div>
        </div>
        <%if(datosUser.getRole().equals("admin")){ %>
        <button  type="submit" class="btn btn-success btn-lg w-100" >Actualizar Stock</button >
        <%}else{%>
         <button  type="submit" class="btn btn-success btn-lg w-100" >Agregar a mi bolsa</button >
        <%} %>
        </form>	
        <p class="mt-3 text-success"><i class="bi bi-star-fill"></i> Con la compra de este producto acumulas 533 puntos</p>
      </div>
    </div>

    <!-- Descripción -->
    <div class="mt-5">
      <h4>Descripción</h4>
      <p>
        <%=detProd.getDescripcion() %>
      </p>
    </div>
  </div>
  <script >
  function adjustQuantity(change) {
	    const quantityInput = document.getElementById('quantity');
	    let newValue = parseInt(quantityInput.value || 1) + change;
	    if (newValue < 1) newValue = 1; // Asegurarse de que no sea menor que 1
	    quantityInput.value = newValue;
	    
	  }
  </script>

  <!-- Bootstrap JS -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>