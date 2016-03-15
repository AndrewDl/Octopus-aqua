import java.sql.*;
/**
 * Created by Andrew on 02.03.2016.
 */
public class SqlConnector {

    private String dbname = "octopus-aqua";
    private String port = "3306";
    private String hostname = "localhost";

    private String url = "jdbc:mysql://localhost:3306/octopus-aqua";

    private String username = "mysql";
    private String password = "mysql";

    private void connectToSql() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, username, password);
        conn.close();
    }

    private void connectToSql(String username, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://" + hostname + ":" + port + "/" + dbname, username, password);
        conn.close();
    }
}
