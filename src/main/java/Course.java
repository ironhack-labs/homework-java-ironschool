
import java.util.UUID;
public class Course {
    private String courseId;
    private String name;


    private double price;
    private double money_earned;
    private Teacher teacher;


    public Course(String courseId, String name, double price, double money_earned) {
        setCourseId(courseId);
        setName(name);
        setPrice(price);
        setMoney_earned(money_earned);
    }

    public String getCourseId() {
        return UUID.randomUUID().toString();
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMoney_earned() {
        return money_earned;
    }

    public void setMoney_earned(double money_earned) {
        this.money_earned = money_earned;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
