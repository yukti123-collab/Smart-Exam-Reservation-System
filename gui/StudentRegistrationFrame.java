
package gui;

import javax.swing.*;
import java.awt.*;
import model.Student;

public class StudentRegistrationFrame extends JFrame {

    public StudentRegistrationFrame() {

        setTitle("Student Registration");
        setSize(450, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 15));

        panel.setBorder(
            BorderFactory.createEmptyBorder(30, 30, 30, 30)
        );

        JTextField roll = new JTextField();
        JTextField name = new JTextField();
        JTextField department = new JTextField();
        JPasswordField password = new JPasswordField();

        JButton register = new JButton("Register");

        panel.add(new JLabel("Roll Number:"));
        panel.add(roll);

        panel.add(new JLabel("Student Name:"));
        panel.add(name);

        panel.add(new JLabel("Department:"));
        panel.add(department);

        panel.add(new JLabel("Password:"));
        panel.add(password);

        panel.add(new JLabel(""));
        panel.add(register);

        add(panel);

        register.addActionListener(e -> {

            try {
                int rollNo = Integer.parseInt(roll.getText().trim());

                String studentName = name.getText().trim();
                String dept = department.getText().trim();
                String pass = new String(password.getPassword());

                if (studentName.isEmpty() ||
                    dept.isEmpty() || pass.isEmpty()) {

                    JOptionPane.showMessageDialog(
                        this, "Please fill all details"
                    );
                    return;
                }

                if (AppData.students.containsKey(rollNo)) {

                    JOptionPane.showMessageDialog(
                        this, "Roll number already registered"
                    );
                    return;
                }

                Student s = new Student(
                    rollNo, studentName, dept, pass
                );

                AppData.students.put(rollNo, s);

                JOptionPane.showMessageDialog(
                    this, "Registration Successful!"
                );

                dispose();

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                    this, "Enter a valid roll number"
                );
            }
        });
    }
}
