package main.java.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Movie {
    private String name;
    private double durationMin;
    private String genre;
    private String language;
    private Map<String, List<Show>> cityToShowListMap;

    public Movie() {
    }

    public Movie(String name, double durationMin, String genre,
                 String language) {
        this.name = name;
        this.durationMin = durationMin;
        this.genre = genre;
        this.language = language;
        this.cityToShowListMap = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDurationMin() {
        return durationMin;
    }

    public void setDurationMin(double durationMin) {
        this.durationMin = durationMin;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Map<String, List<Show>> getCityToShowListMap() {
        return cityToShowListMap;
    }

    public void setCityToShowListMap(Map<String, List<Show>> cityToShowListMap) {
        this.cityToShowListMap = cityToShowListMap;
    }

}
