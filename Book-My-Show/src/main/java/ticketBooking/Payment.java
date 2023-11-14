package main.java.ticketBooking;

import main.java.entities.Show;

import java.time.LocalDateTime;
import java.util.Random;

public class Payment {

    double amount;
    LocalDateTime paymentDate;
    int transactionId;
    boolean isSuccess;

    public Payment(double amount, LocalDateTime paymentDate, int transactionId, boolean isSuccess) {
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.transactionId = transactionId;
        this.isSuccess = isSuccess;
    }

    public static void generatePayment(Ticket ticket) {
        double billAmount = ticket.getTotalSeatsBooked() * ticket.getShow().getPrice();
        Payment payment = new Payment(billAmount, LocalDateTime.now(), 1, true);
        System.out.println("Payment Success = " + payment);
        ticket.isPaid = true;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "amount=" + amount +
                ", paymentDate=" + paymentDate +
                ", transactionId=" + transactionId +
                ", isSuccess=" + isSuccess +
                '}';
    }
}
