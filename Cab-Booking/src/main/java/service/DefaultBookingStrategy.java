package main.java.service;

import main.java.entities.BookingRequest;
import main.java.entities.Cab;
import main.java.entities.Location;
import main.java.entities.Rider;
import main.java.managers.CabManager;

import java.util.ArrayList;

public class DefaultBookingStrategy implements AssignCabStrategy {
    @Override
    public Cab assignCabToRider(BookingRequest bookingRequest) {
        Rider rider = bookingRequest.getRider();
        ArrayList<Cab> availableCabs = CabManager.getCabManagerInstance().findAvailableCabs();

        double minDistance = Double.MAX_VALUE;
        Cab assignedCab = null;

        for (int i = 0; i < availableCabs.size(); i++) {
            Cab cab = availableCabs.get(i);
            double distance = calcDistance(cab.getLocation(), rider.getLocation());
            if (distance < minDistance) {
                minDistance = distance;
                assignedCab = cab;
            }
        }
        return assignedCab;
    }

    private double calcDistance(Location cabLocation, Location riderLocation) {
        double d = Math.pow((cabLocation.getX() - riderLocation.getX()), 2) +
                Math.pow((cabLocation.getY() - riderLocation.getY()), 2);
        return d;
    }
}
