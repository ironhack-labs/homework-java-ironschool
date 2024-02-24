package ironhack.com;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class Student extends Person{
    private String address;
    private String email;
    private List<Course> courseList;
}
