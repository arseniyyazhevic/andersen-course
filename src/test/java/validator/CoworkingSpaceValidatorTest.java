package validator;

import exception.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import validation.BookingValidator;
import validation.CoworkingSpaceValidator;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CoworkingSpaceValidatorTest {
    private CoworkingSpaceValidator coworkingSpaceValidator;

    @BeforeEach
    public void prepareInstance() {coworkingSpaceValidator = new CoworkingSpaceValidator();}

    @Test
    void getValidatePrice_notCorrectInput_throwValidationException(){

        assertThrows(ValidationException.class, () -> coworkingSpaceValidator.validatePriceOfCoworkingFromUser(1));
    }
}
