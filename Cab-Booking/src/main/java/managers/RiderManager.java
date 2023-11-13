package main.java.managers;

import main.java.entities.BookingRequest;
import main.java.entities.Location;
import main.java.entities.Rider;
import main.java.service.BookingService;
import main.java.service.DefaultBookingStrategy;

import java.util.HashMap;
import java.util.Map;

public class RiderManager {

    private final Map<String, Rider> nameToRiderMap;
    private static RiderManager riderManagerInstance = null;

    private RiderManager() {
        nameToRiderMap = new HashMap<>();
    }

    public static RiderManager getRiderManagerInstance() {
        if (riderManagerInstance == null) {
            riderManagerInstance = new RiderManager();
        }
        return riderManagerInstance;
    }

    public void addRider(Rider rider) {
        String name = rider.getName();
        if (!nameToRiderMap.containsKey(name)) {
            nameToRiderMap.put(name, rider);
        }
    }

    public void removeRider(Rider rider) {
        String name = rider.getName();
        nameToRiderMap.remove(name);
    }

    public Rider findRider(String name) {
        if (nameToRiderMap.containsKey(name)) {
            return nameToRiderMap.get(name);
        }

        return null;
    }

    public BookingRequest requestCab(Rider rider, Location destination) {
        BookingRequest bookingRequest = new BookingRequest(rider.getLocation(), destination, rider);

        //strategy to assign the cab
        bookingRequest = new BookingService().useBookingStrategy(new DefaultBookingStrategy()).assignCabToRider(bookingRequest);
        return bookingRequest;
    }

}
