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

    public static void createSchoolName() {
        System.out.println("Welcome to the School Application");
        while (true) {
            try {
                System.out.print("Please enter the name of the school:");

                String schoolName = scanner.nextLine();
                if (schoolName.isBlank()) {
                    throw new IllegalArgumentException( "\u001B[31mSchool name cannot be blank.\u001B[0m");
                }

                System.out.println("Your school is: " + schoolName);
                break;
            } catch (Exception e) {
                System.out.println("\u001B[31mAn error occurred: " + e.getMessage());
            }
        }
    }

    public static int numberOfComponents(SchoolComponents schoolComponents) {
        int number;

        do {
            System.out.println(String.format("How many %s are there in the school: ", schoolComponents));
            while (!scanner.hasNextInt()) {
                System.err.println(String.format("Please enter a valid number for the %s ", schoolComponents));
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

    public static Map<String,Teacher> teacherDetails() {
        Map<String,Teacher> teachersMap = new HashMap<>();
        int number = numberOfComponents(SchoolComponents.TEACHERS);
        scanner.nextLine();
        for (int i = 0; i < number; i++) {
            System.out.println("Enter details for Teacher " + (i + 1) + ":");
            String name = validateInput("Name", "Name cannot be empty", "Name cannot contain numbers");
            double salary = validateDoubleInput("Salary", "Invalid input for salary. Please enter a valid number");

            Teacher teacher = new Teacher(name, salary);
            teachersMap.put(teacher.getTeacherId(), teacher);
        }

        for (Map.Entry<String, Teacher> entry : teachersMap.entrySet()) {
                System.out.println("Teacher ID: " + entry.getKey() + ", Name: " + entry.getValue().getName() + ", Salary: " + entry.getValue().getSalary() +" Euros");
            }

          return teachersMap;

    }

    public static Map<String,Student> studentDetails() {
        Map<String,Student> studentMap = new HashMap<>();
        int number = numberOfComponents(SchoolComponents.STUDENTS);
        scanner.nextLine();
        for (int i = 0; i < number; i++) {
            System.out.println("Enter details for Student " + (i + 1) + ":");
            String name = validateInput("Name", "Name cannot be empty", "Name cannot contain numbers");
            String address = validateInput("Address", "Address cannot be empty", "Address is not valid");
            String email = validateInput("Email", "Email cannot be empty", "Email is not valid");

            Student student = new Student(name, address, email);
            studentMap.put(student.getStudentId(), student);
        }
        for (Map.Entry<String, Student> entry : studentMap.entrySet()) {
            System.out.println("Student ID: " + entry.getKey() + ", Name: " + entry.getValue().getName() + ", Address: " + entry.getValue().getAddress() + ", Email: " + entry.getValue().getEmail());
        }
        return studentMap;
    }



    public static Map<String,Course> courseDetails() {
        Map<String,Course> coursesMap = new HashMap<>();
        int number = numberOfComponents(SchoolComponents.COURSES);
        scanner.nextLine();
        for (int i = 0; i < number; i++) {
            System.out.println("Enter details for Course " + (i + 1) + ":");
            String name = validateInput("Course Name", "Course Name cannot be empty", "Name cannot contain numbers");
            double price = validateDoubleInput("Price", "Invalid input for price. Please enter a valid number");

            Course course = new Course(name, price);
            coursesMap.put(course.getCourseId(), course);
        }

        for (Map.Entry<String, Course> entry : coursesMap.entrySet()) {
            System.out.println("Course ID: " + entry.getKey() + ", Name: " + entry.getValue().getName() + ", Price: " + entry.getValue().getPrice() + " Euros.");
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

    public static String validateInput(String fieldName, String emptyErrorMessage, String invalidErrorMessage) {
        String input = "";
        while (true) {
            try {
                System.out.print(fieldName + ": ");
                input = scanner.nextLine();
                if (input.isBlank()) {
                    throw new IllegalArgumentException("\u001B[31m" + emptyErrorMessage + "\u001B[0m");
                } else if (fieldName.equals("Name") && input.matches(".*\\d+.*")) {
                    throw new IllegalArgumentException("\u001B[31m" + invalidErrorMessage + "\u001B[0m");
                } else if (fieldName.equals("Email") && !input.contains("@")) {
                    throw new IllegalArgumentException("\u001B[31m" + invalidErrorMessage + "\u001B[0m");
                }
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println("\u001B[31mError: " + e.getMessage() + "\u001B[0m");
            }
        }
    }

    public static double validateDoubleInput(String fieldName, String errorMessage) {
        double input = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print(fieldName + ": ");
            try {
                input = Double.parseDouble(scanner.nextLine());
                validInput = true;
                if (input < 0) {
                    validInput = false;
                    System.out.println("\u001B[31m" + errorMessage + "\u001B[0m");
                }
            } catch (NumberFormatException e) {
                System.out.println("\u001B[31m" + errorMessage + "\u001B[0m");
            }
        }
        return input;
    }



}




