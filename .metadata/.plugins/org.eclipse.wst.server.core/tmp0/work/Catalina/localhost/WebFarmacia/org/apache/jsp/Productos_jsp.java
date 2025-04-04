/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/11.0.1
 * Generated at: 2024-12-19 06:32:22 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import entidades.*;
import java.util.List;

public final class Productos_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(6);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("entidades");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(2);
    _jspx_imports_classes.add("java.util.List");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write(" <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("  <style>\r\n");
      out.write("    .product-card {\r\n");
      out.write("      border: 1px solid #ddd;\r\n");
      out.write("      border-radius: 10px;\r\n");
      out.write("      padding: 15px;\r\n");
      out.write("      text-align: center;\r\n");
      out.write("      transition: transform 0.3s ease, box-shadow 0.3s ease;\r\n");
      out.write("    }\r\n");
      out.write("    .product-card:hover {\r\n");
      out.write("      transform: scale(1.05);\r\n");
      out.write("      box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);\r\n");
      out.write("    }\r\n");
      out.write("    .discount-badge {\r\n");
      out.write("      background-color: #f44336;\r\n");
      out.write("      color: white;\r\n");
      out.write("      padding: 5px 10px;\r\n");
      out.write("      border-radius: 5px;\r\n");
      out.write("      font-size: 0.9rem;\r\n");
      out.write("      position: absolute;\r\n");
      out.write("      top: 10px;\r\n");
      out.write("      left: 10px;\r\n");
      out.write("    }\r\n");
      out.write("  </style>\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
 if(session.getAttribute("listaCategoria")==null){
	
      out.write("\r\n");
      out.write("	<script> window.location.href=\"CategoriaServlet\"</script>\r\n");
      out.write("	");

}	

      out.write('\r');
      out.write('\n');
 User datosUser=(User) session.getAttribute("user");
      out.write("\r\n");
      out.write("<nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\r\n");
      out.write("  <div class=\"container-fluid\">\r\n");
      out.write("    <a class=\"navbar-brand\" href=\"Principal.jsp\">MichiFarma</a>\r\n");
      out.write("    \r\n");
      out.write("    <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n");
      out.write("      <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\r\n");
      out.write("        <li class=\"nav-item\">\r\n");
      out.write("          	<a class=\"navbar-brand d-flex align-items-center\" href=\"#\">\r\n");
      out.write("     		 <img src=\"img/logo.png\" alt=\"Logo\" width=\"40\" height=\"	40\" class=\"me-2\">\r\n");
      out.write("    		</a>\r\n");
      out.write("        </li>\r\n");
      out.write("         <li class=\"nav-item\">\r\n");
      out.write("          <a class=\"nav-link active\" aria-current=\"page\" href=\"AccionServlet?tipo=ListarTodo\">Productos</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        ");
if(datosUser.getRole().equals("admin")){ 
      out.write("\r\n");
      out.write("        <li class=\"nav-item\">\r\n");
      out.write("          <a class=\"nav-link active\" aria-current=\"page\" href=\"Reporte.jsp\">Reportes</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"nav-item\">\r\n");
      out.write("          <a class=\"nav-link active\" aria-current=\"page\" href=\"ClienteServlet?accion=ListarCli\">Clientes</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"nav-item\">\r\n");
      out.write("          <a class=\"nav-link active\" aria-current=\"page\" href=\"ProveedoresServlet?caso=ListarProv\">Proveedores</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        ");
} 
      out.write("\r\n");
      out.write("        <li class=\"nav-item dropdown\">\r\n");
      out.write("          <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\r\n");
      out.write("            Categorías\r\n");
      out.write("          </a>\r\n");
      out.write("          <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\r\n");
      out.write("          \r\n");
      out.write("          	");
 List<Categorias> listaCategoria =(List<Categorias>) session.getAttribute("listaCategoria"); 
      out.write("\r\n");
      out.write("          		");
if(listaCategoria != null){
					for(Categorias item:listaCategoria){
				
      out.write("		\r\n");
      out.write("						\r\n");
      out.write("						<li><a class=\"dropdown-item\" href=\"ProductoServlet?type=info&idCategoria=");
      out.print(item.getIdCategoria());
      out.write("\">\r\n");
      out.write("							");
      out.print(item.getNombreCategoria() );
      out.write("\r\n");
      out.write("						</a></li>	\r\n");
      out.write("						");

					}
				}
				
      out.write("\r\n");
      out.write("          </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"nav-item\">\r\n");
      out.write("          <a class=\"btn btn-outline-success\" aria-current=\"page\" href=\"VentaServlet?tipo=listarCarrito&usuario=");
      out.print(datosUser.getId());
      out.write("\">Carrito</a>\r\n");
      out.write("        </li>\r\n");
      out.write("      </ul>\r\n");
      out.write("      <!-- Elementos alineados a la derecha -->\r\n");
      out.write("      \r\n");
      out.write("      <ul class=\"navbar-nav ms-auto\">\r\n");
      out.write("        <li class=\"nav-item dropdown\">\r\n");
      out.write("          <a class=\"btn btn-success\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\r\n");
      out.write("            Bienvenido\r\n");
      out.write("          </a>\r\n");
      out.write("          <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\r\n");
      out.write("            <a class=\"dropdown-item\">\r\n");
      out.write("            ");
if(datosUser.getRole().equals("admin")){ 
      out.write("\r\n");
      out.write("              <img src=\"img/admin.png\" alt=\"60\" width=\"60\">\r\n");
      out.write("           	");
} else{
      out.write("\r\n");
      out.write("           		<img src=\"img/cliente.png\" alt=\"60\" width=\"60\">\r\n");
      out.write("           	");
} 
      out.write("\r\n");
      out.write("            </a>\r\n");
      out.write("            <a class=\"dropdown-item\" href=\"#\">");
      out.print(datosUser.getRole());
      out.write("</a>\r\n");
      out.write("            <a class=\"dropdown-item\" href=\"#\">");
      out.print(datosUser.getName() );
      out.write("</a>\r\n");
      out.write("            <a class=\"dropdown-item\" href=\"#\">");
      out.print(datosUser.getEmail() );
      out.write("</a>\r\n");
      out.write("            \r\n");
      out.write("             <a name=\"xxxxxxxxx\" value=\"Salir\" class=\"dropdown-item\" href=\"Login.jsp\">Salir</a>\r\n");
      out.write("           \r\n");
      out.write("          </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</nav>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	<div class=\"container my-5\">\r\n");
      out.write("    <h2 class=\"mb-4\">Farmacia</h2>\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("     \r\n");
      out.write("\r\n");
      out.write("      <!-- Products Section -->\r\n");
      out.write("      <div class=\"col-md-12\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("        ");

        List<Producto> listaProducto = (List<Producto>) session.getAttribute("listaProducto");

				if(listaProducto != null){
					for(Producto item : listaProducto){
						 
      out.write("	\r\n");
      out.write("					\r\n");
      out.write("          <!-- Product Card -->\r\n");
      out.write("          \r\n");
      out.write("          <div class=\"col-md-4 mb-4\">\r\n");
      out.write("          <a href=\"DetalleServlet?type=info&codigoProducto=");
      out.print(item.getCodigoProducto());
      out.write("&idCategoria=");
      out.print(item.getIdCategoria());
      out.write("\">\r\n");
      out.write("            <div class=\"product-card position-relative\">\r\n");
      out.write("              <div class=\"discount-badge\">");
      out.print(item.getDescuento());
      out.write(" dscto.</div>\r\n");
      out.write("              <img src=\"img/");
      out.print(item.getImagen() );
      out.write("\" alt=\"Producto\" class=\"img-fluid mb-3\">\r\n");
      out.write("              <h5 class=\"mb-2\">");
      out.print(item.getNombreProducto() );
      out.write("</h5>\r\n");
      out.write("              <p class=\"text-muted\">Válido del ");
      out.print(item.getFechaIngreso() );
      out.write(" al ");
      out.print(item.getFechaVencimiento() );
      out.write(" o hasta agotar.</p>\r\n");
      out.write("              <p>\r\n");
      out.write("                <span class=\"text-danger fw-bold\">s/ ");
      out.print(item.precioDSCT() );
      out.write("</span>\r\n");
      out.write("                <span class=\"text-decoration-line-through text-muted\">");
      out.print(item.getPrecio() );
      out.write("</span>\r\n");
      out.write("              </p>\r\n");
      out.write("              ");
if(datosUser.getRole().equals("admin")){ 
      out.write("\r\n");
      out.write("              <div class=\"btn-group\" role=\"group\" aria-label=\"Basic example\">\r\n");
      out.write("             \r\n");
      out.write("              <a class=\"btn btn-warning\" href=\"AccionServlet?type=info&tipo=ProducModi&codigoProducto=");
      out.print(item.getCodigoProducto());
      out.write("\">Modificar</a>          \r\n");
      out.write("              <a class=\"btn btn-danger\" href=\"AccionServlet?type=info&tipo=Eliminar&cProducto=");
      out.print(item.getCodigoProducto());
      out.write("&>&idCategoria=");
      out.print(item.getIdCategoria());
      out.write("\">Eliminar</a>\r\n");
      out.write("             \r\n");
      out.write("               </div>\r\n");
      out.write("                ");
}else{ 
      out.write("\r\n");
      out.write("              <a class=\"btn btn-outline-primary w-100\" href=\"VentaServlet?tipo=agregarCarrito&codigoProducto=");
      out.print(item.getCodigoProducto());
      out.write("&cantidad=1&usuario=");
      out.print(datosUser.getId());
      out.write("\">Agregar</a>\r\n");
      out.write("            ");
} 
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            </a>\r\n");
      out.write("          </div>\r\n");
      out.write("          ");
}} 
      out.write("\r\n");
      out.write("\r\n");
      out.write("          <!-- Puedes replicar más tarjetas similares aquí -->\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("		\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
