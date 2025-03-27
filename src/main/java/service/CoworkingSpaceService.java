package service;

import entity.CoworkingSpace;
import ui.ConsoleOutput;
import util.FileUtils;
import util.sortingUtils.SortingUtil;

import java.util.HashMap;
import java.util.Optional;

public class CoworkingSpaceService {
    public static final String fileOfCoworkingSpacesPath = "src/main/resources/data/bookings.bin";

    public static HashMap<Integer, CoworkingSpace> allCoworkingSpaces = new HashMap<>();


    public CoworkingSpaceService() {
        loadCoworkingSpacesFromFile("src/main/resources/data/coworkingSpaces.bin");
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

