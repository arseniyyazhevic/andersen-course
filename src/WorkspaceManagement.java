import java.util.HashSet;
import java.util.Iterator;


public class WorkspaceManagement {
    public static HashSet<CoworkingSpace> allCoworkingSpaces;


    public static CoworkingSpace getCoworkingSpaceById(int id) {
        for (CoworkingSpace coworkingSpace : allCoworkingSpaces) {
            if(coworkingSpace.getId() == id){
                return coworkingSpace;
            }
        }
        throw new RuntimeException("Coworking space with that id does not exist");
    }

    public static void displayAllCoworkingSpaces() {
        for (CoworkingSpace coworkingSpace: allCoworkingSpaces) {
            System.out.println(coworkingSpace);
        }
    }

}
