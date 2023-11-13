package main.java.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Rider {
    private String name;
    private Location location;
    private Map<UUID, BookingRequest> uuidToBookingRequestMap;

    public Rider(String name, Location location) {
        uuidToBookingRequestMap = new HashMap<>();
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void addBookingRequest(BookingRequest bookingRequest) {
        UUID uuid = bookingRequest.getUuid();
        if (!uuidToBookingRequestMap.containsKey(uuid))
            uuidToBookingRequestMap.put(uuid, bookingRequest);
    }

    public void updateBookingRequest(BookingRequest bookingRequest) {
        UUID uuid = bookingRequest.getUuid();
        if (!uuidToBookingRequestMap.containsKey(uuid))
            uuidToBookingRequestMap.put(uuid, bookingRequest);
    }

    public BookingRequest findBookingRequest(UUID uuid) {
        if (uuidToBookingRequestMap.containsKey(uuid)) {
            return uuidToBookingRequestMap.get(uuid);
        }
        return null;
    }


}
