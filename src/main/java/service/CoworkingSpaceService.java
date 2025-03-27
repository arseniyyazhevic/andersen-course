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

    public CoworkingSpaceService() {
        loadCoworkingSpacesFromFile("src/main/resources/data/coworkingSpaces.bin");
    }

    public Optional<CoworkingSpace> getCoworkingSpaceById(int id) {
       return Optional.ofNullable(CoworkingSpaceDBUtils.getCoworkingSpace(id));
    }

    public void addCoworkingSpace(CoworkingSpace coworkingSpace) {
        CoworkingSpaceDBUtils.createCoworkingSpace(coworkingSpace);
    }

    public void updateAllInformationAboutCoworkingSpace(int id, CoworkingSpace coworkingSpace) {
        CoworkingSpaceDBUtils.updateCoworkingSpace(id, coworkingSpace);
    }

    public void removeCoworkingSpace(int id) {
        CoworkingSpaceDBUtils.deleteCoworkingSpace(id);
    }

    public static void displayAllCoworkingSpaces() {
//        ConsoleOutput.println("List of Coworking Spaces: ");
//        SortingUtil.sortById(allCoworkingSpaces).forEach((key, value) -> System.out.println(value));
        CoworkingSpaceDBUtils.readCoworkingSpaces();
    }

    public HashMap<Long, CoworkingSpace>  loadCoworkingSpacesFromDB() {
        return DBUtils.loadCoworkingSpacesFromDB().orElse(new HashMap<>());
    }

}

