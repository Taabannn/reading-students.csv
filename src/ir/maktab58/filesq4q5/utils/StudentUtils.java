package ir.maktab58.filesq4q5.utils;

/**
 * @author Taban Soleymani
 */
public class StudentUtils {
    public static boolean endsWithInteger(String input) {
        if (input.endsWith("0") || input.endsWith("1") || input.endsWith("2") ||
            input.endsWith("3") || input.endsWith("4") || input.endsWith("5") ||
            input.endsWith("6") || input.endsWith("7") || input.endsWith("8") || input.endsWith("9"))
            return true;

        return false;
    }
}
