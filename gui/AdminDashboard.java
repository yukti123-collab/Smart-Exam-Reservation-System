
package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Map;
import model.Student;

public class AdminDashboard extends JFrame {

    public AdminDashboard() {

        setTitle("Admin Dashboard");
        setSize(750, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel heading = new JLabel(
            "ADMIN DASHBOARD",
            SwingConstants.CENTER
        );

        heading.setFont(new Font("Arial", Font.BOLD, 28));

        JButton studentsButton =
            new JButton("View Registered Students");

        JButton seatsButton =
            new JButton("Check Seat Availability");

        JButton logoutButton =
            new JButton("Logout");

        JPanel panel = new JPanel(new GridLayout(3, 1, 15, 15));

        panel.setBorder(
            BorderFactory.createEmptyBorder(40, 120, 40, 120)
        );

        panel.add(studentsButton);
        panel.add(seatsButton);
        panel.add(logoutButton);

        add(heading, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        studentsButton.addActionListener(e -> showStudents());

        seatsButton.addActionListener(e -> showSeats());

        logoutButton.addActionListener(e -> {
            new LoginFrame().setVisible(true);
            dispose();
        });
    }

    // Display Registered Students in JTable

    private void showStudents() {

        String[] columns = {
            "Roll Number",
            "Name",
            "Department",
            "Seat Number"
        };

        DefaultTableModel model =
            new DefaultTableModel(columns, 0) {

                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

        for (Map.Entry<Integer, Student> entry :
                AppData.students.entrySet()) {

            Student student = entry.getValue();

            Object[] row = {
                student.getRollNo(),
                student.getName(),
                student.getDepartment(),
                student.getSeatNo() == null
                    ? "Not Booked"
                    : student.getSeatNo()
            };

            model.addRow(row);
        }

        JTable table = new JTable(model);

        table.setRowHeight(30);

        table.setFont(new Font("Arial", Font.PLAIN, 14));

        table.getTableHeader().setFont(
            new Font("Arial", Font.BOLD, 14)
        );

        table.getTableHeader().setBackground(
            new Color(52, 73, 94)
        );

        table.getTableHeader().setForeground(Color.WHITE);

        table.setSelectionBackground(
            new Color(174, 214, 241)
        );

        table.setSelectionForeground(Color.BLACK);

        table.setAutoCreateRowSorter(true);

        JScrollPane scrollPane = new JScrollPane(table);

        JFrame frame = new JFrame("Registered Students");

        frame.setSize(700, 400);

        frame.setLocationRelativeTo(this);

        frame.add(scrollPane, BorderLayout.CENTER);

        if (model.getRowCount() == 0) {

            JOptionPane.showMessageDialog(
                this,
                "No students registered yet."
            );

            return;
        }

        frame.setVisible(true);
    }

    // Check Seat Availability

    private void showSeats() {

        int total = AppData.allocator.getTotalSeats();

        int booked = AppData.allocator.getBookedCount();

        int available = AppData.allocator.getAvailableCount();

        String message =
            "Total Seats: " + total +
            "\nBooked Seats: " + booked +
            "\nAvailable Seats: " + available;

        JOptionPane.showMessageDialog(
            this,
            message,
            "Seat Availability",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
