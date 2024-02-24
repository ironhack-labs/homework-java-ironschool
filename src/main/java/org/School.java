package org;
import java.util.List;

public class School {
    private String name;
    private List<Course> listCourse;

    private List<Teacher> listTeacher;

    private List<Student> listStudent;

    public School(String name, List<Course> listCourse, List<Teacher> listTeacher, List<Student> listStudent) {
        setName(name);
        setListCourse(listCourse);
        setListTeacher(listTeacher);
        setListStudent(listStudent);
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setListCourse(List<Course> listCourse) {
        this.listCourse = listCourse;
    }
    public void setListTeacher(List<Teacher> listTeacher) {
        this.listTeacher = listTeacher;
    }
    public void setListStudent(List<Student> listStudent) {
        this.listStudent = listStudent;
    }

    public String getName() {
        return this.name;
    }
    public List<Course> getListCourse() {
        return this.listCourse;
    }
    public List<Teacher> getListTeacher() {
        return this.listTeacher;
    }
    public List<Student> getListStudent() {
        return this.listStudent;
    }
}
