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

    public void setSalary(double salary) {
        if (Double.isNaN(salary)) {
            System.err.println("The input for salary must be a number");
        } else {
            this.salary = salary;
        }
    }

    public void printInfo() {
        System.out.println("Id: " + getId()
                + ", Name: " + getName()
                + ", Salary: " + getSalary());
    }
}