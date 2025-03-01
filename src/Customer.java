import java.util.HashSet;

public class Customer extends User {


    private HashSet<Booking> customerReservations = new HashSet<>();


    public boolean cancelReservation(int id) {
        Booking booking = BookingManagement.getBookingById(id);
        if(booking == null) {
            return false;
        }else {
            BookingManagement.allBookings.remove(booking);
            customerReservations.remove(booking);
            return true;
        }
    }

    public void makeReservation(Booking booking){
        customerReservations.add(booking);
        BookingManagement.allBookings.add(booking);
    }

    public void viewReservations() {
        for (Booking booking: customerReservations) {
            System.out.println(booking.getId() + "\n" + booking.getCustomerName() + "\n" + booking.getDate() + " " + booking.getStartAndEndOfBookingTime() +"\n"
            + booking.getIdOfCoworkingSpace() + " " + WorkspaceManagement.getCoworkingSpaceById(booking.getIdOfCoworkingSpace()).getName());
            System.out.println("------------------------------");
        }
    }
}
