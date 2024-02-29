package org;

import org.Teacher;

import java.util.List;

public class Course {
    private String courseId;
    private String name;
    private double price;
    private double money_earned;
    private Teacher teacher;
    private static int idCounter = 1;
    private static final double MIN_PRICE = 100;
    private static final double MAX_PRICE = 1000;

    public Course(String name, double price, double money_earned, Teacher teacher) {
        assignCourseId();
        setName(name);
        setPrice(price);
        this.money_earned = 0;
        //setMoney_earned(money_earned);//no se asigna manualmente
        setTeacher(teacher);
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
        if(isValidPrice(price)){
            this.price = price;
        } else {
            System.out.println("Price should be between " + MIN_PRICE +" and " + MAX_PRICE);
        }
    }

    private boolean isValidPrice(double price){
        return !(price < MIN_PRICE) && !(price > MAX_PRICE);
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
    //se llama desde otra clase cada vez que se asigna un student
    public void updateMoney_earned(double money_earned) {
        this.money_earned = money_earned;
    }

    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }

    public Teacher getTeacher(){
        return this.teacher;
    }



    public String getInfo(){
        return "Course - ID: " + getCourseId() + " | Name: "
                + getName() + " | Price: " + getPrice() + "$"
                + " | Total earned: " + getMoney_earned() + "$"
                + " | Taught by: " + getTeacher();
        //falta añadir getter del name del Teacher
    }

    // TODO - move to Utils
    public static String getAllCourses(List<Course> courseList){
        StringBuilder allCoursesInfo = new StringBuilder();
        for (Course course : courseList) {
            allCoursesInfo.append(course.getInfo()).append("\n");
        }

        return allCoursesInfo.toString();

    }
}

