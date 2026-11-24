
package gui;

import javax.swing.*;
import java.awt.*;
import model.Student;

public class LoginFrame extends JFrame {

    public LoginFrame() {

        setTitle("Smart Examination Hall Seat Reservation");
        setSize(550, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel heading = new JLabel(
            "SMART EXAM SEAT RESERVATION",
            SwingConstants.CENTER
        );

        heading.setFont(new Font("Arial", Font.BOLD, 20));

        JTextField username = new JTextField();
        JPasswordField password = new JPasswordField();

        JButton adminButton = new JButton("Admin Login");
        JButton studentButton = new JButton("Student Login");
        JButton registerButton =
                new JButton("New Student Registration");

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 15));

        panel.setBorder(
            BorderFactory.createEmptyBorder(30, 40, 30, 40)
        );

        panel.add(new JLabel("Username / Roll Number:"));
        panel.add(username);

        panel.add(new JLabel("Password:"));
        panel.add(password);

        panel.add(adminButton);
        panel.add(studentButton);

        panel.add(new JLabel(""));
        panel.add(registerButton);

        add(heading, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        // Admin Login
        adminButton.addActionListener(e -> {

            String user = username.getText().trim();
            String pass = new String(password.getPassword());

            if (user.equals(AppData.ADMIN_USERNAME)
                    && pass.equals(AppData.ADMIN_PASSWORD)) {

                new AdminDashboard().setVisible(true);
                dispose();

            } else {

                JOptionPane.showMessageDialog(
                    this, "Invalid Admin Username or Password"
                );
            }
        });

        // Student Login
        studentButton.addActionListener(e -> {

            try {

                int rollNo = Integer.parseInt(
                    username.getText().trim()
                );

                String pass =
                    new String(password.getPassword());

                Student student = AppData.students.get(rollNo);

                if (student != null
                        && student.getPassword().equals(pass)) {

                    new StudentDashboard(student).setVisible(true);
                    dispose();

                } else {

                    JOptionPane.showMessageDialog(
                        this, "Invalid Student Login"
                    );
                }

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                    this, "Enter a valid Roll Number"
                );
            }
        });

        // Registration
        registerButton.addActionListener(e -> {
            new StudentRegistrationFrame().setVisible(true);
        });
    }
}
