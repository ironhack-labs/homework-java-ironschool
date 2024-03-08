package org;

import java.util.UUID;

public class Student {
    private String studentId;
    private String name;
    private String address;
    private String email;
    private Course course;
    private static int idCounter = 1;

    // Constructor
    public Student(String name, String address, String email) {
        assignCourseId();
        setName(name);
        setAddress(address);
        setEmail(email);
    }

    private void assignCourseId(){
        this.studentId = "C" + String.valueOf(idCounter++);
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

    public Course getCourse() {
        return course;
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

    public void setCourse(Course course) {
        this.course = course;
    }

    // Helper
    public String getInfo() {
        return("Student - ID: " + this.studentId + " | Name: " + getName() +
                " | Address: " + getAddress() + " | Email: " + getEmail());
    }
}