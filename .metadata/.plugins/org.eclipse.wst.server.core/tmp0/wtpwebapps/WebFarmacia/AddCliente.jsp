<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.util.List" %>
<%@page import = "entidades.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<%String caso = (String)session.getAttribute("caso");
	User user = (User)session.getAttribute("cliente");%>
	 <div class="container mt-5">
        <div class="card shadow">
            <div class="card-header bg-primary text-white text-center">
                <h2>Registrar Nuevo Proveedor</h2>
            </div>
            <div class="card-body">
                <!-- Formulario para crear un nuevo proveedor -->
                <form action="ClienteServlet?accion=<%=caso %>" method="post">
                	<div class="mb-3">
                        <label for="nombre" class="form-label">Id</label>
                        <input type="text" class="form-control"  name="txtId" value="<%=user.getId() %>"  readonly>
                    </div>
                    <div class="mb-3">
                        <label for="nombre" class="form-label">Name</label>
                        <input type="text" class="form-control"  name="txtName" value="<%=user.getName() %>"  placeholder="Ingrese el nombre" required>
                    </div>
                    <div class="mb-3">
                        <label for="nombre" class="form-label">Hotmail</label>
                        <input type="text" class="form-control" name="txtHotmail" value="<%= user.getEmail() %>"  placeholder="Ingrese el nombre" required>
                    </div>
                    <div class="mb-3">
                        <label for="nombre" class="form-label">password</label>
                        <input type="text" class="form-control" name="txtpassword" value="<%=user.getPassword() %>"  placeholder="Ingrese el nombre" required>
                    </div>
                    
                    <div class="text-center">
                        <input type="submit" class="btn btn-primary" value="registrar">
                        <a href="Cliente.jsp" class="btn btn-secondary">
                            <i class="bi bi-arrow-left"></i> Volver
                        </a>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
	
</body>
</html>