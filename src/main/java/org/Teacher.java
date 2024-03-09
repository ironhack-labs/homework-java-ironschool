package org;

public class Teacher {
    private String id;
    private String name;
    private double salary;
    private static int idCounter = 1;

    public Teacher(String name, double salary) {
        assignTeacherId();
        setName(name);
        setSalary(salary);
    }

    public boolean getTeacherById(String idToCheck){
        return this.id.equals(idToCheck);
    }
    private void assignTeacherId(){
        this.id = "T" + String.valueOf(idCounter++);
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    //getters
    public String getTeacherId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getSalary() {
        return this.salary;
    }

    //TODO Agregar
    public String getInfo(){
        return ("Teacher - ID: " + getTeacherId() + " | Name: " +
            getName() + " | Salary: " + getSalary());
    }

}