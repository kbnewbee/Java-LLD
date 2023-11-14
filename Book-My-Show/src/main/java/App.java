package main.java;

import main.java.entities.CinemaHall;
import main.java.entities.Customer;
import main.java.entities.Movie;
import main.java.entities.Show;
import main.java.service.BookingService;
import main.java.ticketBooking.TicketBookingThread;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) {

        /* *********************************** Admin work *********************************** */

        CinemaHall cinemaHall1 = new CinemaHall(1, "PVR", "Bir", 10);
        CinemaHall cinemaHall2 = new CinemaHall(2, "INOX", "Manali", 10);

        Movie movie1 = new Movie("Fight Club", 120, "Action", "English");
        Movie movie2 = new Movie("Inception", 120, "Action", "English");

        LocalDateTime slot1 = LocalDateTime.of(
                LocalDate.of(2023, 11, 20),
                LocalTime.of(8, 0));
        LocalDateTime slot2 = LocalDateTime.of(
                LocalDate.of(2023, 11, 20),
                LocalTime.of(13, 0));

        Show show1 = new Show(1, movie1, slot1, 10, cinemaHall1, 100.00);
        Show show2 = new Show(2, movie1, slot2, 10, cinemaHall1, 100.00);

        ArrayList<Show> movie1Shows = new ArrayList<>();
        movie1Shows.add(show1);
        movie1Shows.add(show2);

        cinemaHall1.setShowList(movie1Shows);

        Show show3 = new Show(3, movie2, slot1, 10, cinemaHall2, 100.00);
        Show show4 = new Show(4, movie2, slot2, 10, cinemaHall2, 100.00);
        ArrayList<Show> movie2Shows = new ArrayList<>();
        movie2Shows.add(show3);
        movie2Shows.add(show4);

        cinemaHall2.setShowList(movie2Shows);

        Map<String, List<Show>> cityToShowListMap1 = new HashMap<>();
        cityToShowListMap1.put("Bir", movie1Shows);
        movie1.setCityToShowListMap(cityToShowListMap1);

        Map<String, List<Show>> cityToShowListMap2 = new HashMap<>();
        cityToShowListMap2.put("Bir", movie1Shows);
        movie2.setCityToShowListMap(cityToShowListMap2);

        ArrayList<CinemaHall> cinemaHalls = new ArrayList<>();
        cinemaHalls.add(cinemaHall1);
        cinemaHalls.add(cinemaHall2);
        BookingService bookingService = new BookingService(cinemaHalls);

        /* *********************************** Admin end ************************************ */

        /* *********************************** Customer Booking ***************************** */

        Customer c1 = new Customer("Kallol");
        Customer c2 = new Customer("Udit");
        Customer c3 = new Customer("Pratik");

        System.out.println("*********************** Customer Platform *************************************");

        ArrayList<Show> movie1shows = bookingService.searchShows("Fight Club");
        System.out.println("Shows for Fight Club : ");
        System.out.println(movie1shows);

        ArrayList<Show> movie2shows = bookingService.searchShows("Inception");
        System.out.println("Shows for Inception : ");
        System.out.println(movie2shows);

        TicketBookingThread customer1 = new TicketBookingThread(show1, c1, 2);
        TicketBookingThread customer2 = new TicketBookingThread(show1, c2, 3);
        TicketBookingThread customer3 = new TicketBookingThread(show3, c3, 2);

        customer1.start();
        customer2.start();
        customer3.start();

        try {
            customer1.join();
            customer2.join();
            customer3.join();

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        /* *********************************** Next Customer Booking ***************************** */

        ArrayList<Show> movie1shows2 = bookingService.searchShows("Fight Club");
        System.out.println("Shows for Fight Club : ");
        System.out.println(movie1shows2);

        ArrayList<Show> movie2shows2 = bookingService.searchShows("Inception");
        System.out.println("Shows for Inception : ");
        System.out.println(movie2shows2);

    }
}
