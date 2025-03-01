import java.util.Scanner;

public enum TypeOfWorkspaces {
    OPEN_SPACE,
    PRIVATE,
    ROOM,
    MEETING_ROOM;


    public static TypeOfWorkspaces getTypeOfWorkspaceFromUserInput(Scanner scanner) throws RuntimeException{
        return switch (scanner.nextLine().toLowerCase()) {
            case "private" -> TypeOfWorkspaces.PRIVATE;
            case "open space" -> TypeOfWorkspaces.OPEN_SPACE;
            case "room" -> TypeOfWorkspaces.ROOM;
            case "meeting room" -> TypeOfWorkspaces.MEETING_ROOM;
            default -> throw new RuntimeException();
        };
    }

}
