package org;

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
                    //TODO ponerle un color
                    System.out.println("These are all the students that join "+ school.getName()+" school.");
                    showAllStudents(school.getStudentMap());
                    System.out.println("");
                    System.out.println(printBlue("Enter the id of the student:"));
                    scanner.nextLine();
                    studentId = scanner.nextLine();
                    System.out.println("");
                    System.out.println("These are all the courses available:");
                    showAllCourses(school.getCourseMap());
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
                    System.out.println("These are all the teachers that work for "+school.getName()+" school.");
                    showAllTeachers(school.getTeacherMap());
                    System.out.println("");
                    System.out.println(printBlue("Enter the id of the teacher:"));
                    scanner.nextLine();
                    teacherId = scanner.nextLine();
                    System.out.println("");
                    System.out.println("These are all the courses available");
                    showAllCourses(school.getCourseMap());
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
                        showAllCourses(school.getCourseMap());
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
                    System.out.println(printYellow("The profit of the school is ") + printPurple(String.valueOf(profit)));
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

                    break;
                case 14:

                    break;
                case 15:

                    break;
                case 16:
                    System.out.println(printYellow("Closing program."));
                    scanner.close();
                    break;
            }
        }while(choiceMenu != 16);

    }

}
