package ironhack.com;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Course {
    private String Id;
    private String name;
    private double price;
    private double money_earned;
    private Teacher teacher;

    public void setId(){
        setId(Utils.generateSerialId());
    }
    public Course(String name) {
        setId();
        setName(name);
    }

    public Course(String name, double price){
        setId();
        setName(name);
        setPrice(price);
    }
    public Course(String name, double price,Teacher teacher){
        setId();
        setName(name);
        setPrice(price);
        setTeacher(teacher);
    }
    public void assign(Teacher teacher) {
        setTeacher(teacher);
    }

    public void printInfo() {
        System.out.println("Id: " + getId()
                + ", Name: " + getName()
                + ", Price: " + getPrice()
                + ", Money Earned: " + getMoney_earned()
                + ", Teacher: " +(getTeacher() != null ? getTeacher().getName() : "N/A"));
    }

    public static Course findCourseByName(List<Course> courses, String courseName) {
        for (Course course : courses) {
            if (course.getName().equalsIgnoreCase(courseName)) {
                return course;
            }
        }
        return null;
    }
}
