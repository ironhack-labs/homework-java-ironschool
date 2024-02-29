import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public class Commands {
    private Map<String, Course> courseList = new HashMap<>();
    private Map<String, Student> studentList = new HashMap<>();
    private Map<String, Teacher> teacherList = new HashMap<>();


    public Commands(Map<String, Course> courseList, Map<String, Student> studentList, Map<String, Teacher> teacherList) {
        setCourseList(courseList);
        setStudentList(studentList);
        setTeacherList(teacherList);
    }

    public void commandSelector(CommandEnum commandAction){
        String studentID = "asdfasdf";
        String courseID = "asdfasdf";
        String teacherID = "asdfasdf";

        switch (commandAction){
        case ENROLL:
            enroll(studentID, courseID);

            break;
        case ASSIGN:
            assign(teacherID, courseID);
            break;

        case SHOW_COURSES:
            ShowCourses();
            break;

        case LOOKUP_COURSE:
            LookupCourse(courseID);
            break;

        case SHOW_STUDENTS:
            ShowStudents();
            break;

        case LOOKUP_STUDENT:
            LookupStudent(studentID);
            break;

        case SHOW_TEACHERS:
            ShowTeachers();
            break;

        case LOOKUP_TEACHER:
            LookupTeacher(teacherID);
            break;

        case SHOW_PROFIT:
            ShowProfit();
            break;

        default:
            System.err.println("The command selected is not available");
            break;
        }
    }

    public void enroll(String studentID, String courseID) {
        Student student = studentList.get(studentID);
        Course course = courseList.get(courseID);
        course.courseEnroll(student, course);

        // Increase money earned
        course.setMoney_earned(course.getMoney_earned() + course.getPrice());
    }

    public void assign(String teacherID, String courseID){   //This command will help assign the teacher specified to the corresponding course
        Teacher teacher = teacherList.get(teacherID);
        Course course = courseList.get(courseID);

        course.setTeacher(teacher);
    }

    public void ShowCourses(){    //This command will display a list of all courses
        for (Course course : courseList.values()){
            System.out.println(course.getName());
        }
    }

    public void ShowTeachers() { //This command will display a list of all teachers
        for (Teacher teacher : teacherList.values()) {
            System.out.println(teacher.getName());
            System.out.println("List of Teachers: ");
            for (Map.Entry<String, Course> entry : courseList.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue().getName());
            }
        }
    }

    public void LookupCourse(String courseID){ // This command will display the full details of the specified course
        Course x = courseList.get(courseID);

        System.out.println(x.getName());
        System.out.println(x.getPrice());
        System.out.println(x.getTeacher());
        System.out.println(x.getClass());
    }

    /*
    public void LookupCourse(String courseID){ // This command will display the full details of the specified course
        if(courseList.containsKey(courseID)) {
            System.out.println("Course ID: " + courseID);
            System.out.println("Course Name: " + courseList.get(courseID).getName());
            System.out.println("Course Price: " + courseList.get(courseID).getPrice());
            System.out.println("Course Money Earned: " + courseList.get(courseID).getMoney_earned());
            System.out.println("Course Teacher: " + courseList.get(courseID).getTeacher().getName());
        }
    }*/


    public void ShowStudents(){ //This command will display a list of all students
        for (Student student : studentList.values()){
            System.out.println(student.getName());
        }
    }

   /* public void ShowStudents(){ //This command will display a list of all students
        System.out.println("List of Students: ");
        for (Map.Entry<String, Student> entry : studentList.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().getName());
        }
    }*/

    /*public void LookupStudent(Student studentID){ //This command will display the full details of the specified student
        Student student = studentList.get(studentID);

        System.out.println(student.getName());
        System.out.println(student.getAddress());
        System.out.println(student.getCourse());
        System.out.println(student.getEmail());
    }*/


    public void LookupStudent(String studentID){ //This command will display the full details of the specified student
        if(studentList.containsKey(studentID)){
            System.out.println("Student ID: " + studentID);
            System.out.println("Student Name: " + studentList.get(studentID).getName());
            System.out.println("Student Address: " + studentList.get(studentID).getAddress());
            System.out.println("Student Email: " + studentList.get(studentID).getEmail());
            System.out.println("Student Course: " + studentList.get(studentID).getCourse().getName());
        }
    }

    public void LookupTeacher(String teacherID){ // This command will display the full details of the specified teacher
        Teacher teacher = teacherList.get(teacherID);

        System.out.println(teacher.getName());
        System.out.println(teacher.getSalary());
        System.out.println(teacher.getClass());
        if(teacherList.containsKey(teacherID)){
            System.out.println("Teacher ID: " + teacherID);
            System.out.println("Teacher Name: " + teacherList.get(teacherID).getName());
            System.out.println("Teacher Salary: " + teacherList.get(teacherID).getSalary());
        }
    }

    public void ShowProfit(){ //This command will calculate (The total money earned from all courses) - (The sum of all the teachers' salaries) and return the result
        if (courseList.isEmpty())
            return ;

        double profit = 0;
        for (Course oneCourse : courseList.values()) {
            profit += oneCourse.getMoney_earned();
            if (oneCourse.getTeacher() != null)
                profit -= oneCourse.getTeacher().getSalary();
        }

        System.out.println("Total profit: " + profit + "€");
    }
}

