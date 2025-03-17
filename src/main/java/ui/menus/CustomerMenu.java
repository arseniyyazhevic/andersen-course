package ui.menus;

import ui.ConsoleOutput;

public class CustomerMenu extends Menu {

    private static final String CUSTOMER_MENU_CONTEXT = "Browse available spaces(1)/ Make reservation(2)/ Cancel my reservations(3)/ View my reservation(4)/ Exit(5): ";

    @Override
    public void showMenu() {
        ConsoleOutput.print(CUSTOMER_MENU_CONTEXT);
    }
}
