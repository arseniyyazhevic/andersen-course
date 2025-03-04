package validation;

import entity.roles.Admin;
import entity.roles.Customer;
import entity.roles.User;
import exception.ValidationException;
import ui.ConsoleInput;
import ui.ConsoleOutput;

import java.util.Scanner;

public class UserValidator {
    public static User getUserFromUserInput(String userInput) { // TODO
        while (true) {
            if (userInput != null) {
                if (userInput.equalsIgnoreCase("customer") || userInput.equals("1")) {
                    return new Customer();
                } else if (userInput.equalsIgnoreCase("admin") || userInput.equals("2")) {
                    return new Admin();
                } else {
                    ConsoleOutput.println("Invalid input");
                }
            }
        }
    }

    public static String getLoginFromUserInput(String userLoginInput) { // TODO
        while (true) {
            if (userLoginInput.equals("3") || userLoginInput.equalsIgnoreCase("exit")) {
                return "exit";
            }
            if (userLoginInput.length() >= 5) {
                return userLoginInput;
            } else {
                ConsoleOutput.println("Invalid input");
            }
        }
    }

}
