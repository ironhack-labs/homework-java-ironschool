package org;

public class PrintUtils {

    static String printBlue(String text) {
        return ConsoleColors.BLUE + text + ConsoleColors.RESET;
    }

    static String printPurple(String text) {
        return ConsoleColors.PURPLE + text + ConsoleColors.RESET;
    }

    static String printYellow(String text) {
        return ConsoleColors.YELLOW + text + ConsoleColors.RESET;
    }

    static String printRed(String text) {
        return ConsoleColors.RED + text + ConsoleColors.RESET;
    }

    static String printCyan(String text) { return ConsoleColors.CYAN + text + ConsoleColors.RESET; }

    static String printBlueBold(String text) { return ConsoleColors.BLUE_BOLD + text + ConsoleColors.RESET; }

}
