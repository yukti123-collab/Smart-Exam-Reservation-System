
package allocation;

import model.Student;
import model.Seat;
import java.util.ArrayList;

public class SeatAllocator {

    private ArrayList<Seat> seats = new ArrayList<>();

    // Create examination seats
    public SeatAllocator(int totalSeats) {

        if (totalSeats < 0) {
            throw new IllegalArgumentException(
                "Total seats cannot be negative"
            );
        }

        for (int i = 1; i <= totalSeats; i++) {
            seats.add(new Seat("A" + i));
        }
    }

    // Allocate seat
    public synchronized String allocateSeat(Student student) {

        if (student.getSeatNo() != null) {
            return student.getSeatNo();
        }

        for (Seat seat : seats) {

            if (!seat.isBooked()) {

                seat.setBooked(true);
                student.setSeatNo(seat.getSeatNo());

                return seat.getSeatNo();
            }
        }

        return "No Seat Available";
    }

    // Cancel reservation
    public synchronized boolean releaseSeat(Student student) {

        String seatNo = student.getSeatNo();

        if (seatNo == null) {
            return false;
        }

        for (Seat seat : seats) {

            if (seat.getSeatNo().equals(seatNo)) {

                seat.setBooked(false);
                student.setSeatNo(null);

                return true;
            }
        }

        return false;
    }

    // Total seats
    public synchronized int getTotalSeats() {
        return seats.size();
    }

    // Booked seats
    public synchronized int getBookedCount() {

        int count = 0;

        for (Seat seat : seats) {
            if (seat.isBooked()) {
                count++;
            }
        }

        return count;
    }

    // Available seats
    public synchronized int getAvailableCount() {
        return seats.size() - getBookedCount();
    }
}
