package rumahTangga.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private String dbName;
    private String user;
    private String password;
    private String host;
    private String port;
    private Connection connection;

    public Database(String dbName, String user, String password, String host, String port) {
        this.dbName = dbName;
        this.user = user;
        this.password = password;
        this.host = host;
        this.port = port;
    }

    public void setup() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the connection
            String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found.", e);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database.", e);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}