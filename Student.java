package model;

public class Student implements Comparable<Student> {
    private int rollNo;
    private String name;
    private String email;
    private String course;
    private double marks;

    public Student(int rollNo, String name, String email, String course, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.email = email;
        this.course = course;
        this.marks = marks;
    }

    public int getRollNo() { return rollNo; }
    public String getName() { return name; }
    public double getMarks() { return marks; }

    @Override
    public int compareTo(Student s) {
        return Double.compare(this.marks, s.marks);
    }

    @Override
    public String toString() {
        return rollNo + "," + name + "," + email + "," + course + "," + marks;
    }

    public void display() {
        System.out.println("\nRoll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
    }
}
