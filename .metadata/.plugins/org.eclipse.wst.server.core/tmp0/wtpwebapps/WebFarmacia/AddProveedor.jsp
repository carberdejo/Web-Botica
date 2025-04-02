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
	  Proveedores prov = (Proveedores)session.getAttribute("prov");%>
	 <div class="container mt-5">
        <div class="card shadow">
            <div class="card-header bg-primary text-white text-center">
                <h2>Registrar Nuevo Proveedor</h2>
            </div>
            <div class="card-body">
                <!-- Formulario para crear un nuevo proveedor -->
                <form action="ProveedoresServlet?caso=<%=caso %>" method="post" >
                	<input type="hidden">
                	<div class="mb-3">
                        <label for="nombre" class="form-label">Id</label>
                        <input type="text" class="form-control"  name="txtCodigo" value="<%= (!caso.equals("RegistrarProv")) ? prov.getCodProveedor() : "" %>"  readonly>
                    </div>
                    <div class="mb-3">
                        <label for="nombre" class="form-label">Nombre</label>
                        <input type="text" class="form-control"  name="txtNombre" value="<%= (!caso.equals("RegistrarProv")) ? prov.getNombreProveedor() : "" %>"  placeholder="Ingrese el nombre" required>
                    </div>
                    <div class="mb-3">
                        <label for="nombre" class="form-label">Correo</label>
                        <input type="text" class="form-control"  name="txtCorreo" value="<%= (!caso.equals("RegistrarProv")) ? prov.getCorreo() : "" %>"  placeholder="Ingrese el nombre" required>
                    </div>
                    <div class="mb-3">
                        <label for="nombre" class="form-label">Encargado</label>
                        <input type="text" class="form-control" name="txtEncargado" value="<%= (!caso.equals("RegistrarProv")) ? prov.getEncargado(): "" %>"  placeholder="Ingrese el nombre" required>
                    </div>
                    <div class="mb-3">
                        <label for="telefono" class="form-label">Numero</label>
                        <input type="tel" class="form-control" name="txtNumero" value="<%= (!caso.equals("RegistrarProv")) ? prov.getNumProveedor() : "" %>"  placeholder="Ingrese el teléfono" required>
                    </div>
                    <div class="mb-3">
                        <label for="telefono" class="form-label">Pais</label>
                        <input type="tel" class="form-control" name="txtPais" value="<%= (!caso.equals("RegistrarProv")) ? prov.getPais() : "" %>"  placeholder="Ingrese el teléfono" required>
                    </div>
                    <div class="mb-3">
                <label for="imagen" class="form-label">Imagen</label>
                <input type="file" class="form-control" name="fileimagen" id="imagen" accept="image/*">
            	</div>	
                    <div class="text-center">
                        <input type="submit" class="btn btn-primary" value="registrar">
                        <a href="Proveedores.jsp" class="btn btn-secondary">
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