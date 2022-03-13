import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class Database {
    private String url;
    private String user;
    private String pass;

    Database (String host, String user, String pass) {
        this.url = "jdbc:mariadb://" + host;
        this.user = user;
        this.pass = pass;
    }

    void HelloWorld () throws SQLException {
        //create connection for a server installed in localhost, with a user "root" with no password
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            // create a Statement
            try (Statement stmt = conn.createStatement()) {
                //execute query
                try (ResultSet rs = stmt.executeQuery("SELECT 'Hello World!'")) {
                    //position result to first
                    rs.first();
                    System.out.println(rs.getString(1)); //result is "Hello World!"
                }
            }
        }
    }

    void ListDatabases() {
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SHOW DATABASES;");
            while (rs.next()){
                System.out.println(rs.getString(1));
            }
        }
        catch (SQLException ex) {
            System.out.println("ListDatabases() failed: " + ex);
        }
    }

    void CreateDatabase(String name) throws SQLException{
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("CREATE DATABASE " + name + ";");
            while (rs.next()){
                System.out.println(rs.getString(1));
            }
        }
        catch (SQLTransientConnectionException ex) {
            if (ex.getErrorCode() == 1007) {
                System.out.println("Database already exists.");
            } else {
                System.out.println(String.format("CreateDatabase() failed with error: %d messge: %s", ex.getErrorCode(), ex.getMessage()));
            }
        }
    }

}
