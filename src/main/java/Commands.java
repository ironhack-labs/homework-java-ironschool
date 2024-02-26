import java.util.HashMap;
import java.util.Map;

public class Commands {
    private Map<String, Course> courseList = new HashMap<>();
    private Map<String, Student> studentList = new HashMap<>();
    private Map<String, Teacher> teacherList = new HashMap<>();


    public Commands(Map<String, Course> courseList, Map<String, Student> studentList, Map<String, Teacher> teacherList) {
        setCourseList(courseList);
        setStudentList(studentList);
        setTeacherList(teacherList);
    }

    public Map<String, Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(Map<String, Course> courseList) {
        this.courseList = courseList;
    }

    public Map<String, Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(Map<String, Student> studentList) {
        this.studentList = studentList;
    }

    public Map<String, Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(Map<String, Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public void commandSelector(CommandEnum commandAction){
        String studentID = "asdfasdf";
        String courseID = "asdfasdf";
        String teacherID = "asdfasdf";

        switch (commandAction){
        case ENROLL:
            enroll(studentID,courseID);

            break;
        case ASSIGN:
            assign(teacherID,courseID);
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

    public void enroll(Student studentID, Course courseID) {
        Course course = courseID;
        Student student = studentID;

        courseID.courseEnroll(studentID, courseID);

        // Increase money earned
        courseID.setMoney_earned(courseID.getMoney_earned() + courseID.getPrice());
    }

    public void assign(Teacher teacherID,Course courseID){   //This command will help assign the teacher specified to the corresponding course
        Teacher teacher = teacherID;

        courseID.setTeacher(teacherID);
    }

    public void ShowCourses(){    //This command will display a list of all courses

    }

    public void LookupCourse(String courseID){ // This command will display the full details of the specified course

    }

    public void ShowStudents(){ //This command will display a list of all students

    }

    public void LookupStudent(String studentID){ //This command will display the full details of the specified student

    }

    public void ShowTeachers(){ //This command will display a list of all teachers

    }

    public void LookupTeacher(String teacherID){ // This command will display the full details of the specified teacher

    }

    public void ShowProfit(){ //This command will calculate (The total money earned from all courses) - (The sum of all the teachers' salaries) and return the result

    }
}

