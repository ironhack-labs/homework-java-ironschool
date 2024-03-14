package org;

import java.util.InputMismatchException;
import java.util.Scanner;

import static org.PrintUtils.printBlue;


public class CommandAddNewItem {
    public static void addNewTeacher (School school){
        boolean is_num = false;
        String name = "";
        double salary = 00.00;
        Scanner scanner = new Scanner(System.in);

        System.out.println(printBlue("Enter teacher name:"));
        name = scanner.nextLine();
        System.out.println(printBlue("Enter teacher salary:"));
        while (!is_num) {
            try {
                salary = scanner.nextDouble();
                scanner.nextLine();
                is_num = true;
            } catch (InputMismatchException ie) {
                scanner.nextLine();
                System.err.println("Oops! You need to enter a number.");
            }
        }
        Teacher teacher = new Teacher(name, salary);
        school.getTeacherMap().put(teacher.getTeacherId(), teacher);
    }

    public static void addNewCourse(School school){
        boolean is_num = false;
        String name = "";
        double price = 00.00;
        Scanner scanner = new Scanner(System.in);

        System.out.println(printBlue("Enter course name:"));
        name = scanner.nextLine();
        System.out.println(printBlue("Enter course price:"));
        while (!is_num) {
            try {
                price = scanner.nextDouble();
                scanner.nextLine();
                is_num = true;
            } catch (InputMismatchException ie) {
                scanner.nextLine();
                System.err.println("Oops! You need to enter a number.");
            }
        }
        Course course = new Course(name, price, (double) 0);
        school.getCourseMap().put(course.getCourseId(), course);
    }

    public static void addNewStudent(School school){
        String name = "";
        String address = "";
        String email = "";
        Scanner scanner = new Scanner(System.in);

        System.out.println(printBlue("Enter student name:"));
        name = scanner.nextLine();
        System.out.println(printBlue("Enter student address:"));
        address = scanner.nextLine();
        System.out.println(printBlue("Enter student email:"));
        email = scanner.nextLine();

        Student student = new Student(name, address, email);
        school.getStudentMap().put(student.getStudentId(), student);
    }
}
