Smart Exam Reservation System
Overview

The Smart Exam Reservation System is a Java-based desktop application designed to streamline the process of reserving examination seats. It provides separate interfaces for students and administrators, allowing students to register, log in and reserve seats for scheduled exams, while administrators manage exams, examination halls and seating arrangements.

The system uses a multithreaded seat allocation mechanism so that reservations are processed efficiently and seats are assigned without conflict.

Objectives
Replace manual exam seat assignment with an automated, reliable process.
Provide students with a simple way to register, view exams and reserve seats.
Give administrators a central dashboard to manage exams, halls and seat availability.
Store application data persistently through a database connection.
Key Features
Student Module
Secure student registration and login.
Student dashboard to view available exams and make seat reservations.
Administrator Module
Dedicated admin dashboard for managing exams, halls and seats.
Centralised control over reservation and allocation data.
Seat Allocation
Automated seat assignment handled by SeatAllocator.
Concurrent processing through AllocationThread, enabling multiple allocation tasks to run in parallel.
Data Management
Database connectivity provided by DBConnection for storing and retrieving student, exam and reservation records.
Project Structure
Smart-Exam-Reservation-System/
├── Main.java                      # Application entry point
├── gui/                           # User interface layer
│   ├── LoginFrame.java            # Login screen
│   ├── StudentRegistrationFrame.java
│   ├── StudentDashboard.java      # Student interface
│   ├── AdminDashboard.java        # Administrator interface
│   └── AppData.java               # Shared application data
├── admin/
│   └── database/
│       └── DBConnection.java      # Database connection handling
├── model/                         # Core data classes
│   ├── Exam.java
│   ├── Hall.java
│   ├── Seat.java
│   └── Student.java
└── allocation/                    # Seat allocation logic
    ├── SeatAllocator.java
    └── AllocationThread.java
Technologies Used
Language: Java
Interface: Java desktop GUI
Concurrency: Java threads
Database: JDBC-based database connection
Prerequisites

Before running the project, ensure that the following are available:

Java Development Kit (JDK) installed and configured on the system path.
A running database server, together with its JDBC driver, if the database features are used.
Optionally, a Java IDE such as IntelliJ IDEA or Eclipse.
Installation and Setup
Clone the repository
bash
git clone https://github.com/yukti123-collab/Smart-Exam-Reservation-System.git
cd Smart-Exam-Reservation-System
Configure the database Open admin/database/DBConnection.java and update the connection URL, username and password to match your database environment.
Compile the source code
bash
javac -d out Main.java gui/*.java admin/database/*.java model/*.java allocation/*.java

If a JDBC driver is required, include its .jar file using the -cp option.

Run the application
bash
java -cp out Main

Alternatively, import the project into an IDE and run Main.java directly.

Usage
Launch the application to open the login screen.
New students should register using the registration form, then log in.
Students can view available exams and reserve a seat from the student dashboard.
Administrators can log in to manage exams, halls and seat allocations from the admin dashboard.
Future Enhancements
Email or SMS confirmation for seat reservations.
Exportable seating plans and hall tickets.
Role-based access control with stronger authentication.
Reporting and analytics for exam hall utilisation.
Author

Developed by Yukti.
