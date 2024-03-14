package ironhack.com;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReadCsvInfoTestTest {

    @Test
    void createInstance_WithValidStudentData_ReturnsStudent() {
        // Assumes input validation methods will pass.
        String[] properties = {"Valid Name", "123 Main St", "email@example.com"};

        Student student = ReadCsvInfo.<Student>createInstance(RoleType.STUDENT, properties);

        Assertions.assertNotNull(student, "Student should not be null for valid inputs");
        Assertions.assertEquals("Valid Name", student.getName());
        Assertions.assertEquals("email@example.com", student.getEmail());
    }

    @Test
    void createInstance_WithInvalidStudentName_ReturnsNull() {
        String[] properties = {"", "123 Main St", "email@example.com"};

        Student student = ReadCsvInfo.<Student>createInstance(RoleType.STUDENT, properties);

        Assertions.assertNull(student, "Student should be null for invalid name input");
    }

    @Test
    void createInstance_WithInvalidStudentEmail_ReturnsNull() {
        String[] properties = {"Valid Name", "123 Main St", "not an email"};

        Student student = ReadCsvInfo.<Student>createInstance(RoleType.STUDENT, properties);

        Assertions.assertNull(student, "Student should be null for invalid email input");
    }

    @Test
    void createInstance_WithValidTeacherData_ReturnsTeacher() {
        String[] properties = {"Valid Teacher", "5000.50"};
        Teacher teacher = ReadCsvInfo.<Teacher>createInstance(RoleType.TEACHER, properties);

        Assertions.assertNotNull(teacher, "Teacher should not be null for valid inputs");
        Assertions.assertEquals("Valid Teacher", teacher.getName());
    }

    @Test
    void createInstance_WithInvalidTeacherName_ReturnsNull() {
        String[] properties = {"", "5000.50"};
        Teacher teacher = ReadCsvInfo.<Teacher>createInstance(RoleType.TEACHER, properties);

        Assertions.assertNull(teacher, "Teacher should be null for invalid name input");
    }

    @Test
    void createInstance_WithValidCourseData_ReturnsCourse() {
        String[] properties = {"Valid Course", "3"};
        Course course = ReadCsvInfo.<Course>createInstance(RoleType.COURSE, properties);

        Assertions.assertNotNull(course, "Course should not be null for valid inputs");
        Assertions.assertEquals("Valid Course", course.getName());
    }

    @Test
    void createInstance_WithInvalidCourseName_ReturnsNull() {
        String[] properties = {"", "3"};
        Course course = ReadCsvInfo.<Course>createInstance(RoleType.COURSE, properties);

        Assertions.assertNull(course, "Course should be null for invalid name input");
    }
}
