package org;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Student {
    private String studentId;
    private String name;
    private String address;
    private String email;
    //private Course course;
    private List<Course> enrolledCourses;
    private static int idCounter = 1;

    // Constructor
    public Student(String name, String address, String email) {
        assignCourseId();
        setName(name);
        setAddress(address);
        setEmail(email);
        enrolledCourses = new ArrayList<>();

    }

    private void assignCourseId(){
        this.studentId = "S" + String.valueOf(idCounter++);
    }

    // Getters
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }
    //añadido!!
    public List<Course> getCourse() {
        return enrolledCourses;
    }
    public void removeCourse(Course course){
        enrolledCourses.remove(course);
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //public void setCourse(Course course) {
        //this.course = course;
    //}
    public void addCourse(Course course){
        enrolledCourses.add(course);
    }

    // Helper
    //TODO - Agregar Courses info (extra)
    public String getInfo() {
        if(enrolledCourses.isEmpty()){
            return "Student - ID: " + this.studentId + " | Name: " + getName() +
                    " | Address: " + getAddress() + " | Email: " + getEmail();
        } else {
            return "Student - ID: " + this.studentId + " | Name: " + getName() +
                    " | Address: " + getAddress() + " | Email: " + getEmail()
                    + " | Enrolled in: " + getInfoCourses();
        }

    }

    public String getInfoCourses(){
        StringBuilder coursesInfo = new StringBuilder();

        for (Course course : enrolledCourses) {
            coursesInfo.append(course.getName()).append(", ");
        }

        // Remove the trailing comma and space
        if (coursesInfo.length() > 0) {
            coursesInfo.setLength(coursesInfo.length() - 2);
        }

        return coursesInfo.toString();
    }
}