package ironhack.com;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class SchoolTest {

@Test
public void testCalculateProfit() {
    // Create a school
    School school = new School("Test School");

    // Create some courses and teachers and add them to the school
    Course course1 = new Course("Course1", 1000.0);
    Course course2 = new Course("Course2", 2000.0);
    Teacher teacher1 = new Teacher("Teacher1", 500.0);
    Teacher teacher2 = new Teacher("Teacher2", 1000.0);

    school.getCourse_map().put(course1.getId(), course1);
    school.getCourse_map().put(course2.getId(), course2);
    school.getTeacher_map().put(teacher1.getId(), teacher1);
    school.getTeacher_map().put(teacher2.getId(), teacher2);

    // Create some students and enroll them in the courses
    Student student1 = new Student("Student1", "Address1", "student1@example.com");
    Student student2 = new Student("Student2", "Address2", "student2@example.com");

    school.getStudent_map().put(student1.getId(), student1);
    school.getStudent_map().put(student2.getId(), student2);

    school.enroll(student1.getId(), course1.getId());
    school.enroll(student2.getId(), course2.getId());

    // Calculate the profit
    double profit = school.calculateProfit();

    // Check if the profit is as expected
    assertEquals(1500.0, profit);
}

@Test
public void testLookupTeacher() {
    // Create a school
    School school = new School("Test School");

    // Create a teacher and add it to the school
    Teacher teacher1 = new Teacher("Teacher1", 500.0);
    school.getTeacher_map().put(teacher1.getId(), teacher1);

    // Use the lookupTeacher method to find the teacher
    school.lookupTeacher(teacher1.getId());

    assertTrue(school.getTeacher_map().containsKey(teacher1.getId()));
}

@Test
public void testShowTeachers() {
    // Create a school
    School school = new School("Test School");

    // Create a teacher and add it to the school
    Teacher teacher1 = new Teacher("Teacher1", 500.0);
    school.getTeacher_map().put(teacher1.getId(), teacher1);

    // Use the showTeachers method
    school.showTeachers();

    assertFalse(school.getTeacher_map().isEmpty());
}

@Test
public void testLookupCourse() {
    // Create a school
    School school = new School("Test School");

    // Create a course and add it to the school
    Course course1 = new Course("Course1", 1000.0);
    school.getCourse_map().put(course1.getId(), course1);

    // Use the lookupCourse method
    school.lookupCourse(course1.getId());

    assertTrue(school.getCourse_map().containsKey(course1.getId()));
}

@Test
public void testShowCourses() {
    // Create a school
    School school = new School("Test School");

    // Create a course and add it to the school
    Course course1 = new Course("Course1", 1000.0);
    school.getCourse_map().put(course1.getId(), course1);

    // Use the showCourses method
    school.showCourses();


    assertFalse(school.getCourse_map().isEmpty());
}

@Test
public void testSetListToTeacherMap() {
    // Create a school
    School school = new School("Test School");

    // Create a list of teachers and add it to the school
    List<Teacher> teachers = new ArrayList<>();
    Teacher teacher1 = new Teacher("Teacher1", 500.0);
    teachers.add(teacher1);

    // Use the setListToTeacherMap method
    school.setListToTeacherMap(teachers);

    assertFalse(school.getTeacher_map().isEmpty());
}

@Test
public void testSetListToCourseMap() {
    // Create a school
    School school = new School("Test School");

    // Create a list of courses and add it to the school
    List<Course> courses = new ArrayList<>();
    Course course1 = new Course("Course1", 1000.0);
    courses.add(course1);

    // Use the setListToCourseMap method
    school.setListToCourseMap(courses);

    assertFalse(school.getCourse_map().isEmpty());
}
}
