package ui;

import databaseAccess.StudentDAO;
import java.util.ArrayList;
import java.util.Scanner;
import model.Student;

/**
 * Console-based user interface for managing students.
 * Handles all user input and menu operations.
 */
public class MainConsoleUi {

    /**
     * Starts the console menu loop and handles user actions.
     */
    public MainConsoleUi() {
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1- Insert");
            System.out.println("2- Search by ID");
            System.out.println("3- Show All");
            System.out.println("4- Update GPA");
            System.out.println("5- Delete");
            System.out.println("6- Exit");

            System.out.print("Choose: ");
            int choice = sc.nextInt();

            if (choice == 1) {

                System.out.print("ID: ");
                int id = sc.nextInt();

                sc.nextLine();
                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("GPA: ");
                double gpa = sc.nextDouble();

                Student student = new Student(id, name, gpa);
                boolean inserted = StudentDAO.insert(student);

                if (inserted) {
                    System.out.println("Inserted!");
                } else {
                    System.out.println("Error inserting!");
                }

            } else if (choice == 2) {

                System.out.print("ID: ");
                int id = sc.nextInt();

                Student student = StudentDAO.getById(id);

                if (student != null) {
                    System.out.println("Name: " + student.getName());
                    System.out.println("GPA: " + student.getGpa());
                } else {
                    System.out.println("Not found!");
                }

            } else if (choice == 3) {
                ArrayList<Student> students = StudentDAO.getAll();

                if (students.isEmpty()) {
                    System.out.println("No students found!");
                    continue;
                }

                System.out.println("----------------");
                for (Student student : students) {
                    System.out.println("ID: " + student.getId());
                    System.out.println("Name: " + student.getName());
                    System.out.println("GPA: " + student.getGpa());
                    System.out.println("----------------");
                }

            } else if (choice == 4) {

                System.out.print("ID: ");
                int id = sc.nextInt();

                System.out.print("New GPA: ");
                double gpa = sc.nextDouble();

                Student student = new Student();
                student.setId(id);
                student.setGpa(gpa);
                boolean updated = StudentDAO.updateGpa(student);

                if(updated) {
                    System.out.println("Updated!");
                } else {
                    System.out.println("Not found!");
                }

            } else if (choice == 5) {

                System.out.print("ID: ");
                int id = sc.nextInt();

                Student student = new Student();
                student.setId(id);
                boolean deleted = StudentDAO.delete(student);

                if (deleted) {
                    System.out.println("Deleted!");
                } else {
                    System.out.println("Not found!");
                }

            } else if (choice == 6) {

                System.out.println("Bye!");
                break;
            }
            else {
                System.out.println("Invalid choice!");
            }
            System.out.println("Press Enter to continue...");
            sc.nextLine(); // consume the newline
            sc.nextLine(); // wait for Enter key

            //delet all data on console:
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
