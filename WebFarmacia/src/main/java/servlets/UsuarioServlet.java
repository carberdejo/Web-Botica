package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

import entidades.User;
import interfaces.LoginInterface;
import dao.DAOFactory;

@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginInterface loginModelo;
    SessionProyect sessionProyect = new SessionProyect();

    public UsuarioServlet() {
        super();
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        loginModelo = factory.getLoginDAO();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println("Estoy en el login");
        try {
            if ("register".equals(action)) {
                register(request, response);
            } else if ("login".equals(action)) {
                login(request, response);
            } else if ("logout".equals(action)) {
                logout(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println("Estoy en register");
        System.out.println("name =>"+name);
        System.out.println("email =>"+email);
        System.out.println("password =>"+password);

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole("user");
       
        loginModelo.registerUser(user);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        response.sendRedirect("Principal.jsp");
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println("Estoy en login");
        User user = loginModelo.loginUser(email, password);
        if (user != null) {
        	
			sessionProyect.saveSessionTimeOut(request, 30);
			sessionProyect.saveSessionString(request, Constantes.LOGIN, user.getId()+"");
			sessionProyect.saveSessionString(request, Constantes.NOMBRE, user.getName());
			sessionProyect.saveSessionString(request, Constantes.EMAIL, user.getEmail());
			sessionProyect.saveSessionString(request, Constantes.CLAVE, user.getPassword());
			sessionProyect.saveSessionString(request, Constantes.ROL, user.getRole());
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("Principal.jsp");
        } else {
            request.setAttribute("error", "Invalid email or password");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        sessionProyect.invalidateSession(request);
        response.sendRedirect("Login.jsp");
    }
}