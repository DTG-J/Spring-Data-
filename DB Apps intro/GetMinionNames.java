import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class GetMinionNames {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        // Connect t0 DB
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "12345");

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/minions_db", properties);

        int villainId = Integer.parseInt(scanner.nextLine());
        // Statement logic -> create query
        String sql =  "SELECT m.name, m.age\n" +
                "FROM minions m\n" +
                "JOIN minions_villains mv ON mv.minion_id = m.id\n" +
                "WHERE villain_id = ?;";
        ResultSet resultSet;
        try (PreparedStatement preparedStatement = DBtools.getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, villainId);
            resultSet = preparedStatement.executeQuery();
        }

        int index = 0;

// Print result
        while (resultSet.next()){
            System.out.printf("%d. %s %d", ++index, resultSet.getString("name")
                    , resultSet.getInt("age")).append(System.lineSeparator());
        }

    }
}
