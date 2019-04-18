package trollgame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class DBConnector {
	final static String CONNECTION_STRING =  "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	final static String CONNECTION_USERNAME = "troll_game";
	final static String CONNECTION_PASSWORD = "troll_game";
	
	protected static Connection setConnection() {
		Connection conn = null;
		try {
		DriverManager.registerDriver(new OracleDriver());
		conn = DriverManager.getConnection(CONNECTION_STRING, CONNECTION_USERNAME, CONNECTION_PASSWORD);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
}
