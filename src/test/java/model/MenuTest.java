package model;

import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import utils.Validator;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MenuTest {

    @Test
    @DisplayName("Test that the school is created with the expected name")
    public void testCreateSchool() {
        // Create a real instance of the Menu class
        Menu menu = new Menu();

        // Create a spy of the real instance
        Menu menuSpy = spy(menu);

        // Mock the behavior of getValidNameFor method
        doReturn("MySchool").when(menuSpy).getValidNameFor("school");

        // Call the method to be tested
        School school = menuSpy.createSchool();

        // Verify that the method returned a School object with the correct name
        assertEquals("MySchool", school.getName());
    }

    @Test
    @DisplayName("Test that a valid address is returned when the user enters a valid address")
    public void testGetValidAddress() {
        // Given
        String expectedInputAddress = "MyStreet 1";
        System.setIn(new ByteArrayInputStream(expectedInputAddress.getBytes()));

        // When
        try (MockedStatic<Validator> validator = Mockito.mockStatic(Validator.class)) {
            validator.when(() -> Validator.isAddressValid(anyString())).thenReturn(true);

            Menu menu = new Menu();
            String validAddress = menu.getValidAddress();

            // Then
            assertEquals(expectedInputAddress, validAddress);
        }
    }

    @Test
    @DisplayName("Test that a valid address is returned when the user enters a valid address")
    public void testGetValidEmail() {
        // Given
        String expectedInputEmail = "student@hotpot.cat";
        System.setIn(new ByteArrayInputStream(expectedInputEmail.getBytes()));

        // When
        try (MockedStatic<Validator> validator = Mockito.mockStatic(Validator.class)) {
            validator.when(() -> Validator.isEmailValid(anyString())).thenReturn(true);

            Menu menu = new Menu();
            String validEmail = menu.getValidEmail();

            // Then
            assertEquals(expectedInputEmail, validEmail);
        }
    }

    @Test
    @DisplayName("Test that a valid name for a student is returned when the user enters a valid name")
    public void testGetValidNameFor() {
        // Given
        String expectedInputStudentName = "John Wick";
        System.setIn(new ByteArrayInputStream(expectedInputStudentName.getBytes()));

        // When
        try (MockedStatic<Validator> validator = Mockito.mockStatic(Validator.class)) {
            validator.when(() -> Validator.isNameValid(anyString())).thenReturn(true);

            // Create a real instance of the Menu class
            Menu menu = new Menu();

            // Call the method to be tested
            String validStudentName = menu.getValidNameFor("student");

            // Then
            assertEquals(expectedInputStudentName, validStudentName);
        }
    }

    @Test
    @DisplayName("Test that a valid salary is returned when the user enters a valid salary")
    public void testGetSalary() {
        // Given
        String expectedInputSalary = "2500.5";
        System.setIn(new ByteArrayInputStream(expectedInputSalary.getBytes()));

        // When
        try (MockedStatic<Validator> validator = Mockito.mockStatic(Validator.class)) {
            validator.when(() -> Validator.isPositiveDecimalNumberValid(anyString())).thenReturn(true);

            double validSalary = new Menu().getSalary();

            // Then
            assertEquals(Double.parseDouble(expectedInputSalary), validSalary);
        }
    }

    @Test
    @DisplayName("Test that a valid price is returned when the user enters a valid price")
    public void testGetPrice() {
        // Given
        String expectedInputPrice = "550.5";
        System.setIn(new ByteArrayInputStream(expectedInputPrice.getBytes()));

        // When
        try (MockedStatic<Validator> validator = Mockito.mockStatic(Validator.class)) {
            validator.when(() -> Validator.isPositiveDecimalNumberValid(anyString())).thenReturn(true);

            double validPrice = new Menu().getPrice();

            // Then
            assertEquals(Double.parseDouble(expectedInputPrice), validPrice);
        }
    }

}