<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entidades.*"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    .product-card {
      border: 1px solid #ddd;
      border-radius: 10px;
      padding: 15px;
      text-align: center;
      transition: transform 0.3s ease, box-shadow 0.3s ease;
    }
    .product-card:hover {
      transform: scale(1.05);
      box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    }
    .discount-badge {
      background-color: #f44336;
      color: white;
      padding: 5px 10px;
      border-radius: 5px;
      font-size: 0.9rem;
      position: absolute;
      top: 10px;
      left: 10px;
    }
  </style>
<title>Insert title here</title>
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



	
	<div class="container my-5">
    <h2 class="mb-4">Farmacia</h2>
    <div class="row">
     

      <!-- Products Section -->
      <div class="col-md-12">
        <div class="row">
        <%
        List<Producto> listaProducto = (List<Producto>) session.getAttribute("listaProducto");

				if(listaProducto != null){
					for(Producto item : listaProducto){
						 %>	
					
          <!-- Product Card -->
          
          <div class="col-md-4 mb-4">
          <a href="DetalleServlet?type=info&codigoProducto=<%=item.getCodigoProducto()%>&idCategoria=<%=item.getIdCategoria()%>">
            <div class="product-card position-relative">
              <div class="discount-badge"><%=item.getDescuento()%> dscto.</div>
              <img src="img/<%=item.getImagen() %>" alt="Producto" class="img-fluid mb-3">
              <h5 class="mb-2"><%=item.getNombreProducto() %></h5>
              <p class="text-muted">Válido del <%=item.getFechaIngreso() %> al <%=item.getFechaVencimiento() %> o hasta agotar.</p>
              <p>
                <span class="text-danger fw-bold">s/ <%=item.precioDSCT() %></span>
                <span class="text-decoration-line-through text-muted"><%=item.getPrecio() %></span>
              </p>
              <%if(datosUser.getRole().equals("admin")){ %>
              <div class="btn-group" role="group" aria-label="Basic example">
             
              <a class="btn btn-warning" href="AccionServlet?type=info&tipo=ProducModi&codigoProducto=<%=item.getCodigoProducto()%>">Modificar</a>          
              <a class="btn btn-danger" href="AccionServlet?type=info&tipo=Eliminar&cProducto=<%=item.getCodigoProducto()%>&>&idCategoria=<%=item.getIdCategoria()%>">Eliminar</a>
             
               </div>
                <%}else{ %>
              <a class="btn btn-outline-primary w-100" href="VentaServlet?tipo=agregarCarrito&codigoProducto=<%=item.getCodigoProducto()%>&cantidad=1&usuario=<%=datosUser.getId()%>">Agregar</a>
            <%} %>
            </div>
            </a>
          </div>
          <%}} %>

          <!-- Puedes replicar más tarjetas similares aquí -->
        </div>
      </div>
    </div>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
		
</body>
</html>