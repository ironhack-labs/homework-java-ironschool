import com.github.lalyos.jfiglet.FigletFont;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Menu {
    private static final int OPTION_DATA_ENTRY = 1;
    private static final int OPTION_SCHOOL_MANAGEMENT = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(FigletFont.convertOneLine("Iron-School"));
        int selectedOption = showPrincipalMenuAndRetrieveOption(sc);
        System.out.println("Option Selected: " + selectedOption);
    }

        public static int showPrincipalMenuAndRetrieveOption(Scanner sc) {
            System.out.println("Select option");
            System.out.println(OPTION_DATA_ENTRY + " -> Data Entry");
            System.out.println(OPTION_SCHOOL_MANAGEMENT + " -> School Management");


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


