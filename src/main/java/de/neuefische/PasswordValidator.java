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
        boolean result = false;

        for(int i = 0; i < password.length() && !result; i++) {
            char currentChar = password.charAt(i);

            if(currentChar >= '0' && currentChar <= '9') {
                result = true;
            }
        }

        return result;
    }

    public static boolean containsUpperAndLower(String password) {

        boolean containsUppercase = false;
        boolean containsLowercase = false;

        for(int i = 0; i < password.length() && (!containsUppercase || !containsLowercase); i++) {
            char currentCharacter = password.charAt(i);

            if (Character.isUpperCase(currentCharacter)) {
                containsUppercase = true;
            } else if (Character.isLowerCase(currentCharacter)) {
                containsLowercase = true;
            }
        }

        return containsUppercase && containsLowercase;
    }

    public static boolean isCommonPassword(String password) {
        return false;
    }

    public static boolean isValid(String password) {
        return false;
    }
}
