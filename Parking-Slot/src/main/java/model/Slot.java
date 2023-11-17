package main.java.model;

public class Slot {
    private int number;
    private boolean isAvailable;

    public Slot(int number, boolean isAvailable) {
        this.number = number;
        this.isAvailable = isAvailable;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "number=" + number +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
