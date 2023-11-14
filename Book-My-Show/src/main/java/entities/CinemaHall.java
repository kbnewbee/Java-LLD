package main.java.entities;

import java.util.ArrayList;
import java.util.List;

public class CinemaHall {

    private int id;
    private String name;
    private String city;
    private int totalSeats;
    private ArrayList<Show> showList;

    public CinemaHall() {
    }

    public CinemaHall(int id, String name, String city,
                      int totalSeats) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.totalSeats = totalSeats;
        this.showList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public ArrayList<Show> getShowList() {
        return showList;
    }

    public void setShowList(ArrayList<Show> showList) {
        this.showList = showList;
    }

}
