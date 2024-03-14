package ironhack.com;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream outContentClean = System.out;

    @BeforeEach
    public void setUp() {
        teacher1 = new Teacher("Maria",45000d);
        teacher2 = new Teacher("Anna",45000d);
        teachers = new ArrayList<>(List.of(teacher1,teacher2));

        course1 = new Course("Java Backend", 4000d,teacher1);
        course2 = new Course("Frontend", 4000d,teacher2);
        courses = new ArrayList<>(List.of(course1,course2));

        student1 = new Student("Paula","Calle Calabria 25","paulasg461@gmail.com");
        student2 = new Student("Ariadna","Calle Paterna 86","ariadnamp_99@gmail.com");
        student3 = new Student("Sandra","Calle Laurel 4","sandra_laurel52@gmail.com");
        students = new ArrayList<>(List.of(student1,student2,student3));

        school = new School("MiCasita");
        school.setListToTeacherMap(teachers);
        school.setListToCourseMap(courses);
        school.setListToStudentMap(students);

        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void outContentClean(){
        System.setOut(outContentClean);
    }
//    /**
//     * Create the test case
//     *
//     * @param testName name of the test case
//     */
//    public AppTest( String testName )
//    {
//        super( testName );
//    }

//    /**
//     * @return the suite of tests being tested
//     */
//    public static Test suite()
//    {
//        return new TestSuite( AppTest.class );
//    }

//    /**
//     * Rigourous Test :-)
//     */
//    public void testApp()
//    {
//        assertTrue( true );
//    }

    @Test
    public void testCreateObjects() {
        assertEquals("Maria",teacher1.getName());
        assertEquals(4000d,course1.getPrice());
        assertEquals(teacher1,course1.getTeacher());
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

//    @Test
//    public void testLookupMethods() {
//        assertEquals(teacher1,school.lookupTeacher(teachers.get(0).getId()));
//        assertEquals(course2,school.lookupCourse(courses.get(1).getId()));
//        assertEquals(student3,school.lookupStudent(students.get(2).getId()));
//    }

//    @Test
//    public void testShowInfoMethods() {
//        school.showCourses();
//        String out1 = ("Id: " + course1.getId()
//                + ", Name: " + course1.getName()
//                + ", Price: " + course1.getPrice()
//                + ", Money Earned: " + course1.getMoney_earned()
//                + ", Teacher: " +(course1.getTeacher() != null ? course1.getTeacher().getName() : "N/A"));
//
//        String out2 = ("Id: " + course2.getId()
//                + ", Name: " + course2.getName()
//                + ", Price: " + course2.getPrice()
//                + ", Money Earned: " + course2.getMoney_earned()
//                + ", Teacher: " +(course2.getTeacher() != null ? course2.getTeacher().getName() : "N/A"));
//        assertEquals(out1 + "\n" + out2 + "\n", outContent.toString());
//
//    }

    @Test
    public void testEnrollStudent() {
        student1.enrollInCourse(course1);
        assertEquals(1,student1.getCourseList().size());
        assertEquals(course1.getName(), student1.getCourseList().get(0).getName());

        student1.enrollInCourse(course2);
        assertEquals(2,student1.getCourseList().size());
        assertEquals(course2.getName(), student1.getCourseList().get(1).getName());
    }
    // pending test assigning a null course(?) and/or to a null student(?)

    @Test
    public void testAssignTeacher() {
        //school.assignTeacherToCourse(teacher1.getId(),course1.getId());

        course1.assign(teacher1);
        assertEquals(teacher1,course1.getTeacher());
        assertEquals(teacher1,school.getCourse_map().get(course1.getId()).getTeacher());
    }
    // pending test assigning a null teacher(?)

    @Test
    public void testShowProfit() {
        double profitActual = school.calculateProfit();

        double profitExpected = 0d;
        // Sum up all money earned from all courses
        Map<String,Course> schoolCourses = school.getCourse_map();
        for (Map.Entry<String, Course> course : schoolCourses.entrySet()) {
            profitExpected += course.getValue().getMoney_earned();
        }
        // Deduct all teachers' salaries
        Map<String,Teacher> schoolTeachers = school.getTeacher_map();
        for (Map.Entry<String, Teacher> teacher : schoolTeachers.entrySet()) {
            profitExpected -= teacher.getValue().getSalary();
        }

        assertEquals(profitExpected,profitActual);
    }
}