import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        createSchoolName();
        numberOfTeachers();


    }
    private static final Scanner scanner = new Scanner(System.in);

    private static void createSchoolName() {
        System.out.println("Welcome to the School Application");
        System.out.println("Please enter the name of the school:");

        String schoolName = scanner.nextLine();
        System.out.println("Your school is: " + schoolName);

    }
    private static int numberOfTeachers() {

        int numberofTeachers;
        do {
            System.out.println("How many teachers are there in the school: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number for the teachers.");
                scanner.next();
            }
            numberofTeachers = scanner.nextInt();
        } while (numberofTeachers <= 0);


        System.out.println("In your school there are: " + numberofTeachers + " teachers");
        return numberofTeachers;


        }

}




