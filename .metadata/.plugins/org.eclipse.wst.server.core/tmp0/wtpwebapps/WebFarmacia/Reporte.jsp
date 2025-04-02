<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="entidades.*" %>
<%@ page import="dao.*" %>
<%@ page import="interfaces.*" %>
<%@ page import="bd.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<title>Insert title here</title>
<link rel="stylesheet" href="styles.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <style>
         body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        header {
            background-color: #4CAF50;
            color: white;
            padding: 1rem;
            text-align: center;
            font-size: 1.5rem;
        }
        .container {
            margin: 2rem auto;
            max-width: 80%;
            background: white;
            padding: 1rem;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            border-radius: 8px;
        }

        .filters {
            display: flex;
            justify-content: space-between;
            flex-wrap: wrap;
            margin-bottom: 1.5rem;
        }

        .filters div {
            margin-bottom: 1rem;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 0.5rem;
        }

        input, select {
            padding: 0.5rem;
            width: 100%;
            max-width: 200px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        button {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 0.7rem 1.5rem;
            cursor: pointer;
            font-size: 1rem;
            border-radius: 4px;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #45a049;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 1.5rem;
        }

        table th, table td {
            border: 1px solid #ddd;
            padding: 0.8rem;
            text-align: left;
        }

        table th {
            background-color: #f4f4f4;
        }

        .no-data {
            text-align: center;
            color: #999;
            margin-top: 1rem;
        }
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
        main {
            padding: 2rem;
        }
        footer {
            background-color: #EEEE;
            color: black;
            text-align: center;
            padding: 1rem 0;
            position: fixed;
            width: 100%;
            bottom: 0;
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


<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="Reporte.jsp">Reporte de Ventas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ReporteProducto.jsp">Reporte de Producto Más Adquirido</a>
                </li>
            </ul>
        </div>
    </div>
</nav>


 <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <!-- Navbar Content -->
    </nav>

    <div class="container">
        <h2>Generar Reporte de Ventas</h2>
        <form method="post" action="">
            <div>
                <label for="startDate">Fecha Inicio:</label>
                <input type="date" id="startDate" name="startDate" required>
            </div>
            <div>
                <label for="endDate">Fecha Fin:</label>
                <input type="date" id="endDate" name="endDate" required>
            </div>
            <br>
            <div>
                <button type="submit" class="btn btn-primary">Generar Reporte</button>
            </div>
        </form>
        <br>

        <h3>Resultados del Reporte</h3>
        <table class="table">
            <thead>
                <tr>
                    
                    <th>Fecha Inicio</th>
                    <th>Fecha Fin</th>
                    <th>Total Ventas</th>
                    <th>Cantidad Ventas</th>
                    <th>Productos Vendidos</th>
                </tr>
            </thead>
            <tbody id="resultadosReporte">
            <!-- Los resultados se cargarán dinámicamente aquí -->
        </tbody>
            <tbody>
            
                <% String startDate = request.getParameter("startDate");
                String endDate = request.getParameter("endDate");
                
                if (startDate != null && endDate != null ) {
                	DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            		ReporteInterface producDAO = daoFactory.getReporteDAO();
                	List<Reporte> reportePorFechas =(List<Reporte>) producDAO.obtenerReportePorFechas(request.getParameter("startDate"), request.getParameter("endDate"));
    			session.setAttribute("listaReportePorFecha", reportePorFechas);
    			
                	System.out.print("entro");
                	   if(reportePorFechas != null){
     					for(Reporte item:reportePorFechas){
                     %>
                     <tr>
     					
     					<td><%=item.getFechaInicio() %></td>
     					<td><%=item.getFechaFin() %></td>
     					<td><%=item.getTotalVentas() %></td>
     					<td><%=item.getCantidadVentas() %></td>
     					<td><%=item.getProductosVendidos() %></td>
     			   </tr>
     				<%
     					}
     				}
     			
                	
                }
                
                %>		
            </tbody>
        </table>
    </div>
	
</body>
</html>