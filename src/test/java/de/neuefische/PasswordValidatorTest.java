package de.neuefische;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

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
}