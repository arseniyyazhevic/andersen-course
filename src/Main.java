import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Coworking Space Reservation App – Your Gateway to Productive Workspaces!");
        String userRoleInput = validateAndGetUserRoleInput(scanner);
        System.out.println(userRoleInput);
        UserRole userRole;
        if(userRoleInput.equals("admin")) {
            userRole = new Admin();
            userRole.setLogin(scanner.nextLine());
        }else{
            userRole = new Customer();
            userRole.setLogin(scanner.nextLine());
        }

    }

    private static String validateAndGetUserRoleInput(Scanner scanner) {
        boolean validInput = false;
        while(!validInput) {
            System.out.print("Please choose your role Customer(1) or Admin(2): ");
            try {
                if (scanner.hasNextLine()) {
                    String userInput = scanner.next();
                    if (userInput.equalsIgnoreCase("customer") || userInput.equals("1")) {
                        validInput = true;
                        return "customer";
                    } else if (userInput.equalsIgnoreCase("admin") || userInput.equals("2")) {
                        validInput = true;
                        return "admin";
                    } else {
                        System.out.println("Invalid role input, please try again.");
                    }
                }
            }catch (InputMismatchException e) {
                System.out.println("Invalid role input, please try again. You need to write: customer/admin/1/2");
                scanner.next();
            }
        }
        throw new RuntimeException("Unknown Exception");
    }
}