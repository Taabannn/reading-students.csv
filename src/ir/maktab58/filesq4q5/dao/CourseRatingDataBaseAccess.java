package ir.maktab58.filesq4q5.dao;

import ir.maktab58.filesq4q5.models.CourseRating;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * @author Taban Soleymani
 */
public class CourseRatingDataBaseAccess extends DataBaseAccess{
    public CourseRatingDataBaseAccess() {super();}

    public boolean saveStudentCourseRating(CourseRating courseRating, Timestamp timestamp) {
        if (connection != null) {
            try {
                String sqlQuery = String.format("INSERT INTO student_course_rating (id, fk_course_id, fk_student_id, rate, time_stamp, comment) VALUES (?, ?, ?, ?, ?, ?)");
                PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);
                prepareStatement.setInt(1, courseRating.getId());
                prepareStatement.setInt(2, courseRating.getCourse().getId());
                prepareStatement.setInt(3, courseRating.getStudent().getId());
                prepareStatement.setDouble(4, courseRating.getRate());
                prepareStatement.setTimestamp(5, timestamp);
                prepareStatement.setString(6, courseRating.getComment());
                boolean result = prepareStatement.execute();
                return !result;
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
        return false;
    }
}
