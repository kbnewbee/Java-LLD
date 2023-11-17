package main.java;

import main.java.model.Car;
import main.java.model.Slot;
import main.java.parking.DefaultParkingStrategy;
import main.java.parking.ParkingLot;
import main.java.parking.ParkingStrategy;
import main.java.service.ParkingService;

public class App {

    public static void main(String[] args) {
        Slot s1 = new Slot(1, true);
        Slot s2 = new Slot(2, true);
        Slot s3 = new Slot(3, true);

        ParkingLot parkingLot = new ParkingLot(3, 3);

        ParkingStrategy parkingStrategy = new DefaultParkingStrategy();
        parkingStrategy.addSlot(1);
        parkingStrategy.addSlot(2);
        parkingStrategy.addSlot(3);

        ParkingService parkingService = new ParkingService(parkingLot);
        parkingService = parkingService.useParkingStrategy(parkingStrategy);

        /* ****************************** Car entering parking ***************************************************** */

        Car c1 = new Car("lic1", "blue");
        Car c2 = new Car("lic2", "blue");
        Car c3 = new Car("lic3", "red");
        Car c4 = new Car("lic4", "white");

        parkingService.park(c1);
        parkingService.park(c2);
        parkingService.park(c3);

        parkingService.leave(c2);

        parkingService.park(c4);

    }
}
