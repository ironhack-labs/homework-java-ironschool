package org;


import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Command {

    public static void displayCommands(){
        System.out.println("1. Enroll a new student");
        System.out.println("2. Assign teacher to a course");
        System.out.println("3. See all courses");
        System.out.println("4. Search for a specific course");
        System.out.println("5. See all students");
        System.out.println("6. Search for a specific student");
        System.out.println("7. See all teachers");
        System.out.println("8. Search for a specific teacher");
        System.out.println("9. Show profit");
        System.out.println("10. Remove teacher from course");
        System.out.println("11. Unenroll student from course");
        System.out.println("12. Enroll a list of students to course");
        System.out.println("13. Exit program");
        System.out.print("Enter your choice: ");
    }

    public static void enrollStudent(String studentId, String courseId, School school) {
        // Gets student by looking through students map
        Student student = CommandUtils.lookUpStudent(school.getStudentMap(), studentId);
        // Gets course by looking through courses map
        Course course = CommandUtils.lookUpCourse(school.getCourseMap(), courseId);

        // Checks if the course and the student exist
        if (student != null && course != null) {
            // Check if the student is already enrolled in another course
            //**************mas cambios lista courses
//            if (student.getCourse() != null) {
//                throw new IllegalArgumentException("Student is already enrolled in a course.");
//            }
            if (student.getCourse().contains(course)) {
                throw new IllegalArgumentException("Student is already enrolled in a course.");
            }


            // Enrolls student in the course
            //student.setCourse(course); añadido!!
            student.addCourse(course);

            // Updates money earned in the course based on its price
            course.updateMoney_earned(course.getPrice());
        } else {
            throw new IllegalArgumentException("Invalid student or course ID.");
        }
    }

//    public static Course assignTeacher(String teacherId, String courseId, School school){
//        //find course by id, getCourseMap()
//        Course course = CommandUtils.lookUpCourse(school.getCourseMap(), courseId);
//        //find teacher by teacher id, getTeacherMap()
//        Teacher teacher = CommandUtils.lookUpTeacher(school.getTeacherMap(), teacherId);
//        //set teacher to course
//        if(course == null){
//            throw new IllegalArgumentException("Course doesn't exist!");
//        } else {
//            course.setTeacher(teacher);
//            return course;
//        }
//    }

    public static void assignTeacher(String teacherId, String courseId, School school){
        //find course by id, getCourseMap()
        Course course = CommandUtils.lookUpCourse(school.getCourseMap(), courseId);
        //set teacher to course
        if(course == null){
            throw new IllegalArgumentException("Course doesn't exist!");
        }

        //find teacher by teacher id, getTeacherMap()
        Teacher teacher = CommandUtils.lookUpTeacher(school.getTeacherMap(), teacherId);

        if(teacher == null){
            throw new IllegalArgumentException("Teacher doesn't exist!");
        }
        course.setTeacher(teacher);
        //teacher.setCourse(course);
    }

    public static void removeTeacherFromCourse(String courseId, School school){
        //find course by id, getCourseMap()
        Course course = CommandUtils.lookUpCourse(school.getCourseMap(), courseId);

        if(course == null){
            throw new IllegalArgumentException("Course doesn't exist!");
        } else if (course.getTeacher() == null){
            throw new IllegalArgumentException("No teacher assigned to this course!");
        }

        else {
            course.removeTeacher();
        }
    }
    public static void unenrollStudent(String studentId, String courseId, School school){
        // Gets student by looking through students map
        Student student = CommandUtils.lookUpStudent(school.getStudentMap(), studentId);
        // Gets course by looking through courses map
        Course course = CommandUtils.lookUpCourse(school.getCourseMap(), courseId);
        // Checks if the course and the student exist
        if (student != null && course != null) {
            // Check if the student is enrolled in the given course
            if (isStudentEnrolledInCourse(student, courseId)) {
                // Remove the course from the student
                student.removeCourse(course);

                // Update money earned in the course based on its price
                course.updateMoney_earned(course.getMoney_earned() - course.getPrice());
            } else {
                throw new IllegalArgumentException("Student is not enrolled in this course.");
            }
        } else {
            throw new IllegalArgumentException("Invalid student or course ID.");
        }
    }

    // Helper method to check if a student is enrolled in a given course
    public static boolean isStudentEnrolledInCourse(Student student, String courseId) {
        List<Course> courses = student.getCourse();
        for (Course course : courses) {
            if (Objects.equals(course.getCourseId(), courseId)) {
                return true;
            }
        }
        return false;
    }


    public static void enrollStudents(List<String> studentsIds, String courseId, School school) {
        Course course = CommandUtils.lookUpCourse(school.getCourseMap(), courseId);
        for(String id : studentsIds){
            Student student = CommandUtils.lookUpStudent(school.getStudentMap(), id);
            // Checks if the course and the student exist
            if (student != null && course != null) {
            //no comprobar si uno ya está matriculado, se vuelve a matricular

                // Enrolls student in the course
                student.addCourse(course);

                // Updates money earned in the course based on its price
                course.updateMoney_earned(course.getPrice());
            } else {
                throw new IllegalArgumentException("Invalid student or course ID.");
            }
        }
    }
    //añadirlo al comando Show all courses?:
    public static void showStudentsOfCourse(String courseId, Map<String,Student> studentsMap){

        studentsMap.forEach((id, student) -> {
            if(isStudentEnrolledInCourse(student, courseId)){
                System.out.println(student.getInfo());
            }
        });
    }

    public static double showProfit(School school) throws IllegalArgumentException {
        double totalMoneyEarned = 0;
        double totalTeacherSalaries = 0;

        try {
            // Calculate total money earned from all courses
            for (Course course : school.getCourseMap().values()) {
                totalMoneyEarned += course.getMoney_earned();
            }

            // Calculate the sum of all the teachers' salaries
            for (Teacher teacher : school.getTeacherMap().values()) {
                totalTeacherSalaries += teacher.getSalary();
            }

            // Return the result (difference)
            return totalMoneyEarned - totalTeacherSalaries;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("An error occurred while calculating profit: " + e.getMessage());
        }
    }

}
