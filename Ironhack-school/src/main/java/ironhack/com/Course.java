package ironhack.com;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Course {
    private String Id;
    private String name;
    private double price;
    private double money_earned;
    private Teacher teacher;

    public void assign(String teacherId) {
        // logica
    }
}
