package org;



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
        System.out.print("Enter your choice: ");
    }

    public static void enrollStudent(String studentId, String courseId) {
        // Create an instance of the Command class so we don't have to change lookups to static
        Command command = new Command();

        // Call the lookupCourse method on the instance
        Course course = command.lookupCourse(courseId);

        // Check if the course exists and the student is not enrolled in another course
        if (course == null) {
            throw new IllegalArgumentException("Invalid course.");
        }

        // Get the student by id
        Student student = command.lookupStudent(studentId);

        // Check if the student is already enrolled in the course
        if (student.getCourse() != null) {
            throw new IllegalArgumentException("Student is already enrolled in a course.");
        }

        // Enroll student in the course
        student.setCourse(course);

        // Update money earned in the course based on its price
        course.updateMoney_earned(course.getPrice());
    }

    public static void assignTeacher(String teacherId, String courseId, School school){
        //find course by id, getCourseMap()
        Course course = School.getCourseById(courseId, school.getCourseMap());
        //find teacher by teacher id, getTeacherMap()
        Teacher teacher = School.getTeacherById(teacherId, school.getTeacherMap());
        //set teacher to course
        if(course == null){
            System.out.println("Course doesn't exist");
        } else {
            course.setTeacher(teacher);
            System.out.println("teacher assigned!");
        }
    }



    public List<Course> showCourses(){}

    public List<Student> showStudents(){}

    public List<Teacher> showTeachers(){}

    public Course lookupCourse(String courseId){}

    public Student lookupStundent(String studentId){}

    public Teacher lookupTeacher(String teacherId){}

    public double showProfit(School school) throws IllegalArgumentException {
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
