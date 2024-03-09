
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Getter
@Setter
public class Course {
    private String courseId;
    private String name;

    private double price;
    private double money_earned;
    private Teacher teacher;
    private List<Student> students = new ArrayList<>();


    public Course(String name, double price) {
        setCourseId(UUID.randomUUID().toString());
        setName(name);
        setPrice(price);
    }

    public void courseEnroll(Student student){
        students.add(student);
    }
}
