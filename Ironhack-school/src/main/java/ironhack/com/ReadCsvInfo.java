package ironhack.com;

import java.io.*;
import java.util.*;

import static ironhack.com.Course.findCourseByName;

public class ReadCsvInfo {
    public static List<Course> global_course;
    //TODO handling possible exceptions
    public static String[]  readSchoolInfo() throws FileNotFoundException {
        String SCHOOL_PATH = "src/files/School.csv";
        File file_school = new File(SCHOOL_PATH);
        Scanner school_scanner =new Scanner(file_school);

        school_scanner.nextLine();
        String[] school_vector = school_scanner.nextLine().split(",");
        return school_vector;
    }
    public static <ObjectType> List<ObjectType> readObjectInfo(String path, int rowsToRead, RoleType type, boolean totalRows) throws IOException {
        File file = new File(path);
        Scanner sc = new Scanner(file);
        List<ObjectType> objectList = new ArrayList<>();

        if (totalRows){
            rowsToRead =countLines(path)-1;
        }

        sc.nextLine();
        for (int i = 1; i <= rowsToRead; i++) {
            String[] properties = sc.nextLine().split(",");
            ObjectType newObj = createInstance(type, properties);
            if (newObj!=null) {
                objectList.add(newObj);
            }
        }
        return objectList;
    }

    public static <ObjectType> ObjectType createInstance(RoleType type, String[] properties) {
        switch (type) {
            case TEACHER:
                if (!Utils.validateName(properties[0])) {
                    System.out.println("Invalid teacher name: " + properties[0]);
                    return null;
                }
                @SuppressWarnings("unchecked")
                ObjectType teacher = (ObjectType) new Teacher(properties[0], Double.parseDouble(properties[1]));
                return teacher;
            case STUDENT:

                if (!Utils.validateName(properties[0]) || !Utils.ValidateEmail.isValidEmail(properties[2])) {
                    System.out.println("Invalid student name or email: " + properties[0] + ", " + properties[2]);
                    return null;
                }
                List<Course> courses_list= new ArrayList<>();
                Course posible_course=null;
                for (String course: parseCourseList(properties[3])){
                    if(!course.equals("") ){
                        posible_course = findCourseByName(global_course, course);
                    }
                    if (posible_course!=null){
                        courses_list.add(posible_course);
                    }
                }
                if (courses_list!=null){
                    @SuppressWarnings("unchecked")
                    ObjectType student = (ObjectType) new Student(properties[0], properties[1], properties[2],courses_list);
                    return student;
                }else{
                    @SuppressWarnings("unchecked")
                    ObjectType student = (ObjectType) new Student(properties[0], properties[1], properties[2]);
                    return student;
                }
            case COURSE:
               // if (!Utils.validateName(properties[0])) {
                //    System.out.println("Invalid course name: " + properties[0]);
                //    return null;
                //}
                @SuppressWarnings("unchecked")

                ObjectType course = (ObjectType) new Course(properties[0], Double.parseDouble(properties[1]));
                return course;
            default:
                throw new IllegalArgumentException("Invalid RoleType");
        }
    }
    public static List<String> parseCourseList(String courseListString) {
        List<String> courses = new ArrayList<>();

        String trimmedString = courseListString.substring(1, courseListString.length() - 1);
        String[] coursesArray = trimmedString.split("\\|");

        for (String course : coursesArray) {
            courses.add(course.trim());
        }

        return courses;
    }
    public static int countLines(String filePath) throws IOException {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while (br.readLine() != null) {
                count++;
            }
        }
        return count;
    }
    public static School school_creation_csv() {
        School school = null;
        try {
            String[] school_info = readSchoolInfo();


            List<Teacher> teachers = readObjectInfo("src/files/Teachers.csv",1,RoleType.TEACHER, true);
            global_course = readObjectInfo("src/files/Courses.csv",2,RoleType.COURSE,true);
            List<Student> students = readObjectInfo("src/files/Students.csv",2,RoleType.STUDENT,true);


            school = new School(school_info[0]);
            school.setListToStudentMap(students);
            school.setListToTeacherMap(teachers);
            school.setListToCourseMap(global_course);

            System.out.println("All Courses");
            school.showCourses();

            System.out.println("All Teachers");
            school.showTeachers();

            System.out.println("All Students");
            school.showStudents();
            return school;
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
            return school;
        } catch (IOException e) {
            System.err.println("problem with csv, skipped school creation");
            return school;
        }
    }

}
