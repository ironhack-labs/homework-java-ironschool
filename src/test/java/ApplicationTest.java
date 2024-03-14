import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalSystemOut = System.out;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private ByteArrayInputStream input;
    Application application;



    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testCreateSchoolName() {
        input = new ByteArrayInputStream("Ironhack School\n".getBytes());
        System.setIn(input);

        application = new Application();
        application.createSchoolName();
        assertEquals("Welcome to the School Application\nPlease enter the name of the school:Your school is: Ironhack School\n", outputStream.toString());
    }

    @Test
    public void testNumberOfComponentsWithValidInput() {
        input = new ByteArrayInputStream("5\n".getBytes());
        System.setIn(input);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        application = new Application();
        int result = application.numberOfComponents(SchoolComponents.TEACHERS);

        assertEquals(5, result);
        assertTrue(outputStream.toString().contains("In your school there are 5 teachers"));


    }

    @Test
    public void testNumberOfComponentsWithInvalidInput() {
        input = new ByteArrayInputStream("invalid\n5\n".getBytes());
        System.setIn(input);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        application = new Application();
        int result = application.numberOfComponents(SchoolComponents.TEACHERS);

        assertEquals(5, result);
        assertTrue(outputStream.toString().contains("In your school there are 5 teachers"));


    }

    @Test
    public void testValidateInputWithValidInput() {
        input = new ByteArrayInputStream("Ironhack\n".getBytes());
        System.setIn(input);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        application = new Application();

        String result = application.validateInput("Name", "Name cannot be empty", "Name cannot contain numbers");

        assertEquals("Ironhack", result);
    }

    @Test
    public void testTeacherDetail() {
        input = new ByteArrayInputStream("1\nJohn\n3000\n".getBytes());
        System.setIn(input);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        application = new Application();

        Map<String, Teacher> result = application.teacherDetails();

        assertNotNull(result);
        assertEquals(1, result.size());

        Teacher teacher = result.values().iterator().next();
        assertEquals("John", teacher.getName());
        assertEquals(3000.0, teacher.getSalary());

        assertTrue(outputStream.toString().contains("John"));
        assertTrue(outputStream.toString().contains("3000.0"));
    }



    @Test
    public void testStudentDetail() {
        input = new ByteArrayInputStream("1\nJohn\nCasa\ndsdad@fds.com".getBytes());
        System.setIn(input);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        application = new Application();

        Map<String, Student> result = application.studentDetails();

        assertNotNull(result);
        assertEquals(1, result.size());

        Student student = result.values().iterator().next();
        assertEquals("John", student.getName());
        assertEquals("Casa", student.getAddress());
        assertEquals("dsdad@fds.com", student.getEmail());

        assertTrue(outputStream.toString().contains("John"));
        assertTrue(outputStream.toString().contains("Casa"));
        assertTrue(outputStream.toString().contains("dsdad@fds.com"));
    }

    @Test
    public void testCourseDetail() {
        input = new ByteArrayInputStream("1\nEnglish\n3000\n".getBytes());
        System.setIn(input);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        application = new Application();

        Map<String, Course> result = application.courseDetails();

        assertNotNull(result);
        assertEquals(1, result.size());

        Course student = result.values().iterator().next();
        assertEquals("English", student.getName());
        assertEquals(3000.0, student.getPrice());


        assertTrue(outputStream.toString().contains("English"));
        assertTrue(outputStream.toString().contains("3000.0"));
    }




    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);
    }
}

