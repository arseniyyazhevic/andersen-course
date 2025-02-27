import java.util.HashSet;

public class BookingManagement {
    public static HashSet<Booking> allBookings;


    public static void displayAllBookings() {
        for (Booking booking: allBookings) {
            System.out.println(booking);
        }
    }

}
