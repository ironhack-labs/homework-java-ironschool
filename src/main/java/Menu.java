import com.github.lalyos.jfiglet.FigletFont;
import model.School;
import model.Teacher;
import org.w3c.dom.ls.LSOutput;
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
    private static int numberOfTeacher;
    private static int numberOfStudent;

    public static void main(String[] args) {
        System.out.println(FigletFont.convertOneLine(getSchoolName()));
        //System.out.println("Option Selected: " + showPrincipalMenuAndRetrieveOption(scanner));
        numberOfCourses = getNumberOfEntity("courses", MaxValue.MAX_COURSES_TO_CREATE.getValue());
        numberOfTeacher = getNumberOfEntity("teachers", MaxValue.MAX_TEACHER_TO_CREATE.getValue());
        numberOfStudent = getNumberOfEntity("students", MaxValue.MAX_STUDENT_TO_CREATE.getValue());
    }

    private static String getSchoolName() {
        String schoolName;
        do {
            System.out.println("Enter a school name: ");
            schoolName = scanner.nextLine();
        } while (!Validator.isNameValid(schoolName));
        return schoolName;
    }

    private static int getNumberOfEntity(String value, int max) {
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
}


