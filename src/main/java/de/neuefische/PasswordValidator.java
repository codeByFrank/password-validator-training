package de.neuefische;

import java.util.Locale;

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

        if (password == null) {
            return false;
        }

        char[] characters = password.toCharArray();

        for (char character : characters) {

            if(character >= '0' && character <= '9') {
                result = true;
            }
        }

        return result;
    }

    public static boolean containsUpperAndLower(String password) {
        boolean containsUppercase = false;
        boolean containsLowercase = false;

        if (password == null) {
            return false;
        }

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
        if (password == null) {
            return false;
        }

        String[] commonPasswords =  {"password", "Passwort1", "12345678", "Aa345678"};
        String normalizedPassword = password.trim().toLowerCase(Locale.ROOT);

        for (String commonPassword : commonPasswords) {
            if (normalizedPassword.equals(commonPassword.toLowerCase(Locale.ROOT))) {
                return true;
            }
        }

        return false;
    }

    public static boolean isValid(String password) {
        if (password == null) {
            return false;
        }

        if (!hasMinLength(password, 8)) {
            return false;
        }

        if (!containsDigit(password)) {
            return false;
        }

        if (!containsUpperAndLower(password)) {
            return false;
        }

        if (isCommonPassword(password)) {
            return false;
        }

        return true;
    }

    // Bonus
    public static boolean containsSpecialChar(String password, String allowed) {
        return false;
    }
}
