
package gui;

import javax.swing.*;
import java.awt.*;
import model.Student;

public class StudentDashboard extends JFrame {

    private Student student;
    private JLabel seatLabel;

    public StudentDashboard(Student student) {

        this.student = student;

        setTitle("Student Dashboard");
        setSize(550, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel heading = new JLabel(
            "STUDENT DASHBOARD",
            SwingConstants.CENTER
        );

        heading.setFont(new Font("Arial", Font.BOLD, 23));

        JLabel details = new JLabel(
            "<html><center>Welcome, " + student.getName() +
            "<br>Roll Number: " + student.getRollNo() +
            "<br>Department: " + student.getDepartment() +
            "</center></html>",
            SwingConstants.CENTER
        );

        JButton bookButton =
            new JButton("Reserve Examination Seat");

        JButton checkButton =
            new JButton("Check My Seat");

        JButton cancelButton =
            new JButton("Cancel Reservation");

        JButton logoutButton = new JButton("Logout");

        seatLabel = new JLabel(
            "Seat: " + (student.getSeatNo() == null
                ? "Not Allocated" : student.getSeatNo()),
            SwingConstants.CENTER
        );

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));

        panel.setBorder(
            BorderFactory.createEmptyBorder(20, 80, 20, 80)
        );

        panel.add(bookButton);
        panel.add(checkButton);
        panel.add(cancelButton);
        panel.add(logoutButton);

        add(heading, BorderLayout.NORTH);
        add(details, BorderLayout.WEST);
        add(panel, BorderLayout.CENTER);
        add(seatLabel, BorderLayout.SOUTH);

        bookButton.addActionListener(e -> bookSeat());
        checkButton.addActionListener(e -> checkSeat());
        cancelButton.addActionListener(e -> cancelSeat());

        logoutButton.addActionListener(e -> {
            new LoginFrame().setVisible(true);
            dispose();
        });
    }

    // Book seat using a separate thread
    private void bookSeat() {

        Thread bookingThread = new Thread(() -> {

            String seat =
                AppData.allocator.allocateSeat(student);

            SwingUtilities.invokeLater(() -> {

                seatLabel.setText("Seat: " + seat);

                JOptionPane.showMessageDialog(
                    this, "Reservation Result: " + seat
                );
            });
        });

        bookingThread.start();
    }

    // Check allocated seat
    private void checkSeat() {

        if (student.getSeatNo() == null) {

            JOptionPane.showMessageDialog(
                this, "You have not reserved a seat yet."
            );

        } else {

            JOptionPane.showMessageDialog(
                this, "Your allocated seat is: "
                + student.getSeatNo()
            );
        }
    }

    // Cancel reservation
    private void cancelSeat() {

        boolean cancelled =
            AppData.allocator.releaseSeat(student);

        if (cancelled) {

            seatLabel.setText("Seat: Not Allocated");

            JOptionPane.showMessageDialog(
                this, "Reservation Cancelled Successfully!"
            );

        } else {

            JOptionPane.showMessageDialog(
                this, "No reservation found to cancel."
            );
        }
    }
}
