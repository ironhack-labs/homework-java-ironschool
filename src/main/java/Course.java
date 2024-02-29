
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.UUID;
@Getter
@Setter
public class Course {
    private String courseId;
    private String name;

    private double price;
    private double money_earned;
    private Teacher teacher;
    private HashMap<String, Course> courseList = new HashMap<String, Course>();


    public Course(String name, double price) {
        setCourseId(UUID.randomUUID().toString());
        setName(name);
        setPrice(price);
    }

    public void courseEnroll(Student student, Course x){
        courseList.put(student.getStudentId(), x);
    }
}
