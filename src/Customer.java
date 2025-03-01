import java.util.HashSet;

public class Customer extends User {


    private HashSet<Booking> customerReservations;


    public boolean cancelReservation(int id) {
        Booking booking = BookingManagement.getBookingById(id);
        if(booking == null) {
            return false;
        }else {
            WorkspaceManagement.allCoworkingSpaces.remove(WorkspaceManagement.getCoworkingSpaceById(id));
            return true;
        }
    }

    public void makeReservation(Booking booking){
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
