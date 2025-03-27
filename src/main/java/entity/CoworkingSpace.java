package entity;

import enums.TypeOfWorkspaces;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import util.DBUtils;

import java.io.Serial;
import java.io.Serializable;
@Data
@NoArgsConstructor
@Entity
public class CoworkingSpace implements Serializable {

    private static Integer nextId = DBUtils.getMaxIdFromCoworkingSpaces() + 1;

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private TypeOfWorkspaces typeOfWorkspaces;

    @Column
    private Integer priceInDollars;

    @Column
    private boolean availabilityStatus;


    public CoworkingSpace(String name, TypeOfWorkspaces typeOfWorkspace, int priceDollars, boolean availabilityStatus) { //TODO
    }
}
