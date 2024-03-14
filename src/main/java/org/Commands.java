package org;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static org.Command.*;
import static org.Command.showProfit;
import static org.CommandAddNewItem.*;
import static org.CommandUtils.*;
import static org.PrintUtils.*;
import static org.PrintUtils.printYellow;

public class Commands {

    public static void menuCommands (School school){
        Scanner scanner = new Scanner(System.in);
        int choiceMenu;
        do{

            displayCommands();
            choiceMenu = scanner.nextInt();
            String studentId;
            String courseId;
            String teacherId;

            switch(choiceMenu){
                case 1:

                    System.out.println("These are all the students that join "+ printPurple(school.getName())+" school:");
                    showAllStudents(school.getStudentMap());

                    System.out.println(printBlue("Enter the id of the student:"));
                    scanner.nextLine();
                    studentId = scanner.nextLine();
                    System.out.println("\nThese are all the courses available: ");
                    showAllCourses(school.getCourseMap());

                    System.out.println(printBlue("\nEnter the id of the course:"));
                    courseId = scanner.nextLine();
                    System.out.println(printBlueBold("Please wait, enrolling student...\n \n"));

                    try{
                        enrollStudent(studentId, courseId, school);
                        System.out.println(printYellow("Congratulations! Your student has been successfully enrolled to the course:\n"));
                    }catch(IllegalArgumentException e){
                        System.out.println(printRed("Error: "+e.getMessage()));
                    }

                    break;
                case 2:
                    System.out.println("These are all the teachers that work for "+printPurple(school.getName())+" school:");
                    showAllTeachers(school.getTeacherMap());

                    System.out.println(printBlue("\n Enter the id of the teacher:"));
                    scanner.nextLine();
                    teacherId = scanner.nextLine();

                    System.out.println("\n These are all the courses available");
                    showAllCourses(school.getCourseMap());
                    System.out.println(printBlue("\n Enter the id of the course:"));
                    courseId = scanner.nextLine();
                    System.out.println(printBlueBold("Please wait, assigning teacher to the course... \n \n"));
                    try{
                        assignTeacher(teacherId, courseId, school);
                        System.out.println(printYellow("Congratulations! Your teacher has been successfully assigned to the course."));

                    }catch(IllegalArgumentException e){
                        System.out.println("Error: "+e.getMessage());
                    }

                    break;
                case 3:
                    try{
                        System.out.println("\n These are all the courses available:");
                        showAllCourses(school.getCourseMap());

                    }catch(IllegalArgumentException e){
                        System.out.println(printRed("Error: "+e.getMessage()));
                    }
                    break;
                case 4:
                    System.out.println(printBlue("Enter the id of the course:"));
                    scanner.nextLine();
                    courseId = scanner.nextLine();

                    try{
                        lookUpCourse(school.getCourseMap(),courseId);
                    }catch(IllegalArgumentException e){
                        System.out.println("Error: "+e.getMessage());
                    }
                    break;
                case 5:
                    try{
                        System.out.println("These are all the students enrolled:");
                        showAllStudents(school.getStudentMap());
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
                        lookUpStudent(school.getStudentMap(),studentId);
                    }catch(IllegalArgumentException e){
                        System.out.println("Error: "+e.getMessage());
                    }
                    break;
                case 7:
                    try{
                        System.out.println("These are all the teachers that work at the school:");
                        showAllTeachers(school.getTeacherMap());
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
                        lookUpTeacher(school.getTeacherMap(), teacherId);
                    }catch(IllegalArgumentException e){
                        System.out.println("Error: "+e.getMessage());
                    }
                    break;
                case 9:
                    double profit = showProfit(school);
                    System.out.println(printYellow("The profit of the school is ") + printPurple(String.valueOf(profit))+"\n");
                    break;
                case 10:
                    addNewCourse(school);
                    break;
                case 11:
                    addNewStudent(school);
                    break;
                case 12:
                    addNewTeacher(school);
                    break;
                case 13:
                    System.out.println("These are all the courses available");
                    showAllCourses(school.getCourseMap());
                    System.out.println("");
                    System.out.println(printBlue("Enter the id of the course:"));
                    scanner.nextLine();
                    courseId = scanner.nextLine();
                    System.out.println("Please wait, removing teacher from course.");
                    System.out.println("");
                    System.out.println("");
                    try{
                        Course course = CommandUtils.getCourseById(school.getCourseMap(), courseId);
                        String printTeacher = (course != null && course.getTeacher() != null)
                                ? course.getTeacher().getName()
                                : null;

                        removeTeacherFromCourse(courseId, school);

                        System.out.println(printYellow("Congratulations! "
                                + printTeacher
                                + " has been successfully removed from "
                                + CommandUtils.getCourseById(school.getCourseMap(), courseId).getName()  + "."));

                    }catch(IllegalArgumentException e){
                        System.out.println("Error: "+e.getMessage());
                    }
                    break;
                case 14:
                    System.out.println("These are all the students that join "+school.getName()+" school.");
                    showAllStudents(school.getStudentMap());
                    System.out.println("");
                    System.out.println(printBlue("Enter the id of the student:"));
                    scanner.nextLine();

                    studentId = scanner.next();
                    System.out.println("");

                    try{
                        System.out.println("These are all the courses available:");
                        showAllCourses(school.getCourseMap());
                        System.out.println("");
                        System.out.println(printBlue("Enter the id of the course:"));
                        scanner.nextLine();
                        courseId = scanner.nextLine();
                        System.out.println("Please wait, removing student from course.");
                        System.out.println("");
                        System.out.println("");
                        Student student = getStudentById(school.getStudentMap(), studentId);
                        Course course = getCourseById(school.getCourseMap(), courseId);
                        String printStudent = (course != null && student != null)
                                ? student.getName()
                                : null;
                        unenrollStudent(studentId, courseId, school);
                        System.out.println(printYellow("Congratulations! "
                                + printPurple(printStudent)
                                + " has been successfully unrolled from "
                                + printPurple(getCourseById(school.getCourseMap(), courseId).getName()  + ".")));
                    }catch(IllegalArgumentException e){
                        System.out.println(printRed("Error: "+e.getMessage()));
                    }
                    break;
                case 15:
                    System.out.println("These are all the students that join "+printPurple(school.getName())+" school.");
                    showAllStudents(school.getStudentMap());
                    System.out.println("");

                    int numberStudents = 0;
                    int maxStudents = school.getStudentMap().size();

                    while (true) {
                        try {
                            System.out.println(printBlue("How many students do you want to add?"));
                            numberStudents = scanner.nextInt();

                            if (numberStudents > 0 && numberStudents <= maxStudents) {
                                scanner.nextLine();
                                break;
                            } else {
                                throw new IllegalArgumentException(printRed("Error: Number of students to add must be greater than 0 and less or equal to " + maxStudents));
                            }
                        } catch (InputMismatchException e) {
                            scanner.nextLine();
                            System.err.println(printRed("Oops! You need to enter a valid number."));
                        } catch (IllegalArgumentException e) {
                            scanner.nextLine();
                            System.err.println(e.getMessage());
                        }
                    }

                    List<String> studentList = new ArrayList<>();
                    for (int i = 0; i < numberStudents; i++) {
                        System.out.println(printBlue("Enter the id of the student:"));
                        studentId = scanner.nextLine();
                        studentList.add(studentId);
                    }

                    System.out.println("These are all the courses available:");
                    showAllCourses(school.getCourseMap());
                    System.out.println("");
                    System.out.println(printBlue("Enter the id of the course:"));
                    courseId = scanner.nextLine();
                    System.out.println(printBlueBold("Please wait, enrolling students..."));
                    System.out.println("");
                    System.out.println("");
                    try{
                        enrollStudents(studentList, courseId, school);

                        System.out.println(printYellow("Congratulations! Your students have been successfully enrolled to "
                                + CommandUtils.getCourseById(school.getCourseMap(), courseId).getName()  + "."));

                        System.out.println("");
                    }catch(IllegalArgumentException e){
                        System.out.println("Error: "+e.getMessage());
                    }
                    break;
                case 16:
                    System.out.println(printYellow("Closing program."));
                    scanner.close();
                    break;
            }
        }while(choiceMenu != 16);

    }

}
