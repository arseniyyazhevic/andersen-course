package service;

import entity.CoworkingSpace;
import ui.ConsoleOutput;
import util.CoworkingSpaceDBUtils;
import util.DBUtils;
import util.FileUtils;
import util.sortingUtils.SortingUtil;

import java.util.HashMap;
import java.util.Optional;

public class CoworkingSpaceService {
    public static HashMap<Integer, CoworkingSpace> allCoworkingSpaces;

    public CoworkingSpaceService() {
    }

    public Optional<CoworkingSpace> getCoworkingSpaceById(int id) {
       return Optional.ofNullable(CoworkingSpaceDBUtils.getCoworkingSpace(id));
    }

    public void addCoworkingSpace(CoworkingSpace coworkingSpace) {
        allCoworkingSpaces.put(coworkingSpace.getId(), coworkingSpace);
        CoworkingSpaceDBUtils.createCoworkingSpace(coworkingSpace);
    }

    public void updateAllInformationAboutCoworkingSpace(int id, CoworkingSpace coworkingSpace) {
        allCoworkingSpaces.put(id, coworkingSpace);
        CoworkingSpaceDBUtils.updateCoworkingSpace(id, coworkingSpace);
    }

    public void removeCoworkingSpace(int id) {
        allCoworkingSpaces.remove(id);
        CoworkingSpaceDBUtils.deleteCoworkingSpace(id);
    }

    public static void displayAllCoworkingSpaces() {
//        ConsoleOutput.println("List of Coworking Spaces: ");
//        SortingUtil.sortById(allCoworkingSpaces).forEach((key, value) -> System.out.println(value));
        CoworkingSpaceDBUtils.readCoworkingSpaces();
    }

    public void saveAllCoworkingSpacesToFile(String fileName) {
        FileUtils.saveCoworkingSpacesToFile(fileName, allCoworkingSpaces);
    }

    public void loadCoworkingSpacesFromDB(String fileName) {
        allCoworkingSpaces = FileUtils.loadCoworkingSpacesFromFile(fileName).orElse(new HashMap<>());
    }

    public void loadCoworkingSpacesFromDB() {
        allCoworkingSpaces = DBUtils.loadCoworkingSpacesFromDB().orElse(new HashMap<>());
    }

}

