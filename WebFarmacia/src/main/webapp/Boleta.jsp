<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="entidades.*"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<%List<DetalleVenta> listaDetalleventa = (List<DetalleVenta>) session.getAttribute("listaDetalleventa");
  User cliente = (User) session.getAttribute("cliente");
%>
	<body>
  <div class="container mt-5">
    <div class="card">
      <div class="card-header text-center bg-primary text-white">
        <h3>Boleta de Pago</h3>
        <p>No. 001-000123</p>
      </div>
      <div class="card-body">
        <!-- Información del comprador -->
        <h5 class="text-secondary">Detalles del Cliente:</h5>
        <ul class="list-group mb-4">
          <li class="list-group-item"><strong>Nombre:</strong> <%=cliente.getName() %></li>
          <li class="list-group-item"><strong>Correo:</strong><%=cliente.getEmail() %></li>
          <li class="list-group-item"><strong>Id:</strong> <%=cliente.getId() %></li>
        </ul>
        
        <!-- Detalles de la compra -->
        <h5 class="text-secondary">Detalles de la Compra:</h5>
        <table class="table table-striped">
          <thead class="table-dark">
            <tr>
              <th>Producto</th>
              <th>Cantidad</th>
              <th>Precio Unitario</th>
              <th>Subtotal</th>
            </tr>
          </thead>
          <tbody>
          <%if(listaDetalleventa != null){
				for(DetalleVenta item : listaDetalleventa){ %>	
            <tr>
              <td><%=item.getNombreProducto() %></td>
              <td><%=item.getCantidad() %></td>
              <td><%=item.getPrecio() %></td>
              <td><%=item.getImporte() %></td>
            </tr>
            <%}} %>
          </tbody>
          <tfoot>
          <% double importe = 0; 
        for(DetalleVenta det : listaDetalleventa){
            importe += Double.parseDouble(det.getImporte());  	
        }
    %>
            <tr>
              <td colspan="3" class="text-end"><strong>Total:</strong></td>
              <td><strong>S/ <%=importe %></strong></td>
            </tr>
          </tfoot>
        </table>
        
        <!-- Botón para imprimir -->
        <div class="text-center mt-4">
          <button class="btn btn-success" onclick="window.print()">Imprimir Boleta</button>
        </div>
        <div class="text-center mt-4">
          <a class="btn btn-success" href="Principal.jsp">Principal</a>
        </div>
      </div>
      <div class="card-footer text-center">
        <p class="text-muted">Gracias por su compra</p>
      </div>
    </div>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
	
</body>
</html>