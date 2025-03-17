package service;

import entity.Booking;
import ui.ConsoleOutput;
import util.FileUtils;
import util.sortingUtils.BookingDateComparator;
import util.sortingUtils.SortingUtil;

import java.util.*;

public class BookingService {
    public static HashMap<Integer, Booking> allBookingsByCoworking;
    public HashMap<Integer, Booking> customerReservations = new HashMap<>();

    public BookingService() {
    }


    public Optional<Booking> getBookingById(int id) {
        return Optional.ofNullable(allBookingsByCoworking.get(id));
    }

    public void cancelReservation(int id) { // TODO
        allBookingsByCoworking.remove(id);
        customerReservations.remove(id);
    }

    public void makeReservation(Booking booking) {
        allBookingsByCoworking.put(booking.getId(), booking);
        customerReservations.put(booking.getId(), booking);
    }

    public void viewMyReservations() {
        ConsoleOutput.println("List of Customer Reservations: ");
        allBookingsByCoworking.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(new BookingDateComparator()))
                .forEach(entry -> ConsoleOutput.println(entry.getKey() +" "+ entry.getValue()));
    }

    public void displayAllBookings() {
        ConsoleOutput.println("List of Bookings: ");
        allBookingsByCoworking.entrySet().stream().
                sorted(Map.Entry.comparingByValue(new BookingDateComparator())).
                forEach(entry -> ConsoleOutput.println(entry.getKey() +" "+ entry.getValue()));
    }

    public void saveAllBookingsToFile(String fileName) {
        FileUtils.saveBookingsToFile(fileName, allBookingsByCoworking);
    }

    public void loadBookingFromFile(String fileName) {
        allBookingsByCoworking = FileUtils.loadBookingsFromFile(fileName).orElse(new HashMap<>());
    }

}
