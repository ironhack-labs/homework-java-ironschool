package org;

import org.Teacher;

import java.util.List;
import java.util.Objects;

public class Course {
    private String courseId;
    private String name;
    private double price;
    private double money_earned;
    private Teacher teacher = null;
    private static int idCounter = 1;

    public Course(String name, double price, double money_earned) {
        assignCourseId();
        setName(name);
        try {
            setPrice(price);
        } catch(IllegalArgumentException e){
            System.out.println("Error: "+e.getMessage());
        }
        setMoney_earned(0.0);
        setTeacher(null);
    }

    public String getCourseId() {
        return courseId;
    }

    private void assignCourseId() {
        this.courseId = "C" + String.valueOf(idCounter++);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Salary can not be negative value");
        } else {
            this.price = price;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(isValidName(name)){
            this.name = name;
        } else {
            System.out.println("Name has to be between 3 and 15 ");
        }

    }

    private boolean isValidName(String name){
        return name != null && name.length() >= 3 && name.length() <= 15;
    }

    public double getMoney_earned() {
        return money_earned;
    }
    public void updateMoney_earned(double money_earned) {
        this.money_earned = money_earned;
    }

    public void setMoney_earned(double money_earned) {
        this.money_earned = money_earned;
    }

    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }

    public Teacher getTeacher(){
        return this.teacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course course)) return false;
        return Double.compare(getPrice(), course.getPrice()) == 0 && Double.compare(getMoney_earned(), course.getMoney_earned()) == 0 && Objects.equals(getName(), course.getName()) && Objects.equals(getTeacher(), course.getTeacher());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice(), getMoney_earned(), getTeacher());
    }

    public String getInfo() {
        String name = getName().length() > 16 ? getName().substring(0, 15) + " ." : getName();
        String teacherName = "";
        if(teacher != null){
            teacherName = getTeacher().getName().length() > 16 ? getTeacher().getName().substring(0, 15) + " ." : getTeacher().getName();
        }
        return String.format(" %-4s│ %-17s │ %-13s│ %-17s ",
                courseId, name, getPrice(), teacherName);
    }
}

