package entity;

import enums.TypeOfWorkspaces;

import java.io.Serial;
import java.io.Serializable;

public class CoworkingSpace implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private static Integer nextId = 1;

    private final int id;

    private String name;
    private TypeOfWorkspaces typeOfWorkspaces;
    private Integer priceInDollars;

    private boolean availabilityStatus;


    public CoworkingSpace(String name, TypeOfWorkspaces typeOfWorkspaces, Integer priceInDollars, boolean availabilityStatus) {
        this.name = name;
        this.typeOfWorkspaces = typeOfWorkspaces;
        this.priceInDollars = priceInDollars;
        this.availabilityStatus = availabilityStatus;
        this.id = nextId++;
    }

    public CoworkingSpace() {
        this.id = nextId++;
    }

    public TypeOfWorkspaces getTypeOfWorkspaces() {
        return typeOfWorkspaces;
    }

    public void setTypeOfWorkspaces(TypeOfWorkspaces typeOfWorkspaces) {
        this.typeOfWorkspaces = typeOfWorkspaces;
    }

    public Integer getPriceInDollars() {
        return priceInDollars;
    }

    public void setPriceInDollars(Integer priceInDollars) {
        this.priceInDollars = priceInDollars;
    }

    public boolean isAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(boolean availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "(id)=" + id +
                ", " + name +
                ", typeOfWorkspaces=" + typeOfWorkspaces +
                ", price=" + priceInDollars +
                ", availabilityStatus=" + availabilityStatus;
    }
}
