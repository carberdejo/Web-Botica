package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bd.MySQLConexion;
import entidades.User;
import interfaces.LoginInterface;

public class LoginModelo implements LoginInterface {

    private static final String INSERT_USERS_SQL = "INSERT INTO users (name, email, password,role) VALUES (?, ?, ?,?);";
    private static final String SELECT_USER_BY_EMAIL_AND_PASSWORD = "SELECT id, name, email, password,role FROM users WHERE email = ? AND password = ?;";

    @Override
    public void registerUser(User user) throws SQLException {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = MySQLConexion.getConexionMySQL();
            pstm = con.prepareStatement(INSERT_USERS_SQL);
            pstm.setString(1, user.getName());
            pstm.setString(2, user.getEmail());
            pstm.setString(3, user.getPassword());
            pstm.setString(4, user.getRole());
            int result = pstm.executeUpdate();
            if (result > 0) {
            	rs = pstm.getGeneratedKeys();
                System.out.println("Usuario registrado exitosamente!");
            } else {
                System.out.println("Fallo en el registro del usuario.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
                if (pstm != null) pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public User loginUser(String email, String password) {
        User user = null;
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = MySQLConexion.getConexionMySQL();
            pstm = con.prepareStatement(SELECT_USER_BY_EMAIL_AND_PASSWORD);
            pstm.setString(1, email);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                
                user.setRole(rs.getString("role"));
                System.out.println("role"+ user.getRole());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
                if (pstm != null) pstm.close();
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }
}