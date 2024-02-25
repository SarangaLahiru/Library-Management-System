import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db {

    public static Connection connect() {
        Connection connection = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Database connection URL
            String url = "jdbc:mysql://localhost:3306/laravel1";
            String username ="root";
            String password = "";

            // Establish the connection
            connection = DriverManager.getConnection(url, username, password);

            System.out.println("Connected to the database!");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void main(String[] args) {
        Connection connection = connect();

        // Add your database operations here

        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Disconnected from the database!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}