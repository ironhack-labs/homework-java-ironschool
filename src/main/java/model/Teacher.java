package model;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Teacher {

    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Include
    private final String teacherId;

    @EqualsAndHashCode.Include
    private String name;

    @EqualsAndHashCode.Include
    private double salary;

    public Teacher(String name, double salary) {
        this.teacherId = UUID.randomUUID().toString();
        this.name = name;
        this.salary = salary;
    }
}