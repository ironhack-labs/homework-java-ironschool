package org;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String schoolName = "";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hi!");
        System.out.println("Welcome to the School Manager Tool.");

        System.out.println(printBlue("Please, text the name for your school:"));
        schoolName = scanner.nextLine();
        System.out.println("Perfect, we have created the school: " + printPurple(schoolName));

        itemCreator("teacher", schoolName);
        itemCreator("course", schoolName);
        itemCreator("student", schoolName);

        scanner.close();
    }

    private static void itemCreator(String type, String schoolName) {
        boolean is_num = false;
        int totalItems = 0;
        Scanner scanner = new Scanner(System.in);

        while (!is_num) {
            System.out.println(printBlue("How many " + type + "s are in " + schoolName + "?"));
            try {
                totalItems = scanner.nextInt();
                scanner.nextLine();
                if (totalItems > 0) {
                    System.out.println("Perfect, let's create now each " + type);
                    for (int i = 0; i < totalItems; i++) {
                        System.out.println("Execute " + type + "Creator " + (i+1));
                    }
                    System.out.println("Perfect, we have created all the " + type + "s.");
                    is_num = true;
                } else {
                    System.err.println("Oops! You need to have at least one " + type + ".");
                }
            } catch (InputMismatchException ie) {
                scanner.nextLine();
                System.err.println("Oops! You need to enter a number.");
            }
        }
        is_num = false;
    }

    private static String printBlue(String text) {
        return ConsoleColors.BLUE + text + ConsoleColors.RESET;
    }

    private static String printPurple(String text) {
        return ConsoleColors.PURPLE + text + ConsoleColors.RESET;
    }
}
