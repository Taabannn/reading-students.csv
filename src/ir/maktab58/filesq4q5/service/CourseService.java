package ir.maktab58.filesq4q5.service;

import ir.maktab58.filesq4q5.dao.CourseDataBaseAccess;
import ir.maktab58.filesq4q5.exceptions.StudentCourseRatingSysEx;
import ir.maktab58.filesq4q5.models.Course;

/**
 * @author Taban Soleymani
 */
public class CourseService {
    private final CourseDataBaseAccess courseAccess = new CourseDataBaseAccess();

    public void saveACourse(Course course) {
        boolean isSaved = courseAccess.saveCourse(course);
        if (isSaved) {
            System.out.println(course + " is saved successfully.");
        } else {
            throw new StudentCourseRatingSysEx(course + " is not saved.", 500);
        }
    }
}
