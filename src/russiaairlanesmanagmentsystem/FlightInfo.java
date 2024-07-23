package russiaairlanesmanagmentsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.proteanit.sql.DbUtils;

public class FlightInfo extends JFrame implements ActionListener {
    public FlightInfo() {
        getContentPane().setLayout(new BorderLayout());
        JTable table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        table.setBounds(0,0,800,500);

        try {
            Connections newConnection = new Connections();
            ResultSet resultSet = newConnection.statement.executeQuery("select  * from flight");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        add(scrollPane, BorderLayout.CENTER);

        setSize(800,200);
        setLocation(400,200);
        setTitle("Flight Information");
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
