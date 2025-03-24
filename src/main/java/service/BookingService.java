package service;

import entity.Booking;
import ui.ConsoleOutput;
import util.BookingDBUtils;
import util.DBUtils;
import util.FileUtils;
import util.sortingUtils.BookingDateComparator;

import java.util.*;

public class BookingService {
    public static HashMap<Integer, Booking> allBookingsByCoworking;
    public HashMap<Integer, Booking> customerReservations = new HashMap<>();

    public BookingService() {
    }


    public Optional<Booking> getBookingById(int id) {
        return Optional.ofNullable(BookingDBUtils.getBooking(id));
    }

    public void cancelReservation(int id) {
        allBookingsByCoworking.remove(id);
        customerReservations.remove(id);
        BookingDBUtils.deleteBooking(id);
    }

    public void makeReservation(Booking booking) {
        allBookingsByCoworking.put(booking.getId(), booking);
        customerReservations.put(booking.getId(), booking);
        BookingDBUtils.createBooking(booking);
    }

    public void viewMyReservations() {
//        ConsoleOutput.println("List of Customer Reservations: ");
//        allBookingsByCoworking.entrySet().stream()
//                .sorted(Map.Entry.comparingByValue(new BookingDateComparator()))
//                .forEach(entry -> ConsoleOutput.println(entry.getKey() +" "+ entry.getValue()));
        BookingDBUtils.readBookings();
    }

    public void displayAllBookings() {
//        ConsoleOutput.println("List of Bookings: ");
//        allBookingsByCoworking.entrySet().stream().
//                sorted(Map.Entry.comparingByValue(new BookingDateComparator())).
//                forEach(entry -> ConsoleOutput.println(entry.getKey() +" "+ entry.getValue()));
        BookingDBUtils.readBookings();
    }

    public void saveAllBookingsToFile(String fileName) {
        FileUtils.saveBookingsToFile(fileName, allBookingsByCoworking);
    }

    public void loadBookingsFromFile(String fileName) {
        allBookingsByCoworking = FileUtils.loadBookingsFromFile(fileName).orElse(new HashMap<>());
    }

    public void loadBookingsFromDB() {
        allBookingsByCoworking = DBUtils.loadBookingsFromDB().orElse(new HashMap<>());
    }

}
