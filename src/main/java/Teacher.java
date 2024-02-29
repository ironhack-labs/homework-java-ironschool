import java.util.UUID;


public class Teacher {
    private final String teacherId;
    private String name;
    private double salary;

    public Teacher(String name, double salary) {
        this.teacherId = UUID.randomUUID().toString();
        setName(name);
        setSalary(salary);
    }

    public String getTeacherId() {
        return teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public boolean setSalary(double salary) {
        if (salary < 0) {
            return false;
        } else {
            this.salary = salary;
        }
        return true;
    }

}