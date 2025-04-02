<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login and Register</title>
 <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600;700&display=swap" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/js/all.min.js"></script>
<style>
    body {
        font-family: 'Montserrat', sans-serif;
        margin: 0;
        padding: 0;
        background: linear-gradient(135deg, #e3f2fd, #90caf9);
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
    }

    .galvan {
        background: #ffffff;
        border-radius: 12px;
        box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
        padding: 2rem;
        width: 400px;
        text-align: center;
        position: relative;
        animation: slide-in 1s ease-out;
        overflow: hidden;
    }

    @keyframes slide-in {
        from {
            transform: translateY(-50px);
            opacity: 0;
        }
        to {
            transform: translateY(0);
            opacity: 1;
        }
    }

    .admin-icon {
        margin-bottom: 1rem;
    }

    .admin-icon i {
        font-size: 3rem;
        color: #007bff;
        cursor: pointer;
        transition: transform 0.3s ease-in-out;
    }

    .admin-icon i:hover {
        transform: scale(1.2);
        color: #0056b3;
    }

    .galliquio {
        display: flex;
        justify-content: center;
        gap: 1rem;
        margin-bottom: 1.5rem;
    }

    .revoredo {
        text-decoration: none;
        font-weight: bold;
        color: #555;
        font-size: 1rem;
        padding: 0.5rem 1rem;
        border-radius: 8px;
        transition: all 0.3s ease-in-out;
    }

    .revoredo.active {
        color: #fff;
        background-color: #007bff;
    }

    .revoredo:hover {
        color: #fff;
        background-color: #42a5f5;
    }

    .vargas {
        margin-bottom: 1rem;
        text-align: left;
    }

    .raymonda {
        font-weight: 600;
        color: #444;
    }

    .torres {
        width: 100%;
        padding: 0.8rem;
        border: 1px solid #ddd;
        border-radius: 6px;
        transition: all 0.3s;
    }

    .torres:focus {
        outline: none;
        border-color: #42a5f5;
        box-shadow: 0 0 5px rgba(66, 165, 245, 0.8);
    }

    .hidalgo {
        background: #007bff;
        color: #fff;
        border: none;
        border-radius: 6px;
        padding: 0.8rem;
        width: 100%;
        cursor: pointer;
        font-size: 1rem;
        font-weight: 600;
        transition: background 0.3s ease-in-out;
    }

    .hidalgo:hover {
        background: #0056b3;
    }

    .admin-info {
        margin-top: 1rem;
        font-size: 0.9rem;
        color: #555;
    }

    .floating-image {
        position: absolute;
        top: -50px;
        left: 50%;
        transform: translateX(-50%);
        z-index: 1;
        width: 180px;
    }
</style>
</head>
<body>
    <div class="galvan">
        <div class="admin-icon">
            <i class="fas fa-user-shield" onclick="location.href='Principal.jsp'"></i>
        </div>
        <div class="galliquio">
            <a href="#" class="revoredo active" id="tab-login">Iniciar sesión</a>
            <a href="#" class="revoredo" id="tab-register">Registrarse</a>
        </div>
        <div id="login-section">
            <form action="UsuarioServlet?action=login" method="post">
                <div class="vargas">
                    <label for="email" class="raymonda">Correo electrónico</label>
                    <input type="email" id="email" name="email" class="torres" required>
                </div>
                <div class="vargas">
                    <label for="password" class="raymonda">Contraseña</label>
                    <input type="password" id="password" name="password" class="torres" required>
                </div>
                <button type="submit" class="hidalgo">Entrar</button>
            </form>
        </div>
        <div id="register-section" style="display: none;">
            <form action="UsuarioServlet?action=register" method="post">
                <div class="vargas">
                    <label for="registerName" class="raymonda">Nombre</label>
                    <input type="text" id="registerName" name="name" class="torres" required>
                </div>
                <div class="vargas">
                    <label for="registerEmail" class="raymonda">Correo electrónico</label>
                    <input type="email" id="registerEmail" name="email" class="torres" required>
                </div>
                <div class="vargas">
                    <label for="registerPassword" class="raymonda">Contraseña</label>
                    <input type="password" id="registerPassword" name="password" class="torres" required>
                </div>
                <button type="submit" class="hidalgo">Registrarse</button>
            </form>
        </div>
    </div>
    <script>
        document.getElementById("tab-login").addEventListener("click", function () {
            document.getElementById("login-section").style.display = "block";
            document.getElementById("register-section").style.display = "none";
            this.classList.add("active");
            document.getElementById("tab-register").classList.remove("active");
        });
        document.getElementById("tab-register").addEventListener("click", function () {
            document.getElementById("register-section").style.display = "block";
            document.getElementById("login-section").style.display = "none";
            this.classList.add("active");
            document.getElementById("tab-login").classList.remove("active");
        });
    </script>

</body>
</html>