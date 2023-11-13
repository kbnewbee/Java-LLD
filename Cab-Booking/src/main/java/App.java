package main.java;

import main.java.entities.BookingRequest;
import main.java.entities.Cab;
import main.java.entities.Location;
import main.java.entities.Rider;
import main.java.managers.CabManager;
import main.java.managers.RiderManager;

public class App {

    public static void main(String[] args) {
        // create 3 cabs
        Cab c1 = new Cab("l1", "driver1", true, new Location(0, 0));
        Cab c2 = new Cab("l2", "driver2", true, new Location(10, 10));
        Cab c3 = new Cab("l3", "driver3", true, new Location(20, 20));

        CabManager.getCabManagerInstance().addCabToDatabase(c1);
        CabManager.getCabManagerInstance().addCabToDatabase(c2);
        CabManager.getCabManagerInstance().addCabToDatabase(c3);

        // create rider trying to book a cab
        Rider r1 = new Rider("rider1", new Location(2, 2));
        RiderManager.getRiderManagerInstance().addRider(r1);
        Location destination1 = new Location(50, 50);

        BookingRequest bookingRequest1 =
                RiderManager.getRiderManagerInstance().requestCab(r1, destination1);

        Rider r2 = new Rider("rider1", new Location(2, 2));
        RiderManager.getRiderManagerInstance().addRider(r1);
        Location destination2 = new Location(50, 50);

        BookingRequest bookingRequest2 =
                RiderManager.getRiderManagerInstance().requestCab(r2, destination2);

        System.out.println(bookingRequest1);
        System.out.println(bookingRequest2);
    }


}
