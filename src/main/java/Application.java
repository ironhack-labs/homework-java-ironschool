import lombok.Data;
import lombok.Getter;

import java.util.*;

@Data
public class Application {
    private Map<String, Course> courseList = new HashMap<>();
    private Map<String, Student> studentList = new HashMap<>();
    private Map<String, Teacher> teacherList = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public Application() {
        createSchoolName();
        setTeacherList(teacherDetails());
        setStudentList(studentDetails());
        setCourseList(courseDetails());
    }

    public void run() {
        String response = " ";
        Commands commands = new Commands(this.getCourseList(), this.getStudentList(), this.getTeacherList());
        Selector(commands);
    }

    private static void createSchoolName() {
        System.out.println("Welcome to the School Application");
        System.out.print("Please enter the name of the school:");

        String schoolName = scanner.nextLine();
        System.out.println("Your school is: " + schoolName);

    }

    private static int numberOfComponents(SchoolComponents schoolComponents) {
        int number;

        do {
            System.out.print(String.format("How many %s are there in the school: ", schoolComponents));
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

    private Map<String,Teacher> teacherDetails() {
        Map<String,Teacher> teachersMap = new HashMap<>();
        int number = numberOfComponents(SchoolComponents.TEACHERS);
        scanner.nextLine();
        for (int i = 0; i < number; i++) {
            System.out.println("Enter details for Teacher " + (i + 1) + ":");

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Salary: ");
            double salary = Double.parseDouble(scanner.nextLine());

            Teacher teacher = new Teacher(name, salary);
            teachersMap.put(teacher.getTeacherId(), teacher);
        }

        for (Map.Entry<String, Teacher> entry : teachersMap.entrySet()) {
                System.out.println("Teacher ID: " + entry.getKey() + ", Name: " + entry.getValue().getName() + ", Salary: " + entry.getValue().getSalary());
            }

          return teachersMap;

    }

    private Map<String,Student> studentDetails() {
        Map<String,Student> studentMap = new HashMap<>();
        int number = numberOfComponents(SchoolComponents.STUDENTS);
        scanner.nextLine();
        for (int i = 0; i < number; i++) {
            System.out.println("Enter details for Student " + (i + 1) + ":");

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Address: ");
            String address = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            Student student = new Student(name, address, email);
            studentMap.put(student.getStudentId(), student);
        }

        for (Map.Entry<String, Student> entry : studentMap.entrySet()) {
                System.out.println("Student ID: " + entry.getKey() + ", Name: " + entry.getValue().getName() + ", Address: " + entry.getValue().getAddress() + ", Email: " + entry.getValue().getEmail());
            }

        return studentMap;

    }

    private Map<String,Course> courseDetails() {
        Map<String,Course> coursesMap = new HashMap<>();
        int number = numberOfComponents(SchoolComponents.COURSES);
        scanner.nextLine();
        for (int i = 0; i < number; i++) {
            System.out.println("Enter details for Course " + (i + 1) + ":");

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Price: ");
            double price = Double.parseDouble(scanner.nextLine());

            Course course = new Course(name, price);
            coursesMap.put(course.getCourseId(), course);
        }

        for (Map.Entry<String, Course> entry : coursesMap.entrySet()) {
            System.out.println("Course ID: " + entry.getKey() + ", Name: " + entry.getValue().getName() + ", Price: " + entry.getValue().getPrice());
        }

        return coursesMap;

    }

    public static void Selector(Commands comandos){
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(("Do you want to use a command? (y/n)"));
            String response = scanner.next();
            scanner.nextLine();
            if (response.equals("y")) {
                System.out.println("Choose a command:\n");
                System.out.println("1. Enroll\n");
                System.out.println("2. Assign\n");
                System.out.println("3. Show courses\n");
                System.out.println("4. Lookup course\n");
                System.out.println("5. Show students\n");
                System.out.println("6. Lookup student\n");
                System.out.println("7. Show teachers\n");
                System.out.println("8. Lookup teacher\n");
                System.out.println("9. Show profit\n");
                try {
                    int commandoption = scanner.nextInt();
                    switch (commandoption) {
                        case 1:
                            comandos.commandSelector(CommandEnum.ENROLL);
                            break;
                        case 2:
                            comandos.commandSelector(CommandEnum.ASSIGN);
                            break;
                        case 3:
                            comandos.commandSelector(CommandEnum.SHOW_COURSES);
                            break;
                        case 4:
                            comandos.commandSelector(CommandEnum.LOOKUP_COURSE);
                            break;
                        case 5:
                            comandos.commandSelector(CommandEnum.SHOW_STUDENTS);
                            break;
                        case 6:
                            comandos.commandSelector(CommandEnum.LOOKUP_STUDENT);
                            break;
                        case 7:
                            comandos.commandSelector(CommandEnum.SHOW_TEACHERS);
                            break;
                        case 8:
                            comandos.commandSelector(CommandEnum.LOOKUP_TEACHER);
                            break;
                        case 9:
                            comandos.commandSelector(CommandEnum.SHOW_PROFIT);
                            break;
                        default:
                            System.err.println("The option selected is not available");
                            break;
                    }
                } catch (InputMismatchException ime) {
                    System.err.println("The option selected is not available");
                }
            } else if (response.equals("n")) {
                return;
            } else {
                System.err.println("You typed a non-valid option");
            }
        }
    }
}




