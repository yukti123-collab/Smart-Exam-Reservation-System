
package allocation;

import model.Student;

public class AllocationThread extends Thread {

    private Student student;
    private SeatAllocator allocator;

    public AllocationThread(Student student,
                            SeatAllocator allocator) {

        this.student = student;
        this.allocator = allocator;
    }

    @Override
    public void run() {

        String seat = allocator.allocateSeat(student);

        System.out.println(
            student.getName() + " received seat: " + seat
        );
    }
}
