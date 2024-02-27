import com.github.lalyos.jfiglet.FigletFont;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

public class Menu {
    private static final int OPTION_DATA_ENTRY = 1;
    private static final int OPTION_SCHOOL_MANAGEMENT = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(FigletFont.convertOneLine("Iron-School"));
        System.out.println("Option Selected: " + showPrincipalMenuAndRetrieveOption(sc));
    }

        public static int showPrincipalMenuAndRetrieveOption(Scanner sc) {
            System.out.println("Select option");
            Stream.of(MainMenuOptions.values()).forEach(opt -> System.out.println((opt.ordinal() + 1) + " - " + opt.getDescription()) );

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


