package service;

import entity.Booking;
import entity.CoworkingSpace;
import ui.ConsoleOutput;
import util.FileUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class BookingService {
    public static HashMap<Integer, Booking> allBookingsByCoworking = new HashMap<>();
    public HashMap<Integer, Booking> customerReservations = new HashMap<>();

    public BookingService() {
    }


    public Booking getBookingById(int id) {
        return allBookingsByCoworking.get(id);
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
        int i = 1;
        for (Map.Entry<Integer, Booking> entry : customerReservations.entrySet()) {
            System.out.println(i + ". " + entry.getValue());
        }
    }

    public void displayAllBookings() {
        ConsoleOutput.println("List of Bookings: ");
        int i = 1;
        for (Map.Entry<Integer, Booking> entry : allBookingsByCoworking.entrySet()) {
            System.out.println(i + ". " + entry.getValue());
        }
    }

    public void saveAllBookingsToFile(String fileName) {
        FileUtils.saveBookingsToFile(fileName, allBookingsByCoworking);
    }

    public void loadBookingFromFile(String fileName) {
        HashMap<Integer, Booking> input = FileUtils.loadBookingsFromFile(fileName);
        if(input != null) {
            allBookingsByCoworking = input;
        }
    }

}
