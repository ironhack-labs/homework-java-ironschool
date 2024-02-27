package ironhack.com;
import lombok.Getter;
import lombok.Setter;
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
        this.email = email;
    }

    public Student(String name, String address, String email, List<Course> courseList) {
        super(name);
        this.address = address;
        this.email = email;
        this.courseList = courseList;
    }

    public void printInfo() {
        System.out.println("Id: " + getId()
                + ", Name: " + getName()
                + ", Address: " + getAddress()
                + ", Email: " + getEmail()
                + ", Courses: " + (getCourseList() != null ? getCourseList().toString() : "N/A"));
    }
}