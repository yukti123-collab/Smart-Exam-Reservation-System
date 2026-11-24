
package model;

public class Seat {

    private String seatNo;
    private boolean booked;

    public Seat(String seatNo) {
        this.seatNo = seatNo;
        this.booked = false;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }
}
