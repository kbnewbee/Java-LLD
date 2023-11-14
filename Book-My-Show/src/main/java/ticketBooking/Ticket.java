package main.java.ticketBooking;

import main.java.entities.Show;

import java.time.LocalDateTime;

public class Ticket {
    private int id;
    private String owner;
    private int totalSeatsBooked;
    private Show show;
    private LocalDateTime dateTime;
    boolean isPaid;

    public Ticket() {
    }

    public Ticket(int id, String owner, int totalSeatsBooked, Show show, LocalDateTime dateTime) {
        this.id = id;
        this.owner = owner;
        this.totalSeatsBooked = totalSeatsBooked;
        this.show = show;
        this.dateTime = dateTime;
        isPaid = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getTotalSeatsBooked() {
        return totalSeatsBooked;
    }

    public void setTotalSeatsBooked(int totalSeatsBooked) {
        this.totalSeatsBooked = totalSeatsBooked;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", totalSeatsBooked=" + totalSeatsBooked +
                ", show=" + show +
                ", dateTime=" + dateTime +
                '}';
    }
}
