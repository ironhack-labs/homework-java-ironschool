package utils;

import lombok.Getter;

@Getter
public enum MaxValue {
    MAX_COURSES_TO_CREATE(5),
    MAX_STUDENT_TO_CREATE(10),
    MAX_TEACHER_TO_CREATE(20);

    private final int value;

    MaxValue(int value) {
        this.value = value;
    }
}
