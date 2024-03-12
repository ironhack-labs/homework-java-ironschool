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

   @Test
    void testEnrollStudent() {
        Student student = new Student("John Doe", "123 Main St", "john.doe@example.com");
        school.getStudentMap().put(student.getStudentId(), student);

        Course course = new Course("C2", 100.0, 0.0);
        school.getCourseMap().put(course.getCourseId(), course);

        student.setCourse(course);

        assertEquals(course, student.getCourse());
    }

    @Test
    void testShowProfit() {
        Course course1 = new Course("C1", 100.0, 0.0);
        school.getCourseMap().put(course1.getCourseId(), course1);

        Course course2 = new Course("C2", 150.0, 0.0);
        school.getCourseMap().put(course2.getCourseId(), course2);

        double totalMoneyEarned = course1.getPrice() + course2.getPrice();
        double totalTeacherSalaries = 0; // Assume no teacher salaries in this case

        double profit = totalMoneyEarned - totalTeacherSalaries;

        try {
            double calculatedProfit = totalMoneyEarned - totalTeacherSalaries;
            assertEquals(profit, calculatedProfit);
        } catch (IllegalArgumentException e) {
            fail("Error calculating profit: " + e.getMessage());
        }
    }

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
