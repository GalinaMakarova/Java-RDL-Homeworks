import java.sql.*;

public class Main {
    private static final String DATABASE_URL = "jdbc:oracle:thin:@localhost:1521/dborcl";
    private static final String USER = "SYSTEM";
    private static final String PASSWORD = "!qaZ2";
    public static void main(String[] args) {
        System.out.println("Oracle JDBC Connection..");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("Oracle JDBC Driver connected");
        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            System.out.println("Database connection..");
            Statement statement = connection.createStatement();
            System.out.println("Database connected");
            Selects selects = new Selects(statement);

            selects.select1();
            selects.select2();
            selects.select3();
            selects.select4();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
