import java.util.Date;

public class Booking {
    private Integer id;
    private String customerName;

    private String startAndEndOfBookingTime;

    private Date date;


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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }
}
