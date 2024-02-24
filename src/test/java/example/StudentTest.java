package example;

public class StudentTest {
    public static void main(String[] args) {
        Student student = new Student("", "", "");

        student.setName("John Doe");
        student.setAddress("Calle Falsa 123, Springfield");
        student.setEmail("johndoe@test.com");

        System.out.println("Student ID: " + student.getStudentId());
        System.out.println("Name: " + student.getName());
        System.out.println("Address: " + student.getAddress());
        System.out.println("Email: " + student.getEmail());
        System.out.println("Course: " + student.getCourse());
    }
}
