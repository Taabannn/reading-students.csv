package ir.maktab58.filesq4q5.models;

import lombok.*;

import java.util.Objects;

/**
 * @author Taban Soleymani
 */

@AllArgsConstructor
@ToString
public class Course {
    private @Getter @Setter int id;
    private @Getter @Setter String courseName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return courseName.equals(course.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName);
    }
}
