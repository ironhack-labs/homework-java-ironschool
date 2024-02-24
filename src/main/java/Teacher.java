import java.util.Random;

public class Teacher {
    private String id;
    private String name;
    private double salary;

    public Teacher(String name, double salary) {
        Random random = new Random();
        this.id =  Integer.toString(random.nextInt(1000));
        setName(name);
        setSalary(salary);
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    //getters
    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getSalary() {
        return this.salary;
    }
}
