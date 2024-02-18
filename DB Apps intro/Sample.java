import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sample {
private static final DBtools dBtools = new DBtools("root", "12345", "minions_db");

private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException, SQLException {
        exercise_03();

    }
    public static void exercise_03 () throws IOException, SQLException {


        int villainId = Integer.parseInt(READER.readLine());
       // Statement logic -> create query
        String sql =  "SELECT m.name, m.age \n" +
                "FROM minions m\n" +
                "JOIN minions_villains mv ON mv.minion_id = m.id\n" +
                "WHERE villain_id = ?;";
        PreparedStatement preparedStatement = DBtools.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, villainId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (!resultSet.next()){
            System.out.printf("No villain with ID %d exists in the database.", villainId);
        }

        int index = 0;
        while (resultSet.next()){
            System.out.printf("%d. %s %d", ++index, resultSet.getString("name")
                    , resultSet.getInt("age")).append(System.lineSeparator());
        }
    }
}
