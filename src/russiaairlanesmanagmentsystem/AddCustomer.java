package russiaairlanesmanagmentsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddCustomer extends JFrame implements ActionListener {

    JLabel customerName, customerNationality, customerNumber, customerAddress, customerGender;
    JTextField customerNameField, customerNationalityField, customerNumberField, customerAddressField;
    ButtonGroup buttonGroup = new ButtonGroup();
    JRadioButton rbMale, rbFemale, rbOther;
    JButton resetButton, addCustomerButton, backButton;

    public AddCustomer() {
        getContentPane().setBackground(Color.WHITE);
        setTitle("Add Customer");
        ImageIcon imageSource = new ImageIcon(ClassLoader.getSystemResource("russiaairlanesmanagmentsystem/img/add-customer.png"));
        JLabel customerBackground = new JLabel(imageSource);
        customerBackground.setBounds(0, 0, imageSource.getIconWidth(), imageSource.getIconHeight());
        add(customerBackground);

        customerName = new JLabel("Name:");
        customerName.setBounds(20, 100, 150, 35);
        customerName.setFont(new Font("BLACK-ITALIC", Font.ITALIC, 18));
        customerBackground.add(customerName);

        customerNameField = new JTextField();
        customerNameField.setBounds(120, 100, 350, 35);
        customerNameField.setFont(new Font("BLACK-ITALIC", Font.PLAIN, 18));
        customerBackground.add(customerNameField);

        customerNationality = new JLabel("Nationality:");
        customerNationality.setBounds(20, 150, 150, 35);
        customerNationality.setFont(new Font("BLACK-ITALIC", Font.ITALIC, 18));
        customerBackground.add(customerNationality);

        customerNationalityField = new JTextField();
        customerNationalityField.setBounds(120, 150, 350, 35);
        customerNationalityField.setFont(new Font("BLACK-ITALIC", Font.PLAIN, 18));
        customerBackground.add(customerNationalityField);

        customerNumber = new JLabel("Number:");
        customerNumber.setBounds(20, 200, 150, 35);
        customerNumber.setFont(new Font("BLACK-ITALIC", Font.ITALIC, 18));
        customerBackground.add(customerNumber);

        customerNumberField = new JTextField();
        customerNumberField.setBounds(120, 200, 350, 35);
        customerNumberField.setFont(new Font("BLACK-ITALIC", Font.PLAIN, 18));
        customerBackground.add(customerNumberField);

        customerAddress = new JLabel("Address:");
        customerAddress.setBounds(20, 250, 150, 35);
        customerAddress.setFont(new Font("BLACK-ITALIC", Font.ITALIC, 18));
        customerBackground.add(customerAddress);

        customerAddressField = new JTextField();
        customerAddressField.setBounds(120, 250, 350, 35);
        customerAddressField.setFont(new Font("BLACK-ITALIC", Font.PLAIN, 18));
        customerBackground.add(customerAddressField);

        customerGender = new JLabel("Gender:");
        customerGender.setBounds(20, 300, 150, 35);
        customerGender.setFont(new Font("BLACK-ITALIC", Font.ITALIC, 18));
        customerBackground.add(customerGender);

        rbMale = new JRadioButton("Male");
        rbMale.setBounds(120, 300, 80, 35);
        customerBackground.add(rbMale);

        rbFemale = new JRadioButton("Female");
        rbFemale.setBounds(210, 300, 80, 35);
        customerBackground.add(rbFemale);

        rbOther = new JRadioButton("Other");
        rbOther.setBounds(300, 300, 80, 35);
        customerBackground.add(rbOther);

        buttonGroup.add(rbMale);
        buttonGroup.add(rbFemale);
        buttonGroup.add(rbOther);

        addCustomerButton = new JButton("Add");
        addCustomerButton.setBounds(20, 400, 100, 35);
        addCustomerButton.addActionListener(this);
        addCustomerButton.setActionCommand("addCustomer");
        customerBackground.add(addCustomerButton);

        backButton = new JButton("Back");
        backButton.setBounds(130, 400, 100, 35);
        backButton.addActionListener(this);
        backButton.setActionCommand("back");
        customerBackground.add(backButton);

        resetButton = new JButton("Reset");
        resetButton.setBounds(240, 400, 100, 35);
        resetButton.addActionListener(this);
        resetButton.setActionCommand("reset");
        customerBackground.add(resetButton);

        setSize(900, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("addCustomer")) {
                String name = customerNameField.getText();
                String nationality = customerNationalityField.getText();
                String number = customerNumberField.getText();
                String address = customerAddressField.getText();
                String gender = "";
                if (rbMale.isSelected()) {
                    gender = rbMale.getText();
                } else if (rbFemale.isSelected()) {
                    gender = rbFemale.getText();
                } else if (rbOther.isSelected()) {
                    gender = rbOther.getText();
                }
                if (name.isEmpty() || nationality.isEmpty() || number.isEmpty() || address.isEmpty() || gender.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please fill all the fields");
                } else {
                    new GenerateCustomer(name,nationality,number, address, gender);
                }
        }
        if (e.getActionCommand().equals("reset")) {
            customerNameField.setText("");
            customerNationalityField.setText("");
            customerNumberField.setText("");
            customerAddressField.setText("");
            rbMale.setSelected(false);
            rbFemale.setSelected(false);
            rbOther.setSelected(false);
        }
        if (e.getActionCommand().equals("back")) {
            setVisible(false);
        }
    }
}
