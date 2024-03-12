package org;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.Command.assignTeacher;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList; // Import ArrayList class from java.util package
import java.util.List;

class
CommandTest {

    Command command;
    School school;

    @BeforeEach
    void setUp(){
        command = new Command();
        school = new School("test2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

    }
/*
    @Test
    void testEnrollStudent() {
        Command command = new Command();

        // test if a student is already enrolled
        try {
            command.enrollStudent("S1", "C2");
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Student is already enrolled in the course.", e.getMessage());
        }
    }

    @Test
    void testShowProfit() {
        School school = new School("test", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Command command = new Command();

        // test if the showProfit method calculates correctly
        double profit = command.showProfit(school);
        assertEquals(0, profit);
    }

    */

    @Test
    void testAssignTeacher(){
        //School school = new School("test2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Teacher teacher = new Teacher("Juan", 2000);
        //asignar el teacher a school
        school.getTeacherMap().put(teacher.getTeacherId(), teacher);
        Course course = new Course("Ciencia", 500, 0);
        //asignar el course a school
        school.getCourseMap().put(course.getCourseId(), course);
        assertEquals("Ciencia", course.getName());
        Command.assignTeacher(teacher.getTeacherId(), course.getCourseId(), school);
        assertEquals("Juan", course.getTeacher().getName());
    }

    @Test
    void testRemoveTeacherFromCourse(){
        Teacher teacher = new Teacher("Juan", 2000);
        //asignar el teacher a school
        school.getTeacherMap().put(teacher.getTeacherId(), teacher);
        Course course = new Course("Mates", 100, 0);
        //asignar el course a school
        school.getCourseMap().put(course.getCourseId(), course);
        Command.assignTeacher(teacher.getTeacherId(), course.getCourseId(), school);
        Command.removeTeacherFromCourse(course.getCourseId(), school);
        assertNull(course.getTeacher());
    }

    @Test
    void testUnenrollStudent(){
        Student student = new Student("Pepe", "dirección", "email");
        school.getStudentMap().put(student.getStudentId(), student);
        Course course = new Course("Mates", 100, 0);
        //asignar el course a school
        school.getCourseMap().put(course.getCourseId(), course);
        Command.enrollStudent(student.getStudentId(), course.getCourseId(), school);
        assertFalse(student.getCourse().contains(student));
    }

    @Test
    void testIsStudentEnrolledInCourse(){
        Student student = new Student("Pepe", "dirección", "email");
        school.getStudentMap().put(student.getStudentId(), student);
        Course course = new Course("Mates", 100, 0);
        school.getCourseMap().put(course.getCourseId(), course);
        assertFalse(Command.isStudentEnrolledInCourse(student, course.getCourseId()));
        Command.enrollStudent(student.getStudentId(), course.getCourseId(), school);
        assertTrue(Command.isStudentEnrolledInCourse(student, course.getCourseId()));
    }

    @Test
    void testEnrollStudents(){
        List<String> studentList = new ArrayList<>();
        Student student1 = new Student("Pepe", "dirección", "email");
        Student student2 = new Student("María", "calle", "gmail");
        school.getStudentMap().put(student1.getStudentId(), student1);
        school.getStudentMap().put(student2.getStudentId(), student2);
        studentList.add(student1.getStudentId());
        studentList.add(student2.getStudentId());

        Course course = new Course("Mates", 100, 0);
        school.getCourseMap().put(course.getCourseId(), course);

        Command.enrollStudents(studentList, course.getCourseId(), school);
        assertTrue(student1.getCourse().contains(course));
        assertTrue(student2.getCourse().contains(course));
        assertTrue(Command.isStudentEnrolledInCourse(student1, course.getCourseId()));
        assertTrue(Command.isStudentEnrolledInCourse(student2, course.getCourseId()));


    }
}
