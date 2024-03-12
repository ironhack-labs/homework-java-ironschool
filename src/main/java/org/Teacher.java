package org;

import java.util.List;
import java.util.Objects;

public class Teacher {
    private String studentId;
    private String name;
    private double salary;
    private List<Course> courses;
    private static int idCounter = 1;

    public Teacher(String name, double salary) {
        assignTeacherId();
        setName(name);
        setSalary(salary);
    }

    public boolean getTeacherById(String idToCheck){
        return this.studentId.equals(idToCheck);
    }
    private void assignTeacherId(){
        this.studentId = "T" + String.valueOf(idCounter++);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String getTeacherId() {
        return this.studentId;
    }

    public String getName() {
        return this.name;
    }

    public double getSalary() {
        return this.salary;
    }

    public List<Course> getCourses() {
        return this.courses;
    }

    public void addCourseToTeacher(Course course){
        this.courses.add(course);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher teacher)) return false;
        return Double.compare(getSalary(), teacher.getSalary()) == 0 && Objects.equals(getName(), teacher.getName()) && Objects.equals(getCourses(), teacher.getCourses());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSalary(), getCourses());
    }

    public String getInfo() {
        String name = getName().length() > 16 ? getName().substring(0, 15) + " ." : getName();
        return String.format(" %-4s│ %-17s │ %-13s",
                getTeacherId(), name, getSalary());
    }
}