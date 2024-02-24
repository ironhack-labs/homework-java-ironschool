package model;

import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode
public class Course {

    private final String courseId;
    private String name;
    private double price;
    private double money_earned;
    private Teacher teacher;

    public Course(String name, double price) {
        courseId = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
    }

}
