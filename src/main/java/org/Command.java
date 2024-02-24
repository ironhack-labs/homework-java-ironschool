package org;

import java.util.List;

public class Command {
    public void displayCommands(){
        System.out.println("1. Enroll a new student");
        System.out.println("2. Assign teacher to a course");
        System.out.println("3. See all courses");
        System.out.println("4. Search for a specific course");
        System.out.println("5. See all students");
        System.out.println("6. Search for a specific student");
        System.out.println("7. See all teachers");
        System.out.println("8. Search for a specific teacher");
        System.out.print("Enter your choice: ");
    }

    public void enrollStudent(String studentId, String courseId){}

    public void assignTeacher(String teacherId, String courseId){}

    public List<Course> showCourses(){}

    public List<Student> showStudents(){}

    public List<Teacher> showTeachers(){}

    public Course lookupCourse(String courseId){}

    public Student lookupStundent(String studentId){}

    public Teacher lookupTeacher(String teacherId){}

    public double showProfit(){}




}
