package ir.maktab58.filesq4q5.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Taban Soleymani
 */
public class DateAndTimeValidator {
    public boolean validateDateAndTime(String timeStamp) {
        String regex = "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$";
        Pattern pattern = Pattern.compile(regex);
        if (timeStamp == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(timeStamp);
        return matcher.matches();
    }
}
