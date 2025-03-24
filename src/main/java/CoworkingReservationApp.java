import enums.TypeOfWorkspaces;
import service.BookingService;
import service.CoworkingSpaceService;
import service.UserService;
import ui.ConsoleInput;
import ui.MenuHandler;
import util.CoworkingSpaceDBUtils;
import util.DBUtils;
import validation.BookingValidator;
import validation.CoworkingSpaceValidator;
import validation.UserValidator;

import java.io.IOException;
import java.sql.*;

public class CoworkingReservationApp {

    private static final BookingService bookingService = new BookingService();
    private static final CoworkingSpaceService coworkingSpaceService = new CoworkingSpaceService();
    private static final UserService userService = new UserService();
    private static final ConsoleInput consoleInput = new ConsoleInput( new CoworkingSpaceValidator(coworkingSpaceService), new BookingValidator(bookingService), new UserValidator());
    private static final MenuHandler menuHandler = new MenuHandler(bookingService, coworkingSpaceService, userService, consoleInput);

    public static void main(String[] args){
        bookingService.loadBookingsFromDB();
        coworkingSpaceService.loadCoworkingSpacesFromDB();
        menuHandler.processingReservationApp();
        }
    }

