package main.java.parking;

import main.java.model.Slot;

import java.util.TreeSet;

public class DefaultParkingStrategy implements ParkingStrategy {
    TreeSet<Integer> slots;

    public DefaultParkingStrategy() {
        this.slots = new TreeSet<>();
    }

    public void addSlot(Integer n) {
        slots.add(n);
    }

    public void removeSlot(Integer n) {
        slots.remove(n);
    }

    public Slot getSlot() {
        if (slots.isEmpty()) {
            System.out.println("no slots available");
        }
        return new Slot(slots.first(), true);
    }
}
