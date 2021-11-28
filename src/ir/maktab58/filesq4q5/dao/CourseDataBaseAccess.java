package ir.maktab58.filesq4q5.dao;

import ir.maktab58.filesq4q5.models.Course;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Taban Soleymani
 */
public class CourseDataBaseAccess extends DataBaseAccess {
    public CourseDataBaseAccess() {super();}

    public boolean saveCourse(Course course) {
        if (connection != null) {
            try {
                String sqlQuery = String.format("INSERT INTO course (course_id, course_name) VALUES (?, ?)");
                PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);
                prepareStatement.setInt(1, course.getId());
                prepareStatement.setString(2, course.getCourseName());
                boolean result = prepareStatement.execute();
                return !result;
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
        return false;
    }
}
