
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class GetVillainsNames {
    public static void main(String[] args) throws SQLException {
// Connect t0 DB
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "12345");

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/minions_db", properties);

// Statement logic -> create query
        String sql = "SELECT v.name, COUNT(m.id) AS minion_count\n" +
                "FROM villains v\n" +
                "JOIN minions_villains mv ON mv.villain_id = v.id\n" +
                "JOIN minions m ON mv.minion_id = m.id\n" +
                "GROUP BY v.id, v.name\n" +
                "HAVING minion_count > 15\n" +
                "ORDER BY minion_count DESC;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();


// Print result
        while (resultSet.next()) {
            System.out.printf("%s %d", resultSet.getString(1), resultSet.getInt(2))
                    .append(System.lineSeparator());
        }
    }
}

