package de.neuefische;

public final class PasswordValidator {

    public static boolean hasMinLength(String password, int min) {
        if(password != null && password.length() >= min) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean containsDigit(String password) {
        return false;
    }

    public static boolean containsUpperAndLower(String password) {
        return false;
    }

    public static boolean isCommonPassword(String password) {
        return false;
    }

    public static boolean isValid(String password) {
        return false;
    }
}
