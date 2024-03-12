package model;

import com.github.lalyos.jfiglet.FigletFont;
import utils.Command;
import utils.MaxValue;
import utils.Validator;

import java.util.Scanner;
import java.util.stream.Stream;

public class Menu {
    private School school;

    public void start() {
        school = createSchool();

        int numberOfTeachers = getNumberOfEntity("teachers", MaxValue.MAX_TEACHER_TO_CREATE.getValue());
        registerTeachers(numberOfTeachers);

        int numberOfStudents = getNumberOfEntity("students", MaxValue.MAX_STUDENT_TO_CREATE.getValue());
        registerStudents(numberOfStudents);

        int numberOfCourses = getNumberOfEntity("courses", MaxValue.MAX_COURSES_TO_CREATE.getValue());
        registerCourses(numberOfCourses);

        menuOfCommands();
    }

    public School createSchool() {
        String schoolName = getValidNameFor("school");
        System.out.println(FigletFont.convertOneLine(schoolName));
        return new School(schoolName);
    }

    public void registerStudents(int numberOfStudents) {
        for (int i = 0; i < numberOfStudents; i++) {
            Student student = new Student(getValidNameFor("student"), getValidAddress(), getValidEmail());
            school.addStudent(student);
        }
    }

    public void registerTeachers(int numberOfTeachers) {
        for (int i = 0; i < numberOfTeachers; i++) {
            Teacher teacher = new Teacher(getValidNameFor("teacher"), getSalary());
            school.addTeacher(teacher);
        }
    }

    public void registerCourses(int numberOfCourses) {
        for (int i = 0; i < numberOfCourses; i++) {
            Course course = new Course(getValidNameFor("course"), getPrice());
            school.addCourse(course);
        }
    }

    public double getSalary() {
        Scanner scanner = new Scanner(System.in);
        String salary;
        do {
            System.out.println("Enter the salary: ");
            salary = scanner.next();
        } while (!Validator.isPositiveDecimalNumberValid(salary));
        return Double.parseDouble(salary);
    }

    public double getPrice() {
        Scanner scanner = new Scanner(System.in);
        String price;
        do {
            System.out.println("Enter the price: ");
            price = scanner.next();
        } while (!Validator.isPositiveDecimalNumberValid(price));
        return Double.parseDouble(price);
    }

    public String getValidNameFor(String entityType) {
        Scanner scanner = new Scanner(System.in);
        String name;
        do {
            System.out.printf("Enter a %s name: ", entityType);
            name = scanner.nextLine();
        } while (!Validator.isNameValid(name));
        return name;
    }

    public String getValidAddress() {
        Scanner scanner = new Scanner(System.in);
        String address;
        do {
            System.out.println("Enter student's address: ");
            address = scanner.nextLine();
        } while (!Validator.isAddressValid(address));
        return address;
    }

    public String getValidEmail() {
        Scanner scanner = new Scanner(System.in);
        String email;
        do {
            System.out.println("Enter student's email: ");
            email = scanner.next();
        } while (!Validator.isEmailValid(email));
        return email;
    }

    private int getNumberOfEntity(String value, int max) {
        Scanner scanner = new Scanner(System.in);
        String number;
        do {
            System.out.printf("Enter the number of %s to create (max-%d): %n", value, max);
            number = scanner.next();
        } while (!Validator.isPositiveNumberValid(number, max));
        return Integer.parseInt(number);
    }

    public void menuOfCommands() {
        Scanner scanner = new Scanner(System.in);
        long max = Stream.of(Command.values()).count();

        String commandIndex;
        do {
            System.out.println("\nCommand's list");
            Stream.of(Command.values()).forEach(opt -> System.out.println(opt.getIndex() + " - " + opt.getDescription()));
            System.out.print("0 - Exit program");
            System.out.printf("%nEnter a command (1 - %d): ", max);
            commandIndex = scanner.next();
            school.executeCommand(commandIndex);
        } while (!commandIndex.equals("0"));

    }

}


