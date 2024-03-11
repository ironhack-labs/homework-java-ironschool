import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Command9to10Test {
    Map<String, Course> testCourseList = new LinkedHashMap<>();
    Map<String, Student> testStudentList = new LinkedHashMap<>();
    Map<String, Teacher> testTeacherList = new LinkedHashMap<>();
    Commands commandsInstance = new Commands(testCourseList, testStudentList, testTeacherList);
    Course sampleCourse;
    Teacher sampleTeacher;
    ByteArrayOutputStream outputStream;
    Student sampleStudent;

    @BeforeEach
    public void setUp() {
        // Redirect System.out to capture the output
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Create sample data and add it to the coursesMap
        sampleCourse = new Course("Math", 200.0);
        testCourseList.put(sampleCourse.getCourseId(), sampleCourse);

        // Create sample data and add it to the teachersMap
        sampleTeacher = new Teacher("Prof. Smith", 500.0);
        testTeacherList.put(sampleTeacher.getTeacherId(), sampleTeacher);

        // Create sample data and add it to the testStudentList
        sampleStudent = new Student("John Smith", "123 Main St", "johnS@example.com");
        testStudentList.put(sampleStudent.getStudentId(), sampleStudent);
    }

    @Test
    public void testShowProfitPositive() {
        // Assign Teacher to Course
        sampleCourse.setTeacher(sampleTeacher);

        // SetMoneyEarned
        sampleCourse.setMoney_earned(1000);

        // Call the method to be tested
        commandsInstance.ShowProfit();

        // Assert on the expected output
        String expectedOutput = "Total profit: " + 500.0 + "€\n";

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testShowProfitNegative() {
        // Assign Teacher to Course
        sampleCourse.setTeacher(sampleTeacher);

        // SetMoneyEarned
        sampleCourse.setMoney_earned(100);

        // Call the method to be tested
        commandsInstance.ShowProfit();

        // Assert on the expected output
        String expectedOutput = "Total profit: " + -400.0 + "€\n";

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testShowCourseStudents() {
        // Enroll student to Course
        sampleCourse.courseEnroll(sampleStudent);

        // Call the method to be tested
        commandsInstance.ShowCourseStudents(sampleCourse.getCourseId());

        // Assert on the expected output
        String expectedOutput = sampleCourse.getName() + " students:\n"
                + sampleStudent.getStudentId() + ": " + sampleStudent.getName() + "\n";

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testShowCourseStudentsEmpty() {
        // Call the method to be tested
        commandsInstance.ShowCourseStudents(sampleCourse.getCourseId());

        // Assert on the expected output
        String expectedOutput = sampleCourse.getName() + " has no students enrolled\n";

        assertEquals(expectedOutput, outputStream.toString());
    }


    @AfterEach
    public void clear() {
        // Reset the testCourseList
        testCourseList.clear();

        // Reset System.out
        System.setOut(System.out);
    }
}
