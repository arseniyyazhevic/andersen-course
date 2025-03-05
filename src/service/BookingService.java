package service;

import entity.Booking;
import ui.ConsoleInput;
import ui.ConsoleOutput;
import util.FileUtils;
import validation.BookingValidator;

import java.util.HashSet;

public class BookingService {
    public static HashSet<Booking> allBookings;
    public HashSet<Booking> customerReservations = new HashSet<>();

    public BookingService() {
    }


    public Booking getBookingById(int id) {
        for (Booking booking : allBookings) {
            if (booking.getId() == id) {
                return booking;
            }
        }
        return null;
    }

    public void cancelReservation(int id) { // TODO
            BookingService.allBookings.remove(getBookingById(id));
            customerReservations.remove(getBookingById(id));
    }

    public void makeReservation(Booking booking) {
        customerReservations.add(booking);
        BookingService.allBookings.add(booking);
    }

    public void viewMyReservations() {
        for (Booking booking : customerReservations) {
            ConsoleOutput.println(booking.getId() + "\n" + booking.getCustomerName() + "\n" + booking.getDate() + " " + booking.getStartAndEndOfBookingTime() + "\n" +
                    +booking.getIdOfCoworkingSpace() + " " + (CoworkingSpaceService.getCoworkingSpaceById(booking.getIdOfCoworkingSpace())).getName());
            ConsoleOutput.println("------------------------------");
        }
    }

    public void displayAllBookings() {
        ConsoleOutput.println("list of bookings: ");
        for (Booking booking : allBookings) {
            ConsoleOutput.println(booking.toString());
        }
    }

    public void saveAllBookingsToFile(String fileName) {
        FileUtils.saveBookingsToFile(fileName, allBookings);
    }

    public void loadBookingFromFile(String fileName) {
        allBookings = FileUtils.loadBookingsFromFile(fileName);
    }

}
