import entity.Booking;
import entity.CoworkingSpace;
import enums.TypeOfWorkspaces;
import entity.menus.AdminMenu;
import entity.menus.CustomerMenu;
import entity.menus.Menu;
import entity.roles.Admin;
import entity.roles.Customer;
import entity.roles.User;
import exception.InvalidStartAndEndOfBookingException;
import utils.BookingManagement;
import utils.WorkspaceManagement;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    private static final String WELCOME_MESSAGE = "Welcome to Coworking Space Reservation App – Your Gateway to Productive Workspaces!";
    private static final String WRITE_YOUR_LOGIN_MESSAGE = "If you want to Exit enter 3 or write down your login (five and more characters): ";
    private static final String CHOOSE_ROLE_MESSAGE = "Please choose your role Customer(1) or Admin(2): ";

    public static void main(String[] args) throws InvalidStartAndEndOfBookingException {
        Scanner scanner = new Scanner(System.in);
        processingReservationApp(scanner);
    }

    private static User chooseRoleAndGetIt(Scanner scanner) {
        System.out.println(WELCOME_MESSAGE);
        User user = getUserFromUserInput(scanner);
        String userLoginInput = getLoginFromUserInput(scanner);
        if (userLoginInput.equals("exit")) {
            return null;
        }
        user.setLogin(userLoginInput);
        return user;
    }

    private static void processingReservationApp(Scanner scanner) throws InvalidStartAndEndOfBookingException {
        User user = chooseRoleAndGetIt(scanner);
        if (user == null) {
            return;
        }
        Menu menu = createMenu(user);
        user = createUser(user);
        if (user instanceof Admin) {
            handlingUserInputInAdminMenu((Admin) user, menu, scanner);
        } else if (user instanceof Customer) {
            handlingUserInputInCustomerMenu((Customer) user, menu, scanner);
        }
    }

    private static User getUserFromUserInput(Scanner scanner) {
        while (true) {
            System.out.print(CHOOSE_ROLE_MESSAGE);
            if (scanner.hasNextLine()) {
                String userInput = scanner.next();
                if (userInput.equalsIgnoreCase("customer") || userInput.equals("1")) {
                    return new Customer();
                } else if (userInput.equalsIgnoreCase("admin") || userInput.equals("2")) {
                    return new Admin();
                } else {
                    System.out.println("Invalid role input, please try again.");
                }
            }
        }
    }


    private static String getLoginFromUserInput(Scanner scanner) {
        while (true) {
            System.out.print(WRITE_YOUR_LOGIN_MESSAGE);
            String userLoginInput = scanner.next();
            if (userLoginInput.equals("3") || userLoginInput.equalsIgnoreCase("exit")) {
                return "exit";
            }
            if (userLoginInput.length() >= 5) {
                return userLoginInput;
            } else {
                System.out.println("Invalid login, please try again.");
            }
        }
    }

    private static Menu createMenu(User userRole) {
        if (userRole instanceof Admin) {
            return new AdminMenu();
        } else {
            return new CustomerMenu();
        }
    }

    private static User createUser(User userRole) {
        if (userRole instanceof Admin) {
            return new Admin();
        } else {
            return new Customer();
        }
    }

    private static CoworkingSpace createCoworkingSpaceUsingUserInput(Scanner scanner) {
        CoworkingSpace coworkingSpace = new CoworkingSpace();
        System.out.println("Enter information about Coworking Space");
        coworkingSpace.setName(getValidatedNameFromUser(scanner));
        coworkingSpace.setTypeOfWorkspaces(getValidatedTypeOfWorkspaceUserInput(scanner));
        coworkingSpace.setPriceInDollars(getValidatedPriceOfCoworkingFromUser(scanner));
        coworkingSpace.setAvailabilityStatus(getValidatedAvailableStatusOfCoworkingFromUser(scanner));
        return coworkingSpace;
    }

    private static Booking createBookingUsingUserInput(Scanner scanner) throws InvalidStartAndEndOfBookingException {
        Booking booking = new Booking();
        System.out.println("Enter information about entity.Booking");
        booking.setCustomerName(getValidatedNameFromUser(scanner));
        booking.setDate(getValidatedDateFromUser(scanner));
        booking.setStartAndEndOfBookingTime(getValidatedStartAndEndOfBookingTimeFromUser(scanner));
        booking.setIdOfCoworkingSpace(getValidatedIdOfCoworkingSpaceFromUser(scanner));
        return booking;
    }

    private static TypeOfWorkspaces getValidatedTypeOfWorkspaceUserInput(Scanner scanner) {
        boolean invalidTypeOfWorkspaceInput = true;
        TypeOfWorkspaces typeOfWorkspaces = null;
        while (invalidTypeOfWorkspaceInput) {
            scanner.nextLine(); // clearing the buffer
            System.out.print("Type of coworking (private/open space/room/meeting room) : ");
            try {
                String typeOfWorkSpace = scanner.next();
                typeOfWorkspaces = TypeOfWorkspaces.getTypeOfWorkspaceFromUserInput(typeOfWorkSpace);
                invalidTypeOfWorkspaceInput = false;
            } catch (RuntimeException e) {
                System.out.println("Invalid input, private/open space/room/meeting room ");
            }
        }
        return typeOfWorkspaces;
    }

    private static String getValidatedNameFromUser(Scanner scanner) {
        boolean invalidNameOfCoworkingSpaceInput = true;
        String str = null;
        while (invalidNameOfCoworkingSpaceInput) {
            scanner.nextLine(); // clearing the buffer
            System.out.print("Enter your name: ");
            if (scanner.hasNext()) {
                str = scanner.next();
                invalidNameOfCoworkingSpaceInput = false;
            } else {
                System.out.println("Invalid input please try again");
            }

        }
        return str;
    }

    private static Integer getValidatedPriceOfCoworkingFromUser(Scanner scanner) {
        boolean invalidPriceOfCoworkingSpaceInput = true;
        Integer price = null;
        while (invalidPriceOfCoworkingSpaceInput) {
            scanner.nextLine();  // clearing the buffer
            System.out.print("Price in dollars: ");
            if (scanner.hasNextInt()) {
                price = scanner.nextInt();
                invalidPriceOfCoworkingSpaceInput = false;

            } else {
                System.out.println("Invalid input please try again");
            }

        }
        return price;
    }

    private static Boolean getValidatedAvailableStatusOfCoworkingFromUser(Scanner scanner) {
        boolean invalidAvailableStatusOfCoworkingSpaceInput = true;
        Boolean availableStatus = null;
        while (invalidAvailableStatusOfCoworkingSpaceInput) {
            scanner.nextLine(); // clearing the buffer
            System.out.print("Available status (false - not available/ true - available): ");
            if (scanner.hasNextBoolean()) {
                availableStatus = scanner.nextBoolean();
                invalidAvailableStatusOfCoworkingSpaceInput = false;
            } else {
                System.out.println("Invalid input please try again (false/ true)");
            }

        }
        return availableStatus;
    }

    private static Integer getValidatedIdToDeleteFromUser(Scanner scanner) {
        boolean invalidIdUserInput = true;
        Integer id = null;
        while (invalidIdUserInput) {
            try {
                scanner.nextLine(); // clearing the buffer
                System.out.print("Enter an id to delete: ");
                if (scanner.hasNextInt()) {
                    id = scanner.nextInt();
                    invalidIdUserInput = false;
                } else {
                    System.out.println("Invalid input please try again");
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        return id;
    }

    private static Integer getValidatedIdOfCoworkingSpaceFromUser(Scanner scanner) {
        boolean invalidIdUserInput = true;
        Integer id = null;
        while (invalidIdUserInput) {
            try {
                WorkspaceManagement.displayAllCoworkingSpaces();
                scanner.nextLine(); // clearing the buffer
                System.out.print("Enter id of coworking space you want to book: ");
                if (scanner.hasNextInt()) {
                    id = scanner.nextInt();
                    invalidIdUserInput = false;
                } else {
                    System.out.println("Invalid input please try again");
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        return id;
    }

    private static LocalDate getValidatedDateFromUser(Scanner scanner) {
        boolean invalidDateOfBookingInput = true;
        LocalDate date = null;
        String[] userInput;
        while (invalidDateOfBookingInput) {
            scanner.nextLine(); // clearing the buffer
            System.out.print("Enter date (Example:year.month.dayOfMonth): ");
            if (scanner.hasNext()) {
                try {
                    userInput = scanner.next().split("\\.");
                    date = LocalDate.of(Integer.parseInt(userInput[0]), Integer.parseInt(userInput[1]), Integer.parseInt(userInput[2]));
                    invalidDateOfBookingInput = false;
                } catch (DateTimeException e) {
                    System.out.println("Invalid input please try again (Example:year.month.dayOfMonth)");
                }
            } else {
                System.out.println("Invalid input please try again (Example:year.month.dayOfMonth)");
            }

        }
        return date;
    }

    private static String getValidatedStartAndEndOfBookingTimeFromUser(Scanner scanner) throws InvalidStartAndEndOfBookingException { //  TODO - create custom exception here
        boolean invalidStartAndEndOfBookingTimeInput = true;
        String startAndEndOfBookingTime = null;
        String[] userInput;
        int endOfBooking;
        while (invalidStartAndEndOfBookingTimeInput) {
            scanner.nextLine(); // clearing the buffer
            System.out.print("Enter time of reservation and duration (18,2), 18 - time, 2 - duration: ");
            if (scanner.hasNext()) {
                try {
                    userInput = scanner.next().split(",");
                    endOfBooking = Integer.parseInt(userInput[0]) + Integer.parseInt(userInput[1]);
                    startAndEndOfBookingTime = userInput[0] + ":00-" + endOfBooking + ":00";
                    invalidStartAndEndOfBookingTimeInput = false;
                } catch (Exception e) {
                    throw new InvalidStartAndEndOfBookingException("Invalid input please try again (18,2), 18 - time, 2 - duration");
                }
            } else {
                System.out.println("Invalid input please try again (18,2), 18 - time, 2 - duration");
            }

        }
        return startAndEndOfBookingTime;
    }

    private static void removingCoworkingSpaceValidated(Admin admin, Scanner scanner) {
        boolean existOfCoworkingSpace = false;
        while (!existOfCoworkingSpace) {
            existOfCoworkingSpace = admin.removeCoworkingSpace(getValidatedIdToDeleteFromUser(scanner));
            if (!existOfCoworkingSpace) {
                System.out.println("Coworking Space with this id does not exist");
            }
        }
    }

    private static void removingBookingValidated(Customer customer, Scanner scanner) {
        boolean existOfBooking = false;
        while (!existOfBooking) {
            existOfBooking = customer.cancelReservation(getValidatedIdToDeleteFromUser(scanner));
            if (!existOfBooking) {
                System.out.println("entity.Booking with this id does not exist");
            }
        }
    }

    private static void handlingUserInputInAdminMenu(Admin admin, Menu menu, Scanner scanner) throws InvalidStartAndEndOfBookingException {
        while (true) {
            menu.showMenu();
            switch (scanner.next()) {   //TODO - create a method to validate this input
                case "1":
                    admin.addCoworkingSpace(createCoworkingSpaceUsingUserInput(scanner));
                    break;
                case "2":
                    WorkspaceManagement.displayAllCoworkingSpaces();
                    removingCoworkingSpaceValidated(admin, scanner);
                    break;
                case "3":
                    WorkspaceManagement.displayAllCoworkingSpaces();
                    admin.updateAllInformationAboutCoworkingSpace(getValidatedIdToDeleteFromUser(scanner), createCoworkingSpaceUsingUserInput(scanner));
                    break;
                case "4":
                    BookingManagement.displayAllBookings();
                    break;
                case "5":
                    processingReservationApp(scanner);
                default:
                    System.out.println("Incorrect input");
                    break;
            }
        }
    }

    private static void handlingUserInputInCustomerMenu(Customer customer, Menu menu, Scanner scanner) throws InvalidStartAndEndOfBookingException {
        while (true) {
            menu.showMenu();
            switch (scanner.nextInt()) {
                case 1:
                    WorkspaceManagement.displayAllCoworkingSpaces();
                    break;
                case 2:
                    customer.makeReservation(createBookingUsingUserInput(scanner));
                    break;
                case 3:
                    customer.cancelReservation(getValidatedIdToDeleteFromUser(scanner));
                    break;
                case 4:
                    customer.viewReservations();
                    break;
                case 5:
                    processingReservationApp(scanner);
                default:
                    System.out.println("Incorrect input");
                    break;

            }
        }
    }

}