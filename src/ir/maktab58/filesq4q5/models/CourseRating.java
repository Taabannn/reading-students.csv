package ir.maktab58.filesq4q5.models;

import lombok.*;

/**
 * @author Taban Soleymani
 */

@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class CourseRating {
    private @Getter @Setter int id;
    private @Getter @Setter Course course;
    private @Getter @Setter Student student;
    private @Getter @Setter double rate;
    private @Getter @Setter String timeStamp;
    private @Getter @Setter String comment;
}
