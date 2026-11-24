
package model;

public class Student {

    private int rollNo;
    private String name;
    private String department;
    private String password;
    private String seatNo;

    public Student(int rollNo, String name,
                   String department, String password) {

        this.rollNo = rollNo;
        this.name = name;
        this.department = department;
        this.password = password;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getPassword() {
        return password;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }
}

