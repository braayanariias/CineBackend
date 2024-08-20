package org.brayan.cinebackend.Utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

public class Routines {

    private final static String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})";

    public static boolean isEmpty(String test) {
        return test == null || test.trim().isEmpty();
    }

    public static boolean isEmailValid(String email) {
        return !isEmpty(email) && email.matches(EMAIL_PATTERN);
    }

    public static<T> T newIsNotNull(T currentValue, T newValue) {
        if (Objects.nonNull(newValue)) {
            return newValue;
        } else {
            return currentValue;
        }
    }

    public static boolean isEmptyOrNull(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean identificationIsValid(String identification) {
        return !isEmpty(identification) && identification.length() == 10 && identification.matches("\\d{10}");
    }

    public static int compareDate(LocalDate date1, LocalDate date2) {
        if (date1 != null && date2 != null) {
            return date1.compareTo(date2);
        } else {
            return 999;
        }
    }

    public static boolean isGreater(LocalDate date, LocalDate reference) {
        return compareDate(date, reference) == 1;
    }

    public static boolean isGreaterOrEqual(LocalDate date, LocalDate reference) {
        return compareDate(date, reference) == 1 || compareDate(date, reference) == 0;
    }

    public static boolean isLess(LocalDate date, LocalDate reference) {
        return compareDate(date, reference) == -1;
    }
    public static boolean isLessOrEqual(LocalDate date, LocalDate reference) {
        return compareDate(date, reference) == -1 || compareDate(date, reference) == 0;
    }

    public static boolean isDateValid(String date) {
        if (!isEmpty(date)) {
            Optional<LocalDate> dateNew = Optional.empty();
            try {
                dateNew = Optional.of(LocalDate.parse(date, Constants.FORMAT_DATE_EU));
                return true;
            } catch (DateTimeParseException ignored) {
            }
        }
        return false;
    }

    public static boolean isPasswordValid(String password) {
        return !isEmpty(password) && password.matches(PASSWORD_PATTERN);
    }

}
