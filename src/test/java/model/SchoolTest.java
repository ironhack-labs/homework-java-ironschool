package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SchoolTest {

    static School DummySchool;
    static Teacher dummyAnne;

    static Course dummyCourse;
    static Student dummyStudent;
    static Teacher dummyPedro;
    @BeforeAll
    static void CreateMockSchool() {
        DummySchool = new School("Marinade");
        dummyAnne = new Teacher("Anne", 1300.00);
        dummyCourse = new Course("Introducción a la programación con Java", 7500);
        dummyStudent = new Student("Pedro", "Avenida portal del angel,36", "Pedro@ejemplo.com");
        DummySchool.addTeacher(dummyAnne);
        DummySchool.addCourse(dummyCourse);
        DummySchool.addStudent(dummyStudent);
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
        assertEquals(1, DummySchool.getTeachers().size());
    }



    @Test
    @DisplayName("Should be the same showTeachersMethod table result")
    void School_showTeachersMethodReturnASCIITable() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        String uuidDummyAnne = dummyAnne.getTeacherId();
        String nameDummyAnne = dummyAnne.getName();
        DummySchool.showTeachersMethod();
        String expectedOutput = String.format(
                "╔══════════════════════════════════════╤══════════╗%n" +
                        "║ ID                                   │ Teachers ║%n" +
                        "╠══════════════════════════════════════╪══════════╣%n" +
                        "║ %-36s │ %-8s ║%n" +
                        "╚══════════════════════════════════════╧══════════╝%n%n", uuidDummyAnne, nameDummyAnne);


        String expectedNormalized = expectedOutput.replaceAll("\\s", "").replaceAll("\\\\", "");
        String actualNormalized = outputStreamCaptor.toString().replaceAll("\\s", "").replaceAll("\\\\", "");

        assertEquals(expectedNormalized, actualNormalized);
    }

    @Test
    @DisplayName("Should be the same showCoursesMethod table result")
    void School_showCoursesMethodReturnASCIITable() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        String uuidDummyCourse = dummyCourse.getCourseId();
        String uuidDummyNameCourse = dummyCourse.getName();
        DummySchool.showCoursesMethod();

        String expectedOutput = String.format(
                "╔══════════════════════════════════════╤═════════════════════════════════════════╗%n" +
                        "║ ID                                   │ Courses                                 ║%n" +
                        "╠══════════════════════════════════════╪═════════════════════════════════════════╣%n" +
                        "║ %-36s │ %-36s ║%n" +
                        "╚══════════════════════════════════════╧═════════════════════════════════════════╝%n%n", uuidDummyCourse, uuidDummyNameCourse);


        String expectedNormalized = expectedOutput.replaceAll("\\s", "").replaceAll("\\\\", "");
        String actualNormalized = outputStreamCaptor.toString().replaceAll("\\s", "").replaceAll("\\\\", "");
        assertEquals(expectedNormalized, actualNormalized);
    }

    @Test
    @DisplayName("Should be the same showStudentsMethod table result")
    void School_showStudentsMethodReturnASCIITable() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        String uuidDummyStudent = dummyStudent.getStudentId();
        String dummyStudentName = dummyStudent.getName();
        String dummyStudentEmail = dummyStudent.getEmail();
        DummySchool.showStudentsMethod();

        String expectedOutput = String.format(
                "╔══════════════════════════════════════╤══════════╤═══════════════════╗%n" +
                        "║ ID                                   │ Students │ Email-Students    ║%n" +
                        "╠══════════════════════════════════════╪══════════╪═══════════════════╣%n" +
                        "║ %-36s │ %-8s │ %-16s ║%n" +
                        "╚══════════════════════════════════════╧══════════╧═══════════════════╝", uuidDummyStudent, dummyStudentName, dummyStudentEmail);


        String expectedNormalized = expectedOutput.replaceAll("\\s", "").replaceAll("\\\\", "");
        String actualNormalized = outputStreamCaptor.toString().replaceAll("\\s", "").replaceAll("\\\\", "");
        assertEquals(expectedNormalized, actualNormalized);
    }

    @Test
    @DisplayName("Check Assign Method when IDs are valid")
    void School_enrollOneStudentAtCourse_HappyPath(){

        School balmes = new School("Jaume Balmes");
        Teacher john = new Teacher("John", 1200.00);
        Course englishCourseA1 = new Course("English A1", 300.00);
        Student peter = new Student("Peter", "False Street 123", "testing@testcase.es");

        balmes.addTeacher(john);
        balmes.addStudent(peter);
        balmes.addCourse(englishCourseA1);

        balmes.enrollStudent(peter.getStudentId(), englishCourseA1.getCourseId());

        assertEquals(300, englishCourseA1.getMoney_earned());
        assertEquals(englishCourseA1, peter.getCourse());

        Student bruce = new Student("Bruce", "False Street 123", "testing@testcase.es");
        balmes.addStudent(bruce);
        balmes.enrollStudent(bruce.getStudentId(), englishCourseA1.getCourseId());

        assertEquals(600, englishCourseA1.getMoney_earned());
        assertEquals(englishCourseA1, bruce.getCourse());
    }













}
