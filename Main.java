import java.util.*;
import model.Student;
import service.StudentManager;
import util.FileUtil;

public class Main {

    public static void main(String[] args) {

        List<Student> list = FileUtil.readFromFile("students.txt");
        System.out.println("Loaded students from file:");

        for (Student s : list) s.display();

        StudentManager sm = new StudentManager(list);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Capstone Student Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search by Name");
            System.out.println("4. Delete by Name");
            System.out.println("5. Sort by Marks");
            System.out.println("6. Save and Exit");

            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("Enter Roll No: ");
                    int roll = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = Double.parseDouble(sc.nextLine());

                    sm.addStudent(new Student(roll, name, email, course, marks));
                    break;

                case 2:
                    sm.viewAll();
                    break;

                case 3:
                    System.out.print("Enter Name: ");
                    sm.searchByName(sc.nextLine());
                    break;

                case 4:
                    System.out.print("Enter Name: ");
                    sm.deleteByName(sc.nextLine());
                    break;

                case 5:
                    sm.sortByMarks();
                    break;

                case 6:
                    FileUtil.writeToFile("students.txt", list);
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
