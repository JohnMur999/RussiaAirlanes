package russiaairlanesmanagmentsystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JourneyDetails extends JFrame implements ActionListener {
    JTable table;
    JTextField jtfPNR;
    JLabel labelPNR;
    JButton jbShow;
    JScrollPane jspScrollPane;
    public JourneyDetails() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        labelPNR = new JLabel("PNR Details");
        labelPNR.setFont(new Font("BLACK-ITALIC", Font.PLAIN, 16));
        labelPNR.setBounds(50, 50, 100, 25);
        add(labelPNR);

        jtfPNR = new JTextField();
        jtfPNR.setBounds(160, 50, 120, 25);
        add(jtfPNR);

        jbShow = new JButton("Show Details");
        jbShow.setBackground(Color.BLACK);
        jbShow.setForeground(Color.WHITE);
        jbShow.setBounds(290, 50, 120, 25);
        jbShow.addActionListener(this);
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
        try {
            Connections newConnection = new Connections();
            ResultSet resultSet = newConnection.statement.executeQuery("select * from reservation where PNR = '" + jtfPNR.getText() + "'");
            if (!resultSet.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Информация не найдена.");
                return;
            }
            table.setModel(DbUtils.resultSetToTableModel(resultSet));;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
