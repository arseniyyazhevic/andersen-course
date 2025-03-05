package service;

import entity.roles.Admin;
import entity.roles.Customer;
import entity.roles.User;
import ui.ConsoleInput;
import validation.UserValidator;

public class UserService {
    public User createUser(User userRole) {
        if (userRole instanceof Admin) {
            return new Admin();
        } else {
            return new Customer();
        }
    }

    public  User getUserAndSetLogin(ConsoleInput consoleInput) {
        User user = UserValidator.getUserFromUserInput(consoleInput.getString(("Please choose your role Customer(1) or Admin(2): ")));
        String userLoginInput = UserValidator.getLoginFromUserInput(consoleInput.getString(("If you want to Exit enter 3 or write down your login (five and more characters): ")));
        if (userLoginInput.equals("exit")) {
            return null;
        }
        user.setLogin(userLoginInput);
        return user;
    }
}
