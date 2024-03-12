package ironhack.com;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Unit test for simple App.
 */
public class AppTest
{

    private Teacher teacher1;
    private Teacher teacher2;
    private List<Teacher> teachers;

    private Course course1;
    private Course course2;
    private List<Course> courses;

    private Student student1;
    private Student student2;
    private Student student3;
    private List<Student> students;

    private School school;

    @BeforeEach
    public void setUp() {
        teacher1 = new Teacher("Maria",45000d);
        teacher2 = new Teacher("Anna",45000d);
        teachers = new ArrayList<>(List.of(teacher1,teacher2));

        course1 = new Course("Java Backend", 4000d,teacher1);
        course2 = new Course("Frontend", 4000d,teacher2);
        courses = new ArrayList<>(List.of(course1,course2));

        student1 = new Student("Paula","Calle Calabria 25","paulasg461@gmail.com",courses);
        student2 = new Student("Ariadna","Calle Paterna 86","ariadnamp_99@gmail.com",courses);
        student3 = new Student("Sandra","Calle Laurel 4","sandra_laurel52@gmail.com",courses);
        students = new ArrayList<>(List.of(student1,student2,student3));

        school = new School("MiCasita");
        school.setListToTeacherMap(teachers);
        school.setListToCourseMap(courses);
        school.setListToStudentMap(students);
    }
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
//    public AppTest( String testName )
//    {
//        super( testName );
//    }

    /**
     * @return the suite of tests being tested
     */
//    public static Test suite()
//    {
//        return new TestSuite( AppTest.class );
//    }

    /**
     * Rigourous Test :-)
     */
//    public void testApp()
//    {
//        assertTrue( true );
//    }

    @Test
    public void testCreateObjects() {
        assertEquals("Maria",teacher1.getName());
        assertEquals(4000d,course1.getPrice());
        assertEquals(teacher1,course1.getTeacher());
        assertEquals(courses,student1.getCourseList());
        assertEquals("Java Backend", courses.get(0).getName());
    }

    @Test
    public void testCreateStudentWithNotValidEmail() {
        Student studentNotValidEmail = new Student("Paula","Calle Calabria 25","paulasg461@gmail");
        Student studentNotValidEmail2 = new Student("Paula","Calle Calabria 25","paulasg461.com");
        Student studentNotValidEmail3 = new Student("Paula","Calle Calabria 25","dhjskjfsfsjfksefjicnweirmwrdlkjsijfkcjxospfojisjeifjasdkfpoasfoksofasflasf@gmail.com");
        // pending
    }

    @Test
    public void testCreateSchoolWithNotValidName() {
        School schoolNotValidName = new School("&3");
        // pending
    }

    @Test
    public void testFillInSchool() {
        // TeacherMap tests
        assertEquals(2,school.getTeacher_map().size());
        assertEquals(teacher1,school.getTeacher_map().get(teacher1.getId()));
        assertEquals(teacher1.getSalary(),school.getTeacher_map().get(teacher1.getId()).getSalary());

        // CourseMap tests
        assertEquals(2,school.getCourse_map().size());
        assertEquals(course2,school.getCourse_map().get(course2.getId()));
        assertEquals(course2.getName(),school.getCourse_map().get(course2.getId()).getName());

        // StudentMap tests
        assertEquals(3,school.getStudent_map().size());
        assertEquals(student1,school.getStudent_map().get(student1.getId()));
        assertEquals(student1.getAddress(),school.getStudent_map().get(student1.getId()).getAddress());
    }

    @Test
    public void testLookupMethods() {
        assertEquals(teacher1,school.lookupTeacher(teachers.get(0).getId()));
        assertEquals(course2,school.lookupCourse(courses.get(1).getId()));
        assertEquals(student3,school.lookupStudent(students.get(2).getId()));
    }

    @Test
    public void testShowInfoMethods() {

    }

    @Test
    public void testEnrollStudent() {

    }

    @Test
    public void testAssignTeacher() {

    }

    @Test
    public void testShowProfit() {

    }
}