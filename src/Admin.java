public class Admin extends User {

    public void addCoworkingSpace(CoworkingSpace coworkingSpace) {
        WorkspaceManagement.allCoworkingSpaces.add(coworkingSpace);
    }

    public boolean removeCoworkingSpace(int id){
       CoworkingSpace coworkingSpace = WorkspaceManagement.getCoworkingSpaceById(id);
       if(coworkingSpace == null) {
           return false;
       }else {
           WorkspaceManagement.allCoworkingSpaces.remove(coworkingSpace);
           return true;
       }
    }


    public void updateAllInformationAboutCoworkingSpace(int id, CoworkingSpace coworkingSpace) {
        removeCoworkingSpace(id);
        addCoworkingSpace(coworkingSpace);
    }

    public void viewAllReservations() {
        BookingManagement.displayAllBookings();
    }

}
