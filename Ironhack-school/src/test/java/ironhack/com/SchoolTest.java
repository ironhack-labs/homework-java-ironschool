package ironhack.com;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SchoolTest {

    // Create a school
    School school = new School("Test School");

    Course course1 = new Course("Course1", 1000.0);
    Course course2 = new Course("Course2", 2000.0);
    Teacher teacher1 = new Teacher("Teacher1", 500.0);
    Teacher teacher2 = new Teacher("Teacher2", 1000.0);
    Student student1 = new Student("Student1", "Address1", "student1@example.com");
    Student student2 = new Student("Student2", "Address2", "student2@example.com");

    @BeforeEach
    void setUp() {
        // Create some courses and teachers and add them to the school
        school.getCourse_map().put(course1.getId(), course1);
        school.getCourse_map().put(course2.getId(), course2);
        school.getTeacher_map().put(teacher1.getId(), teacher1);
        school.getTeacher_map().put(teacher2.getId(), teacher2);

        // Create some students and enroll them in the courses
        school.getStudent_map().put(student1.getId(), student1);
        school.getStudent_map().put(student2.getId(), student2);

        school.enroll(student1.getId(), course1.getId());
        school.enroll(student2.getId(), course2.getId());
    }


@Test
public void testCalculateProfit() {
    // Calculate the profit
    double profit = school.calculateProfit();

    // Check if the profit is as expected
    assertEquals(1500.0, profit);
}

    @Test
    public void testFindMoneySpentByStudent() {
        double moneySpent = school.findMoneySpentByStudent(student1.getId());
        assertEquals(1000.0, moneySpent);
    }

    @Test
    public void testFindStudentsByCourseId() {
        List<Student> students = school.findStudentsByCourseId(course1.getId());
        assertEquals(1, students.size());
    }

    @Test
    public void testEnroll() {
        school.enroll(student1.getId(), course1.getId());
        Course courseEnrolled = school.getStudent_map().get(student1.getId()).getCourseList().get(0);
        assertEquals("Course1", courseEnrolled.getName());
    }

}
