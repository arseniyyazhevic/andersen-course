package entity;

import enums.TypeOfWorkspaces;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import util.DBUtils;

import java.io.Serial;
import java.io.Serializable;
@Data
@NoArgsConstructor
@Entity
@Table(name = "coworking_spaces")
public class CoworkingSpace implements Serializable {

    private static Integer nextId = DBUtils.getMaxIdFromCoworkingSpaces() + 1;

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type_of_workspace")
    private TypeOfWorkspaces typeOfWorkspaces;

    @Column(name = "price_in_dollars")
    private Integer priceInDollars;

    @Column(name = "availability_status")
    private boolean availabilityStatus;


    public CoworkingSpace(String name, TypeOfWorkspaces typeOfWorkspace, int priceDollars, boolean availabilityStatus) { //TODO
    }
}
