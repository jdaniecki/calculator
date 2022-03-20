import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class Database {
    private String url;
    private String user;
    private String pass;
    Connection conn;

    Database (String host, String user, String pass) {
        this.url = "jdbc:mariadb://" + host;
        this.user = user;
        this.pass = pass;
        conn = null;
    }

    void Connect () throws SQLException {
        conn = DriverManager.getConnection(url, user, pass);
    }

    String Execute(String query) throws SQLException{
        String result = new String();

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()){
            result += rs.getString(1) + "\n";
        }
        return result;
    }
}
