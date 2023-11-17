package main.java.parking;

import main.java.model.Slot;

public interface ParkingStrategy {
    Slot getSlot();

    void addSlot(Integer n);

    void removeSlot(Integer n);
}
