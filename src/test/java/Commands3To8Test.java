import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Commands3To8Test {
    Map<String, Course> testCourseList = new LinkedHashMap<>();
    Map<String, Student> testStudentList = new LinkedHashMap<>();
    Map<String, Teacher> testTeacherList = new LinkedHashMap<>();
    Commands commandsInstance = new Commands(testCourseList, testStudentList, testTeacherList);

    @Test
    public void testShowCourses() {
        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Create sample data and add it to the coursesMap
        Course sampleCourse = new Course("Math", 100.0);
        testCourseList.put(sampleCourse.getCourseId(), sampleCourse);
        Course sampleCourse2 = new Course("Science", 150.0);
        testCourseList.put(sampleCourse2.getCourseId(), sampleCourse2);
        Course sampleCourse3 = new Course("History", 200.0);
        testCourseList.put(sampleCourse3.getCourseId(), sampleCourse3);

        // Call the method to be tested
        commandsInstance.ShowCourses();

        // Assert on the expected output
        String expectedOutput = "List of Courses: \n" +
                sampleCourse.getCourseId() + " : Math\n" +
                sampleCourse2.getCourseId() + " : Science\n" +
                sampleCourse3.getCourseId() + " : History\n";

        assertEquals(expectedOutput, outputStream.toString());

        // Reset System.out
        System.setOut(System.out);

        // Reset the testCourseList
        testCourseList.clear();
    }

    @Test
    void testLookupCourse() {

        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Create sample data and add it to the coursesMap
        Course sampleCourse = new Course("Math", 100.0);
        testCourseList.put(sampleCourse.getCourseId(), sampleCourse);
        Course sampleCourse2 = new Course("Science", 150.0);
        testCourseList.put(sampleCourse2.getCourseId(), sampleCourse2);
        Course sampleCourse3 = new Course("History", 200.0);
        testCourseList.put(sampleCourse3.getCourseId(), sampleCourse3);

        // Call the method to be tested
        commandsInstance.LookupCourse(sampleCourse.getCourseId());
        commandsInstance.LookupCourse(sampleCourse2.getCourseId());
        commandsInstance.LookupCourse(sampleCourse3.getCourseId());

        // Assert on the expected output
        String expectedOutput = "Course ID: " + sampleCourse.getCourseId() + "\nCourse Name: Math\nCourse Price: 100.0\nCourse Money Earned: 0.0\nCourse Teacher: No teacher assigned\n" +
                "Course ID: " + sampleCourse2.getCourseId() + "\nCourse Name: Science\nCourse Price: 150.0\nCourse Money Earned: 0.0\nCourse Teacher: No teacher assigned\n" +
                "Course ID: " + sampleCourse3.getCourseId() + "\nCourse Name: History\nCourse Price: 200.0\nCourse Money Earned: 0.0\nCourse Teacher: No teacher assigned\n";
        assertEquals(expectedOutput, outputStream.toString());


        // Reset System.out
        System.setOut(System.out);

        // Reset the testCourseList
        testCourseList.clear();
    }

    @Test
    void testShowStudents() {
        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Create sample data and add it to the testStudentList
        Student sampleStudent = new Student("John Doe", "123 Main St", "123@gmail.com");
        testStudentList.put(sampleStudent.getStudentId(), sampleStudent);
        Student sampleStudent2 = new Student("Jane Doe", "123 Main St", "234@gmailcom");
        testStudentList.put(sampleStudent2.getStudentId(), sampleStudent2);
        Student sampleStudent3 = new Student("John Smith", "123 Main St", "345@gmail.com");
        testStudentList.put(sampleStudent3.getStudentId(), sampleStudent3);


        // Call the method to be tested
        commandsInstance.ShowStudents();

        // Assert on the expected output
        String expectedOutput = "List of Students: \n" +
                sampleStudent.getStudentId() + " : John Doe\n" +
                sampleStudent2.getStudentId() + " : Jane Doe\n" +
                sampleStudent3.getStudentId() + " : John Smith\n";

        assertEquals(expectedOutput, outputStream.toString());

        // Reset System.out
        System.setOut(System.out);

        // Reset the testStudentList
        testStudentList.clear();
    }

    @Test
    void testLookupStudent() {
        // Create sample data and add it to the testStudentList
        Student sampleStudent = new Student("John Doe", "123 Main St", "john@example.com");
        testStudentList.put(sampleStudent.getStudentId(), sampleStudent);
        Student sampleStudent2 = new Student("Jane Doe", "123 Main St", "jane@example.com");
        testStudentList.put(sampleStudent2.getStudentId(), sampleStudent2);
        Student sampleStudent3 = new Student("John Smith", "123 Main St", "johnS@example.com");
        testStudentList.put(sampleStudent3.getStudentId(), sampleStudent3);

        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the method to be tested
        commandsInstance.LookupStudent(sampleStudent.getStudentId());
        commandsInstance.LookupStudent(sampleStudent2.getStudentId());
        commandsInstance.LookupStudent(sampleStudent3.getStudentId());

        // Assert on the expected output
        String expectedOutput = "Student ID: " + sampleStudent.getStudentId() + "\nStudent Name: John Doe\nStudent Address: 123 Main St\nStudent Email: john@example.com\nStudent Course: No course enrolled\n"
                + "Student ID: " + sampleStudent2.getStudentId() + "\nStudent Name: Jane Doe\nStudent Address: 123 Main St\nStudent Email: jane@example.com\nStudent Course: No course enrolled\n" +
                "Student ID: " + sampleStudent3.getStudentId() + "\nStudent Name: John Smith\nStudent Address: 123 Main St\nStudent Email: johnS@example.com\nStudent Course: No course enrolled\n";
        assertEquals(expectedOutput, outputStream.toString());

        // Reset System.out
        System.setOut(System.out);

        // Reset the testStudentList
        testStudentList.clear();
    }

    @Test
    void testShowTeachers() {
        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Create sample data and add it to the testTeacherList
        Teacher sampleTeacher = new Teacher("Prof. Smith", 5000.0);
        testTeacherList.put(sampleTeacher.getTeacherId(), sampleTeacher);
        Teacher sampleTeacher2 = new Teacher("Prof. Doe", 6000.0);
        testTeacherList.put(sampleTeacher2.getTeacherId(), sampleTeacher2);
        Teacher sampleTeacher3 = new Teacher("Prof. Johnson", 7000.0);
        testTeacherList.put(sampleTeacher3.getTeacherId(), sampleTeacher3);

        // Call the method to be tested
        commandsInstance.ShowTeachers();

        // Assert on the expected output
        String expectedOutput = "List of Teachers: \n" +
                sampleTeacher.getTeacherId() + " : Prof. Smith\n" +
                sampleTeacher2.getTeacherId() + " : Prof. Doe\n" +
                sampleTeacher3.getTeacherId() + " : Prof. Johnson\n";

        assertEquals(expectedOutput, outputStream.toString());

        // Reset System.out
        System.setOut(System.out);

        // Reset the testTeacherList
        testTeacherList.clear();
    }

    @Test
    void testLookupTeacher() {
        // Create sample data and add it to the testTeacherList
        Teacher sampleTeacher = new Teacher("Prof. Smith", 5000.0);
        testTeacherList.put(sampleTeacher.getTeacherId(), sampleTeacher);
        Teacher sampleTeacher2 = new Teacher("Prof. Doe", 6000.0);
        testTeacherList.put(sampleTeacher2.getTeacherId(), sampleTeacher2);
        Teacher sampleTeacher3 = new Teacher("Prof. Johnson", 7000.0);
        testTeacherList.put(sampleTeacher3.getTeacherId(), sampleTeacher3);

        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the method to be tested
        commandsInstance.LookupTeacher(sampleTeacher.getTeacherId());
        commandsInstance.LookupTeacher(sampleTeacher2.getTeacherId());
        commandsInstance.LookupTeacher(sampleTeacher3.getTeacherId());

        // Assert on the expected output
        String expectedOutput = "Teacher ID: " + sampleTeacher.getTeacherId()+ "\nTeacher Name: Prof. Smith\nTeacher Salary: 5000.0\n"
                + "Teacher ID: " + sampleTeacher2.getTeacherId()+ "\nTeacher Name: Prof. Doe\nTeacher Salary: 6000.0\n"
                + "Teacher ID: " + sampleTeacher3.getTeacherId()+ "\nTeacher Name: Prof. Johnson\nTeacher Salary: 7000.0\n";
        assertEquals(expectedOutput, outputStream.toString());

        // Reset System.out
        System.setOut(System.out);

        // Reset the testTeacherList
        testTeacherList.clear();
    }

}
