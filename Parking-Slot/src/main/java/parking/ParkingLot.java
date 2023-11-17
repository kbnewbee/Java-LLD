package main.java.parking;

import main.java.model.Car;
import main.java.model.Slot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int totalSlots;
    private int slotsAvailable;
    private Map<String, Slot> carToSlotMap;

    public ParkingLot(int totalSlots, int slotsAvailable) {
        this.totalSlots = totalSlots;
        this.slotsAvailable = slotsAvailable;
        this.carToSlotMap = new HashMap<>();
    }

    public void addCarToPark(Car car, Slot slot) {
        if (slotsAvailable >= 0) {
            carToSlotMap.put(car.getLicense(), slot);
            slot.setAvailable(false);
            slotsAvailable--;
            System.out.println(slot + " slot successfully allocated to the car" + car);
            //return a receipt
        } else {
            System.out.println("no slots available");
        }
    }

    public Slot removeCar(Car car) {
        if (carToSlotMap.containsKey(car.getLicense())) {
            Slot slot = carToSlotMap.get(car.getLicense());
            slot.setAvailable(true);
            slotsAvailable++;
            carToSlotMap.remove(car.getLicense());
            return slot;
        } else {
            System.out.println("slot is empty, car might have left already");
        }

        return null;
    }


}
