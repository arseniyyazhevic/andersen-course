package validator;

import entity.Booking;
import exception.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import validation.BookingValidator;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookingValidatorTest {
    private BookingValidator bookingValidator;

    @BeforeEach
    public void prepareInstance() {bookingValidator = new BookingValidator();}

    @Test
    void getValidateDate_notCorrectInput_throwValidationException(){

        assertThrows(ValidationException.class, () -> bookingValidator.validateDate("121.2121.21212.2112"));
    }
}
