package main.java.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class BookingRequest {
    private UUID uuid;
    private Location from;
    private Location destination;
    private Rider rider;
    private String assignedCabLicense;
    private LocalDateTime date;
    private BookingStatus status;

    public BookingRequest(Location from, Location destination, Rider rider) {
        this.uuid = UUID.randomUUID();
        this.from = from;
        this.destination = destination;
        this.rider = rider;
        this.date = LocalDateTime.now();
        this.status = BookingStatus.PENDING;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Location getFrom() {
        return from;
    }

    public void setFrom(Location from) {
        this.from = from;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public String getAssignedCabLicense() {
        return assignedCabLicense;
    }

    public void setAssignedCabLicense(String assignedCabLicense) {
        this.assignedCabLicense = assignedCabLicense;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BookingRequest{" +
                "uuid=" + uuid +
                ", from=" + from +
                ", destination=" + destination +
                ", rider=" + rider +
                ", assignedCabLicense='" + assignedCabLicense + '\'' +
                ", date=" + date +
                ", status=" + status +
                '}';
    }
}
