package main.java.ticketBooking;

import main.java.entities.Customer;
import main.java.entities.Show;

public class TicketBookingThread extends Thread {

    private Show show;
    private Customer customer;
    private int totalSeatsToBook;
    private Ticket ticket;
    private Payment payment;


    public TicketBookingThread(Show show, Customer customer, int totalSeatsToBook) {
        this.show = show;
        this.customer = customer;
        this.totalSeatsToBook = totalSeatsToBook;
    }

    @Override
    public void run() {
        this.ticket = show.bookTicket(customer,totalSeatsToBook);
        Payment.generatePayment(ticket);
    }

    public Ticket getTicket() {
        return ticket;
    }
}
