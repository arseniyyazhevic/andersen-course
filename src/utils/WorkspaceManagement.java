package utils;

import entity.CoworkingSpace;

import java.util.HashSet;


public class WorkspaceManagement {
    public static HashSet<CoworkingSpace> allCoworkingSpaces = new HashSet<>();


    public static CoworkingSpace getCoworkingSpaceById(int id) {
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
        for (CoworkingSpace coworkingSpace : allCoworkingSpaces) {
            System.out.println(i + ". " + coworkingSpace);
            i++;
        }
    }

}
