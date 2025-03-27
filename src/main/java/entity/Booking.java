package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import util.DBUtils;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@Entity
public class Booking implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column()
    private String customerName;

    @Column
    private String startAndEndOfBookingTime;

    @Column
    private LocalDate date;

    @Column()
    private Integer idOfCoworkingSpace;


    public Booking(String customerName, String timeInterval, LocalDate date, int coworkingSpaceId) { //TODO
    }
}
