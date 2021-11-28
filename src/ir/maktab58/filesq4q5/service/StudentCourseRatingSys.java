package ir.maktab58.filesq4q5.service;

import ir.maktab58.filesq4q5.models.Course;
import ir.maktab58.filesq4q5.models.CourseRating;
import ir.maktab58.filesq4q5.models.Review;
import ir.maktab58.filesq4q5.models.Student;
import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Taban Soleymani
 */
public class StudentCourseRatingSys {
    private final CourseRatingService ratingService = new CourseRatingService();
    private final CourseService courseService = new CourseService();
    private final StudentService studentService = new StudentService();
    private final List<Course> courses = new ArrayList<>();
    private final List<Student> students = new ArrayList<>();
    private final List<CourseRating> rates = new ArrayList<>();
    private final static String STUDENTS_URL = "C:\\Users\\Taban\\Desktop\\maktab\\HW13_Taban\\resource\\students.csv";
    private final static String FIRST_LINE = "Course Name,Student Name,Timestamp,Rating,Comment";
    private final static int NUM_OF_COLUMNS = 5;
    private static int courseId = 1;
    private static int studentId = 1;
    private static int ratingId = 1;

    /**
     * Question5
     */
    public boolean readAllRecordsWithBinReader() throws IOException {
        CellProcessor[] processors = new CellProcessor[]{
                new NotNull(), new NotNull(), new NotNull(), new ParseDouble(), new NotNull()
        };
        ICsvBeanReader beanReader = new CsvBeanReader(new FileReader(STUDENTS_URL),
                CsvPreference.STANDARD_PREFERENCE);

        beanReader.getHeader(true);
        String[] header = {"courseName", "studentName", "timestamp", "rating", "comment"};
        Review bean;
        while ((bean = beanReader.read(Review.class, header, processors)) != null) {
            String courseName = bean.getCourseName();
            String studentName = bean.getStudentName();
            String timestamp = bean.getTimestamp();
            double rating = bean.getRating();
            String comment = bean.getComment();
            Course currentCourse = getCurrentCourse(courseName);
            Student currentStudent = getCurrentStudent(studentName);
            getCurrentCourseRating(currentCourse, currentStudent, timestamp, rating, comment);
        }
        return insertDataToDb();
    }

    /**
     * Question4
     */
    private String readCompletelyFromCSV() {
        File studentsFile = new File(STUDENTS_URL);
        String csvSting = "";
        try {
            Scanner studentsReader = new Scanner(studentsFile);
            while (studentsReader.hasNext()) {
                String newLine = studentsReader.nextLine();
                if (!newLine.equals(FIRST_LINE))
                    csvSting += newLine + ",";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return csvSting;
    }

    private List<String> getCsvColumns() {
        String csvContent = readCompletelyFromCSV();
        String[] csvRecords = csvContent.split(",");
        List<String> csvColumns = new ArrayList<>();
        int index = 0;
        while (index < csvRecords.length - 1) {
            if (csvRecords[index].startsWith("\"") && csvRecords[index].endsWith("\"")) {
                csvColumns.add(csvRecords[index]);
            } else if (csvRecords[index].startsWith("\"") && csvRecords[index + 1].endsWith("\"")) {
                if (csvRecords[index + 1].startsWith("\"") && csvRecords[index + 1].endsWith("\"")) {
                    index++;
                    continue;
                }
                csvColumns.add(csvRecords[index] + " " + csvRecords[index + 1]);
                index++;
            } else {
                csvColumns.add(csvRecords[index]);
            }
            index++;
        }
        return csvColumns;
    }

    public boolean extractObjects() {
        List<String> columns = getCsvColumns();
        Course currentCourse = null;
        Student currentStudent = null;
        String timeStamp = null;
        double rate = 0.0;
        for (String column : columns) {
            int remaining = columns.indexOf(column) % NUM_OF_COLUMNS;
            switch (remaining) {
                case 0 -> currentCourse = getCurrentCourse(column);
                case 1 -> currentStudent = getCurrentStudent(column);
                case 2 -> timeStamp = column;
                case 3 -> rate = Double.parseDouble(column);
                case 4 -> getCurrentCourseRating(currentCourse, currentStudent, timeStamp, rate, column);
            }
        }
        return insertDataToDb();
    }

    private void getCurrentCourseRating(Course currentCourse, Student currentStudent, String timeStamp, double rate, String comment) {
        CourseRating courseRating;
        courseRating = CourseRating.builder()
                .id(ratingId)
                .course(currentCourse)
                .student(currentStudent)
                .timeStamp(timeStamp)
                .rate(rate)
                .comment(comment).build();
        rates.add(courseRating);
        ratingId++;
    }

    private Student getCurrentStudent(String column) {
        Student currentStudent;
        currentStudent = new Student(studentId, column);
        if (!students.contains(currentStudent)) {
            studentId++;
            students.add(currentStudent);
        } else {
            int index = students.indexOf(currentStudent);
            currentStudent = students.get(index);
        }
        return currentStudent;
    }

    private Course getCurrentCourse(String column) {
        Course currentCourse = new Course(courseId, column);
        if (!courses.contains(currentCourse)) {
            courseId++;
            courses.add(currentCourse);
        } else {
            int index = courses.indexOf(currentCourse);
            currentCourse = courses.get(index);
        }
        return currentCourse;
    }

    public boolean insertDataToDb() {
        try {
            courses.forEach(courseService::saveACourse);
            students.forEach(studentService::saveAStudent);
            rates.forEach(ratingService::saveAStudentCourseRating);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return true;
    }
}
