
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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
    @ValueSource(strings = {"pex\n", "dos\n", "NotValid\n", "!!!!!!!!!!\n"})
    public void testShowPrincipalMenuAndRetrieveOption_InvalidInput(String value){
        ByteArrayInputStream input = new ByteArrayInputStream(value.getBytes());
        Scanner sc = new Scanner(input);
        assertThrows(NoSuchElementException.class, () -> Menu.showPrincipalMenuAndRetrieveOption(sc));
    }

    @ParameterizedTest
    @DisplayName("Should return true if we pass any number other than 1 or 2.")
    @ValueSource(strings = {"5\n1\n", "1928\n1\n", "72863\n1\n", "9999999\n1\n"})
    public void testInvalidOptionMessageParameterizedTest(String value) {
        ByteArrayOutputStream errorStream = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errorStream));
        ByteArrayInputStream inputStream = new ByteArrayInputStream(value.getBytes());
        Scanner sc = new Scanner(inputStream);
        Menu.showPrincipalMenuAndRetrieveOption(sc);
        String errorOutput = errorStream.toString();
        assertTrue(errorOutput.contains("Invalid option. Please enter either 1 or 2"));
        System.setErr(System.err);
    }
}