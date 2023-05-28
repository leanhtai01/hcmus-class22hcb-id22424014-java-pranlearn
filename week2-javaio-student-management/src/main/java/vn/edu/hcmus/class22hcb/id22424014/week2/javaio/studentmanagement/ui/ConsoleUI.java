package vn.edu.hcmus.class22hcb.id22424014.week2.javaio.studentmanagement.ui;

public class ConsoleUI {
    public static void main(String[] args) {
        displayMenu();
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
        System.console().writer().print("Please enter your choice: ");
    }
}
