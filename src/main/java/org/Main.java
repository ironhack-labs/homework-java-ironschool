package org;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("iron shchool");
        String schoolName = "";
        Scanner scanner = new Scanner(
                System.in
        );
        System.out.println("Hi!");
        System.out.println("Welcome to the School Manager Tool.");
        System.out.println(printBlue("Please, text the name for your school:"));
        schoolName = scanner.nextLine();
        System.out.println("Perfect, we have created the school: " + printPurple(schoolName));
        itemCreator("teacher", schoolName);
        itemCreator("course", schoolName);
        itemCreator("student", schoolName);
        scanner.close();







        int choiceMenu;
        Command command = new Command();

        do{

            command.displayCommands();
            choiceMenu = scanner.nextInt();
            String studentId;
            String courseId;
            String teacherId;

            switch(choiceMenu){
                case 1:
                    System.out.println(printBlue("Enter the id of the student:"));
                    scanner.nextLine();
                    studentId = scanner.nextLine();

                    System.out.println(printBlue("Enter the id of the course:"));
                    scanner.nextLine();
                    courseId = scanner.nextLine();

                    try{
                        command.enrollStudent(studentId, courseId);

                        System.out.println(printPurple("Congratulations! Your student has been successfully enrolled to the course."));

                    }catch(IllegalArgumentException e){
                        System.out.println("Error: "+e.getMessage());

                    }

                    break;
                case 2:
                    System.out.println(printBlue("Enter the id of the teacher:"));
                    scanner.nextLine();
                    teacherId = scanner.nextLine();

                    System.out.println(printBlue("Enter the id of the course:"));
                    scanner.nextLine();
                    courseId = scanner.nextLine();

                    try{
                        command.assignTeacher(teacherId, courseId);

                        System.out.println(printPurple("Congratulations! Your teacher has been successfully assigned to the course."));

                    }catch(IllegalArgumentException e){
                        System.out.println("Error: "+e.getMessage());

                    }

                    break;
                case 3:
                    try{

                        // TODO check como se definio esta funcion e implementarla - Victoria
                       // System.out.println(printPurple(command.showCourses()));


                    }catch(IllegalArgumentException e){
                        System.out.println("Error: "+e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println(printBlue("Enter the id of the course:"));
                    scanner.nextLine();
                    courseId = scanner.nextLine();

                    try{
                        Course course = command.lookupCourse(courseId);

                        // TODO check como se definio esta funcion e implementarla - Victoria

                        //TODO Agregar un esperando o buscando? - Victoria
                        //System.out.println(printPurple(course));

                    }catch(IllegalArgumentException e){
                        System.out.println("Error: "+e.getMessage());
                    }
                    break;
                case 5:
                    try{
                        // TODO check como se definio esta funcion e implementarla - Victoria

                        //System.out.println(printPurple(showStudents()));
                    }catch(IllegalArgumentException e){
                        System.out.println("Error: "+e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println(printBlue("Enter the id of the student:"));
                    scanner.nextLine();
                    studentId = scanner.nextLine();

                    try{
                        Student student = command.lookupStundent(studentId);
                        // TODO check como se definio esta funcion e implementarla - Victoria

                        //System.out.println(printPurple(student));

                    }catch(IllegalArgumentException e){
                        System.out.println("Error: "+e.getMessage());
                    }
                    break;
                case 7:
                    try{
                        // TODO check como se definio esta funcion e implementarla - Victoria
                        //System.out.println(printPurple(showTeachers()));
                    }catch(IllegalArgumentException e){
                        System.out.println("Error: "+e.getMessage());
                    }
                    break;
                case 8:
                    System.out.println(printBlue("Enter the id of the teacher:"));
                    scanner.nextLine();
                    teacherId = scanner.nextLine();

                    try{
                        Teacher teacher = command.lookupTeacher(teacherId);
                        //System.out.println(printPurple(teacher));

                    }catch(IllegalArgumentException e){
                        System.out.println("Error: "+e.getMessage());
                    }
                    break;
                case 9:
                    System.out.println("Closing program.");
                    scanner.close();
                    break;
            }

        }while(choiceMenu != 9);

    }
    private static void itemCreator(String type, String schoolName) {
        boolean is_num = false;
        int totalItems = 0;
        Scanner scanner = new Scanner(
                System.in
        );
        while (!is_num) {
            System.out.println(printBlue("How many " + type + "s are in " + schoolName + "?"));
            try {
                totalItems = scanner.nextInt();
                scanner.nextLine();
                if (totalItems > 0) {
                    System.out.println("Perfect, let's create now each " + type);
                    for (int i = 0; i < totalItems; i++) {
                        System.out.println("Execute " + type + "Creator " + (i+1));
                    }
                    System.out.println("Perfect, we have created all the " + type + "s.");
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
    private static String printBlue(String text) {
        return ConsoleColors.BLUE + text + ConsoleColors.RESET;
    }
    private static String printPurple(String text) {
        return ConsoleColors.PURPLE + text + ConsoleColors.RESET;
    }
}