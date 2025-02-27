public class Admin extends User {

    public void addCoworkingSpace(CoworkingSpace coworkingSpace) {
        WorkspaceManagement.allCoworkingSpaces.add(coworkingSpace);
    }

    public void removeCoworkingSpace(int id) {
       WorkspaceManagement.allCoworkingSpaces.remove(WorkspaceManagement.getCoworkingSpaceById(id));
    }


    public void updateAllInformationAboutCoworkingSpace(int id, CoworkingSpace coworkingSpace) {
        removeCoworkingSpace(id);
        addCoworkingSpace(coworkingSpace);
    }

    public void viewAllReservations() {
        BookingManagement.displayAllBookings();
    }

}
