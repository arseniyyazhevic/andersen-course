public class CustomerMenu extends Menu{

    private static final String CUSTOMER_MENU_CONTEXT= "Browse available spaces(1)/ View my reservation(2)/ Cancel my reservation(3): ";
    @Override
    public void showMenu() {
        System.out.print(CUSTOMER_MENU_CONTEXT);
    }
}
