package russiaairlanesmanagmentsystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CancelTickets extends JFrame implements ActionListener {
    JTable table;
    JTextField jtfPNR;
    JLabel labelPNR, labelName, labelCancelNumber, labelFlightCode, labelDate;
    JButton jbShow;
    JScrollPane jspScrollPane;
    public CancelTickets() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        labelPNR = new JLabel("PNR Number");
        labelPNR.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelPNR.setBounds(50, 50, 100, 25);
        add(labelPNR);

        labelName = new JLabel("Name");

        jtfPNR = new JTextField();
        jtfPNR.setBounds(160, 50, 120, 25);
        add(jtfPNR);

        jbShow = new JButton("Show Details");
        jbShow.setBackground(Color.BLACK);
        jbShow.setForeground(Color.WHITE);
        jbShow.setBounds(290, 50, 120, 25);
        jbShow.addActionListener(this);
        jbShow.setActionCommand("Show Details");
        add(jbShow);

        table = new JTable();

        jspScrollPane = new JScrollPane(table);
        jspScrollPane.setBounds(0, 100, 800, 150);
        jspScrollPane.setBackground(Color.WHITE);
        add(jspScrollPane);

        setSize(800, 600);
        setLocation(400, 150);
        setTitle("Journey Details");
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Show Details")) {
            try {
                Connections newConnection = new Connections();
                ResultSet resultSet = newConnection.statement.executeQuery("select * from reservation where PNR = '" + jtfPNR.getText() + "'");
                if (!resultSet.isBeforeFirst()) {
                    JOptionPane.showMessageDialog(null, "Информация не найдена.");
                    return;
                }
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
                labelName
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getActionCommand().equals("Cancel Tickets")) {
            try {
                Connections newConnection = new Connections();
                String query = "DELETE * FROM reservation where PNR = ?";
                PreparedStatement preparedStatement = newConnection.connection.prepareStatement(query);
                preparedStatement.setString(1, jtfPNR.getText());
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static void main(String[] args) {
        new CancelTickets();
    }
}
