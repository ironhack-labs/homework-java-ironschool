package ironhack.com;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Student extends Person {
    private String address;
    private String email;
    private List<Course> courseList;

    public Student(String name, String address, String email) {
        super(name);
        this.address = address;
        this.setEmail(email);
        courseList = new ArrayList<>();
    }

    public Student(String name, String address, String email, List<Course> courseList) {
        super(name);
        this.address = address;
        this.setEmail(email);
        this.courseList = courseList;
    }

    public void setEmail(String email) {
        if (!Utils.ValidateEmail.isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.email = email;
    }

    public void printInfo() {
        System.out.print("Id: " + getId()
                + ", Name: " + getName()
                + ", Address: " + getAddress()
                + ", Email: " + getEmail()
                + ", Courses: [");
                for(Course course:getCourseList()){
                    System.out.print(course.getName()+" ");
                };
                System.out.println("]");
    }

    public void enrollInCourse(Course course) {
        this.courseList.add(course);
    }
}