package ironhack.com;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class School {
    private String name;
    private Map<String, Student> student_map = new HashMap<>();
    private Map<String, Teacher> teacher_map = new HashMap<>();
    private Map<String, Course> course_map = new HashMap<>();

    public School(String name) {
        this.name = name;
    }

    public void showStudents() {
        student_map.forEach((id, student) -> {
            student.printInfo();
        });
    }

    public Student lookupStudent(String studentId) {
        return student_map.get(studentId);
    }

    public void setListToStudentMap(List<Student> students) {
        Map<String, Student> students_map = new HashMap<>();

        for (Student student : students) {
            students_map.put(student.getId(), student);
        }
        setStudent_map(students_map);
    }

    public void setListToCourseMap(List<Course> courses) {
        Map<String, Course> courses_map = new HashMap<>();
        for (Course course : courses) {
            courses_map.put(course.getId(), course);
        }
        setCourse_map(courses_map);
    }

    public void setListToTeacherMap(List<Teacher> teachers) {

        Map<String, Teacher> teachers_map = new HashMap<>();
        for (Teacher teacher : teachers) {
            teachers_map.put(teacher.getId(), teacher);
        }
        setTeacher_map(teachers_map);
    }

    public void showCourses() {
        course_map.forEach((id, course) -> {
            course.printInfo();
        });
    }

    public Course lookupCourse(String courseId) {
        return course_map.get(courseId);
    }

    public void showTeachers() {
        teacher_map.forEach((id, teacher) -> {
            teacher.printInfo();
        });
    }

    public Teacher lookupTeacher(String teacherId) {
        return teacher_map.get(teacherId);
    }

    public double calculateProfit() {
        // TODO: exception handling
        double profit = 0;
        for (Course course : course_map.values()) {
            profit += course.getMoney_earned();
        }
        ;
        for (Teacher teacher : teacher_map.values()) {
            profit -= teacher.getSalary();
        }
        return profit;
    }
}
