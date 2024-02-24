package ironhack.com;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Teacher extends Person {

    private double salary;

    public Teacher(String name, double salary) {
        super(name);
        setSalary(salary);
    }

    public void printInfo() {
        System.out.println("Id: " + getId()
                + ", Name: " + getName()
                + ", Salary: " + getSalary());
    }
}
