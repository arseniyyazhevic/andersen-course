import java.util.HashSet;

public class Customer extends User {


    private HashSet<Booking> customerReservations;


    public void cancelReservation(int id) {

    }

    public void makeReservation(int id, Booking booking){
        customerReservations.add(booking);
        BookingManagement.allBookings.add(booking);
    }

    public void viewReservations() {
        for (Booking booking: customerReservations) {
            System.out.println(booking.getId() + "\n" + booking.getCustomerName() + "\n" + booking.getDate() + " " + booking.getStartAndEndOfBookingTime());
            System.out.println("------------------------------");
        }
    }
}
