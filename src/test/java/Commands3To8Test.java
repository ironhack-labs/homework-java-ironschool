import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Commands3To8Test {
    @Test
    void testShowCourses() {
        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the method to be tested
        Commands.ShowCourses();

        // Assert on the expected output
        String expectedOutput = "List of Courses: \n"; // Add expected course information here
        assertEquals(expectedOutput, outputStream.toString());

        // Reset System.out
        System.setOut(System.out);
    }

    @Test
    void testLookupCourse() {
        // Create sample data and add it to the courseList
        Course sampleCourse = new Course("C101",  100.0);
        Commands.courseList.put("C101", sampleCourse);

        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the method to be tested
        Commands.LookupCourse("C101");

        // Assert on the expected output
        String expectedOutput = "Course ID: C101\nCourse Name: Math\nCourse Price: 100.0\nCourse Money Earned: 0.0\nCourse Teacher: No teacher assigned\n";
        assertEquals(expectedOutput, outputStream.toString());

        // Reset System.out
        System.setOut(System.out);
    }

    @Test
    void testShowStudents() {
        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the method to be tested
        Commands.ShowStudents();

        // Assert on the expected output
        String expectedOutput = "List of Students: \n"; // Add expected student information here
        assertEquals(expectedOutput, outputStream.toString());

        // Reset System.out
        System.setOut(System.out);
    }

    @Test
    void testLookupStudent() {
        // Create sample data and add it to the studentList
        Student sampleStudent = new Student("S101", "John Doe", "123 Main St", "john@example.com");
        Commands.studentList.put("S101", sampleStudent);

        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the method to be tested
        Commands.LookupStudent("S101");

        // Assert on the expected output
        String expectedOutput = "Student ID: S101\nStudent Name: John Doe\nStudent Address: 123 Main St\nStudent Email: john@example.com\nStudent Course: No course enrolled\n";
        assertEquals(expectedOutput, outputStream.toString());

        // Reset System.out
        System.setOut(System.out);
    }

    @Test
    void testShowTeachers() {
        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the method to be tested
        Commands.ShowTeachers();

        // Assert on the expected output
        String expectedOutput = "List of Teachers: \n"; // Add expected teacher information here
        assertEquals(expectedOutput, outputStream.toString());

        // Reset System.out
        System.setOut(System.out);
    }

    @Test
    void testLookupTeacher() {
        // Create sample data and add it to the teacherList
        Teacher sampleTeacher = new Teacher("T101", "Prof. Smith", 5000.0);
        Commands.teacherList.put("T101", sampleTeacher);

        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the method to be tested
        Commands.LookupTeacher("T101");

        // Assert on the expected output
        String expectedOutput = "Teacher ID: T101\nTeacher Name: Prof. Smith\nTeacher Salary: 5000.0\n";
        assertEquals(expectedOutput, outputStream.toString());

        // Reset System.out
        System.setOut(System.out);
    }

}
