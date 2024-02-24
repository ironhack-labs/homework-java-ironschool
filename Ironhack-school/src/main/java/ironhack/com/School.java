package ironhack.com;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class School {
    private List<Student> studentList;
    private List<Teacher> teacherList;
    private List<Course> courseList;

    public void showStudents() {
        for (Student student : studentList) {
            student.printInfo();
        }
    }

    public Student lookupStudent(String studentId) {
        for(Student student : studentList) {
            if (Objects.equals(student.getId(), studentId)) {
                return student;
            }
        }
        return null;
    }

//    public Object lookupObject(String id, List<Object> objectList) {
//        for(Object object : objectList) {
//            if (Objects.equals(object.getId(), id)) {
//                return object;
//            }
//        }
//        return null;
//    }

    public void showCourses() {
        for (Course course : courseList) {
            course.printInfo();
        }
    }

    public Course lookupCourse(String courseId) {
        for(Course course : courseList) {
            if (Objects.equals(course.getId(), courseId)) {
                return course;
            }
        }
        return null;
    }

    public void showTeachers() {
        for (Teacher teacher : teacherList) {
            teacher.printInfo();
        }    }

    public Teacher lookupTeacher(String teacherId) {
        for(Teacher teacher : teacherList) {
            if (Objects.equals(teacher.getId(), teacherId)) {
                return teacher;
            }
        }
        return null;
    }

    public double calculateProfit() {
        // TODO: exception handling
        double profit = 0;
        for (Course course : courseList) {
            profit += course.getMoney_earned();
        }
        for (Teacher teacher : teacherList) {
            profit -= teacher.getSalary();
        }
        return profit;
    }
}
