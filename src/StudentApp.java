import java.util.Scanner;

public class StudentApp {
    private static final String FILE_NAME = "students.dat";

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        manager.loadFromFile(FILE_NAME);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Save & Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Grade: ");
                    String grade = scanner.nextLine();

                    manager.addStudent(new Student(id, name, age, grade));
                    break;

                case 2:
                    manager.viewAllStudents();
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    id = scanner.nextInt();
                    Student student = manager.findStudentById(id);
                    if (student != null) {
                        System.out.println(student);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter ID to update: ");
                    id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Name: ");
                    name = scanner.nextLine();

                    System.out.print("Enter New Age: ");
                    age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Grade: ");
                    grade = scanner.nextLine();

                    manager.updateStudent(id, name, age, grade);
                    break;

                case 5:
                    System.out.print("Enter ID to delete: ");
                    id = scanner.nextInt();
                    manager.deleteStudent(id);
                    break;

                case 6:
                    manager.saveToFile(FILE_NAME);
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
