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
    private final String input = "Ironhack School\n";



    @BeforeEach
    public void setUpStreams() {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testCreateSchoolName() {
        Application.createSchoolName();
        assertEquals("Welcome to the School Application\r\nPlease enter the name of the school:Your school is: Ironhack School\r\n", outputStream.toString());
    }

    @Test
    public void testNumberOfComponentsWithValidInput() {
        ByteArrayInputStream input2 = new ByteArrayInputStream("5\n".getBytes());
        System.setIn(input2);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        int result = Application.numberOfComponents(SchoolComponents.TEACHERS);

        assertEquals(5, result);
        assertTrue(outputStream.toString().contains("In your school there are 5 teachers"));


    }

    @Test
    public void testNumberOfComponentsWithInvalidInput() {
        ByteArrayInputStream input2 = new ByteArrayInputStream("invalid\n5\n".getBytes());
        System.setIn(input2);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        int result = Application.numberOfComponents(SchoolComponents.TEACHERS);

        assertEquals(5, result);
        assertTrue(outputStream.toString().contains("In your school there are 5 teachers"));


    }


    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);
    }
}

