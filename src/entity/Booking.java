package entity;

import service.CoworkingSpaceService;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class Booking implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private static Integer nextId = 1;
    private final Integer id;
    private String customerName;
    private String startAndEndOfBookingTime;

    private LocalDate date;

    private Integer idOfCoworkingSpace;

    public Booking(String customerName, String startAndEndOfBookingTime, LocalDate date, Integer idOfCoworkingSpace) {
        this.customerName = customerName;
        this.startAndEndOfBookingTime = startAndEndOfBookingTime;
        this.date = date;
        this.idOfCoworkingSpace = idOfCoworkingSpace;
        this.id = nextId++;
    }

    public Booking() {
        this.id = nextId++;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getStartAndEndOfBookingTime() {
        return startAndEndOfBookingTime;
    }

    public void setStartAndEndOfBookingTime(String startAndEndOfBookingTime) {
        this.startAndEndOfBookingTime = startAndEndOfBookingTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdOfCoworkingSpace() {
        return idOfCoworkingSpace;
    }

    public void setIdOfCoworkingSpace(Integer idOfCoworkingSpace) {
        this.idOfCoworkingSpace = idOfCoworkingSpace;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ". " + customerName +
                ", typeOfWorkspaces=" + date +
                ", price=" + startAndEndOfBookingTime +
                ", idOfCoworkingSpace=" + idOfCoworkingSpace +
                ", nameOfCoworkingSpace=" + CoworkingSpaceService.getCoworkingSpaceById(idOfCoworkingSpace).orElseThrow().getName();
    }
}
