package ironhack.com;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
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

    public void lookupStudent(String studentId) {
        student_map.get(studentId).printInfo();
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

    public void lookupCourse(String courseId) {
        course_map.get(courseId).printInfo();
    }

public void showTeachers() {
    if (teacher_map.isEmpty()) {
        System.out.println("No teachers found.");
    } else {
        teacher_map.forEach((id, teacher) -> {
            teacher.printInfo();
        });
    }
}

  public void lookupTeacher(String teacherId) {
    Teacher teacher = teacher_map.get(teacherId);
    if (teacher != null) {
        teacher.printInfo();
    } else {
        System.out.println("Teacher with ID " + teacherId + " not found.");
    }
}

public double calculateProfit() {
    double profit = 0;
    for (Course course : course_map.values()) {
        if (course == null) {
            System.out.println("Course not found in the map.");
            continue;
        }
        profit += course.getMoney_earned();
    }
    for (Teacher teacher : teacher_map.values()) {
        if (teacher == null) {
            System.out.println("Teacher not found in the map.");
            continue;
        }
        profit -= teacher.getSalary();
    }
    return profit;
}

    public void enroll(String studentId, String courseId) {
        Student student = findStudentById(studentId);
        Course course = findCourseById(courseId);

        if (student == null) {
            throw new IllegalArgumentException("Student not found.");
        }

        if (course == null) {
            throw new IllegalArgumentException("Course not found.");
        }

        student.enrollInCourse(course);
      
        course.setMoney_earned(course.getMoney_earned() + course.getPrice());
    }

    public void assignTeacherToCourse(String teacherId, String courseId) {
        course_map.get(courseId).setTeacher(teacher_map.get(teacherId));

        Teacher teacher = findTeacherById(teacherId);
        Course course = findCourseById(courseId);

        if (teacher == null) {
            throw new IllegalArgumentException("Teacher not found.");
        }

        if (course == null) {
            throw new IllegalArgumentException("Course not found.");
        }

        course.assign(teacher);
    }

    private Student findStudentById(String studentId) {
        return student_map.get(studentId);
    }

    private Course findCourseById(String courseId) {
        return course_map.get(courseId);
    }

    private Teacher findTeacherById(String teacherId) {
        return teacher_map.get(teacherId);
    }


    public void showStudentsByCourseId(String courseId) {
        Course course = findCourseById(courseId);

        if (course == null) {
            throw new IllegalArgumentException("Course not found");
        }

        List<Student> enrolledStudents = new ArrayList<>();
        for (Student st : student_map.values()) {
            if (st.getCourseList().contains(course)) {
                enrolledStudents.add(st);
            }
        }

        for (Student st : enrolledStudents) {
            st.printInfo();
        }
    }


    public void showMoneySpentByStudent(String studentId) {
        Student student = student_map.get(studentId);
        if (student != null) {
            double totalMoneySpent = 0.0;
            List<Course> courses = student.getCourseList();
            for (Course course : courses) {
                totalMoneySpent += course.getPrice();
            }
            System.out.println(totalMoneySpent);
        } else {
            System.out.println("Student not found");
        }
    }

}