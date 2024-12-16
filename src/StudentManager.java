import java.util.*;
import java.io.*;

public class StudentManager {
    private List<Student> students = new ArrayList<>();

    // Load data from file
    public void loadFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            students = (List<Student>) ois.readObject();
            System.out.println("Data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No previous data found.");
        }
    }

    // Save data to file
    public void saveToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(students);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Add a new student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    // View all students
    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    // Find student by ID
    public Student findStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    // Update student
    public void updateStudent(int id, String name, int age, String grade) {
        Student student = findStudentById(id);
        if (student != null) {
            student.setName(name);
            student.setAge(age);
            student.setGrade(grade);
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Delete student
    public void deleteStudent(int id) {
        Student student = findStudentById(id);
        if (student != null) {
            students.remove(student);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
}

