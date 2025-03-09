package service;

import entity.Booking;
import entity.CoworkingSpace;
import ui.ConsoleOutput;
import util.FileUtils;

import java.util.HashMap;
import java.util.Map;

public class CoworkingSpaceService {
    public static HashMap<Integer, CoworkingSpace> allCoworkingSpaces;

    public CoworkingSpaceService() {
    }

    public static CoworkingSpace getCoworkingSpaceById(int id) {
       return allCoworkingSpaces.get(id);
    }

    public void addCoworkingSpace(CoworkingSpace coworkingSpace) {
        allCoworkingSpaces.put(coworkingSpace.getId(), coworkingSpace);
    }

    public void updateAllInformationAboutCoworkingSpace(int id, CoworkingSpace coworkingSpace) {
        allCoworkingSpaces.put(id, coworkingSpace);
    }

    public void removeCoworkingSpace(int id) {
        allCoworkingSpaces.remove(id);
    }

    public static void displayAllCoworkingSpaces() {
        ConsoleOutput.println("List of Coworking Spaces: ");
        int i = 1;
        for (Map.Entry<Integer, CoworkingSpace> entry : allCoworkingSpaces.entrySet()) {
            System.out.println(i + ". " + entry.getValue());
        }
    }

    public void saveAllCoworkingSpacesToFile(String fileName) {
        FileUtils.saveCoworkingSpacesToFile(fileName, allCoworkingSpaces);
    }

    public void loadCoworkingSpacesFromFile(String fileName) {
        HashMap<Integer, CoworkingSpace> input = FileUtils.loadCoworkingSpacesFromFile(fileName);
//        for(var entry : input.entrySet()) {
//            System.out.println(entry.getValue() + " " + entry.getKey());
//        }
        if(input != null) {
            allCoworkingSpaces =  input;
        }
    }

}

