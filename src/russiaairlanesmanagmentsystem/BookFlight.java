package russiaairlanesmanagmentsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookFlight extends JFrame implements ActionListener {
    JLabel customerUID, customerName, customerNationality, customerNumber, customerAddress, customerGender,
           thCustomerName, thCustomerNationality, thCustomerNumber, thCustomerAddress, thCustomerGender;
    JTextField customerUIDField;
    JButton fetchCustomerButton, FetchFlightButton, bookFlightButton;
    public BookFlight() {
        getContentPane().setBackground(Color.WHITE);
        setTitle("Book Flight");
        ImageIcon imageSource = new ImageIcon(ClassLoader.getSystemResource("russiaairlanesmanagmentsystem/img/book-flight.png"));
        JLabel bookFlightBackground = new JLabel(imageSource);
        bookFlightBackground.setBounds(0, 0, imageSource.getIconWidth(), imageSource.getIconHeight());
        add(bookFlightBackground);

        customerUID = new JLabel("Customer UID");
        customerUID.setBounds(20,60, 150,35);
        customerUID.setFont(new Font("BLACK-ITALIC", Font.ITALIC, 18));
        bookFlightBackground.add(customerUID);

        customerUIDField = new JTextField();
        customerUIDField.setBounds(160,60, 150,35);
        bookFlightBackground.add(customerUIDField);

        fetchCustomerButton = new JButton("Fetch");
        fetchCustomerButton.setBounds(350,60,100,35);
        fetchCustomerButton.addActionListener(this);
        bookFlightBackground.add(fetchCustomerButton);

        customerName = new JLabel("Name:");
        customerName.setBounds(20, 100, 150, 35);
        customerName.setFont(new Font("BLACK-ITALIC", Font.ITALIC, 18));
        bookFlightBackground.add(customerName);

        thCustomerName = new JLabel("");
        thCustomerName.setBounds(160, 100, 350, 35);
        thCustomerName.setFont(new Font("BLACK-ITALIC", Font.PLAIN, 18));
        bookFlightBackground.add(thCustomerName);

        customerNationality = new JLabel("Nationality:");
        customerNationality.setBounds(20, 150, 150, 35);
        customerNationality.setFont(new Font("BLACK-ITALIC", Font.ITALIC, 18));
        bookFlightBackground.add(customerNationality);

        thCustomerNationality = new JLabel("");
        thCustomerNationality.setBounds(160, 150, 350, 35);
        thCustomerNationality.setFont(new Font("BLACK-ITALIC", Font.PLAIN, 18));
        bookFlightBackground.add(thCustomerNationality);

        customerNumber = new JLabel("Number:");
        customerNumber.setBounds(20, 200, 150, 35);
        customerNumber.setFont(new Font("BLACK-ITALIC", Font.ITALIC, 18));
        bookFlightBackground.add(customerNumber);

        thCustomerNumber = new JLabel("");
        thCustomerNumber.setBounds(160, 200, 350, 35);
        thCustomerNumber.setFont(new Font("BLACK-ITALIC", Font.PLAIN, 18));
        bookFlightBackground.add(thCustomerNumber);

        customerAddress = new JLabel("Address:");
        customerAddress.setBounds(20, 250, 150, 35);
        customerAddress.setFont(new Font("BLACK-ITALIC", Font.ITALIC, 18));
        bookFlightBackground.add(customerAddress);

        thCustomerAddress = new JLabel("");
        thCustomerAddress.setBounds(160, 250, 350, 35);
        thCustomerAddress.setFont(new Font("BLACK-ITALIC", Font.PLAIN, 18));
        bookFlightBackground.add(thCustomerAddress);

        customerGender = new JLabel("Gender:");
        customerGender.setBounds(20, 300, 150, 35);
        customerGender.setFont(new Font("BLACK-ITALIC", Font.ITALIC, 18));
        bookFlightBackground.add(customerGender);

        thCustomerGender = new JLabel("");
        thCustomerGender.setBounds(160, 300, 350, 35);
        thCustomerGender.setFont(new Font("BLACK-ITALIC", Font.PLAIN, 18));
        bookFlightBackground.add(thCustomerGender);

        setSize(900, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private static int findCustomerByUID (String StringUID) {
        int uid = -1;
        try {
            Connections conn = new Connections();
            String query = "SELECT * FROM passenger WHERE stringUID = ?";
            PreparedStatement preparedStatement = conn.connection.prepareStatement(query);
            uid = Integer.parseInt(StringUID);
            preparedStatement.setInt(1,uid);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return uid;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fetchCustomerButton) {
            if (findCustomerByUID(fetchCustomerButton.getText()) != -1) {

                /*
                thCustomerName.setText();
                thCustomerAddress.setText();
                thCustomerNationality.setText();
                thCustomerNumber.setText();
                thCustomerGender.setText(); */
            } else {
                JOptionPane.showMessageDialog(null, "Customer not found");
            }
        }
    }
    public static void main(String[] args) {
        new BookFlight();
    }
}
