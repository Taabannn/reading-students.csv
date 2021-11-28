package ir.maktab58.filesq4q5.service;

import ir.maktab58.filesq4q5.dao.CourseRatingDataBaseAccess;
import ir.maktab58.filesq4q5.exceptions.StudentCourseRatingSysEx;
import ir.maktab58.filesq4q5.models.CourseRating;

import java.sql.Timestamp;

/**
 * @author Taban Soleymani
 */
public class CourseRatingService {
    private final CourseRatingDataBaseAccess courseRatingAccess = new CourseRatingDataBaseAccess();

    public void saveAStudentCourseRating(CourseRating courseRating) {
        DateAndTimeValidator dateAndTimeValidator = new DateAndTimeValidator();
        Timestamp timestamp = null;
        if (dateAndTimeValidator.validateDateAndTime(courseRating.getTimeStamp()))
            timestamp = Timestamp.valueOf(courseRating.getTimeStamp());
        boolean isSaved = courseRatingAccess.saveStudentCourseRating(courseRating, timestamp);
        if (isSaved) {
            System.out.println(courseRating + " is saved successfully.");
        } else {
            throw new StudentCourseRatingSysEx(courseRating + " is not saved.", 500);
        }
    }
}
