package ir.maktab58.filesq4q5.view;

import ir.maktab58.filesq4q5.service.StudentCourseRatingSys;

import java.io.IOException;

/**
 * @author Taban Soleymani
 */
public class Main {
    public static void main(String[] args) throws IOException {
        StudentCourseRatingSys ratingSys = new StudentCourseRatingSys();
        /** Question5 */
        //boolean isSuccessful = ratingSys.readAllRecordsWithBinReader();
        /** Question4 */
        boolean isSuccessful = ratingSys.extractObjects();
        if (isSuccessful)
            System.out.println("Data has recorded successfully.");
    }
}
