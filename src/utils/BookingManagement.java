package utils;

import entity.Booking;

import java.util.HashSet;

public class BookingManagement {
    public static HashSet<Booking> allBookings = new HashSet<>();


    public static Booking getBookingById(int id) {
        for (Booking booking : allBookings) {
            if (booking.getId() == id) {
                return booking;
            }
        }
        return null;
    }

    public static void displayAllBookings() {
        System.out.println("list of bookings: ");
        for (Booking booking : allBookings) {
            System.out.println(booking);
        }
    }

}
