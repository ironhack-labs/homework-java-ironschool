import java.util.Random;

public class Teacher {
    private final String id;
    private String name;
    private double salary;
    private static int indexTeacher = 1;

    public Teacher(String name, double salary) {
        id = generateID(indexTeacher);
        setName(name);
        setSalary(salary);
        indexTeacher++;
    }


    public void getInfo(){
        System.out.println("Teacher - ID: " + getId() + " | Name: " + getName() + " | Salary: " + getSalary());
    }

    public boolean getTeacherById(String idToCheck){
        return this.id.equals(idToCheck);
    }
    static String generateID(int indexTeacher){
        return "T" + Integer.toString(indexTeacher);
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
