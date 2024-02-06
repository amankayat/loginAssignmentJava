package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DBConnection {
public static final String URL = "jdbc:postgresql://localhost:5432/bydb";
	
	public static Connection getconnection() throws SQLException {
		Connection conn = null;
		try {
			 conn = DriverManager.getConnection(URL,"postgres","postgres");
			
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return conn;
		
	}

}
