import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Setter
@Getter
public class Commands{
    private Map<String, Course> courseList = new LinkedHashMap<>();
    private Map<String, Student> studentList = new LinkedHashMap<>();
    private Map<String, Teacher> teacherList = new LinkedHashMap<>();


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
        String studentID = "";
        String courseID = "";
        String teacherID = "";
        Boolean validOption = false;
        Scanner scanner = new Scanner(System.in);

        switch (commandAction){
            case ENROLL:
                do {
                    System.out.println("Which course do you want to enroll? (write the id):\n");
                    courseList.forEach((key, value) -> {
                        System.out.println(key + " = " + value.getName() + " ");
                    });
                    try {
                        courseID = scanner.next();
                        if (courseList.containsKey(courseID)) {
                            validOption = true;
                        }else{
                            System.err.println("The course introduced does not exist");
                        }
                    }catch(IllegalArgumentException iae){
                        System.err.println("The option introduced is not correct");
                    }
                }while(validOption == false);
                validOption = false;
                do {
                    System.out.println("Which student do you want to enroll in this course? (write the id):\n");
                    studentList.forEach((key, value) -> {
                        System.out.println(key + " = " + value.getName() + " ");
                    });
                    try {
                        studentID = scanner.next();
                        if (studentList.containsKey(studentID)) {
                            enroll(studentID, courseID);
                            validOption = true;
                        }else{
                            System.err.println("The student introduced does not exist");
                        }
                    } catch (IllegalArgumentException iae) {
                        System.err.println("The option introduced is not correct");
                    }
                }while(validOption == false);
                break;
            case ASSIGN:
                do {
                    System.out.println("In which course do you want to assign a teacher? (write the id):\n");
                    courseList.forEach((key,value) -> {
                        System.out.println(key + " = " + value.getName() + " ");
                    });
                    try{
                        courseID = scanner.next();
                        if(courseList.containsKey(courseID)){
                            validOption = true;
                        }else{
                            System.err.println("The course introduced does not exist");
                        }
                    }catch(IllegalArgumentException iae){
                        System.err.println("The option introduced is not correct");
                    }
                }while(validOption == false);
                validOption = false;
                do{
                    System.out.println("Which teacher do you want to assign to this course? (write the id):\n");
                    teacherList.forEach((key,value) -> {
                        System.out.println(key + " = " + value.getName()+ " ");
                    });
                    try {
                        teacherID = scanner.next();
                        if(teacherList.containsKey(teacherID)){
                            assign(teacherID, courseID);
                            validOption = true;
                        }else{
                            System.err.println("The teacher introduced does not exist");
                        }
                    }catch(IllegalArgumentException iae){
                        System.err.println("The option introduced is not correct");
                    }
                }while(validOption == false);
                break;
            case SHOW_COURSES:
                ShowCourses();
                break;
            case LOOKUP_COURSE:
                do{
                    System.out.println("Which course do you want to look up? (write the id):\n");
                    courseList.forEach((key,value) -> {
                        System.out.println(key + " = " + value.getName() + " ");
                    });
                    try{
                        courseID = scanner.next();
                        if(courseList.containsKey(courseID)){
                            LookupCourse(courseID);
                            validOption = true;
                        }else{
                            System.err.println("The course introduced does not exist");
                        }
                    }catch(IllegalArgumentException iae){
                        System.err.println("The option introduced is not correct");
                    }
                }while(validOption == false);
                break;
            case SHOW_STUDENTS:
                ShowStudents();
                break;
            case LOOKUP_STUDENT:
                do{
                    System.out.println("Which student do you want to look up? (write the id):\n");
                    studentList.forEach((key,value) -> {
                        System.out.println(key + " = " + value.getName() + " ");
                    });
                    try{
                        studentID = scanner.next();
                        if(studentList.containsKey(studentID)){
                            LookupStudent(studentID);
                            validOption = true;
                        }else{
                            System.err.println("The student introduced does not exist");
                        }
                    }catch(IllegalArgumentException iae){
                        System.err.println("The option introduced is not correct");
                    }
                }while(validOption == false);
                break;
            case SHOW_TEACHERS:
                ShowTeachers();
                break;
            case LOOKUP_TEACHER:
                do{
                    System.out.println("Which teacher do you want to look up? (write the id):\n");
                    teacherList.forEach((key,value) -> {
                        System.out.println(key + " = " + value.getName() + " ");
                    });
                    try{
                        teacherID = scanner.next();
                        if(teacherList.containsKey(teacherID)){
                            LookupTeacher(teacherID);
                            validOption = true;
                        }else{
                            System.err.println("The teacher introduced does not exist");
                        }
                    }catch(IllegalArgumentException iae){
                        System.err.println("The option introduced is not correct");
                    }
                }while(validOption == false);
                break;
            case SHOW_PROFIT:
                ShowProfit();
                break;
            case SHOW_COURSE_STUDENTS:
                do{
                    System.out.println("Which course do you want to look up? (write the id):\n");
                    courseList.forEach((key,value) -> {
                        System.out.println(key + " = " + value.getName() + " ");
                    });
                    try{
                        courseID = scanner.next();
                        if(courseList.containsKey(courseID)){
                            ShowCourseStudents(courseID);
                            validOption = true;
                        }else{
                            System.err.println("The course introduced does not exist");
                        }
                    }catch(IllegalArgumentException iae){
                        System.err.println("The option introduced is not correct");
                    }
                } while(!validOption);
                break;
            default:
                System.err.println("The command selected is not available");
                break;
        }
    }

    public void enroll(String studentID, String courseID) {
        Student student = studentList.get(studentID);
        Course course = courseList.get(courseID);
        course.courseEnroll(student);
        student.setCourse(course);

        // Increase money earned
        course.setMoney_earned(course.getMoney_earned() + course.getPrice());
    }

    public void assign(String teacherID, String courseID){   //This command will help assign the teacher specified to the corresponding course
        Teacher teacher = teacherList.get(teacherID);
        Course course = courseList.get(courseID);

        course.setTeacher(teacher);
    }

    public void ShowCourses(){    //This command will display a list of all courses

        System.out.println("List of Courses: ");
        for (Map.Entry<String, Course> entry : courseList.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().getName());
        }
    }

    public void LookupCourse(String courseID) { // This command will display the full details of the specified course

        if (courseList.containsKey(courseID)) {
            System.out.println("Course ID: " + courseID);
            System.out.println("Course Name: " + courseList.get(courseID).getName());
            System.out.println("Course Price: " + courseList.get(courseID).getPrice());
            System.out.println("Course Money Earned: " + courseList.get(courseID).getMoney_earned());
            if (courseList.get(courseID).getTeacher() == null) {
                System.out.println("Course Teacher: " + "No teacher assigned");
            } else {
            System.out.println("Course Teacher: " + courseList.get(courseID).getTeacher().getName()); }
        }
    }
    public void ShowStudents(){ //This command will display a list of all students

        System.out.println("List of Students: ");
        for (Map.Entry<String, Student> entry : studentList.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().getName());
        }
    }

    public void LookupStudent(String studentID){ //This command will display the full details of the specified student

        if(studentList.containsKey(studentID)){
            System.out.println("Student ID: " + studentID);
            System.out.println("Student Name: " + studentList.get(studentID).getName());
            System.out.println("Student Address: " + studentList.get(studentID).getAddress());
            System.out.println("Student Email: " + studentList.get(studentID).getEmail());
            if (studentList.get(studentID).getCourse() == null) {
                System.out.println("Student Course: " + "No course enrolled");
            }else{
                System.out.println("Student Course: " + studentList.get(studentID).getCourse().getName());}
        }
    }

    public void ShowTeachers(){ //This command will display a list of all teachers

        System.out.println("List of Teachers: ");
        for (Map.Entry<String, Teacher> entry : teacherList.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().getName());
        }
    }

    public void LookupTeacher(String teacherID){ // This command will display the full details of the specified teacher

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

    public void ShowCourseStudents(String courseID){ //This command will list the students enrolled in the given course
        Course course = courseList.get(courseID);
        List<Student> students = course.getStudents();

        if (students.isEmpty()) {
            System.out.println(course.getName() + " has no students enrolled");
            return ;
        }
        System.out.println(course.getName() + " students:");
        for (Student student : students) {
            System.out.println(student.getStudentId() + ": " + student.getName());
        }
    }
}

