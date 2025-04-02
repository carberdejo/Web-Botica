<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.util.List" %>
<%@page import = "entidades.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Farmacia</title>
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
            <a class="dropdown-item" href="#"><%=datosUser.getName() %></a>
            <a class="dropdown-item" href="#"><%=datosUser.getEmail() %></a>
            
             <a name="xxxxxxxxx" value="Salir" class="dropdown-item" href="Login.jsp">Salir</a>
           
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>


<style>
  .carousel-inner img {
    width: 100%;       
    height: 800px;     /* Altura fija estándar */
     
  }
    
  /* Estilo para los títulos "Ofertas en Cuidado Personal" */
  .carousel-caption h5.ofertas-cuidado-personal {
    font-family: 'Comic Sans MS', cursive, sans-serif; 
    color: #ff66b2; 
    -webkit-text-stroke: 1px black; 
    text-shadow: 2px 2px 4px #000; 
    font-size: 3rem; 
    font-weight: bold; 
  }

  /* Estilo para los títulos "Descuento en Medicamentos" */
  .carousel-caption h5.descuento-medicamentos {
    font-family: 'Comic Sans MS', cursive, sans-serif; 
    color: #8B0000;
    -webkit-text-stroke: 1px white; 
    text-shadow: 2px 2px 4px #000; 
    font-size: 3rem; 
    font-weight: bold; 
  }

  /* Estilo para los títulos "Vitaminas con Descuento" */
  .carousel-caption h5.vitaminas-descuento {
    font-family: 'Comic Sans MS', cursive, sans-serif;
    color: #32CD32; 
    -webkit-text-stroke: 1px white; 
    text-shadow: 2px 2px 4px #000; 
    font-size: 3rem; 
    font-weight: bold; 
  }

  /* Estilo para los párrafos */
  .carousel-caption p {
    font-size: 1.25rem; 
    font-weight: normal; 
  }

 
  .carousel-caption p.black-text {
    color: black; 
    text-shadow: 2px 2px 8px #f5a623; 
  }

  
  .carousel-caption p.white-text {
    color: white; 
    text-shadow: 2px 2px 8px #ff66b2; 
  }
  
  
  .carousel-caption h5::after {
    content: "🎄"; /* Emoji de árbol navideño */
    margin-left: 10px; /* Espacio entre el texto y el emoji */
  }
  
</style>

<!-- Carrusel de Navidad -->
<div id="navidadCarousel" class="carousel slide mt-3" data-bs-ride="carousel">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#navidadCarousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#navidadCarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#navidadCarousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  <div class="carousel-inner">
    <!-- Slide 1 -->
    <div class="carousel-item active">
      <img src="img/Medicamentos.jpg" class="d-block w-100" alt="Medicamentos en Oferta">
      <div class="carousel-caption d-none d-md-block">
        <h5 class="descuento-medicamentos">Descuentos en Medicamentos</h5>
         <p class="black-text">Aprovecha hasta un 30% de descuento en medicamentos seleccionados.</p>
      </div>
    </div>
    <!-- Slide 2 -->
    <div class="carousel-item">
      <img src="img/Vitaminas.jpg" class="d-block w-100" alt="Vitaminas en Oferta">
      <div class="carousel-caption d-none d-md-block">
        <h5 class="vitaminas-descuento">Vitaminas con Descuento</h5>
        <p class="white-text">Fortalece tu salud con nuestras vitaminas a precios especiales.</p>
      </div>
    </div>
    <!-- Slide 3 -->
    <div class="carousel-item">
      <img src="img/CuidadoPersonal.jpg" class="d-block w-100" alt="Cuidado Personal">
      <div class="carousel-caption d-none d-md-block">
        <h5 class="ofertas-cuidado-personal">Ofertas en Cuidado Personal</h5>
         <p class="black-text">Productos de cuidado personal con grandes descuentos por Navidad.</p>
      </div>
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#navidadCarousel" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Anterior</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#navidadCarousel" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Siguiente</span>
  </button>
</div>


	
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">

	
</body>
</html>