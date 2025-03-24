import enums.TypeOfWorkspaces;
import service.BookingService;
import service.CoworkingSpaceService;
import service.UserService;
import ui.ConsoleInput;
import ui.MenuHandler;
import util.CoworkingSpaceDBUtils;
import util.DBUtils;

import java.io.IOException;
import java.sql.*;

public class CoworkingReservationApp {
    private static final ConsoleInput consoleInput = new ConsoleInput();
    private static final BookingService bookingService = new BookingService();
    private static final CoworkingSpaceService coworkingSpaceService = new CoworkingSpaceService();
    private static final UserService userService = new UserService();
    private static final MenuHandler menuHandler = new MenuHandler(bookingService, coworkingSpaceService, userService, consoleInput);

    public static void main(String[] args){
        System.out.println(CoworkingSpaceDBUtils.getCoworkingSpace(1));
        bookingService.loadBookingsFromDB();
        coworkingSpaceService.loadCoworkingSpacesFromDB();
        menuHandler.processingReservationApp();
        }
    }

