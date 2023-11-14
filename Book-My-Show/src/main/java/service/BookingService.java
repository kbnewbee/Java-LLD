package main.java.service;

import main.java.entities.CinemaHall;
import main.java.entities.Movie;
import main.java.entities.Show;

import java.util.ArrayList;
import java.util.HashMap;

public class BookingService {

    private ArrayList<CinemaHall> cinemaHalls;
    private HashMap<String, ArrayList<Show>> movieToShowListMap;

    public BookingService(ArrayList<CinemaHall> cinemaHalls) {
        this.cinemaHalls = cinemaHalls;
        movieToShowListMap = new HashMap<>();
        generateMovieMap();

        System.out.println("All movies list with shows : ");
        System.out.println(movieToShowListMap);
    }

    private void generateMovieMap() {
        for (CinemaHall cinemaHall : cinemaHalls) {
            ArrayList<Show> showList = cinemaHall.getShowList();
            for (Show show : showList) {
                Movie movie = show.getMovie();
                if (!movieToShowListMap.containsKey(movie.getName())) {
                    ArrayList<Show> sList = new ArrayList<>();
                    sList.add(show);
                    movieToShowListMap.put(movie.getName(), sList);
                } else {
                    movieToShowListMap.get(movie.getName()).add(show);
                }
            }

        }
    }

    public ArrayList<Show> searchShows(String movieName) {
        if (movieToShowListMap.containsKey(movieName)) {
            return movieToShowListMap.get(movieName);
        }
        return null;
    }

}
