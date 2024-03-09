package org;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.Command.assignTeacher;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList; // Import ArrayList class from java.util package

class CommandTest {

    Command command;
    School school;

    @BeforeEach
    void setUp(){
        command = new Command();
        school = new School("test2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

    }

   /* @Test
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
        course = assignTeacher(teacher.getTeacherId(), course.getCourseId(), school);
        assertEquals("Juan", course.getTeacher().getName());

    }
}
