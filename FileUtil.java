package util;

import model.Student;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static List<Student> readFromFile(String fileName) {
        List<Student> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int roll = Integer.parseInt(data[0]);
                String name = data[1];
                String email = data[2];
                String course = data[3];
                double marks = Double.parseDouble(data[4]);

                list.add(new Student(roll, name, email, course, marks));
            }
        } catch (Exception e) {
            System.out.println("Error reading file!");
        }

        return list;
    }

    public static void writeToFile(String fileName, List<Student> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Student s : list) {
                bw.write(s.toString());
                bw.newLine();
            }
            System.out.println("Records saved successfully!");
        } catch (Exception e) {
            System.out.println("Error writing to file!");
        }
    }
}
