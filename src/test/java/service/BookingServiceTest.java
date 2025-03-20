package service;

import entity.Booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;

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


}
