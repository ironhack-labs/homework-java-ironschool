package model;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TeacherTest {
    @Test
    @DisplayName("Test Teacher object creation with valid input")
    public void testTeacherCreationWithValidInput() {
        String name = "John Doe";
        double salary = 2500.0;
        Teacher teacher = new Teacher(name, salary);

        assertNotNull(teacher);
        assertEquals(name, teacher.getName());
        assertEquals(salary, teacher.getSalary());
        assertNotNull(teacher.getTeacherId());
    }
    @Test
    @DisplayName("Test Teacher object equality")
    public void testTeacherEquality() {

        Teacher teacher1 = new Teacher("John Doe", 2500.0);
        Teacher teacher2 = new Teacher("John Doe", 2500.0);
        Teacher teacher3 = new Teacher("Jane Smith", 3000.0);

        assertEquals(teacher1, teacher2);
        assertNotEquals(teacher1, teacher3);
    }

    @Test
    @DisplayName("Test Teacher object hash code")
    public void testTeacherHashCode() {

        Teacher teacher1 = new Teacher("John Doe", 2500.0);
        Teacher teacher2 = new Teacher("John Doe", 2500.0);

        assertEquals(teacher1.hashCode(), teacher2.hashCode());
    }
}

