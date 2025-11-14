package service;

import model.Student;
import java.util.*;

public class StudentManager {

    private List<Student> students;

    public StudentManager(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student s) {
        students.add(s);
        System.out.println("Student added successfully!");
    }

    public void viewAll() {
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            it.next().display();
        }
    }

    public void searchByName(String name) {
        boolean found = false;
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                s.display();
                found = true;
            }
        }
        if (!found) System.out.println("Student not found!");
    }

    public void deleteByName(String name) {
        students.removeIf(s -> s.getName().equalsIgnoreCase(name));
        System.out.println("Deleted (if existed)");
    }

    public void sortByMarks() {
        students.sort(Comparator.comparingDouble(Student::getMarks).reversed());
        System.out.println("Sorted Student List by Marks:");
        viewAll();
    }
}
