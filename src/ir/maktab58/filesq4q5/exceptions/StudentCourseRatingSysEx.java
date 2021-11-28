package ir.maktab58.filesq4q5.exceptions;

/**
 * @author Taban Soleymani
 */
public class StudentCourseRatingSysEx extends RuntimeException {
    private int errorCode;

    public StudentCourseRatingSysEx(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
