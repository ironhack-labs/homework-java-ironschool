import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        createSchoolName();
        teacherDetails();


    }
    private static final Scanner scanner = new Scanner(System.in);

    private static void createSchoolName() {
        System.out.println("Welcome to the School Application");
        System.out.println("Please enter the name of the school:");

        String schoolName = scanner.nextLine();
        System.out.println("Your school is: " + schoolName);

    }
    private static int numberOfTeachers() {

        int numberofTeachers;
        do {
            System.out.println("How many teachers are there in the school: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number for the teachers.");
                scanner.next();
            }
            numberofTeachers = scanner.nextInt();

            if (numberofTeachers <= 0) {
                System.err.println("The number of teachers can't be 0 or negative");
            } else if (numberofTeachers == 1) {
                System.out.println("In your school there is only " + numberofTeachers + " teacher");
            } else {
                System.out.println("In your school there are " + numberofTeachers + " teachers");
            }

        } while (numberofTeachers <= 0);


        return numberofTeachers;

        }

        private static Map<String,Teacher> teacherDetails() {
            Map<String,Teacher> teachersMap = new HashMap<>();
            int numberOfTeachers = numberOfTeachers();
            scanner.nextLine();
            for (int i = 0; i < numberOfTeachers; i++) {
                System.out.println("Enter details for Teacher " + (i + 1) + ":");

                System.out.println("Name: ");
                String name = scanner.nextLine();

                System.out.println("Salary: ");
                double salary = Double.parseDouble(scanner.nextLine());
                Teacher teacher = new Teacher(name, salary);
                teachersMap.put(teacher.getTeacherId(), teacher );
            }

            for (Map.Entry<String, Teacher> entry : teachersMap.entrySet()) {
                System.out.println("Teacher ID: " + entry.getKey() + ", Name: " + entry.getValue().getName() + ", Salary: " + entry.getValue().getSalary());
            }

            return teachersMap;

    }

}




