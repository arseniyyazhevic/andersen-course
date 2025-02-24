import java.util.Set;

public class Customer {
    private String login;

    private Set<Booking> customerReservations;


    public void cancelReservation(int id) {

    }

    public void makeReservation(int id, Booking booking)

    public void viewReservations() {
        for (Booking booking: customerReservations) {
            System.out.println(booking.getId() + "\n" + booking.getCustomerName() + "\n" + booking.getDate() + " " + booking.getStartAndEndOfBookingTime());
            System.out.println("------------------------------");
        }
    }
}
