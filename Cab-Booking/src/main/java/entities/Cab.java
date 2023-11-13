package main.java.entities;

public class Cab {
    private String license;
    private String driverName;
    private boolean isAvailable;
    private Location location;
    private double baseFare;
    private double perKMFare;

    public Cab() {
    }

    public Cab(String license, String driverName, boolean isAvailable, Location location) {
        this.license = license;
        this.driverName = driverName;
        this.isAvailable = isAvailable;
        this.location = location;
        this.baseFare = 10.0;
        this.perKMFare = 2.0;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(double baseFare) {
        this.baseFare = baseFare;
    }

    public double getPerKMFare() {
        return perKMFare;
    }

    public void setPerKMFare(double perKMFare) {
        this.perKMFare = perKMFare;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Cab{" +
                "license='" + license + '\'' +
                ", driverName='" + driverName + '\'' +
                ", isAvailable=" + isAvailable +
                ", location=" + location +
                ", baseFare=" + baseFare +
                ", perKMFare=" + perKMFare +
                '}';
    }
}
