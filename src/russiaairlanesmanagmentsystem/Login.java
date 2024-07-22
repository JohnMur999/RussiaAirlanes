package russiaairlanesmanagmentsystem;

import javax.swing.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton jbSubmit, jbReset, jbExit;
    JTextField jtfUsername;
    JPasswordField jpfPassword;
    public Login() {
        setVisible(true);
        setSize(400,300);
        setTitle("Login form");
        setLocation(920,520);
        setLayout(null);

        //Username label
        JLabel lblUsername = new JLabel("Username: "); //Creating label
        lblUsername.setBounds(20,20,100,20); // Entering position of new label (fixed XYWH)
        add(lblUsername); // Adding label to the screen

        //Login field
        jtfUsername = new JTextField();
        jtfUsername.setBounds(100,20,100,20);
        add(jtfUsername);

        //Password label
        JLabel lblPassword = new JLabel("Password: ");
        lblPassword.setBounds(20,60,100,20);
        add(lblPassword);

        //Password field
        jpfPassword = new JPasswordField();
        jpfPassword.setBounds(100,60,100,20);
        add(jpfPassword);

        //Submit button
        jbSubmit = new JButton("Submit");
        jbSubmit.setBounds(250,200,100,20);
        jbSubmit.addActionListener(this);
        add(jbSubmit);

        //Reset button
        jbReset = new JButton("Reset");
        jbReset.setBounds(150,200,100,20);
        jbReset.addActionListener(this);
        add(jbReset);

        //Exit button
        jbExit = new JButton("Exit");
        jbExit.setBounds(200,220,100,20);
        jbExit.addActionListener(this);
        add(jbExit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbExit) {
            System.exit(0);
        }
        if (e.getSource() == jbReset) {
            jtfUsername.setText("");
            jpfPassword.setText("");
        }
        if (e.getSource() == jbSubmit) {
            try {
                Connections newConnection = new Connections();

                String query = "select * from login where username = ? and password = ?";

                PreparedStatement preparedStatement = newConnection.connection.prepareStatement(query);
                preparedStatement.setString(1, jtfUsername.getText());
                preparedStatement.setString(2, jpfPassword.getText());

                ResultSet result = preparedStatement.executeQuery();

                if (result.next()) {
                    JOptionPane.showMessageDialog(null, "Valid. Connected");
                    new Home().setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username of password");
                    setVisible(false);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Login();
    }


}
