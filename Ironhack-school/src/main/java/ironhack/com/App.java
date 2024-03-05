package ironhack.com;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ironhack.com.ReadCsvInfo.readObjectInfo;
import static ironhack.com.ReadCsvInfo.readSchoolInfo;

public class App
{
    public static void main( String[] args ) throws FileNotFoundException {
        String[] school_info = readSchoolInfo();
        School school = new School(school_info[0]);

        List<Teacher> teachers = readObjectInfo("src/files/Teachers.csv",1,RoleType.TEACHER);
        List<Student> students = readObjectInfo("src/files/Students.csv",2,RoleType.STUDENT);
        List<Course> courses = readObjectInfo("src/files/Courses.csv",2,RoleType.COURSE);

        school.setListToStudentMap(students);
        school.setListToTeacherMap(teachers);
        school.setListToCourseMap(courses);

        System.out.println("All Courses");
        school.showCourses();

        System.out.println("All Teachers");
        school.showTeachers();

        System.out.println("All Students");
        school.showStudents();

        System.out.println("\nEnroll");
        school.enroll(students.get(0).getId(), courses.get(0).getId());

        System.out.println("\nShow students by course");
        school.showStudentsByCourseId(courses.get(0).getId());

    }
}
