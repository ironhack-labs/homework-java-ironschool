import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;

public class Commands1to2Test {
    Map<String, Course> testCourseList = new LinkedHashMap<>();
    Map<String, Student> testStudentList = new LinkedHashMap<>();
    Map<String, Teacher> testTeacherList = new LinkedHashMap<>();
    Commands commandsInstance = new Commands(testCourseList, testStudentList, testTeacherList);

    private Student student;
    private Teacher teacher;
    private Course course;

    @BeforeEach
    public void setUp() {

        // Create sample data and add it to the coursesMap
        course = new Course("Math", 200.0);
        testCourseList.put(course.getCourseId(), course);

        // Create sample data and add it to the teachersMap
        teacher = new Teacher("Prof. Smith", 500.0);
        testTeacherList.put(teacher.getTeacherId(), teacher);

        // Create sample data and add it to the testStudentList
        student = new Student("John Smith", "123 Main St", "johnS@example.com");
        testStudentList.put(student.getStudentId(), student);
    }

    @AfterEach
    public void cleanUp(){
        testCourseList.clear();
        testStudentList.clear();
        testStudentList.clear();
    }

    @Test
    public void enrollTest(){

        commandsInstance.enroll(student.getStudentId(), course.getCourseId());

        assertEquals(1, testCourseList.size());
        assertEquals("Math", testCourseList.get(course.getCourseId()).getName());
    }

    @Test
    public void assignTest(){

        commandsInstance.assign(teacher.getTeacherId(), course.getCourseId());

        assertEquals(1, testCourseList.size());
        assertEquals("Prof. Smith", testTeacherList.get(teacher.getTeacherId()).getName());
        assertEquals("Math", testCourseList.get(course.getCourseId()).getName());
    }

}
