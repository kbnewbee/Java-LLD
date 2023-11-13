package main.java.service;

import main.java.entities.BookingRequest;
import main.java.entities.BookingStatus;
import main.java.entities.Cab;
import main.java.managers.CabManager;

public class BookingService {
    private AssignCabStrategy assignCabStrategy;

    public BookingService() {
        this.assignCabStrategy = null;
    }

    public BookingService useBookingStrategy(AssignCabStrategy assignCabStrategy) {
        this.assignCabStrategy = assignCabStrategy;
        return this;
    }

    public BookingRequest assignCabToRider(BookingRequest bookingRequest) {
        if (assignCabStrategy == null) {
            System.out.println("Cab assign strategy is not defined");
        }

        Cab cab = this.assignCabStrategy.assignCabToRider(bookingRequest);
        if (cab != null) {
            bookingRequest.setAssignedCabLicense(cab.getLicense());
            cab.setAvailable(false);
            bookingRequest.setStatus(BookingStatus.CONFIRM);

            // lol - same thing could be implemented for a driver entity
            bookingRequest.getRider().addBookingRequest(bookingRequest);
        } else {
            System.out.println("No cabs are available at the moment");
        }

        return bookingRequest;
    }
}
