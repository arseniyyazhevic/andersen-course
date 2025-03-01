import java.util.Scanner;

public class Main {

    private static final String WELCOME_MESSAGE = "Welcome to Coworking Space Reservation App – Your Gateway to Productive Workspaces!";
    private static final String WRITE_YOUR_LOGIN_MESSAGE = "If you want to Exit enter 3 or write down your login (five and more characters): ";
    private static final String CHOOSE_ROLE_MESSAGE = "Please choose your role Customer(1) or Admin(2): ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(WELCOME_MESSAGE);
        User user = getUserFromUserInput(scanner);
        String userLoginInput = getLoginFromUserInput(scanner);
        if (userLoginInput.equals("exit")) {
            return;
        }
        user.setLogin(userLoginInput);
        Menu menu = createMenu(user);
        Admin admin = (Admin) user;
        handlingUserInputInAdminMenu(admin, menu,scanner);


    }

    private static User getUserFromUserInput(Scanner scanner) {
        boolean validInput = false;
        while (!validInput) {
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
        throw new RuntimeException("Unknown exception");
    }


    private static String getLoginFromUserInput(Scanner scanner) {
        boolean validInput = false;
        while (!validInput) {
            System.out.print(WRITE_YOUR_LOGIN_MESSAGE);
            String userLoginInput = scanner.next();
            if (userLoginInput.equals("3") || userLoginInput.equalsIgnoreCase("exit")) {
                return "exit";
            }
            if (userLoginInput.length() >= 5) {
                return userLoginInput;
            } else {
                System.out.println("Invalid role input, please try again.");
            }
        }
        throw new RuntimeException("Unknown Exception");
    }

    private static Menu createMenu(User userRole) {
        if (userRole instanceof Admin) {
            return new AdminMenu();
        } else {
            return new CustomerMenu();
        }
    }

    private static CoworkingSpace createCoworkingSpaceUsingUserInput(Scanner scanner) {
        CoworkingSpace coworkingSpace = new CoworkingSpace();
        System.out.println("Enter information about Coworking Space");
        coworkingSpace.setName(getValidatedNameOfCoworkingFromUser(scanner));
        coworkingSpace.setTypeOfWorkspaces(getValidatedTypeOfWorkspaceUserInput(scanner));
        coworkingSpace.setPriceInDollars(getValidatedPriceOfCoworkingFromUser(scanner));
        coworkingSpace.setAvailabilityStatus(getValidatedAvailableStatusOfCoworkingFromUser(scanner));
        return coworkingSpace;
    }

    private static TypeOfWorkspaces getValidatedTypeOfWorkspaceUserInput(Scanner scanner) {
        boolean invalidTypeOfWorkspaceInput = true;
        TypeOfWorkspaces typeOfWorkspaces = null;
        while(invalidTypeOfWorkspaceInput) {
            System.out.print("Type of coworking (private/open space/room/meeting room) : ");
            try {
                typeOfWorkspaces = TypeOfWorkspaces.getTypeOfWorkspaceFromUserInput(scanner);
                invalidTypeOfWorkspaceInput = false;
            } catch (RuntimeException e) {
                System.out.println("Invalid input, private/open space/room/meeting room ");
            }
        }
        return typeOfWorkspaces;
    }

    private static String getValidatedNameOfCoworkingFromUser(Scanner scanner) {
        boolean invalidNameOfCoworkingSpaceInput = true;
        String str = null;
        while(invalidNameOfCoworkingSpaceInput) {
            System.out.print("Name: ");
            if(scanner.hasNext()) {
                str = scanner.next();
                invalidNameOfCoworkingSpaceInput = false;
                scanner.nextLine(); // clearing the buffer
            }else {
                System.out.println("Invalid input please try again");
            }

        }
        return str;
    }

    private static Integer getValidatedPriceOfCoworkingFromUser(Scanner scanner) {
        boolean invalidPriceOfCoworkingSpaceInput = true;
        Integer price = null;
        while(invalidPriceOfCoworkingSpaceInput) {
            System.out.print("Price in dollars: ");
            if(scanner.hasNextInt()) {
                price = scanner.nextInt();
                invalidPriceOfCoworkingSpaceInput = false;
                scanner.nextLine(); // clearing the buffer
            }else {
                System.out.println("Invalid input please try again");
            }

        }
        return price;
    }

    private static Boolean getValidatedAvailableStatusOfCoworkingFromUser(Scanner scanner) {
        boolean invalidAvailableStatusOfCoworkingSpaceInput = true;
        Boolean availableStatus = null;
        while(invalidAvailableStatusOfCoworkingSpaceInput) {
            System.out.print("Available status (false - not available/ true - available): ");
            if(scanner.hasNextBoolean()) {
                availableStatus = scanner.nextBoolean();
                invalidAvailableStatusOfCoworkingSpaceInput = false;
                scanner.nextLine(); // clearing the buffer
            }else {
                System.out.println("Invalid input please try again (false/ true)");
            }

        }
        return availableStatus;
    }

    private static Integer getValidatedIdOfCoworkingToDeleteFromUser(Scanner scanner) {
        boolean invalidIdUserInput = true;
        Integer id = null;
        while(invalidIdUserInput) {
            try {
                System.out.print("Enter an id of coworking space you want to delete: ");
                if (scanner.hasNextInt()) {
                    id = scanner.nextInt();
                    invalidIdUserInput = false;
                    scanner.nextLine(); // clearing the buffer
                } else {
                    System.out.println("Invalid input please try again");
                }
            }catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        return id;
    }

    private static void removingCoworkingSpaceValidated(Admin admin, Scanner scanner) {
        boolean existOfCoworkingSpace = false;
        while(!existOfCoworkingSpace) {
            existOfCoworkingSpace = admin.removeCoworkingSpace(getValidatedIdOfCoworkingToDeleteFromUser(scanner));
            if(!existOfCoworkingSpace){
                System.out.println("Coworking Space with this id does not exist");
            }
        }
    }

    private static void handlingUserInputInAdminMenu(Admin admin, Menu menu, Scanner scanner) {
        while (true) {
            menu.showMenu();
            switch (scanner.nextInt()) {
                case 1:
                    admin.addCoworkingSpace(createCoworkingSpaceUsingUserInput(scanner));
                    break;
                case 2:
                    WorkspaceManagement.displayAllCoworkingSpaces();
                    removingCoworkingSpaceValidated(admin, scanner);
                    break;
                case 3:
                    WorkspaceManagement.displayAllCoworkingSpaces();
                    admin.updateAllInformationAboutCoworkingSpace(getValidatedIdOfCoworkingToDeleteFromUser(scanner), createCoworkingSpaceUsingUserInput(scanner));
                    break;
                case 4:
                    BookingManagement.displayAllBookings();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Incorrect input");
                    break;

            }
        }
    }

}