package service;

import entity.Booking;
import entity.CoworkingSpace;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


class CoworkingSpaceServiceTest {
    private CoworkingSpaceService coworkingSpaceService;

    @BeforeEach
    public void prepareTestInstance() {
        coworkingSpaceService = new CoworkingSpaceService();
    }

    @Test
    void getCoworkingSpaceById_notFoundInMap_emptyOptional() {

        Optional<CoworkingSpace> coworkingSpace = coworkingSpaceService.getCoworkingSpaceById(100);

        assertFalse(coworkingSpace.isPresent());
    }

}
