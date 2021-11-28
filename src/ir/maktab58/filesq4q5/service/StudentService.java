package ir.maktab58.filesq4q5.service;

import ir.maktab58.filesq4q5.dao.StudentDataBaseAccess;
import ir.maktab58.filesq4q5.exceptions.StudentCourseRatingSysEx;
import ir.maktab58.filesq4q5.models.Student;

/**
 * @author Taban Soleymani
 */
public class StudentService {
    private final StudentDataBaseAccess studentAccess = new StudentDataBaseAccess();

    public void saveAStudent(Student student) {
        boolean isSaved = studentAccess.saveStudent(student);
        if (isSaved) {
            System.out.println(student + " is saved successfully.");
        } else {
            throw new StudentCourseRatingSysEx(student + " is not saved.", 500);
        }
    }
}
