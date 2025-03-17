package validation;

import entity.CoworkingSpace;
import enums.TypeOfWorkspaces;
import exception.ValidationException;
import service.CoworkingSpaceService;
import ui.ConsoleOutput;


public class CoworkingSpaceValidator extends Validator {
    public Integer validatePriceOfCoworkingFromUser(int price) throws ValidationException {
        if (price > 10) {
            return price;
        } else {
            throw new ValidationException("(more than 10 dollars)");
        }
    }

    public TypeOfWorkspaces validateTypeOfWorkspaceUserInput(String typeOfWorkSpace) throws ValidationException {
        TypeOfWorkspaces typeOfWorkspaces = null;
        try {
            typeOfWorkspaces = TypeOfWorkspaces.getTypeOfWorkspaceFromUserInput(typeOfWorkSpace);
            return typeOfWorkspaces;
        } catch (RuntimeException e) {
            throw new ValidationException("private/open space/room/meeting room ");
        }

    }

    public Boolean validateAvailableStatus(String availableStatus) throws ValidationException {
        if (availableStatus.equals("true")) {
            return true;
        } else if (availableStatus.equals("false")) {
            return false;
        } else {
            throw new ValidationException("(false/ true)");
        }
    }

    public int validateIdCoworkingSpace(int id) throws ValidationException {
        CoworkingSpaceService.getCoworkingSpaceById(id).orElseThrow(() -> new ValidationException(", coworking space with this id does not exist"));
        return id;
    }
}
