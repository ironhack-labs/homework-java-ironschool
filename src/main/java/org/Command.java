package org;

import java.util.List;

import static org.School.getCourseById;

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

    public void assignTeacher(String teacherId, String courseId){
        //find course by id, getCourseMap() tiene que ser static
        Course course = getCourseById(courseId, School.getCourseMap());
        //find teacher by teacher id, getTeacherMap() tiene que ser static
        Teacher teacher = getTeacherById(teacherId, School.getTeacherMap());
        //set teacher to course
        if(course == null){
            System.out.println("Course doesn't exist");
        } else {
            course.setTeacher(teacher);
        }
    }



    public List<Course> showCourses(){}

    public List<Student> showStudents(){}

    public List<Teacher> showTeachers(){}

    public Course lookupCourse(String courseId){}

    public Student lookupStundent(String studentId){}

    public Teacher lookupTeacher(String teacherId){}

    public double showProfit(){}




}
