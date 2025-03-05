package service;

import entity.Booking;
import ui.ConsoleInput;
import ui.ConsoleOutput;
import validation.BookingValidator;

import java.util.HashSet;

public class BookingService {
    public static HashSet<Booking> allBookings = new HashSet<>();
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

    public boolean cancelReservation(int id) {
        Booking booking = getBookingById(id);
        if (booking == null) {
            return false;
        } else {
            BookingService.allBookings.remove(booking);
            customerReservations.remove(booking);
            return true;
        }
    }

    public void makeReservation(Booking booking) {
        customerReservations.add(booking);
        BookingService.allBookings.add(booking);
    }

    public void viewMyReservations() {
        for (Booking booking : customerReservations) {
            ConsoleOutput.println(booking.getId() + "\n" + booking.getCustomerName() + "\n" + booking.getDate() + " " + booking.getStartAndEndOfBookingTime() + "\n" +
                    + booking.getIdOfCoworkingSpace() + " " + (CoworkingSpaceService.getCoworkingSpaceById(booking.getIdOfCoworkingSpace())).getName());
            ConsoleOutput.println("------------------------------");
        }
    }

    public void displayAllBookings() {
        ConsoleOutput.println("list of bookings: ");
        for (Booking booking : allBookings) {
            ConsoleOutput.println(booking.toString());
        }
    }

}
