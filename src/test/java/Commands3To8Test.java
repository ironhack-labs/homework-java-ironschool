import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Commands3To8Test {


    @Test
    void testShowCourses() {
        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Create sample data and add it to the coursesMap
        Map<String,Course> coursesMap = new HashMap<>();

        Course sampleCourse = new Course("Math", 100.0);
        coursesMap.put(sampleCourse.getCourseId(), sampleCourse);
        Course sampleCourse2 = new Course("Science", 150.0);
        coursesMap.put(sampleCourse2.getCourseId(), sampleCourse2);
        Course sampleCourse3 = new Course("History", 200.0);
        coursesMap.put(sampleCourse3.getCourseId(), sampleCourse3);

        // Call the method to be tested
        Commands.ShowCourses();

        // Assert on the expected output
        String expectedOutput = "List of Courses: \n" +
                sampleCourse.getCourseId() + " : Math\n" +
                sampleCourse2.getCourseId() + " : Science\n" +
                sampleCourse3.getCourseId() +" : History\n";

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

        // Create sample data and add it to the studentList
        Map<String, Student> studentList = new HashMap<>();
        Student sampleStudent = new Student("John Doe", "123 Main St", "123@gmail.com");
        studentList.put(sampleStudent.getStudentId(), sampleStudent);
        Student sampleStudent2 = new Student("Jane Doe", "123 Main St", "234@gmailcom");
        studentList.put(sampleStudent2.getStudentId(), sampleStudent2);
        Student sampleStudent3 = new Student("John  Smith", "123 Main St", "345@gmail.com");
        studentList.put(sampleStudent3.getStudentId(), sampleStudent3);


        // Call the method to be tested
        Commands.ShowStudents();

        // Assert on the expected output
        String expectedOutput = "List of Students: \n" +
                sampleStudent.getStudentId() + " : John Doe" +
                sampleStudent2.getStudentId() + " : Jane Doe" +
                sampleStudent3.getStudentId() + " : John Smith";

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

        // Create sample data and add it to the teacherList
        Map<String, Teacher> teacherList = new HashMap<>();
        Teacher sampleTeacher = new Teacher("Prof. Smith", 5000.0);
        teacherList.put(sampleTeacher.getTeacherId(), sampleTeacher);
        Teacher sampleTeacher2 = new Teacher("Prof. Doe", 6000.0);
        teacherList.put(sampleTeacher2.getTeacherId(), sampleTeacher2);
        Teacher sampleTeacher3 = new Teacher("Prof. Johnson", 7000.0);
        teacherList.put(sampleTeacher3.getTeacherId(), sampleTeacher3);

        // Call the method to be tested
        Commands.ShowTeachers();

        // Assert on the expected output
        String expectedOutput = "List of Teachers: \n" +
                sampleTeacher.getTeacherId() + " : Prof. Smith" +
                sampleTeacher2.getTeacherId() + " : Prof. Doe" +
                sampleTeacher3.getTeacherId() + " : Prof. Johnson";
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
