
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {


    @ParameterizedTest
    @DisplayName("Should pass with valid Input")
    @ValueSource(strings = {"1\n", "2\n", "2\n", "1\n"})
    public void testShowPrincipalMenuAndRetrieveOption_ValidInput(String value){
        ByteArrayInputStream input = new ByteArrayInputStream(value.getBytes());
        Scanner sc = new Scanner(input);
        int result = Menu.showPrincipalMenuAndRetrieveOption(sc);
        System.out.println("Option Selected is: " + result);
        assertTrue(result == 1  || result == 2);

    }

    @ParameterizedTest
    @DisplayName("ShouldReturn NoSuchElementException")
    @ValueSource(strings = {"kdf\n", "s\n", "d\n", "dh\n"})
    public void testShowPrincipalMenuAndRetrieveOption_InvalidInput(String value){
        ByteArrayInputStream input = new ByteArrayInputStream(value.getBytes());
        Scanner sc = new Scanner(input);
        assertThrows(NoSuchElementException.class, () -> Menu.showPrincipalMenuAndRetrieveOption(sc));
        System.out.println("Error occurred for input value: " + value + " - ");
    }


    @ParameterizedTest
    @DisplayName("Should return Invalid Option on first input")
    @ValueSource(strings = {"5\n1\n", "12\n1\n", "18\n1\n", "19\n1\n"})
    public void testInvalidOptionMessageParameterizedTest(String value) {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        InputStream inputStream = new ByteArrayInputStream(value.getBytes()); // lanzamos primero el malo y lo capturamos y luego liberamos lanzando el bueno.
        Scanner scanner = new Scanner(inputStream);
        System.setIn(inputStream);
        Menu.showPrincipalMenuAndRetrieveOption(scanner);
        // Capture the output in a variable before resetting the content of the ByteArrayOutputStream
        String capturedOutput = outContent.toString();
        // Reset the content of the ByteArrayOutputStream after the relevant method call
        outContent.reset();
        // Find the index of the specific message in the captured output
        String errorMessage = "Invalid option. Please enter either 1 or 2";
        int startIndex = capturedOutput.indexOf(errorMessage);
        int endIndex = startIndex + errorMessage.length();
        // Extract the specific message from the captured output
        String expectedOutput = capturedOutput.substring(startIndex, endIndex);
        // Verify if the captured output contains the expected message
        assertEquals(errorMessage, expectedOutput.trim());
    }


//    @Test
//    public void testInvalidOptionMessage() {
//        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        InputStream inputStream = new ByteArrayInputStream("3\n1\n".getBytes()); // lanzamos primero el malo y lo capturamos y luego liberamos lanzando el bueno.
//        Scanner scanner = new Scanner(inputStream);
//        System.setIn(inputStream);
//        Menu.showPrincipalMenuAndRetrieveOption(scanner);
//        // Capture the output in a variable before resetting the content of the ByteArrayOutputStream
//        String capturedOutput = outContent.toString();
//        // Reset the content of the ByteArrayOutputStream after the relevant method call
//        outContent.reset();
//        // Find the index of the specific message in the captured output
//        String errorMessage = "Invalid option. Please enter either 1 or 2";
//        int startIndex = capturedOutput.indexOf(errorMessage);
//        int endIndex = startIndex + errorMessage.length();
//        // Extract the specific message from the captured output
//        String expectedOutput = capturedOutput.substring(startIndex, endIndex);
//        // Verify if the captured output contains the expected message
//        assertEquals(errorMessage, expectedOutput.trim());
//    }






}