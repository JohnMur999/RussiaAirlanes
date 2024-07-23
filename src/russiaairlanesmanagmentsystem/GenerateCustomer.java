package russiaairlanesmanagmentsystem;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class GenerateCustomer extends JFrame {
    public GenerateCustomer(String name, String nationality, String number, String address, String gender) {
        try {
                int uid;
                Connections newConnection = new Connections();
                String query = "insert into passenger values(?,?,?,?,?,?)";
                PreparedStatement preparedStatement = newConnection.connection.prepareStatement(query);
                    Random random = new Random();
                    while (true) {
                        uid = random.nextInt(100000) + 1;
                        if (!uidExists(newConnection, uid)) {
                            break;
                        }
                    }

                preparedStatement.setString(1, name);
                preparedStatement.setString(2, nationality);
                preparedStatement.setString(3, number);
                preparedStatement.setString(4, address);
                preparedStatement.setString(5, gender);
                preparedStatement.setInt(6,uid);

                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(this, "Customer added successfully");
                }
                preparedStatement.close();
                newConnection.connection.close();
                setVisible(false);
            } catch (SQLException exception) {
                exception.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error while adding customer");
            }
    }
    private static boolean uidExists(Connections conn, int uid) throws SQLException {
        String query = "SELECT COUNT(*) FROM passenger WHERE uid = ?";
        try (PreparedStatement stmt = conn.connection.prepareStatement(query)) {
            stmt.setInt(1, uid);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }
}
