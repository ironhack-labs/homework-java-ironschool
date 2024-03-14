package ironhack.com;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;


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

@Test
public void testSetListToStudentMap() {
    // Create a school
    School school = new School("Test School");

    // Create a list of students and add it to the school
    List<Student> students = new ArrayList<>();
    Student student1 = new Student("Student1", "Address1", "student1@example.com");
    students.add(student1);

    // Use the setListToStudentMap method
    school.setListToStudentMap(students);

    assertFalse(school.getStudent_map().isEmpty());
}

@Test
public void testLookupStudent() {
    // Create a school
    School school = new School("Test School");

    // Create a student and add it to the school
    Student student1 = new Student("Student1", "Address1", "student1@example.com");
    school.getStudent_map().put(student1.getId(), student1);

    // Use the lookupStudent method
    school.lookupStudent(student1.getId());

    assertTrue(school.getStudent_map().containsKey(student1.getId()));
}

@Test
public void testShowStudents() {
    // Create a school
    School school = new School("Test School");

    // Create a student and add it to the school
    Student student1 = new Student("Student1", "Address1", "student1@example.com");
    school.getStudent_map().put(student1.getId(), student1);

    // Use the showStudents method
    school.showStudents();

    assertFalse(school.getStudent_map().isEmpty());
}

@Test
public void testSchoolConstructor() {
    // Create a school
    School school = new School("Test School");

    // Verify that the name is set correctly
    assertEquals("Test School", school.getName());
}

@Test
public void testFindStudentById() {
    // Create a school
    School school = new School("Test School");

    // Create a student and add it to the school
    Student student1 = new Student("Student1", "Address1", "student1@example.com");
    school.getStudent_map().put(student1.getId(), student1);

    // Use the findStudentById method
    Student foundStudent = school.findStudentById(student1.getId());

    // Verify that the correct student is returned
    assertEquals(student1, foundStudent);
}

@Test
public void testFindCourseById() {
    // Create a school
    School school = new School("Test School");

    // Create a course and add it to the school
    Course course1 = new Course("Course1", 1000.0);
    school.getCourse_map().put(course1.getId(), course1);

    // Use the findCourseById method
    Course foundCourse = school.findCourseById(course1.getId());

    // Verify that the correct course is returned
    assertEquals(course1, foundCourse);
}

@Test
public void testFindTeacherById() {
    // Create a school
    School school = new School("Test School");

    // Create a teacher and add it to the school
    Teacher teacher1 = new Teacher("Teacher1", 500.0);
    school.getTeacher_map().put(teacher1.getId(), teacher1);

    // Use the findTeacherById method
    Teacher foundTeacher = school.findTeacherById(teacher1.getId());

    // Verify that the correct teacher is returned
    assertEquals(teacher1, foundTeacher);
}

}
