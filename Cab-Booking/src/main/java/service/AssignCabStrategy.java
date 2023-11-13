package main.java.service;

import main.java.entities.BookingRequest;
import main.java.entities.Cab;

public interface AssignCabStrategy {
    Cab assignCabToRider(BookingRequest bookingRequest);
}
