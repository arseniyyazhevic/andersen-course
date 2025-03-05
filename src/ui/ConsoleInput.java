package ui;

import enums.TypeOfWorkspaces;
import exception.ValidationException;
import validation.BookingValidator;
import validation.CoworkingSpaceValidator;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleInput {
    private final Scanner scanner = new Scanner(System.in);
    private final BookingValidator bookingValidator = new BookingValidator();
    private final CoworkingSpaceValidator coworkingSpaceValidator = new CoworkingSpaceValidator();


    public String getString(String prompt) {
        ConsoleOutput.print(prompt);
        String str = scanner.next();
        scanner.nextLine();
        return str;
    }

    public int getInt(String prompt) {
        ConsoleOutput.print(prompt);
        while (!scanner.hasNextInt()) {
            ConsoleOutput.print("Please enter a number: ");
            scanner.next();
        }
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    public String getLine(String prompt) {
        ConsoleOutput.print(prompt);
        return scanner.nextLine();
    }

    public TypeOfWorkspaces getTypeOfCoworkingSpace(String prompt) {
        while (true) {
            String strTypeOfWorkspaces = (getLine(prompt));
            try {
                TypeOfWorkspaces typeOfWorkspaces = coworkingSpaceValidator.validateTypeOfWorkspaceUserInput(strTypeOfWorkspaces);
                return typeOfWorkspaces;
            } catch (ValidationException e) {
                ConsoleOutput.println(e.getMessage());
            }
        }
    }

    public int getPrice(String prompt) {
        while (true) {
            int price = getInt(prompt);
            try {
                coworkingSpaceValidator.validatePriceOfCoworkingFromUser(price);
                return price;
            } catch (ValidationException e) {
                ConsoleOutput.println(e.getMessage());
            }
        }
    }

    public Boolean getAvailableStatus(String prompt) {
        while (true) {
            String strAvailableStatus = getString(prompt);
            try {
                Boolean availableStatus = coworkingSpaceValidator.validateAvailableStatus(strAvailableStatus);
                return availableStatus;
            } catch (ValidationException e) {
                ConsoleOutput.println(e.getMessage());
            }
        }
    }

    public LocalDate getDate(String prompt) {
        while (true) {
            String strLocalDate = getString(prompt);
            try {
                LocalDate localDate = bookingValidator.validateDate(strLocalDate); // TODO
                return localDate;
            } catch (ValidationException e) {
                ConsoleOutput.println(e.getMessage());
            }
        }
    }

    public String getStartAndEndOfBookingTime(String prompt) {
        while (true) {
            String startAndEndOfBookingTime = getString(prompt);
            try {
                String validatedstartAndEndOfBookingTime = bookingValidator.validateStartAndEndOfBookingTime(startAndEndOfBookingTime); // TODO
                return validatedstartAndEndOfBookingTime;
            } catch (ValidationException e) {
                ConsoleOutput.println(e.getMessage());
            }
        }
    }


    public int getId(String prompt) {
        while (true) {
            int id = getInt(prompt);
            try {
                coworkingSpaceValidator.validateId(id);
                return id;
            } catch (ValidationException e) {
                ConsoleOutput.println(e.getMessage());
            }
        }
    }

    public String getName(String prompt) {
        while (true) {
            String name = getString(prompt);
            try {
                bookingValidator.validateName(name);
                return name;
            } catch (ValidationException e) {
                ConsoleOutput.println(e.getMessage());
            }
        }
    }
}
