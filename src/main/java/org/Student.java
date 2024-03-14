package org;


import java.util.Objects;

import java.util.ArrayList;
import java.util.List;

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

    public Course getCourse() {return course;}
    public void removeCourse(){this.course = null;}



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





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return Objects.equals(getName(), student.getName()) && Objects.equals(getAddress(), student.getAddress()) && Objects.equals(getEmail(), student.getEmail()) && Objects.equals(getCourse(), student.getCourse());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAddress(), getEmail(), getCourse());
    }


    public String getInfo() {
        String name = getName().length() > 17 ? getName().substring(0, 16) + " ." : getName();
        String address = getAddress().length() > 17 ? getAddress().substring(0, 16) + " ." : getAddress();
        String email = getEmail().length() > 17 ? getEmail().substring(0, 16) + " ." : getEmail();
        String courseName = "";
        if(course != null){
            courseName = getCourse().getName().length() > 17 ? getCourse().getName().substring(0, 16) + " ." : getCourse().getName();
        }
        return String.format(" %-4s│ %-18s │ %-18s │ %-18s │ %-18s ",
                studentId, name, address, email, courseName);

//        if(enrolledCourses.isEmpty()){
//            return "Student - ID: " + this.studentId + " | Name: " + getName() +
//                    " | Address: " + getAddress() + " | Email: " + getEmail();
//        } else {
//            return "Student - ID: " + this.studentId + " | Name: " + getName() +
//                    " | Address: " + getAddress() + " | Email: " + getEmail()
//                    + " | Enrolled in: " + getInfoCourses();
//        }

    }


}