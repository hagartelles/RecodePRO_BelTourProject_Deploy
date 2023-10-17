package mainDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
	



 
	public static Connection getConnection() throws SQLException {

		String URL = "jdbc:mysql://localhost:3306/beltour";
		String USUARIO = "root";
		String SENHA = "m3nuplaYvol*";
		
		return DriverManager.getConnection(URL, USUARIO, SENHA);

	}
	
	
	
}
