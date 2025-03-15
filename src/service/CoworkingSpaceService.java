package service;

import entity.Booking;
import entity.CoworkingSpace;
import ui.ConsoleOutput;
import util.FileUtils;
import util.SortingUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CoworkingSpaceService {
    public static HashMap<Integer, CoworkingSpace> allCoworkingSpaces;

    public CoworkingSpaceService() {
    }

    public static Optional<CoworkingSpace> getCoworkingSpaceById(int id) {
       return Optional.ofNullable(allCoworkingSpaces.get(id));
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
        SortingUtil.sortById(allCoworkingSpaces).forEach((key, value) -> System.out.println(value));
    }

    public void saveAllCoworkingSpacesToFile(String fileName) {
        FileUtils.saveCoworkingSpacesToFile(fileName, allCoworkingSpaces);
    }

    public void loadCoworkingSpacesFromFile(String fileName) {
        allCoworkingSpaces = FileUtils.loadCoworkingSpacesFromFile(fileName).orElse(new HashMap<>());

    }

}

