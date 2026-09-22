package de.neuefische;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    // 3.1----------------------------------------------------------------------

    @Test
    void hasMinLength_shouldReturnFalse_whenGivenSevenCharacters() {
        assertFalse(PasswordValidator.hasMinLength("1234Abc", 8));
    }

    @Test
    void hasMinLength_shouldReturnTrue_whenGivenEightCharacters() {
        assertTrue(PasswordValidator.hasMinLength("1234Abcd", 8));
    }

    @Test
    void hasMinLength_shouldReturnTrue_whenGivenNineCharacters() {
        assertTrue(PasswordValidator.hasMinLength("1234Abcde", 8));
    }

    @Test
    void hasMinLength_shouldReturnFalse_whenGivenEmptyPassword() {
        assertFalse(PasswordValidator.hasMinLength("", 8));
    }

    @Test
    void hasMinLength_shouldReturnFalse_whenGivenNullPassword() {
        assertFalse(PasswordValidator.hasMinLength(null, 8));
    }

    // 3.2----------------------------------------------------------------------

    @Test
    void containsDigit_shouldReturnFalse_whenGivenPasswordWithoutDigit() {
        assertFalse(PasswordValidator.containsDigit("Password"));
    }

    @Test
    void containsDigit_shouldReturnTrue_whenGivenPasswordWithOneDigit() {
        assertTrue(PasswordValidator.containsDigit("Password1"));
    }

    @Test
    void containsDigit_shouldReturnTrue_whenGivenPasswordWithMultipleDigits() {
        assertTrue(PasswordValidator.containsDigit("Pass1word2"));
    }

    @Test
    void containsDigit_shouldReturnTrue_whenGivenOnlyDigits() {
        assertTrue(PasswordValidator.containsDigit("12345678"));
    }

    @Test
    void containsDigit_shouldReturnFalse_whenGivenUnicodeDigit() {
        assertFalse(PasswordValidator.containsDigit("Password١"));
    }

    @Test
    void containsDigit_shouldReturnFalse_whenGivenNull() {
        assertFalse(PasswordValidator.containsDigit(null));
    }

    // 3.3----------------------------------------------------------------------

    @Test
    void containsUpperAndLower_shouldReturnFalse_whenGivenOnlyUppercaseLetters() {
        assertFalse(PasswordValidator.containsUpperAndLower("PASSWORD"));
    }

    @Test
    void containsUpperAndLower_shouldReturnFalse_whenGivenOnlyLowercaseLetters() {
        assertFalse(PasswordValidator.containsUpperAndLower("password"));
    }

    @Test
    void containsUpperAndLower_shouldReturnTrue_whenGivenUpperAndLowercaseLetters() {
        assertTrue(PasswordValidator.containsUpperAndLower("Password"));
    }

    @Test
    void containsUpperAndLower_shouldReturnFalse_whenGivenOneLetter() {
        assertFalse(PasswordValidator.containsUpperAndLower("A"));
    }

    @Test
    void containsUpperAndLower_shouldReturnFalse_whenGivenNull() {
        assertFalse(PasswordValidator.containsUpperAndLower(null));
    }

    // 3.4----------------------------------------------------------------------

    @Test
    void isCommonPassword_shouldReturnTrue_whenGivenPassword() {
        assertTrue(PasswordValidator.isCommonPassword("password"));
    }

    @Test
    void isCommonPassword_shouldReturnTrue_whenGivenPasswortOne() {
        assertTrue(PasswordValidator.isCommonPassword("Passwort1"));
    }

    @Test
    void isCommonPassword_shouldReturnTrue_whenGivenOnlyDigits() {
        assertTrue(PasswordValidator.isCommonPassword("12345678"));
    }

    @Test
    void isCommonPassword_shouldReturnTrue_whenGivenAa345678() {
        assertTrue(PasswordValidator.isCommonPassword("Aa345678"));
    }

    @Test
    void isCommonPassword_shouldIgnoreCaseAndSpaces() {
        assertTrue(PasswordValidator.isCommonPassword("PASSWORD  "));
    }

    @Test
    void isCommonPassword_shouldReturnFalse_whenPasswordIsNotCommon() {
        assertFalse(PasswordValidator.isCommonPassword("Abcdef1g"));
    }

    @Test
    void isCommonPassword_shouldReturnFalse_whenGivenNull() {
        assertFalse(PasswordValidator.isCommonPassword(null));
    }

    // 3.5----------------------------------------------------------------------

    @Test
    void isValid_shouldReturnTrue_whenPasswordMeetsAllCriteria() {
        assertTrue(PasswordValidator.isValid("Abcdef1g"));
    }

    @Test
    void isValid_shouldReturnTrue_whenGivenLongValidPassword() {
        assertTrue(PasswordValidator.isValid("MySecurePassword2026"));
    }

    @Test
    void isValid_shouldReturnFalse_whenPasswordIsTooShort() {
        assertFalse(PasswordValidator.isValid("Abc1def"));
    }

    @Test
    void isValid_shouldReturnFalse_whenPasswordContainsNoDigit() {
        assertFalse(PasswordValidator.isValid("Abcdefgh"));
    }

    @Test
    void isValid_shouldReturnFalse_whenPasswordContainsNoUppercaseLetter() {
        assertFalse(PasswordValidator.isValid("abcdefg1"));
    }

    @Test
    void isValid_shouldReturnFalse_whenPasswordContainsNoLowercaseLetter() {
        assertFalse(PasswordValidator.isValid("ABCDEFG1"));
    }

    @Test
    void isValid_shouldReturnFalse_whenPasswordIsCommon() {
        assertFalse(PasswordValidator.isValid("Passwort1"));
    }

    @Test
    void isValid_shouldReturnFalse_whenPasswordIsNull() {
        assertFalse(PasswordValidator.isValid(null));
    }


    // Bonus----------------------------------------------------------------------

    @Test
    void containsSpecialChar_shouldReturnTrue_whenPasswordContainsAllowedSpecialCharacter() {
        assertTrue(PasswordValidator.containsSpecialChar(
                "Abcdef1!",
                "!@#$%^&*()-_+=?.,;:"
        ));
    }

    @Test
    void containsSpecialChar_shouldReturnFalse_whenPasswordContainsNoSpecialCharacter() {
        assertFalse(PasswordValidator.containsSpecialChar(
                "Abcdef12",
                "!@#$%^&*()-_+=?.,;:"
        ));
    }

    @Test
    void containsSpecialChar_shouldReturnFalse_whenSpecialCharacterIsNotAllowed() {
        assertFalse(PasswordValidator.containsSpecialChar(
                "Abcdef1€",
                "!@#$%^&*()-_+=?.,;:"
        ));
    }

    @Test
    void containsSpecialChar_shouldReturnFalse_whenPasswordIsNull() {
        assertFalse(PasswordValidator.containsSpecialChar(
                null,
                "!@#$%^&*()-_+=?.,;:"
        ));
    }
}