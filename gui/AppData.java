
package gui;

import java.util.LinkedHashMap;
import java.util.Map;

import model.Student;
import allocation.SeatAllocator;

public class AppData {

    public static Map<Integer, Student> students =
            new LinkedHashMap<>();

    public static SeatAllocator allocator =
            new SeatAllocator(50);

    public static final String ADMIN_USERNAME = "admin";
    public static final String ADMIN_PASSWORD = "admin";
}
