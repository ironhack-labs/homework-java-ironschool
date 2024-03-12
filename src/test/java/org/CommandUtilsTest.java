package org;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import static org.CommandUtils.*;

import static org.CommandUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommandUtilsTest {


    private static List<Teacher> listTeacher;
    private static List<Course> listCourse;
    private static List<Student> listStudent;

    private static School school;

    @BeforeAll
    static void setUp(){
        listTeacher = new ArrayList<>();
        listTeacher.add(new Teacher("Victoria", 1000));
        listTeacher.add(new Teacher("Katia", 1500));
        listTeacher.add(new Teacher("Arturo", 1200));
        listCourse = new ArrayList<>();
        listCourse.add(new Course("math", 340, 34));
        listCourse.add(new Course("history", 500, 34));
        listStudent = new ArrayList<>();
        listStudent.add(new Student("Anna", "street 1", "anna@gmail.com"));
        listStudent.add(new Student("Julia", "street 2", "julia@gmail.com"));

        school = new School("school", listTeacher, listCourse, listStudent);
    }

    @Test
    @DisplayName("Check getStudentById method")
    void getStudentByIdTest(){
        Student student = new Student("Anna", "street 1", "anna@gmail.com");
        assertEquals(student, getStudentById(school.getStudentMap(), "S1"));
    }

    @Test
    @DisplayName("Check getTeacherById method")
    void getTeacherByIdTest(){
        Teacher teacher = new Teacher("Katia", 1500);
        assertEquals(teacher, getTeacherById(school.getTeacherMap(), "T2"));
    }

    @Test
    @DisplayName("Check getCourseById method")
    void getCourseByIdTest(){
        Course course = new Course("math", 340, 34);
        assertEquals(course, getCourseById(school.getCourseMap(), "C1"));
    }

    @Test
    @DisplayName("Check looUpStudent command with invalid ID")
    void looUpStudentTest(){
        assertThrows(IllegalArgumentException.class, () -> {
            lookUpStudent(school.getStudentMap(), "invalidID");
        });
    }

    @Test
    @DisplayName("Check looUpTeacher command with invalid ID")
    void looUpTeacherTest(){
        assertThrows(IllegalArgumentException.class, () -> {
            lookUpTeacher(school.getTeacherMap(), "invalidID");
        });
    }

    @Test
    @DisplayName("Check looUpCourse command with invalid ID")
    void looUpCourseTest(){
        assertThrows(IllegalArgumentException.class, () -> {
            lookUpCourse(school.getCourseMap(), "invalidID");
        });
    }
}
