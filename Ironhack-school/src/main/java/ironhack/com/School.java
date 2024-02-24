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

    private void showStudents() {
        // codigo
    }

    private Student lookupStudent(String studentId) {
        for(Student student : studentList) {
            if (Objects.equals(student.getId(), studentId)) {
                return student;
            }
        }
        return null;
    }

//    private Object lookupObject(String id, List<Object> objectList) {
//        for(Object object : objectList) {
//            if (Objects.equals(object.getId(), id)) {
//                return object;
//            }
//        }
//        return null;
//    }

    private void showCourses() {

    }

    private Course lookupCourse(String courseId) {
        for(Course course : courseList) {
            if (Objects.equals(course.getId(), courseId)) {
                return course;
            }
        }
        return null;
    }

    private void showTeachers() {
        // codigo
    }

    private Teacher lookupTeacher(String teacherId) {
        for(Teacher teacher : teacherList) {
            if (Objects.equals(teacher.getId(), teacherId)) {
                return teacher;
            }
        }
        return null;
    }


}
