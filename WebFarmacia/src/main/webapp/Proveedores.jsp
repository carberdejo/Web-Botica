<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entidades.*"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Proveedores</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<style>
	#cuadro{
		width:100%;
		margin: 100px;
	}
    #product {
        width: 50px; /* Ajusta el porcentaje según lo que necesites */
    }
</style>
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

	 <div class="container mt-5" id="cuadro">
        <div class="card shadow">
            <div class="card-header bg-primary text-white text-center">
                <h2>Mantenimiento de Proveedores</h2>
            </div>
            <div class="card-body">
                <table class="table table-hover table-bordered align-middle">
                    <thead class="table-dark text-center">
                        <tr>
                            <th>Logo</th>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Encargado</th>
                            <th>Correo</th>
                            <th>Teléfono</th>
                            <th>Acciones</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Fila vacía inicial -->
                        <tr>
                            <td colspan="5" class="text-center text-muted">No hay clientes disponibles</td>
                        </tr>
				<% List<Proveedores> listaProveedor = (List<Proveedores>)  session.getAttribute("listaProveedor");
					if( listaProveedor != null){
						for(Proveedores prov :listaProveedor){%>
		
                        <!-- Bucle para mostrar los clientes -->
                        
                            <tr>
                            	<td class="text-center">
                                    <!-- Mostrar la imagen del cliente -->
                                    <img src="img/<%=prov.getImagen()%>" alt="not null" class="img-thumbnail" width="100">
                                </td>
                                <td class="text-center"><%=prov.getCodProveedor() %></td>
                                <td class="text-center"><%=prov.getNombreProveedor() %></td>
                                <td><%=prov.getEncargado() %></td>
                                <td><%=prov.getCorreo() %></td>
                                <td class="text-center"><%=prov.getNumProveedor() %></td>
                                <td class="text-center">
                                    <a href="MntoProveedoresServlet?caso=ModificarProv&codigo=<%=prov.getCodProveedor() %>" class="btn btn-sm btn-warning">
                                        <i class="bi bi-pencil-fill"></i> Modificar
                                    </a>
                                    <a href="ProveedoresServlet?caso=EliminarProv&codigo=<%=prov.getCodProveedor() %>" class="btn btn-sm btn-danger">
                                        <i class="bi bi-trash-fill"></i> Eliminar
                                    </a>
                                </td>
                                
                            </tr>
                       		<%}}%>
		
                    </tbody>
                </table>
            </div>
            <div class="card-footer text-center">
                <a href="MntoProveedoresServlet?caso=RegistrarProv" class="btn btn-success">
                    <i class="bi bi-person-plus-fill"></i> Agregar Proveedor
                </a>
            </div>
        </div>
    </div>
    
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
</body>
</html>