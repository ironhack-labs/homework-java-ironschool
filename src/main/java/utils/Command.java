package utils;

import lombok.Getter;

@Getter
public enum Command {
    ENROLL("1", "Enroll student in a course"),
    ASSIGN ("2", "Assign teacher in a course"),
    SHOW_COURSES("3", "Show courses"),
    LOOKUP_COURSE("4", "Look up for a course"),
    SHOW_STUDENTS("5", "Show students"),
    LOOKUP_STUDENT("6", "Look up for a student"),
    SHOW_TEACHERS("7", "Show teachers"),
    LOOKUP_TEACHER("8", "Look up for a teacher"),
    SHOW_PROFIT("9", "Show profit"),
    SHOW_STUDENTS_BY_COURSE_ID("10", "Show students by course ID"),
    EXIT("0", "Exit program");

    private final String index;
    private final String description;

    Command(String index, String description) {
        this.index = index;
        this.description = description;
    }
}
