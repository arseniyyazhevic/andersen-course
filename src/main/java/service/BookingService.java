package service;

import entity.Booking;
import ui.ConsoleOutput;
import util.BookingDBUtils;
import util.DBUtils;
import util.FileUtils;
import util.sortingUtils.BookingDateComparator;

import java.util.*;

public class BookingService {

    public BookingService() {
        loadBookingFromFile(fileOfBookingsPath);
    }


    public Optional<Booking> getBookingById(int id) {
        return Optional.ofNullable(BookingDBUtils.getBooking(id));
    }

    public void cancelReservation(int id) {
        BookingDBUtils.deleteBooking(id);
    }

    public void makeReservation(Booking booking) {
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

    public HashMap<Long, Booking> loadBookingsFromDB() {
        return DBUtils.loadBookingsFromDB().orElse(new HashMap<>());
    }

}
