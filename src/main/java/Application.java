import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        createSchoolName();
        teacherDetails();
        studentDetails();
    }

    private static final Scanner scanner = new Scanner(System.in);

    private static void createSchoolName() {
        System.out.println("Welcome to the School Application");
        System.out.println("Please enter the name of the school:");

        String schoolName = scanner.nextLine();
        System.out.println("Your school is: " + schoolName);

    }

    private static int number(SchoolComponents schoolComponents) {
        int number;

        do {
            System.out.println(String.format("How many %s are there in the school: ", schoolComponents));
            while (!scanner.hasNextInt()) {
                System.out.println(String.format("Please enter a valid number for the %s ", schoolComponents));
                scanner.next();
            }
            number = scanner.nextInt();

            if (number <= 0) {
                System.err.println(String.format("The number of %s can't be 0 or negative", schoolComponents));
            } else if (number == 1) {
                System.out.println(String.format("In your school there is only " + number + " %s", schoolComponents));
            } else {
                System.out.println(String.format("In your school there are " + number + " %s", schoolComponents));
            }

        } while (number <= 0);

        return number;

    }

    private static Map<String,Teacher> teacherDetails() {
        Map<String,Teacher> teachersMap = new HashMap<>();
        int number = number(SchoolComponents.TEACHERS);
        scanner.nextLine();
        for (int i = 0; i < number; i++) {
            System.out.println("Enter details for Teacher " + (i + 1) + ":");

            System.out.println("Name: ");
            String name = scanner.nextLine();

            System.out.println("Salary: ");
            double salary = Double.parseDouble(scanner.nextLine());

            Teacher teacher = new Teacher(name, salary);
            teachersMap.put(teacher.getTeacherId(), teacher);
        }

        for (Map.Entry<String, Teacher> entry : teachersMap.entrySet()) {
                System.out.println("Teacher ID: " + entry.getKey() + ", Name: " + entry.getValue().getName() + ", Salary: " + entry.getValue().getSalary());
            }

          return teachersMap;

    }

    private static Map<String,Student> studentDetails() {
        Map<String,Student> studentMap = new HashMap<>();
        int number = number(SchoolComponents.STUDENTS);
        scanner.nextLine();
        for (int i = 0; i < number; i++) {
            System.out.println("Enter details for Student " + (i + 1) + ":");

            System.out.println("Name: ");
            String name = scanner.nextLine();

            System.out.println("Adress: ");
            String adress = scanner.nextLine();

            System.out.println("Email: ");
            String email = scanner.nextLine();

            Student student = new Student(name, adress, email);
            studentMap.put(student.getStudentId(), student);
        }

        for (Map.Entry<String, Student> entry : studentMap.entrySet()) {
                System.out.println("Student ID: " + entry.getKey() + ", Name: " + entry.getValue().getName() + ", Adress: " + entry.getValue().getAddress() + ", Email: " + entry.getValue().getEmail());
            }

        return studentMap;

    }



}




