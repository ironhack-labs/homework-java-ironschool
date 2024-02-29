package model;

import java.util.HashMap;
import java.util.Map;

public class SchoolBuilder {
    private String name;
    private Map<String, Teacher> teachers = new HashMap<>();
    private Map<String, Course> courses = new HashMap<>();
    private Map<String, Student> students = new HashMap<>();

    public SchoolBuilder name(String name) {
        this.name = name;
        return this;
    }

    public SchoolBuilder teachers(Map<String, Teacher> teachers) {
        this.teachers = teachers;
        return this;
    }

    public SchoolBuilder courses(Map<String, Course> courses) {
        this.courses = courses;
        return this;
    }

    public SchoolBuilder students(Map<String, Student> students) {
        this.students = students;
        return this;
    }

    public School build() {
        return new School(name, teachers, courses, students);
    }

}
