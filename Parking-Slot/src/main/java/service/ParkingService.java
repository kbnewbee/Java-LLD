package main.java.service;

import main.java.model.Car;
import main.java.model.Slot;
import main.java.parking.ParkingLot;
import main.java.parking.ParkingStrategy;

public class ParkingService {
    private final ParkingLot parkingLot;
    private ParkingStrategy parkingStrategy;

    public ParkingService(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        this.parkingStrategy = null;
    }

    public ParkingService useParkingStrategy(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
        return this;
    }

    public void park(Car car) {
        if (parkingStrategy == null) {
            System.out.println("no parking strategy set");
            return;
        }

        Slot slot = this.parkingStrategy.getSlot();
        parkingLot.addCarToPark(car, slot);
        this.parkingStrategy.removeSlot(slot.getNumber());
        //return receipt
    }

    public void leave(Car car) {
        Slot freedSlot = parkingLot.removeCar(car);
        if (freedSlot != null)
            parkingStrategy.addSlot(freedSlot.getNumber());
    }
}
