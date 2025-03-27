package entity;

import jakarta.persistence.*;
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
@Table(name = "bookings")
public class Booking implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "time_interval")
    private String startAndEndOfBookingTime;

    @Column(name = "booking_date")
    private LocalDate date;

    @Column(name = "coworking_space_id")
    private Long idOfCoworkingSpace;


    public Booking(String customerName, String timeInterval, LocalDate date, int coworkingSpaceId) { //TODO
    }
}
