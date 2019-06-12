package layers.db;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import oracle.jdbc.driver.OracleDriver;

public class DBConnector {
    static final String CONNECTION_STRING = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
    static final String CONNECTION_USERNAME = "forums";
    static final String CONNECTION_PASSWORD = "forums";

    public static Connection setConnection() {
        Connection conn = null;
        try {
            DriverManager.registerDriver((Driver)new OracleDriver());
            conn = DriverManager.getConnection(CONNECTION_STRING, "forums", "forums");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}