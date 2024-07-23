package russiaairlanesmanagmentsystem;

import javax.swing.*;
import java.awt.event.*;
import java.awt.print.Book;

public class Home extends JFrame implements ActionListener {
    public Home() {
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("russiaairlanesmanagmentsystem/img/plane-main-background.jpg"));
        JLabel backgroundImage = new JLabel(imageIcon);
        backgroundImage.setBounds(0, 0, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        add(backgroundImage);

        /* JLabel headingLabel = new JLabel("Welcome to Russia airlanes managment system");
        headingLabel.setBounds(500,10,1000,200);
        headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headingLabel.setForeground(Color.BLACK);
        headingLabel.setFont(new Font("Serif", Font.PLAIN, 40));
        backgroundImage.add(headingLabel); */

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        fileMenu.add(exitMenuItem);
        exitMenuItem.addActionListener(this);
        exitMenuItem.setActionCommand("Exit");

        JMenu detailsMenu = new JMenu("Details");
        menuBar.add(detailsMenu);

        JMenuItem flightDetails = new JMenuItem("Flight Details");
        detailsMenu.add(flightDetails);
        flightDetails.addActionListener(this);
        flightDetails.setActionCommand("FlightDetails");

        JMenuItem addCustomerDetails = new JMenuItem("Add Customer Details");
        detailsMenu.add(addCustomerDetails);
        addCustomerDetails.addActionListener(this);
        addCustomerDetails.setActionCommand("AddCustomerDetails");

        JMenuItem reservationDetails = new JMenuItem("Reservation Details");
        detailsMenu.add(reservationDetails);
        reservationDetails.addActionListener(this);
        reservationDetails.setActionCommand("ReservationDetails");

        JMenuItem bookFlights = new JMenuItem("Book Flights");
        detailsMenu.add(bookFlights);
        bookFlights.addActionListener(this);
        bookFlights.setActionCommand("BookFlights");

        JMenuItem journeyDetails = new JMenuItem("Journey Details");
        detailsMenu.add(journeyDetails);
        journeyDetails.addActionListener(this);
        journeyDetails.setActionCommand("JourneyDetails");

        JMenu ticket = new JMenu("Ticket");
        menuBar.add(ticket);
        ticket.addActionListener(this);
        ticket.setActionCommand("Ticket");

        JMenuItem ticketCancellation = new JMenuItem("Ticket Cancellation");
        ticket.add(ticketCancellation);
        ticketCancellation.addActionListener(this);
        ticketCancellation.setActionCommand("TicketCancellation");

        JMenuItem boardingPass = new JMenuItem("Boarding Pass");
        ticket.add(boardingPass);
        boardingPass.addActionListener(this);
        boardingPass.setActionCommand("BoardingPass");

        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Home page");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }
        if (e.getActionCommand().equals("FlightDetails")) {
            new FlightInfo();
        }
        if (e.getActionCommand().equals("AddCustomerDetails")) {
            new AddCustomer();
        }
        if (e.getActionCommand().equals("ReservationDetails")) {

        }
        if (e.getActionCommand().equals("BookFlights")) {
            new BookFlight();
        }
        if (e.getActionCommand().equals("JourneyDetails")) {

        }
        if (e.getActionCommand().equals("TicketCancellation")) {

        }
        if (e.getActionCommand().equals("Ticket")) {

        }
        if (e.getActionCommand().equals("boardingPass")) {

        }
    }
}
