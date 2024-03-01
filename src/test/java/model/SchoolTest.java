package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SchoolTest {
    static School DummySchool;
    static Teacher dummyAnne;
    static Teacher dummyJohn;
    @BeforeAll
    static void CreateMockSchool() {
        DummySchool = new School("Marinade");
        dummyAnne = new Teacher("Anne", 1300.00);
        dummyJohn = new Teacher("John", 1200.00);
    }

    @Test
    @DisplayName("two different schools should have two different ids")
    void School_multipleInstancesOfSchoolDifferentIds() {
        School maristes = new School("Maristes");
        School balmes = new School("Jaume Balmes");
        assertNotEquals(maristes.getId(), balmes.getId());
    }

    @Test
    @DisplayName("subtract teachers salaries from total earned from courses")
    void School_subtractSalariesFromTotalEarnedFromCourses() {
        School balmes = new School("Jaume Balmes");

        Teacher anne = new Teacher("Anne", 1200.00);
        Teacher john = new Teacher("John", 1200.00);
        Course englishCourseA1 = new Course("English A1", 300.00);
        Course englishCourseA2 = new Course("English A2", 300.00);
        Course englishCourseB1 = new Course("English B1", 300.00);
        Course englishCourseB2 = new Course("English B2", 300.00);

        balmes.addTeacher(anne);
        balmes.addTeacher(john);

        englishCourseA1.setMoney_earned(1200);
        englishCourseA2.setMoney_earned(900);
        englishCourseB1.setMoney_earned(1500);
        englishCourseB2.setMoney_earned(1200);

        balmes.addCourse(englishCourseA1);
        balmes.addCourse(englishCourseA2);
        balmes.addCourse(englishCourseB1);
        balmes.addCourse(englishCourseB2);

        assertEquals(balmes.getTotalProfit(), 2400.00);
    }

    @Test
    @DisplayName("Teachers can be added")
    void School_addSomeDummyTeachers(){
        DummySchool.addTeacher(dummyAnne);
        DummySchool.addTeacher(dummyJohn);
        assertEquals(2, DummySchool.getTeachers().size());
    }

//    @Test
//    @DisplayName("")
//    void School_showTeachersMethodReturnASCIITable(){
//        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outputStreamCaptor));
//        String uuidDummyAnne = dummyAnne.getTeacherId();
//        String uuidDummyJohn  = dummyJohn.getTeacherId();
//        DummySchool.showTeachersMethod();
//        String expectedOutput = String.format(
//                        "+--------------------------------------+------------+%n" +
//                        "| ID                                   | Teachers   |%n" +
//                        "+--------------------------------------+------------+%n" +
//                        "| %-36s | Anne       |%n" +
//                        "| %-36s | John       |%n" +
//                        "+--------------------------------------+------------+%n",
//                uuidDummyAnne, uuidDummyJohn);
//
//        assertEquals(expectedOutput, outputStreamCaptor.toString());
//    }
}
