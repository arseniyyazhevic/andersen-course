import java.util.HashSet;
import java.util.Iterator;


public class WorkspaceManagement {
    public static HashSet<CoworkingSpace> allCoworkingSpaces = new HashSet<>();


    public static CoworkingSpace getCoworkingSpaceById(int id){
            for (CoworkingSpace coworkingSpace : allCoworkingSpaces) {
                if (coworkingSpace.getId() == id) {
                    return coworkingSpace;
                }
            }
            return null;
    }

    public static void displayAllCoworkingSpaces() {
        System.out.println("List of Coworking Spaces: ");
        int i = 1;
        for (CoworkingSpace coworkingSpace: allCoworkingSpaces) {
            System.out.println(i +". " + coworkingSpace);
            i++;
        }
    }

}
