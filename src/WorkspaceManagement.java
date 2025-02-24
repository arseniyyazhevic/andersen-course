public class WorkspaceManagement {
    private Integer id;
    private TypeOfWorkspaces typeOfWorkspaces;
    private Integer price;

    private boolean availabilityStatus;


    public void setId(Integer id) {
        this.id = id;
    }

    public TypeOfWorkspaces getTypeOfWorkspaces() {
        return typeOfWorkspaces;
    }

    public void setTypeOfWorkspaces(TypeOfWorkspaces typeOfWorkspaces) {
        this.typeOfWorkspaces = typeOfWorkspaces;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public boolean isAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(boolean availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }
}
