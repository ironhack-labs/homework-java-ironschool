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


    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);
    }
}

