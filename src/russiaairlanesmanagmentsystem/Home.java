package russiaairlanesmanagmentsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {
    public Home() {
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Home page");

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("russiaairlanesmanagmentsystem/img/plane-main-background.jpg"));
        JLabel backgroundImage = new JLabel(imageIcon);
        backgroundImage.setBounds(0, 0, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        add(backgroundImage);

        JLabel headingLabel = new JLabel("Welcome to Russia airlanes managment system");
        headingLabel.setBounds(500,10,1000,200);
        headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headingLabel.setForeground(Color.BLACK);
        headingLabel.setFont(new Font("Serif", Font.PLAIN, 40));
        backgroundImage.add(headingLabel);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        fileMenu.add(exitMenuItem);
        exitMenuItem.addActionListener(this);
        exitMenuItem.setActionCommand("exit");

        JMenu detailsMenu = new JMenu("details");
        menuBar.add(detailsMenu);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("exit")) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Home();
    }


}
