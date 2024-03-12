package org;

public class Main {
    public static void main(String[] args) {

        School school = SchoolCreator.schoolCreatorNew();
        Commands.menuCommands(school);

    }
}