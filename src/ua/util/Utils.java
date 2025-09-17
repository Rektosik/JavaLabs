package ua.util;

import java.time.LocalDate;

public class Utils {
    public static void printSeparator() {
        System.out.println("=".repeat(40));
    }

    public static String formatName(String first, String last) {
        return first + " " + last.toUpperCase();
    }

    // Публічні методи-обгортки
    public static boolean isNonEmpty(String value) {
        return ValidationHelper.isNonEmpty(value);
    }

    public static boolean isValidEmail(String email) {
        return ValidationHelper.isValidEmail(email);
    }

    public static boolean isPositive(int number) {
        return ValidationHelper.isPositive(number);
    }

    public static boolean isFutureOrToday(LocalDate date) {
        return ValidationHelper.isFutureOrToday(date);
    }
}
