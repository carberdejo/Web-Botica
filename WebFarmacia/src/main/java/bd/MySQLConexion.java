package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion {
	public static Connection getConexionMySQL() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			String 	url = "jdbc:mysql://localhost:3306/bd_farmacia?useSSL=false&useTimezone=true&serverTimezone=UTC",
					usuario = "root",
					password = "Indra24go";
			con = DriverManager.getConnection(url,usuario,password);
			//System.out.println("driver"+con);
		} catch(ClassNotFoundException e) {
			System.out.println("Error de driver no instalado "+e.getMessage());
		}catch(SQLException e) {
			System.out.println("Error de conexiÃ³n a la BD "+e.getMessage());
		}catch(Exception e) {
			System.out.println("Error general "+e.getMessage());
		}
		return con;
	}
	public static void closeConexion(Connection con) {
		try {
			con.close();
		}catch(SQLException e) {
			System.out.println("Problemas al cerrar"+e.getMessage());
		}
	}
}
