import model.Student;
import service.StudentManager;
import exceptions.StudentNotFoundException;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        try {
            // Read inputs with wrapper classes and validation
            System.out.print("Enter Roll No (Integer): ");
            String rollInput = sc.nextLine();
            Integer roll = Integer.valueOf(rollInput.trim()); // wrapper usage

            System.out.print("Enter Name: ");
            String name = sc.nextLine().trim();

            System.out.print("Enter Email: ");
            String email = sc.nextLine().trim();

            System.out.print("Enter Course: ");
            String course = sc.nextLine().trim();

            System.out.print("Enter Marks: ");
            String marksInput = sc.nextLine();
            Double marks = Double.valueOf(marksInput.trim()); // wrapper usage

            // Create Student (autoboxing happens where needed)
            Student s = new Student(roll, name, email, course, marks);

            // Add student (with loading simulation + validation)
            try {
                manager.addStudent(s);
            } catch (IllegalArgumentException e) {
                System.out.println("Input Error: " + e.getMessage());
                return;
            }

            // Display the student we just added
            try {
                Student fetched = manager.searchStudent(roll);
                fetched.displayInfo();
            } catch (StudentNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } catch (NumberFormatException nfe) {
            System.out.println("Invalid number format: " + nfe.getMessage());
        } catch (Exception ex) {
            // catch-all for unexpected exceptions
            System.out.println("An unexpected error occurred: " + ex.getMessage());
        } finally {
            System.out.println("Program execution completed.");
            sc.close();
        }
    }
}
