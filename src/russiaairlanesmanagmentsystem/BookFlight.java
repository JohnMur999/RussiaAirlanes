package russiaairlanesmanagmentsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import com.toedter.calendar.JDateChooser;

public class BookFlight extends JFrame implements ActionListener {
    JLabel customerUID, customerName, customerNationality, customerNumber, customerAddress, customerGender,
           thCustomerName, thCustomerNationality, thCustomerNumber, thCustomerAddress, thCustomerGender,
            flyFromLabel, flyToLabel, flightName, flightCode, dateOfTravel, thFlightName, thFlightCode;
    Choice destination, source;
    //JDateChooser dcCalendar;
    JTextField customerUIDField;
    JButton fetchCustomerButton, fetchFlightButton, bookFlightButton;
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

        flyFromLabel = new JLabel("Fly From:");
        flyFromLabel.setBounds(20,350,150,35);
        flyFromLabel.setFont(new Font("BLACK-ITALIC", Font.PLAIN, 18));
        bookFlightBackground.add(flyFromLabel);

        source = new Choice();
        source.setBounds(160,350,150,35);
        source.setFont(new Font("BLACK-ITALIC", Font.PLAIN, 18));
        bookFlightBackground.add(source);

        flyToLabel = new JLabel("Fly To:");
        flyToLabel.setBounds(20,400,150,35);
        flyToLabel.setFont(new Font("BLACK-ITALIC", Font.PLAIN, 18));
        bookFlightBackground.add(flyToLabel);

        destination = new Choice();
        destination.setBounds(160,400,150,35);
        destination.setFont(new Font("BLACK-ITALIC", Font.PLAIN, 18));
        bookFlightBackground.add(destination);

        fetchFlightButton = new JButton("Fetch Flights");
        fetchFlightButton.setBounds(320,400,150,35);
        fetchFlightButton.addActionListener(this);
        bookFlightBackground.add(fetchFlightButton);

        flightName = new JLabel("Flight Name:");
        flightName.setBounds(20,450,150,35);
        flightName.setFont(new Font("BLACK-ITALIC", Font.PLAIN, 18));
        bookFlightBackground.add(flightName);

        thFlightName = new JLabel("");
        thFlightName.setBounds(160,450,150,35);
        thFlightName.setFont(new Font("BLACK-ITALIC", Font.PLAIN, 18));
        bookFlightBackground.add(thFlightName);

        flightCode = new JLabel("Flight Code:");
        flightCode.setBounds(20,500,150,35);
        flightCode.setFont(new Font("BLACK-ITALIC", Font.PLAIN, 18));
        bookFlightBackground.add(flightCode);

        thFlightCode = new JLabel("");
        thFlightCode.setBounds(160,500,150,35);
        thFlightCode.setFont(new Font("BLACK-ITALIC", Font.PLAIN, 18));
        bookFlightBackground.add(thFlightCode);

        dateOfTravel = new JLabel("Date of Travel:");
        dateOfTravel.setFont(new Font("BLACK-ITALIC", Font.PLAIN, 18));
        dateOfTravel.setBounds(20,550,150,35);
        bookFlightBackground.add(dateOfTravel);

        //dcCalendar = new

        bookFlightButton = new JButton("Book Flight");
        bookFlightButton.setBounds(160,600,150,35);
        bookFlightButton.addActionListener(this);
        bookFlightBackground.add(bookFlightButton);

        setSize(900,740);
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
            int findedCustomerUID = findCustomerByUID(customerUIDField.getText());
            if (findedCustomerUID != -1) {
                try {
                    Connections conn = new Connections();
                    String query = "SELECT name, address, nationality, phone, gender FROM passenger WHERE uid = ?";
                    PreparedStatement preparedStatement = conn.connection.prepareStatement(query);
                    preparedStatement.setInt(1, findedCustomerUID);

                    ResultSet rs = preparedStatement.executeQuery();
                    if (rs.next()) {
                        thCustomerName.setText(rs.getString("name"));
                        thCustomerAddress.setText(rs.getString("address"));
                        thCustomerNationality.setText(rs.getString("nationality"));
                        thCustomerNumber.setText(rs.getString("phone"));
                        thCustomerGender.setText(rs.getString("gender"));
                    } else {
                        JOptionPane.showMessageDialog(null, "Cannot find customer with UID " + findedCustomerUID);
                        thCustomerName.setText("");
                        thCustomerAddress.setText("");
                        thCustomerNationality.setText("");
                        thCustomerNumber.setText("");
                        thCustomerGender.setText("");
                    }
                    rs.close();
                    preparedStatement.close();
                    conn.connection.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Customer not found");
            }
            if (e.getSource() == fetchFlightButton) {

            }
            if (e.getSource() == bookFlightButton) {

            }
        }
    }
    public static void main(String[] args) {
        new BookFlight();
    }
}
