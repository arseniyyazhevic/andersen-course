import java.time.LocalDate;

public class Booking {
    private static Integer nextId;
    private final Integer id;
    private String customerName;

    private String startAndEndOfBookingTime;

    private LocalDate date;

    public Booking(String customerName, String startAndEndOfBookingTime, LocalDate date) {
        this.customerName = customerName;
        this.startAndEndOfBookingTime = startAndEndOfBookingTime;
        this.date = date;
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

    @Override
    public String toString() {
        return "id=" + id +
                ". " + customerName +
                ", typeOfWorkspaces=" + date +
                ", price=" + startAndEndOfBookingTime +
                '}';
    }
}
