package service;

import entity.CoworkingSpace;
import enums.TypeOfWorkspaces;
import ui.ConsoleInput;
import ui.ConsoleOutput;
import validation.CoworkingSpaceValidator;

import java.util.HashSet;
import java.util.Scanner;

public class CoworkingSpaceService {
    public static HashSet<CoworkingSpace> allCoworkingSpaces = new HashSet<>();

    public CoworkingSpaceService() {
    }

    public static CoworkingSpace getCoworkingSpaceById(int id) {
        for (CoworkingSpace coworkingSpace : allCoworkingSpaces) {
            if (coworkingSpace.getId() == id) {
                return coworkingSpace;
            }
        }
        return null;
    }

    public void addCoworkingSpace(CoworkingSpace coworkingSpace) {
        CoworkingSpaceService.allCoworkingSpaces.add(coworkingSpace);
    }

    public void updateAllInformationAboutCoworkingSpace(int id, CoworkingSpace coworkingSpace) {
        displayAllCoworkingSpaces();
        removeCoworkingSpace(id);
        addCoworkingSpace(coworkingSpace);
    }

    public boolean removeCoworkingSpace(int id) {
        CoworkingSpace coworkingSpace = getCoworkingSpaceById(id);
        if (coworkingSpace == null) {
            return false;
        } else {
            CoworkingSpaceService.allCoworkingSpaces.remove(coworkingSpace);
            return true;
        }
    }

    public static void displayAllCoworkingSpaces() {
        ConsoleOutput.println("List of Coworking Spaces: ");
        int i = 1;
        for (CoworkingSpace coworkingSpace : allCoworkingSpaces) {
            System.out.println(i + ". " + coworkingSpace);
            i++;
        }
    }

}

