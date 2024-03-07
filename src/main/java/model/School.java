package model;

import com.mitchtalmadge.asciidata.table.ASCIITable;
import com.mitchtalmadge.asciidata.table.formats.ASCIITableFormat;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
public class School {
    @Setter(AccessLevel.NONE)
    private final String id;
    private String name;
    private Map<String, Teacher> teachers = new HashMap<>();
    private Map<String, Course> courses = new HashMap<>();
    private Map<String, Student> students = new HashMap<>();

    public School(String name, Map<String, Teacher> teachers, Map<String, Course> courses, Map<String, Student> students) {
        id = UUID.randomUUID().toString();
        this.name = name;
        this.teachers = teachers;
        this.courses = courses;
        this.students = students;
    }

    public School(String name) {
        id = UUID.randomUUID().toString();
        this.name = name;
    }

    public void addCourse(Course course) {
        courses.put(course.getCourseId(), course);
    }

    public void addTeacher(Teacher teacher) {
        teachers.put(teacher.getTeacherId(), teacher);
    }

    public void addStudent(Student student) {
        students.put(student.getStudentId(), student);
    }

    public double getTotalProfit() {
        return getTotalEarned() - computeSalaries();
    }

    private double computeSalaries() {
        double totalSpent = 0;
        for (Map.Entry<String, Teacher> entry : teachers.entrySet()) {
            Teacher teacher = entry.getValue();
            double spent = teacher.getSalary();
            totalSpent += spent;
        }
        return totalSpent;
    }

    private double getTotalEarned() {
        double totalEarned = 0;
        for (Map.Entry<String, Course> entry : courses.entrySet()) {
            Course course = entry.getValue();
            double earned = course.getMoney_earned();
            totalEarned += earned;
        }
        return totalEarned;
    }

    public void showTeachersMethod() {
        String[] header = {"ID", "Teachers"};
        String[][] data = teachers.values().stream().map(teacher -> new String[]{teacher.getTeacherId(), teacher.getName()}).toArray(String[][]::new);
        System.out.println(ASCIITable.fromData(header, data));
    }

    public void showCoursesMethod() {
        String[] header = {"ID", "Courses"};
        String[][] data = courses.values().stream().map(course -> new String[]{course.getCourseId(), course.getName()}).toArray(String[][]::new);
        System.out.println(ASCIITable.fromData(header, data));
    }

    public void showStudentsMethod() {
        String[] header = {"ID", "Students", "Email-Students"};
        String[][] data = students.values().stream().map(student -> new String[]{student.getStudentId(), student.getName(), student.getEmail()}).toArray(String[][]::new);
        System.out.println(ASCIITable.fromData(header, data));
    }

    public void enrollStudent(String studentID, String courseID) {

        showStudentsMethod();
        String newStudentID = checkID(studentID, students);
        showCoursesMethod();
        String newCourseID = checkID(courseID, courses);

        Student student = students.get(newStudentID);
        Course course = courses.get(newCourseID);

        student.setCourse(course);
        course.setMoney_earned(course.getMoney_earned() + course.getPrice());

        System.out.println("The student " + student.getName() + " have been enrolled the course "
                + course.getName() +"."
        );

    }

    private String checkID(String id, Map<String, ?> map) {
        while (!map.containsKey(id)) {
            if (map == teachers) {
                //showTeachersMethod();
            } else if (map == courses) {
                //showCoursesMethod();
            } else if (map == students) {
                //showStudentsMethod();
            }
            id = getNewID();
        }
        return id;
    }

    public void assignTeacherToCourse(String teacherID, String courseID) {
        showTeachersMethod();
        String validateTeacherID = checkID(teacherID, teachers);
        showCoursesMethod();
        String validateCourseID = checkID(courseID, courses);

        courses.get(validateCourseID).setTeacher(teachers.get(validateTeacherID));

    }

    private String getNewID() {
        System.out.println("Please insert a valid ID from the list shown above: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public void lookupCourse(String courseID) {

        showCoursesMethod();

        String newCourseID = checkID(courseID, courses);
        String[] header = {"ID", "Courses", "Teacher", "Price", "MoneyEarned"};

        String[][] data = courses.values().stream()
                .filter(course -> course.getCourseId().equals(courseID))
                .map(course -> new String[]{course.getCourseId(), course.getName(), course.getTeacher().getName(),
                        String.valueOf(course.getPrice()), String.valueOf(course.getMoney_earned())})
                .toArray(String[][]::new);
        System.out.println(ASCIITable.fromData(header, data));

    }

    public void lookupStudent(String studentID) {

        showStudentsMethod();

        String newStudentID = checkID(studentID, students);
        String[] header = {"ID", "Student", "Enrolled Course", "Email-Student", "Student Address"};

        String[][] data = students.values().stream()
                .filter(student -> student.getStudentId().equals(studentID))
                .map(student -> new String[]{student.getStudentId(), student.getName(), student.getCourse().getName(),
                        student.getEmail(), student.getAddress()})
                .toArray(String[][]::new);
        System.out.println(ASCIITable.fromData(header, data));

    }

	public void lookupTeacher(String teacherID) {

        showTeachersMethod();

        String newStudentID = checkID(teacherID, teachers);
        String[] header = {"ID", "Teacher", "Salary"};

        String[][] data = teachers.values().stream()
                .filter(teacher -> teacher.getTeacherId().equals(teacherID))
                .map(teacher -> new String[]{teacher.getTeacherId(), teacher.getName(), String.valueOf(teacher.getSalary())})
                .toArray(String[][]::new);
        System.out.println(ASCIITable.fromData(header, data));
    }

}

