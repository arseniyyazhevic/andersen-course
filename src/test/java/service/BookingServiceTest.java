package service;

import entity.Booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookingServiceTest {
    private BookingService bookingService;

    @BeforeEach
    public void prepareTestInstance() {
        bookingService = new BookingService();
    }

    @Test
    void getBookingById_notFoundInMap_emptyOptional() {

        Optional<Booking> booking = bookingService.getBookingById(100);

        assertFalse(booking.isPresent());
    }
    @Test
    void getBookingById_FoundInMap_bookingFromFile(){
        Optional<Booking> booking = bookingService.getBookingById(1);

        assertTrue(booking.isPresent());
    }


}
