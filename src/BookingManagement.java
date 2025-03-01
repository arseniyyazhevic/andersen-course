import java.util.HashSet;

public class BookingManagement {
    public static HashSet<Booking> allBookings = new HashSet<>();


    public static void displayAllBookings() {
        System.out.println("list of bookings: ");
        for (Booking booking: allBookings) {
            System.out.println(booking);
        }
    }

}
