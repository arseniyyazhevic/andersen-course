package entity.menus;

import entity.menus.Menu;

public class CustomerMenu extends Menu {

    private static final String CUSTOMER_MENU_CONTEXT = "Browse available spaces(1)/ Make reservation(2)/ Cancel my reservations(3)/ View my reservation(4)/ Exit(5): ";

    @Override
    public void showMenu() {
        System.out.print(CUSTOMER_MENU_CONTEXT);
    }
}
