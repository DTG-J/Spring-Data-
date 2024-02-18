import org.w3c.dom.xpath.XPathResult;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Properties;

public class DBtools {
    private final String url = "jdbc:mysql://localhost:3306/";
    private static Connection connection;

    public DBtools (String username, String password, String tablename) {
        Properties properties = new Properties();
        properties.setProperty("user", username);
        properties.setProperty("password", password);
        try {
            connection = DriverManager.getConnection(url + tablename, properties);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static Connection getConnection(){
        return connection;
    }
}

