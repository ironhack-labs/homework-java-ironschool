package ironhack.com;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Course extends Person {
    private String Id;
    private String name;
    private double price;
    private double money_earned;
    private Teacher teacher;

    public Course(String name) {
        super(name);
    }

    public Course(String name, double price){
        super(name);
        setPrice(price);
    }
    public Course(String name, double price,Teacher teacher){
        super(name);
        setPrice(price);
        setTeacher(teacher);
    }
    public void assign(String teacherId) {
        //setTeacher();
    }
}
