package util;

import entity.Booking;
import entity.CoworkingSpace;
import ui.ConsoleOutput;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class FileUtils {
    public static void saveBookingsToFile(String fileName, HashSet<Booking> allBookings) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(allBookings);
        } catch (IOException e) {
            ConsoleOutput.println(e.getMessage());
        }
    }

    public static void saveCoworkingSpacesToFile(String fileName, HashSet<CoworkingSpace> coworkingSpaces) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(coworkingSpaces);
        } catch (IOException e) {
            ConsoleOutput.println(e.getMessage());
        }
    }

    public static HashSet<CoworkingSpace> loadCoworkingSpacesFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (HashSet<CoworkingSpace>) ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            ConsoleOutput.println(e.getMessage());
        }
        return new HashSet<>();
    }

    public static HashSet<Booking> loadBookingsFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (HashSet<Booking>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            ConsoleOutput.println(e.getMessage());
        }
        return new HashSet<>();
    }

}
