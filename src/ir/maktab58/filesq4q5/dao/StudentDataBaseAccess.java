package ir.maktab58.filesq4q5.dao;

import ir.maktab58.filesq4q5.models.Student;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Taban Soleymani
 */
public class StudentDataBaseAccess extends DataBaseAccess {
    public StudentDataBaseAccess() {super();}

    public boolean saveStudent(Student student) {
        if (connection != null) {
            try {
                String sqlQuery = String.format("INSERT INTO student (student_id, student_name) VALUES (?, ?)");
                PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);
                prepareStatement.setInt(1, student.getId());
                prepareStatement.setString(2, student.getStudentName());
                boolean result = prepareStatement.execute();
                return !result;
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
        return false;
    }
}
