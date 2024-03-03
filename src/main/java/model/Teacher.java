package model;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Double.compare(teacher.salary, salary) == 0 &&
                Objects.equals(name, teacher.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }
}