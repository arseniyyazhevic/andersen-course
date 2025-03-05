package validation;

import enums.TypeOfWorkspaces;
import exception.ValidationException;
import service.CoworkingSpaceService;
import ui.ConsoleOutput;


public class CoworkingSpaceValidator extends Validator{
    public  Integer validatePriceOfCoworkingFromUser(int price) throws ValidationException {
            if (price > 10) {
                return price;
            } else {
                throw new ValidationException("(more than 10 dollars)");
            }
    }

    public  TypeOfWorkspaces validateTypeOfWorkspaceUserInput(String typeOfWorkSpace) throws ValidationException {
        TypeOfWorkspaces typeOfWorkspaces = null;
            try {
                typeOfWorkspaces = TypeOfWorkspaces.getTypeOfWorkspaceFromUserInput(typeOfWorkSpace);
                return typeOfWorkspaces;
            } catch (RuntimeException e) {
                throw new ValidationException("private/open space/room/meeting room ");
            }

    }

    public Boolean validateAvailableStatus(String availableStatus) throws ValidationException {
            if(availableStatus.equals("true")) {
                return true;
            }else if(availableStatus.equals("false")) {
                return false;
            } else {
                throw new ValidationException("(false/ true)");
            }
    }

    public static void removingCoworkingSpaceValidated(CoworkingSpaceService coworkingSpaceService, int id) { //TODO
        boolean existOfCoworkingSpace = false;
        CoworkingSpaceService.displayAllCoworkingSpaces();
        while (!existOfCoworkingSpace) {
            existOfCoworkingSpace = coworkingSpaceService.removeCoworkingSpace(id);
            if (!existOfCoworkingSpace) {
                ConsoleOutput.printInvalidInput(", coworking Space with this id does not exist");
            }
        }
    }

}
