import com.github.lalyos.jfiglet.FigletFont;
import model.School;
import model.SchoolBuilder;
import utils.MainMenuOption;
import utils.MaxValue;
import utils.Validator;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

public class Menu {
    private static final int OPTION_DATA_ENTRY = 1;
    private static final int OPTION_SCHOOL_MANAGEMENT = 2;
    private static final Scanner scanner = new Scanner(System.in);
    private static int numberOfCourses;
    private static int numberOfTeachers;
    private static int numberOfStudents;
    private static School school;

    public static void main(String[] args) {
        school = createSchool();
        //System.out.println("Option Selected: " + showPrincipalMenuAndRetrieveOption(scanner));
        numberOfCourses = getNumberOfEntity("courses", MaxValue.MAX_COURSES_TO_CREATE.getValue());
        numberOfTeachers = getNumberOfEntity("teachers", MaxValue.MAX_TEACHER_TO_CREATE.getValue());
        numberOfStudents = getNumberOfEntity("students", MaxValue.MAX_STUDENT_TO_CREATE.getValue());
    }

    public static String getValidNameFor(String entityType) {
        String name;
        do {
            System.out.printf("Enter a %s name: ", entityType);
            name = scanner.nextLine();
        } while (!Validator.isNameValid(name));
        return name;
    }

    public static int getNumberOfEntity(String value, int max) {
        String number;
        do {
            System.out.printf("Enter the number of %s to create (max-%d): %n", value, max);
            number = scanner.next();
        } while (!Validator.isNumberValid(number, max));
        return Integer.parseInt(number);
    }

    public static int showPrincipalMenuAndRetrieveOption(Scanner sc) {
        System.out.println("Select option");
        Stream.of(MainMenuOption.values()).forEach(opt -> System.out.println((opt.ordinal() + 1) + " - " + opt.getDescription()));

        int selectedOption = -1;
        while (selectedOption != OPTION_DATA_ENTRY && selectedOption != OPTION_SCHOOL_MANAGEMENT) {
            try {
                selectedOption = sc.nextInt();
                if (selectedOption != OPTION_DATA_ENTRY && selectedOption != OPTION_SCHOOL_MANAGEMENT) {
                    System.err.println("Invalid option. Please enter either " + OPTION_DATA_ENTRY + " or " + OPTION_SCHOOL_MANAGEMENT);
                }
            } catch (NoSuchElementException e) {
                System.err.println("Invalid input. Please enter a number.");
                sc.nextLine();
            }
        }
        return selectedOption;
    }

    public static School createSchool() {
        String schoolName = getValidNameFor("school");
        System.out.println(FigletFont.convertOneLine(schoolName));
        return new SchoolBuilder().name(schoolName).build();
    }
}


