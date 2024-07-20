package russiaairlanesmanagmentsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connections {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/russiaairlinesmanagment"; //
    private static final String USER = "root"; //
    private static final String PASSWORD = "12345"; //
    Connection connection = null;
    Statement statement = null;

    public Connections() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection successful!");
            statement = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("MySQL Driver not found.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failed.");
        }
    }
}