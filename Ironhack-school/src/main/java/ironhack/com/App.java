package ironhack.com;

import java.util.*;

import static ironhack.com.ReadCsvInfo.school_creation_csv;
import static ironhack.com.Utils.*;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        School school = null;
        boolean is_finish = false;
        do {
            System.out.println("*******School Management System******");
            System.out.println("Choose a Command From the List");
            System.out.println("1-CREATE SCHOOL BY READING CSV");
            System.out.println("2-CREATE SCHOOL MANUALLY ");
            System.out.println("3-LAUNCH COMMANDS ");
            System.out.println("4-EXIT ");
            String value = scanner.nextLine();
            switch (value) {
                case "1":
                    System.out.println("READING CSV.....");
                    school = school_creation_csv();
                    break;
                case "2":
                    school = create_school_by_std_input(scanner);
                    break;
                case "3":
                    if (school != null) {
                        show_commands_list(scanner, school);
                    } else {
                        System.out.println("School has not been initialized. Use command 1 or 2");
                    }
                    break;

                case "4":
                    is_finish = true;
                    System.out.println("SEE YOU SOON!");
                    break;

                default:
                    System.out.println("Invalid input");
            }

        } while (!is_finish);




    }

    public static School create_school_by_std_input(Scanner scanner){

        System.out.println("Let's create an School");
        System.out.println("Enter a Name:");
        String name = validateNameOf(scanner);

        System.out.println("how many teachers should be created?");
        int teacher_number = validateNumberOf(scanner, 1);
        System.out.println(teacher_number);
        List<Teacher> teachers = create_teachers(scanner, teacher_number);

        System.out.println("how many courses should be created?");
        int courses_number = validateNumberOf(scanner, 1);
        System.out.println(courses_number);
        List<Course> courses = create_course(scanner, courses_number);


        System.out.println("how many students should be created?");
        int students_number = validateNumberOf(scanner, 1);
        System.out.println(students_number);
        List<Student> students = create_students(scanner, students_number);

        return create_school(name, teachers, courses, students);

    }

    public static List<Teacher> create_teachers(Scanner scanner, int teacher_number) {

        List<Teacher> teachers_list = new ArrayList<>();
        for (int i = 0; i < teacher_number; i++) {
            System.out.println("Let's create teacher " + (i + 1));
            System.out.println("Enter Name:");
            String teacher_name = validateNameOf(scanner);

            System.out.println("Enter Salary (Ex 34000): ");
            int teacher_salary = validateNumberOf(scanner, 0);
            // Validate Range of Salaries
            teachers_list.add(new Teacher(teacher_name, teacher_salary));
        }
        return teachers_list;

    }

    public static List<Course> create_course(Scanner scanner, int course_number) {

        List<Course> course_list = new ArrayList<>();
        for (int i = 0; i < course_number; i++) {
            System.out.println("Let's create a course " + (i + 1));
            System.out.println("Enter Name:");
            String course_name = validateNameOf(scanner);

            System.out.println("Enter Price: ");
            double price = validateDoubleOf(scanner);

            course_list.add(new Course(course_name, price));
        }
        return course_list;

    }

    public static List<Student> create_students(Scanner scanner, int students_number) {

        List<Student> students_list = new ArrayList<>();
        for (int i = 0; i < students_number; i++) {
            System.out.println("Let's create student " + (i + 1));
            System.out.println("Enter Name:");
            String student_name = validateNameOf(scanner);
            ;

            System.out.println("Enter Address: ");
            String address = scanner.nextLine();

            System.out.println("Enter Email: ");
            String email = validateEmailOf(scanner);

            students_list.add(new Student(student_name, address, email));
        }
        return students_list;

    }

    public static School create_school(String name, List<Teacher> teachers, List<Course> courses, List<Student> students) {
        School school = new School(name);
        school.setListToStudentMap(students);
        school.setListToTeacherMap(teachers);
        school.setListToCourseMap(courses);
        return school;
    }

    public static void show_commands_list(Scanner scanner, School school) {
        boolean is_finish = false;
        do {
            System.out.println("*******School Management System******");
            System.out.println("Choose a Command From the List");
            System.out.println("1-ENROLL [STUDENT_ID] [COURSE_ID]");
            System.out.println("2-ASSIGN [TEACHER_ID] [COURSE_ID]");
            System.out.println("3-SHOW COURSES");
            System.out.println("4-LOOKUP COURSE [COURSE_ID]");
            System.out.println("5-SHOW STUDENTS");
            System.out.println("6-LOOKUP STUDENT [STUDENT_ID]");
            System.out.println("7-SHOW TEACHERS");
            System.out.println("8-LOOKUP TEACHER [TEACHER_ID]");
            System.out.println("9-SHOW PROFIT");
            System.out.println("10-Go back");
            System.out.println("h-help");
            String value = scanner.nextLine();
            String result;
            String student_id ;
            String teacher_id;
            String course_id;
            switch (value) {
                case "1":
                    System.out.println("1-ENROLL [STUDENT_ID] [COURSE_ID]");
                    Student student = null;
                    System.out.println("Enter a [STUDENT_ID]");
                    while (student == null) {
                        student_id = Long.toString(validateIdOf(scanner));
                        student = school.findStudentById(student_id);
                        if (student == null) {
                            System.out.println("Student with ID " + student_id + " not found. Please try again.");
                        } else {
                            System.out.println("Student found:");
                            student.printInfo();
                        }
                    }

                    // Similar logic applies to course
                    System.out.println("Now Enter a [COURSE_ID]");
                    Course course = null;
                    while (course == null) {
                        course_id = Long.toString(validateIdOf(scanner));
                        course = school.lookupCourse(course_id);
                        if (course == null) {
                            System.out.println("Course with ID " + course_id + " not found. Please try again.");
                        } else {
                            System.out.println("Course found:");
                            course.printInfo();
                        }
                    }
                    break;
                case "2":
                    System.out.println("2-ASSIGN [TEACHER_ID] [COURSE_ID]");
                    System.out.println("Enter a [TEACHER_ID]");
                    teacher_id = Long.toString(validateIdOf(scanner));
                    System.out.println("Now Enter a [COURSE_ID]");
                    course_id = Long.toString(validateIdOf(scanner));
                    school.assignTeacherToCourse(teacher_id, course_id);
                    break;
                case "3":
                    System.out.println("3-SHOW COURSES");
                    school.showCourses();
                    break;
                case "4":
                    System.out.println("4-LOOKUP COURSE [COURSE_ID]");
                    System.out.println("Enter a [COURSE_ID]");
                    course_id = Long.toString(validateIdOf(scanner));
                    school.lookupCourse(course_id);
                    break;
                case "5":
                    System.out.println("5-SHOW STUDENTS");
                    school.showStudents();
                    break;
                case "6":
                    System.out.println("6-LOOKUP STUDENT [STUDENT_ID]");
                    System.out.println("Enter a [STUDENT_ID]");
                    student_id = Long.toString(validateIdOf(scanner));
                    school.lookupStudent(student_id);
                    break;
                case "7":
                    System.out.println("7-SHOW TEACHERS");
                    school.showTeachers();
                    break;
                case "8":
                    System.out.println("8-LOOKUP TEACHER [TEACHER_ID]");
                    System.out.println("Enter a [TEACHER_ID]");
                    teacher_id = Long.toString(validateIdOf(scanner));
                    school.lookupTeacher(teacher_id);
                    break;
                case "9":
                    System.out.println("9-SHOW PROFIT");
                    school.showProfit();

                    break;
                case "h":
                    System.out.println("ENROLL [STUDENT_ID] [COURSE_ID]: This command will help enroll the student specified in the corresponding course. While also updating the money_earned of that course based on its price");
                    System.out.println("ASSIGN [TEACHER_ID] [COURSE_ID]: This command will help assign the teacher specified to the corresponding course");
                    System.out.println("SHOW COURSES: This command will display a list of all courses");
                    System.out.println("LOOKUP COURSE [COURSE_ID]: This command will display the full details of the specified course");
                    System.out.println("SHOW STUDENTS: This command will display a list of all students");
                    System.out.println("LOOKUP STUDENT [STUDENT_ID]: This command will display the full details of the specified student");
                    System.out.println("SHOW TEACHERS: This command will display a list of all teachers");
                    System.out.println("LOOKUP TEACHER [TEACHER_ID]: This command will display the full details of the specified teacher");
                    System.out.println("SHOW PROFIT: This command will calculate (The total money earned from all courses) - (The sum of all the teachers' salaries) and return the result");
                    break;
                case "10":
                    is_finish = true;
                    break;

                default:
                    System.out.println("Invalid input");
            }

        } while (!is_finish);
    }

}
