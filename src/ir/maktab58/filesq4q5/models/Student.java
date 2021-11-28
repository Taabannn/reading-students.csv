package ir.maktab58.filesq4q5.models;

import lombok.*;

import java.util.Objects;

/**
 * @author Taban Soleymani
 */

@AllArgsConstructor
@ToString
public class Student {
    private @Getter @Setter int id;
    private @Getter @Setter String studentName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentName.equals(student.studentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentName);
    }
}
