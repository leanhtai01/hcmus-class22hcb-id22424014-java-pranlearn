package vn.edu.hcmus.class22hcb.id22424014.week2.javaio.studentmanagement.ui;

import java.io.IOException;
import java.util.List;

import vn.edu.hcmus.class22hcb.id22424014.week2.javaio.studentmanagement.domain.Student;
import vn.edu.hcmus.class22hcb.id22424014.week2.javaio.studentmanagement.service.StudentService;

public class ConsoleUI {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        final StudentService service = new StudentService();

        displayMenu();
        int choice = Integer.parseInt(System.console().readLine());
        while (choice != 0) {
            switch (choice) {
                case 1 -> addStudent(service);
                case 2 -> updateStudent(service);
                case 4 -> displayStudents(service.getStudentsAscendingById());
                default -> System.console().writer().println("Invalid choice. Please try again.");
            }

            System.console().writer().println();
            displayMenu();
            choice = Integer.parseInt(System.console().readLine());
        }

        service.saveData();
    }

    private static void addStudent(StudentService service) {
        System.console().writer().println("Add new student:");

        System.console().writer().printf("%s", "ID: ");
        Student student = new Student(System.console().readLine());

        System.console().writer().printf("%s", "Name: ");
        student.setName(System.console().readLine());

        System.console().writer().printf("%s", "Grade: ");
        student.setGrade(Double.parseDouble(System.console().readLine()));

        System.console().writer().printf("%s", "Address: ");
        student.setAddress(System.console().readLine());

        System.console().writer().printf("%s", "Note: ");
        student.setNote(System.console().readLine());

        service.addStudent(student);
    }

    private static void updateStudent(StudentService service) {
        displayStudents(service.getStudents());
        System.console().writer().printf("%s", "ID of updated student: ");
        String id = System.console().readLine();

        if (service.isStudentExists(id)) {
            Student updatedStudent = new Student(id);

            System.console().writer().printf("%s", "Updated Name: ");
            updatedStudent.setName(System.console().readLine());

            System.console().writer().printf("%s", "Updated Grade: ");
            updatedStudent.setGrade(Double.parseDouble(System.console().readLine()));

            System.console().writer().printf("%s", "Updated Address: ");
            updatedStudent.setAddress(System.console().readLine());

            System.console().writer().printf("%s", "Updated Note: ");
            updatedStudent.setNote(System.console().readLine());

            service.updateStudent(updatedStudent);
        } else {
            System.console().writer().println("Student with ID: '%s' isn't exists!".formatted(id));
        }
    }

    private static void displayStudents(List<Student> students) {
        // display header
        System.console().writer().printf("%12s\t%30s\t%6s\t%30s\t%50s%n", "ID", "Name", "Grade", "Address", "Note");
        for (Student student : students) {
            System.console().writer().println(student);
        }
    }
    
    private static void displayMenu() {
        System.console().writer().println("Menu option:");
        System.console().writer().println("1. Add new student.");
        System.console().writer().println("2. Update student.");
        System.console().writer().println("3. Delete student.");
        System.console().writer().println("4. Display students by ID ascending.");
        System.console().writer().println("5. Display students by ID descending.");
        System.console().writer().println("6. Display students by Grade ascending.");
        System.console().writer().println("7. Display students by Grade descending.");
        System.console().writer().println("8. Import data from CSV.");
        System.console().writer().println("9. Export data to CSV.");
        System.console().writer().println("0. Exit.");
        System.console().writer().printf("%s", "Please enter your choice: ");
    }
}
