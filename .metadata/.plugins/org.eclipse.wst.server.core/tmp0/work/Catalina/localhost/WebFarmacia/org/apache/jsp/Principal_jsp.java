/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/11.0.1
 * Generated at: 2024-12-19 06:35:22 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import java.util.List;
import entidades.*;

public final class Principal_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>Farmacia</title>\r\n");
      out.write("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\r\n");
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
      out.write("<style>\r\n");
      out.write("  .carousel-inner img {\r\n");
      out.write("    width: 100%;       \r\n");
      out.write("    height: 800px;     /* Altura fija estándar */\r\n");
      out.write("     \r\n");
      out.write("  }\r\n");
      out.write("    \r\n");
      out.write("  /* Estilo para los títulos \"Ofertas en Cuidado Personal\" */\r\n");
      out.write("  .carousel-caption h5.ofertas-cuidado-personal {\r\n");
      out.write("    font-family: 'Comic Sans MS', cursive, sans-serif; \r\n");
      out.write("    color: #ff66b2; \r\n");
      out.write("    -webkit-text-stroke: 1px black; \r\n");
      out.write("    text-shadow: 2px 2px 4px #000; \r\n");
      out.write("    font-size: 3rem; \r\n");
      out.write("    font-weight: bold; \r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  /* Estilo para los títulos \"Descuento en Medicamentos\" */\r\n");
      out.write("  .carousel-caption h5.descuento-medicamentos {\r\n");
      out.write("    font-family: 'Comic Sans MS', cursive, sans-serif; \r\n");
      out.write("    color: #8B0000;\r\n");
      out.write("    -webkit-text-stroke: 1px white; \r\n");
      out.write("    text-shadow: 2px 2px 4px #000; \r\n");
      out.write("    font-size: 3rem; \r\n");
      out.write("    font-weight: bold; \r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  /* Estilo para los títulos \"Vitaminas con Descuento\" */\r\n");
      out.write("  .carousel-caption h5.vitaminas-descuento {\r\n");
      out.write("    font-family: 'Comic Sans MS', cursive, sans-serif;\r\n");
      out.write("    color: #32CD32; \r\n");
      out.write("    -webkit-text-stroke: 1px white; \r\n");
      out.write("    text-shadow: 2px 2px 4px #000; \r\n");
      out.write("    font-size: 3rem; \r\n");
      out.write("    font-weight: bold; \r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  /* Estilo para los párrafos */\r\n");
      out.write("  .carousel-caption p {\r\n");
      out.write("    font-size: 1.25rem; \r\n");
      out.write("    font-weight: normal; \r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("  .carousel-caption p.black-text {\r\n");
      out.write("    color: black; \r\n");
      out.write("    text-shadow: 2px 2px 8px #f5a623; \r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  \r\n");
      out.write("  .carousel-caption p.white-text {\r\n");
      out.write("    color: white; \r\n");
      out.write("    text-shadow: 2px 2px 8px #ff66b2; \r\n");
      out.write("  }\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  .carousel-caption h5::after {\r\n");
      out.write("    content: \"🎄\"; /* Emoji de árbol navideño */\r\n");
      out.write("    margin-left: 10px; /* Espacio entre el texto y el emoji */\r\n");
      out.write("  }\r\n");
      out.write("  \r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<!-- Carrusel de Navidad -->\r\n");
      out.write("<div id=\"navidadCarousel\" class=\"carousel slide mt-3\" data-bs-ride=\"carousel\">\r\n");
      out.write("  <div class=\"carousel-indicators\">\r\n");
      out.write("    <button type=\"button\" data-bs-target=\"#navidadCarousel\" data-bs-slide-to=\"0\" class=\"active\" aria-current=\"true\" aria-label=\"Slide 1\"></button>\r\n");
      out.write("    <button type=\"button\" data-bs-target=\"#navidadCarousel\" data-bs-slide-to=\"1\" aria-label=\"Slide 2\"></button>\r\n");
      out.write("    <button type=\"button\" data-bs-target=\"#navidadCarousel\" data-bs-slide-to=\"2\" aria-label=\"Slide 3\"></button>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div class=\"carousel-inner\">\r\n");
      out.write("    <!-- Slide 1 -->\r\n");
      out.write("    <div class=\"carousel-item active\">\r\n");
      out.write("      <img src=\"img/Medicamentos.jpg\" class=\"d-block w-100\" alt=\"Medicamentos en Oferta\">\r\n");
      out.write("      <div class=\"carousel-caption d-none d-md-block\">\r\n");
      out.write("        <h5 class=\"descuento-medicamentos\">Descuentos en Medicamentos</h5>\r\n");
      out.write("         <p class=\"black-text\">Aprovecha hasta un 30% de descuento en medicamentos seleccionados.</p>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- Slide 2 -->\r\n");
      out.write("    <div class=\"carousel-item\">\r\n");
      out.write("      <img src=\"img/Vitaminas.jpg\" class=\"d-block w-100\" alt=\"Vitaminas en Oferta\">\r\n");
      out.write("      <div class=\"carousel-caption d-none d-md-block\">\r\n");
      out.write("        <h5 class=\"vitaminas-descuento\">Vitaminas con Descuento</h5>\r\n");
      out.write("        <p class=\"white-text\">Fortalece tu salud con nuestras vitaminas a precios especiales.</p>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- Slide 3 -->\r\n");
      out.write("    <div class=\"carousel-item\">\r\n");
      out.write("      <img src=\"img/CuidadoPersonal.jpg\" class=\"d-block w-100\" alt=\"Cuidado Personal\">\r\n");
      out.write("      <div class=\"carousel-caption d-none d-md-block\">\r\n");
      out.write("        <h5 class=\"ofertas-cuidado-personal\">Ofertas en Cuidado Personal</h5>\r\n");
      out.write("         <p class=\"black-text\">Productos de cuidado personal con grandes descuentos por Navidad.</p>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <button class=\"carousel-control-prev\" type=\"button\" data-bs-target=\"#navidadCarousel\" data-bs-slide=\"prev\">\r\n");
      out.write("    <span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>\r\n");
      out.write("    <span class=\"visually-hidden\">Anterior</span>\r\n");
      out.write("  </button>\r\n");
      out.write("  <button class=\"carousel-control-next\" type=\"button\" data-bs-target=\"#navidadCarousel\" data-bs-slide=\"next\">\r\n");
      out.write("    <span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>\r\n");
      out.write("    <span class=\"visually-hidden\">Siguiente</span>\r\n");
      out.write("  </button>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("    <!-- Bootstrap Icons -->\r\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("	\r\n");
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
