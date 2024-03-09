package org;
import java.util.*;

import static org.Command.*;
import static org.CommandUtils.*;

public class Main {
    public static void main(String[] args) {
        String schoolName = "";
        List<Teacher> teachers = new ArrayList<>();
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hi!");
        System.out.println("Welcome to the School Manager Tool.");

        System.out.println(printBlue("Please, text the name for your school:"));
        schoolName = scanner.nextLine();
        System.out.println("");
        System.out.println(printYellow("Perfect, we have created the school: ") + printPurple(schoolName));
        System.out.println("");

        itemCreator("teacher", schoolName, teachers, null);
        itemCreator("course", schoolName, courses, teachers);
        itemCreator("student", schoolName, students, null);
// TODO hay un bug en student - Se crea con id C1 en vez de S1 - lo cambie en el codigo pero hablarlo
        School school = new School(schoolName, teachers, courses, students);

        int choiceMenu;

        do{

            displayCommands();
            choiceMenu = scanner.nextInt();
            String studentId;
            String courseId;
            String teacherId;

            switch(choiceMenu){
                case 1:
                        //TODO ponerle un color
                        System.out.println("These are all the students that join "+schoolName+" school.");
                        showAll(school.getStudentMap());
                        System.out.println("");
                        System.out.println(printBlue("Enter the id of the student:"));
                        scanner.nextLine();
                        studentId = scanner.nextLine();
                        System.out.println("");
                        System.out.println("These are all the courses available");
                        showAll(school.getCourseMap());
                        System.out.println("");
                        System.out.println(printBlue("Enter the id of the course:"));
                        courseId = scanner.nextLine();
                        System.out.println("Please wait, enrolling student...");
                        
                        // TODO- tratar de poner un elapse time o algo para que espere.
                        System.out.println("");
                        System.out.println("");
                    try{
                        enrollStudent(studentId, courseId, school);
                        // TODO agregar el nombre del estudiante y curso en el print
                        // TODO enrolar multiples alumnos (extra)
                        System.out.println(printYellow("Congratulations! Your student has been successfully enrolled to the course."));
                        System.out.println("");
                    }catch(IllegalArgumentException e){
                        System.out.println("Error: "+e.getMessage());
                    }

                    break;
                case 2:
                    System.out.println("These are all the teachers that work for "+schoolName+" school.");
                    showAll(school.getTeacherMap());
                    System.out.println("");
                    System.out.println(printBlue("Enter the id of the teacher:"));
                    scanner.nextLine();
                    teacherId = scanner.nextLine();
                    System.out.println("");
                    System.out.println("These are all the courses available");
                    showAll(school.getCourseMap());
                    System.out.println("");
                    System.out.println(printBlue("Enter the id of the course:"));
                    courseId = scanner.nextLine();
                    System.out.println("Please wait, assigning teacher to the course.");
                    System.out.println("");
                    System.out.println("");
                    try{
                        assignTeacher(teacherId, courseId, school);
                        System.out.println(printYellow("Congratulations! Your teacher has been successfully assigned to the course."));

                    }catch(IllegalArgumentException e){
                        System.out.println("Error: "+e.getMessage());
                    }

                    break;
                case 3:
                    try{
                        System.out.println("These are all the courses available:");
                        showAll(school.getCourseMap());
                        System.out.println("");
                        System.out.println("");
                    }catch(IllegalArgumentException e){
                        System.out.println("Error: "+e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println(printBlue("Enter the id of the course:"));
                    scanner.nextLine();
                    courseId = scanner.nextLine();

                    try{
                        Course course = lookUpCourse(school.getCourseMap(),courseId);
                        System.out.println(course.getInfo());

                    }catch(IllegalArgumentException e){
                        System.out.println("Error: "+e.getMessage());
                    }
                    break;
                case 5:
                    try{
                        System.out.println("These are all the students enrolled:");
                        showAll(school.getStudentMap());
                        System.out.println("");
                        System.out.println("");
                    }catch(IllegalArgumentException e){
                        System.out.println("Error: "+e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println(printBlue("Enter the id of the student:"));
                    scanner.nextLine();
                    studentId = scanner.nextLine();

                    try{
                        Student student = lookUpStudent(school.getStudentMap(),studentId);
                        System.out.println(printPurple(student.getInfo()));

                    }catch(IllegalArgumentException e){
                        System.out.println("Error: "+e.getMessage());
                    }
                    break;
                case 7:
                    try{
                        System.out.println("These are all the teachers that work at the school:");
                        showAll(school.getTeacherMap());
                        System.out.println("");
                        System.out.println("");
                    }catch(IllegalArgumentException e){
                        System.out.println("Error: "+e.getMessage());
                    }
                    break;
                case 8:
                    System.out.println(printBlue("Enter the id of the teacher:"));
                    scanner.nextLine();
                    teacherId = scanner.nextLine();

                    try{
                        Teacher teacher = lookUpTeacher(school.getTeacherMap(), teacherId);
                        System.out.println(printPurple(teacher.getInfo()));

                    }catch(IllegalArgumentException e){
                        System.out.println("Error: "+e.getMessage());
                    }
                    break;
                case 9:
                    double profit = showProfit(school);
                    System.out.println(printYellow("The profit of the school is ") + printPurple(String.valueOf(profit)));
                    break;

                case 10:
                    System.out.println(printYellow("Closing program."));
                    scanner.close();
                    break;
            }

        }while(choiceMenu != 10);

    }

    private static void itemCreator(String type, String schoolName, List collection, List teachers) {
        boolean is_num = false;
        int totalItems = 0;
        Scanner scanner = new Scanner(System.in);

        while (!is_num) {
            System.out.println(printBlue("How many " + type + "s are in " + schoolName + "?"));
            try {
                totalItems = scanner.nextInt();
                scanner.nextLine();
                if (totalItems > 0) {
                    System.out.println("Okey, let's create now each " + type + ".");

                    for (int i = 0; i < totalItems; i++) {
                        System.out.println("");
                        System.out.println(type.toUpperCase() + " " + (i+1) + ":");
                        if (Objects.equals(type, "teacher")) {
                            teacherCreator(collection);
                        } else if(Objects.equals(type, "course")) {
                            courseCreator(collection, teachers);
                        } else if(Objects.equals(type, "student")) {
                            studentCreator(collection);
                        } else {
                            System.err.println("Type not valid.");
                        }
                    }
                    System.out.println("");
                    System.out.println(printYellow("Congratulations! We have created all the " + type + "s."));
                    System.out.println("");
                    is_num = true;
                } else {
                    System.err.println("Oops! You need to have at least one " + type + ".");
                }
            } catch (InputMismatchException ie) {
                scanner.nextLine();
                System.err.println("Oops! You need to enter a number.");
            }
        }
        is_num = false;
    }

    private static void teacherCreator(List teachers){
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
        teacher.getInfo();
        teachers.add(teacher);
    }

    private static void courseCreator(List courses, List<Teacher> teachers){
        boolean is_num = false;
        String name = "";
        double price = 00.00;
        int teacherSelection = 0;
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
        is_num = false;
        /*
        System.out.println(printBlue("Select an associated teacher:"));
        System.out.println("0 - No teacher associated");
        for (int i = 0; i < teachers.size(); i++) {
            System.out.println((i+1) + " - " + teachers.get(i).getName() + " (" + teachers.get(i).getSalary() + "€)");
        }

        while (!is_num) {
            try {
                teacherSelection = scanner.nextInt();
                scanner.nextLine();
                is_num = true;
            } catch (InputMismatchException ie) {
                scanner.nextLine();
                System.err.println("Oops! You need to enter a number.");
            }
        }

        Course course = null;
        if (teacherSelection == 0) {
            // course = new Course(name, price, (double) 0);
        } else {
            course = new Course(name, price, (double) 0);
        }
        */
        // TODO added por victoria porque petaba
        Course course = new Course(name, price, (double) 0);
        //course.getInfo();
        courses.add(course);
    }

    private static void studentCreator(List students){
        String name = "";
        String address = "";
        String email = "";
        Scanner scanner = new Scanner(System.in);

        System.out.println(printBlue("Enter student name:"));
        name = scanner.nextLine();
        System.out.println(printBlue("Enter student adress:"));
        address = scanner.nextLine();
        System.out.println(printBlue("Enter student email:"));
        email = scanner.nextLine();

        Student student = new Student(name, address, email);
        student.getInfo();
        students.add(student);
    }

    private static String printBlue(String text) {
        return ConsoleColors.BLUE + text + ConsoleColors.RESET;
    }

    private static String printPurple(String text) {
        return ConsoleColors.PURPLE + text + ConsoleColors.RESET;
    }

    private static String printYellow(String text) {
        return ConsoleColors.YELLOW + text + ConsoleColors.RESET;
    }
}