package ironhack.com;

import java.io.FileNotFoundException;
import java.util.*;

import static ironhack.com.ReadCsvInfo.readObjectInfo;
import static ironhack.com.ReadCsvInfo.readSchoolInfo;
import static ironhack.com.Utils.validate_number_of;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean is_finish = false;
        do {

            System.out.println("*******School Management System******");

            System.out.println("Let's create an School");
            System.out.println("Enter a Name:");
            scanner.nextLine();

            System.out.println("how many teachers should be created?");
            int teacher_number = validate_number_of(scanner);
            System.out.println(teacher_number);
            List<Teacher> teachers =create_teachers(scanner, teacher_number);

            System.out.println("how many courses should be created?");
            int courses_number = validate_number_of(scanner);
            System.out.println(courses_number);
            List<Course> courses =create_course(scanner, courses_number);


            System.out.println("how many students should be created?");
            int students_number = validate_number_of(scanner);
            System.out.println(students_number);
            List<Student> students =create_students(scanner, students_number);


            is_finish = true;

        } while (!is_finish);
    }

    public static List<Teacher> create_teachers(Scanner scanner, int teacher_number) {

        List<Teacher> teachers_list = new ArrayList<>();
        for (int i = 0; i < teacher_number; i++) {
            System.out.println("Let's create teacher "+(i+1));
            System.out.println("Enter Name:");
            String teacher_name = scanner.nextLine();

            System.out.println("Enter Salary (Ex 34000): ");
            int teacher_salary = validate_number_of(scanner);
            // Validate Range of Salaries
            teachers_list.add(new Teacher(teacher_name, teacher_salary));
        }
        return teachers_list;
        //school.setListToTeacherMap(teachers);

    }

    public static List<Course> create_course(Scanner scanner, int course_number) {

        List<Course> course_list = new ArrayList<>();
        for (int i = 0; i < course_number; i++) {
            System.out.println("Let's create a course "+(i+1));
            System.out.println("Enter Name:");
            String course_name = scanner.nextLine();

            System.out.println("Enter Price: ");
            double price = 3.14;

            course_list.add(new Course(course_name,price));
        }
        return course_list;

    }

    public static List<Student> create_students(Scanner scanner, int students_number) {

        List<Student> students_list = new ArrayList<>();
        for (int i = 0; i < students_number; i++) {
            System.out.println("Let's create student "+(i+1));
            System.out.println("Enter Name:");
            String student_name = scanner.nextLine();

            System.out.println("Enter Address: ");
            String address = scanner.nextLine();

            System.out.println("Enter Email: ");
            String email = scanner.nextLine();

            students_list.add(new Student(student_name,address, email));
        }
        return students_list;

    }


}
