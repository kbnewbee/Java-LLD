package main.java.model;

public class Car {
    private String license;
    private String color;

    public Car(String license, String color) {
        this.license = license;
        this.color = color;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "license='" + license + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
