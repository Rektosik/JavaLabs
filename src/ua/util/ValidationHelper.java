package ua.util;

import java.time.LocalDate;
import java.util.regex.Pattern;

// package-private (без public)
class ValidationHelper {

    static boolean isNonEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

    static boolean isValidEmail(String email) {
        return email != null && Pattern.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$", email);
    }

    static boolean isPositive(int number) {
        return number > 0;
    }

    static boolean isFutureOrToday(LocalDate date) {
        return date != null && !date.isBefore(LocalDate.now());
    }
}
