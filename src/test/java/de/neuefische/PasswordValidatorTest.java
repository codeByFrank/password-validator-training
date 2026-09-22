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

}