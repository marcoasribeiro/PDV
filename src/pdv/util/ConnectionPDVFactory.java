package pdv.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPDVFactory {
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(					
                                        "jdbc:mysql://162.241.2.208:3306/wilcsfib_pdv", "wilcsfib_pdv", "poopdv");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}
	
	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
