import java.util.Scanner;

public class Main {

    private static final String WELCOME_MESSAGE = "Welcome to Coworking Space Reservation App – Your Gateway to Productive Workspaces!";
    private static final String WRITE_YOUR_LOGIN_MESSAGE = "If you want to Exit enter 3 or write down your login (more than five characters): ";
    private static final String CHOOSE_ROLE_MESSAGE = "Please choose your role Customer(1) or Admin(2): ";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(WELCOME_MESSAGE);
        User user = getUserFromUserInput(scanner);
        String userLoginInput = getLoginFromUserInput(scanner);
        if(userLoginInput.equals("exit")) {
            return;
        }
        user.setLogin(userLoginInput);
        Menu menu = createMenu(user);
        menu.showMenu();
        Admin admin = (Admin)user;
        switch(scanner.nextInt()) {
            case 1:
                CoworkingSpace coworkingSpace = new CoworkingSpace();
                System.out.print("Enter infromation about Coworking Space\n" +
                "Name: ");
                coworkingSpace.setName(scanner.next());
                System.out.println("Type of coworking: ");
                TypeOfWorkspaces typeOfWorkspaces = null;
                switch (scanner.next().toLowerCase()){
                    case "private":
                        typeOfWorkspaces = TypeOfWorkspaces.PRIVATE;
                }
                coworkingSpace.setTypeOfWorkspaces(typeOfWorkspaces);
                System.out.print("Price in dollars: ");
                coworkingSpace.setPriceInDollars(scanner.nextInt());
                System.out.print("Available status( false - not available/ true - available): ");
                coworkingSpace.setAvailabilityStatus(Boolean.getBoolean(scanner.next()));
                admin.addCoworkingSpace(coworkingSpace);
                break;
            case 2:
                System.out.print("Enter an id of coworking space you want to delete: ");
                admin.removeCoworkingSpace(scanner.nextInt());
                break;
            case 3:
                admin.viewAllReservations();
                break;
            case 4:
                break;
            default:
                break;

        }



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
        while(!validInput) {
            System.out.print(WRITE_YOUR_LOGIN_MESSAGE);
            String userLoginInput = scanner.next();
            if(userLoginInput.equals("3") || userLoginInput.equalsIgnoreCase("exit")) {
                return "exit";
            }
            if (userLoginInput.length() >= 5) {
                return userLoginInput;
            }else{
                System.out.println("Invalid role input, please try again.");
            }
        }
        throw new RuntimeException("Unknown Exception");
    }

    private static Menu createMenu(User userRole) {
        if (userRole instanceof Admin) {
            return new AdminMenu();
        }else {
            return new CustomerMenu();
        }
    }
}