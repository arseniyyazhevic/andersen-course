public class AdminMenu extends Menu{
    private static final String ADMIN_MENU_CONTEXT= "Add a new coworking space(1)/ Remove a coworking space(2)/ Update Coworking Space(3)/ View all reservations(4): ";
    @Override

    public void showMenu() {
        System.out.print(ADMIN_MENU_CONTEXT);
    }
}
