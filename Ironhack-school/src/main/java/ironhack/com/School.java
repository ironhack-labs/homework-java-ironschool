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
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.name = name;
    }

    public void showStudents() {
        if (student_map.isEmpty()) {
            System.out.println("No students found.");
        } else {
            student_map.forEach((id, student) -> {
                student.printInfo();
            });
        }
    }

    public void lookupStudent(String studentId) {
        Student student = student_map.get(studentId);
        if (student != null) {
            student.printInfo();
        } else {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }

    public void setListToStudentMap(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students to add.");
        } else {
            Map<String, Student> students_map = new HashMap<>();
            for (Student student : students) {
                students_map.put(student.getId(), student);
            }
            setStudent_map(students_map);
        }
    }

    public void setListToCourseMap(List<Course> courses) {
        if (courses.isEmpty()) {
            System.out.println("No courses to add.");
        } else {
            Map<String, Course> courses_map = new HashMap<>();
            for (Course course : courses) {
                courses_map.put(course.getId(), course);
            }
            setCourse_map(courses_map);
        }
    }

    public void setListToTeacherMap(List<Teacher> teachers) {
        if (teachers.isEmpty()) {
            System.out.println("No teachers to add.");
        } else {
            Map<String, Teacher> teachers_map = new HashMap<>();
            for (Teacher teacher : teachers) {
                teachers_map.put(teacher.getId(), teacher);
            }
            setTeacher_map(teachers_map);
        }
    }

    public void showCourses() {
        if (course_map.isEmpty()) {
            System.out.println("No courses found.");
        } else {
            course_map.forEach((id, course) -> {
                course.printInfo();
            });
        }
    }

    public Course lookupCourse(String courseId) {
        Course course = course_map.get(courseId);
        if (course != null) {
            course.printInfo();
        } else {
            System.out.println("Course with ID " + courseId + " not found.");
        }
        return course;
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
    public void showProfit(){
        System.out.println("Current Total Profit:");
        System.out.println(String.valueOf(calculateProfit())+"€");
    }
    public double calculateProfit() {
        double profit = 0;
        for (Course course : course_map.values()) {
            if (course == null) {
                continue;
            }
            profit += course.getMoney_earned();
        }
        for (Teacher teacher : teacher_map.values()) {
            if (teacher == null) {
                continue;
            }
            profit -= teacher.getSalary();
        }
        return profit;
    }

    public void enroll(Student student, Course course) {

        if (student == null) {
           // System.out.println("Student not found.");
            return;
        }

        if (course == null) {
           // System.out.println("Course not found.");
            return;
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

    public Student findStudentById(String studentId) {
        if (student_map.containsKey(studentId)) {
            return student_map.get(studentId);
        } else {
            System.out.println("Student with ID " + studentId + " not found.");
            return null;
        }
    }

    public Course findCourseById(String courseId) {
        if (course_map.containsKey(courseId)) {
            return course_map.get(courseId);
        } else {
            System.out.println("Course with ID " + courseId + " not found.");
            return null;
        }
    }

    public Teacher findTeacherById(String teacherId) {
        if (teacher_map.containsKey(teacherId)) {
            return teacher_map.get(teacherId);
        } else {
            System.out.println("Teacher with ID " + teacherId + " not found.");
            return null;
        }
    }


    public List<Student> findStudentsByCourseId(String courseId) {
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

        return enrolledStudents;

    }


    public double findMoneySpentByStudent(String studentId) {
        Student student = student_map.get(studentId);
        double totalMoneySpent = 0.0;
        if (student != null) {
            List<Course> courses = student.getCourseList();
            for (Course course : courses) {
                totalMoneySpent += course.getPrice();
            }
        } else {
            System.out.println("Student not found");
        }
        return totalMoneySpent;
    }


}