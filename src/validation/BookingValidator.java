package validation;

import exception.ValidationException;
import service.BookingService;

import java.time.DateTimeException;
import java.time.LocalDate;

public class BookingValidator extends Validator{
    public  LocalDate validateDate(String dateStr) throws ValidationException {
        LocalDate date = null;
        String[] userInput;
                try {
                    userInput = dateStr.split("\\.");
                    date = LocalDate.of(Integer.parseInt(userInput[0]), Integer.parseInt(userInput[1]), Integer.parseInt(userInput[2]));
                    return date;
                } catch (DateTimeException e) {
                    throw new ValidationException("(Example:year.month.dayOfMonth)");
                }
    }

    public  String validateStartAndEndOfBookingTime(String startAndDuration) throws ValidationException { //
        String startAndEndOfBookingTime = null;
        String[] userInput;
        int endOfBooking;
                try {
                    userInput = startAndDuration.split(",");
                    endOfBooking = Integer.parseInt(userInput[0]) + Integer.parseInt(userInput[1]);
                    startAndEndOfBookingTime = userInput[0] + ":00-" + endOfBooking + ":00";
                    return startAndEndOfBookingTime;
                } catch (Exception e) {
                    throw new ValidationException("(18,2), 18 - time, 2 - duration");
                }
    }

    public static void removingBookingValidated(BookingService bookingService, int id) { // TODO
        boolean existOfBooking = false;
        while (!existOfBooking) {
            existOfBooking = bookingService.cancelReservation(id);
            if (!existOfBooking) {
                System.out.println("Booking with this id does not exist");
            }
        }
    }
}
