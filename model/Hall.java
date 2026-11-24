
package model;

public class Hall {

    private int hallId;
    private int capacity;

    public Hall(int hallId, int capacity) {
        this.hallId = hallId;
        this.capacity = capacity;
    }

    public int getHallId() {
        return hallId;
    }

    public int getCapacity() {
        return capacity;
    }
}
