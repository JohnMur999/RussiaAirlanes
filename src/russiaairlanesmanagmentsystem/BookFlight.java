package russiaairlanesmanagmentsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import com.toedter.calendar.JDateChooser;

public class BookFlight extends JFrame implements ActionListener {
    JLabel customerUID, customerName, customerNationality, customerNumber, customerAddress, customerGender,
           thCustomerName, thCustomerNationality, thCustomerNumber, thCustomerAddress, thCustomerGender,
            flyFromLabel, flyToLabel, flightName, flightCode, dateOfTravel, thFlightName, thFlightCode;
    Choice destination, source;
    JDateChooser dcCalendar;
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
        flyFromLabel.setBounds(20,350,130,35);
        flyFromLabel.setFont(new Font("BLACK-ITALIC", Font.PLAIN, 18));
        bookFlightBackground.add(flyFromLabel);

        source = new Choice();
        source.setBounds(160,350,150,35);
        source.setFont(new Font("BLACK-ITALIC", Font.PLAIN, 18));
        bookFlightBackground.add(source);

        getInfoFromFlightTableForChoice(source, "source","select * from flight");

        flyToLabel = new JLabel("Fly To:");
        flyToLabel.setBounds(20,400,130,35);
        flyToLabel.setFont(new Font("BLACK-ITALIC", Font.PLAIN, 18));
        bookFlightBackground.add(flyToLabel);

        destination = new Choice();
        destination.setBounds(160,400,150,35);
        destination.setFont(new Font("BLACK-ITALIC", Font.PLAIN, 18));
        bookFlightBackground.add(destination);

        getInfoFromFlightTableForChoice(destination, "destination","select * from flight");

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

        dcCalendar = new JDateChooser();
        dcCalendar.setBounds(160,550,150,35);
        dcCalendar.setDateFormatString("dd/MM/yyyy");
        bookFlightBackground.add(dcCalendar);

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

    private static ResultSet getInfoFromFlightTableForChoice (Choice choice , String nameOfColumn,String query) {
        ResultSet rs = null;
        try {
            Connections conn = new Connections();
            rs = conn.statement.executeQuery(query);
            while (rs.next()) {
                choice.add(rs.getString(nameOfColumn));
            }
            rs.close();
            conn.connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        if (rs == null) {
            JOptionPane.showMessageDialog(null, "No data found.");
        }
        return rs;
    }

    private static void getInfoFromFlightTableForTextHolders (JLabel lbl1, JLabel lbl2, Choice choice1, Choice choice2, String query) {
        lbl1.setText("No flights found");
        lbl2.setText("No code found");
        String src = choice1.getSelectedItem();
        String dest = choice2.getSelectedItem();
        try {
            Connections conn = new Connections();
            PreparedStatement preparedStatement = conn.connection.prepareStatement(query);
            preparedStatement.setString(1, src);
            preparedStatement.setString(2, dest);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                lbl1.setText(rs.getString("f_name"));
                lbl2.setText(rs.getString("f_code"));
            }
            rs.close();
            preparedStatement.close();
            conn.connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fetchCustomerButton) {
                try {
                    int foundedCustomerUID = findCustomerByUID(customerUIDField.getText());
                    if (foundedCustomerUID != -1) {
                        try {
                            Connections conn = new Connections();
                            String query = "SELECT name, address, nationality, phone, gender FROM passenger WHERE uid = ?";
                            PreparedStatement preparedStatement = conn.connection.prepareStatement(query);
                            preparedStatement.setInt(1, foundedCustomerUID);

                            ResultSet rs = preparedStatement.executeQuery();
                            if (rs.next()) {
                                thCustomerName.setText(rs.getString("name"));
                                thCustomerAddress.setText(rs.getString("address"));
                                thCustomerNationality.setText(rs.getString("nationality"));
                                thCustomerNumber.setText(rs.getString("phone"));
                                thCustomerGender.setText(rs.getString("gender"));
                            } else {
                                JOptionPane.showMessageDialog(null, "Cannot find customer with UID "
                                        + foundedCustomerUID);
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
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Customer ID is incorrect");
                }
            }
            if (e.getSource() == fetchFlightButton) {
                getInfoFromFlightTableForTextHolders(thFlightName, thFlightCode,source, destination,
                        "SELECT * FROM flight WHERE source = ? AND destination = ?");
            }
            if (e.getSource() == bookFlightButton) {
                String uid = customerUIDField.getText();
                String name = thCustomerName.getText();
                String nationality = thCustomerNationality.getText();
                String phone = thCustomerNumber.getText();
                String src = source.getSelectedItem();
                String dest = destination.getSelectedItem();
                String flightName = thFlightName.getText();
                String flightCode = thFlightCode.getText();
                String dateOfTravel = ((JTextField) dcCalendar.getDateEditor().getUiComponent()).getText();
                if (flightName.isEmpty() || flightCode.isEmpty() || dateOfTravel.isEmpty()
                        || uid.isEmpty() || name.isEmpty() || nationality.isEmpty()
                        || phone.isEmpty() || src.isEmpty() || dest.isEmpty()
                        || flightName.equals("No flights found") || flightCode.equals("No code found")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields");
                } else {
                    try {
                        Connections conn = new Connections();
                        String query = "INSERT INTO reservation (PNR, TICKET, name, nationality, flightname, " +
                                "flightcode, src, des, ddate, uid, phone) " +
                                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement preparedStatement = conn.connection.prepareStatement(query);
                        Random random = new Random();
                        int pnr = random.nextInt(100000);
                        int ticket = random.nextInt(100000);
                        preparedStatement.setString(1, Integer.toString(pnr));
                        preparedStatement.setString(2, Integer.toString(ticket));
                        preparedStatement.setString(3, name);
                        preparedStatement.setString(4, nationality);
                        preparedStatement.setString(5, flightName);
                        preparedStatement.setString(6, flightCode);
                        preparedStatement.setString(7, src);
                        preparedStatement.setString(8, dest);
                        preparedStatement.setString(9, dateOfTravel);
                        preparedStatement.setString(10, uid);
                        preparedStatement.setString(11, phone);

                        int rowsInserted = preparedStatement.executeUpdate();
                        if (rowsInserted > 0) {
                            JOptionPane.showMessageDialog(this, "Reservation successful!");
                        }

                        preparedStatement.close();
                        conn.connection.close();
                    } catch (SQLException exception) {
                        exception.printStackTrace();
                    }
                }
            }
        }
    public static void main(String[] args) {
        new BookFlight();
    }
}


