package ir.maktab58.filesq4q5.models;

import lombok.*;

/**
 * @author Taban Soleymani
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Review {
    private @Getter @Setter String courseName;
    private @Getter @Setter String studentName;
    private @Getter @Setter String timestamp;
    private @Getter @Setter double rating;
    private @Getter @Setter String comment;
}

