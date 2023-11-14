package main.java.entities;

import main.java.ticketBooking.Ticket;

import java.time.LocalDateTime;

public class Show {
    private int id;
    private Movie movie;
    private LocalDateTime showTime;
    private int availableSeats;
    private CinemaHall cinemaHall;
    private double price;

    public Show() {
    }

    public Show(int id, Movie movie, LocalDateTime showTime,
                int availableSeats, CinemaHall cinemaHall, double price) {
        this.id = id;
        this.movie = movie;
        this.showTime = showTime;
        this.availableSeats = availableSeats;
        this.cinemaHall = cinemaHall;
        this.price = price;
    }

    public synchronized Ticket bookTicket(Customer customer, int totalSeatsToBook) {
        if (totalSeatsToBook <= availableSeats) {
            Ticket ticket = new Ticket();
            ticket.setShow(this);
            ticket.setOwner(customer.getName());
            ticket.setDateTime(LocalDateTime.now());
            ticket.setTotalSeatsBooked(totalSeatsToBook);
            System.out.println("Ticket booked successfully");

            availableSeats = availableSeats - totalSeatsToBook;
            return ticket;
        }

        System.out.println("Not enough seats available");
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(CinemaHall cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Show{" +
                "id=" + id +
                ", movie=" + movie.getName() +
                ", showTime=" + showTime +
                ", availableSeats=" + availableSeats +
                ", cinemaHall=" + cinemaHall.getName() +
                '}';
    }
}
