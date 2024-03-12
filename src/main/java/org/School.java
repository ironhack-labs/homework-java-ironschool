package org;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class School {
    private String name;
    LinkedHashMap<String, Course> courseMap;
    LinkedHashMap<String, Teacher> teacherMap;
    LinkedHashMap<String, Student> studentMap;


    public School(String name, List<Teacher> listTeacher, List<Course> listCourse, List<Student> listStudent) {
        setName(name);
        setHashmapTeacher(listTeacher);
        setHashmapCourse(listCourse);
        setHashmapStudent(listStudent);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHashmapTeacher(List<Teacher> listTeacher) {
        teacherMap = new LinkedHashMap<>();
        for (Teacher teacher : listTeacher){
            teacherMap.put(teacher.getTeacherId(), teacher);
        }
    }
    public void setHashmapCourse(List<Course> listCourse) {
        courseMap = new LinkedHashMap<>();
        for (Course course : listCourse){
            courseMap.put(course.getCourseId(), course);
        }
    }
    public void setHashmapStudent(List<Student> listStudent) {
        studentMap = new LinkedHashMap<>();
        for (Student student : listStudent){
            studentMap.put(student.getStudentId(), student);
        }
    }

    public String getName() {
        return this.name;
    }
    public LinkedHashMap<String, Course> getCourseMap() {
        return this.courseMap;
    }
    public LinkedHashMap<String, Teacher> getTeacherMap() {
        return this.teacherMap;
    }

    public LinkedHashMap<String, Student> getStudentMap() {
        return this.studentMap;
    }
}
