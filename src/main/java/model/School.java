package model;

import com.mitchtalmadge.asciidata.table.ASCIITable;
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


    public void showTeachersMethod(){
        String[] header = {"ID", "Teachers"};
        String[][] data = teachers.values().stream().map(teacher -> new String[]{teacher.getTeacherId(), teacher.getName()}).toArray(String[][]::new);
        System.out.println(ASCIITable.fromData(header, data));
    }

    public void showCoursesMethod(){
        String[] header = {"ID", "Courses"};
        String[][] data = courses.values().stream().map(course-> new String[]{course.getCourseId(), course.getName()}).toArray(String[][]::new);
        System.out.println(ASCIITable.fromData(header, data));
    }

    public void showStudentsMethod(){
        String[] header = {"ID", "Students", "Email-Students"};
        String[][] data = students.values().stream().map(student -> new String[]{student.getStudentId(), student.getName(),student.getEmail()}).toArray(String[][]::new);
        System.out.println(ASCIITable.fromData(header, data));
    }

    public void enrollStudentMethod(String studentID, String courseID){

        String newStudentID=checkID(studentID, students, this::showStudentsMethod);
        String newCourseID = checkID(courseID, courses, this::showCoursesMethod);

        students.get(newStudentID).setCourse(courses.get(newCourseID));

        if(courses.get(newCourseID).getMoney_earned()==0.0){
            courses.get(newCourseID).setMoney_earned(courses.get(newCourseID).getPrice());
        }else{
            courses.get(newCourseID).setMoney_earned(courses.get(newCourseID).getMoney_earned()
                    +courses.get(newCourseID).getPrice());
        }
    }
    private String checkID(String id, Map<String, ?> map, Runnable showMethod) {
        String newID = id;

        while (!map.containsKey(newID)) {
            showMethod.run();
            System.out.println("Please insert a valid ID from the list shown above:");
            Scanner scanner = new Scanner(System.in);
            newID = scanner.nextLine();
        }
        return newID;
    }

}