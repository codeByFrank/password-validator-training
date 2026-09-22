package de.neuefische;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bitte gib ein Passwort ein:");
        String password = scanner.nextLine();

        if (PasswordValidator.isValid(password)) {
            System.out.println("Das Passwort ist gültig.");
        } else {
            System.out.println("Das Passwort ist ungültig.");

            if (!PasswordValidator.hasMinLength(password, 8)) {
                System.out.println("- Das Passwort muss mindestens 8 Zeichen enthalten.");
            }

            if (!PasswordValidator.containsDigit(password)) {
                System.out.println("- Das Passwort muss mindestens eine Ziffer enthalten.");
            }

            if (!PasswordValidator.containsUpperAndLower(password)) {
                System.out.println("- Das Passwort muss Groß- und Kleinbuchstaben enthalten.");
            }

            if (!PasswordValidator.containsSpecialChar(
                    password,
                    "!@#$%^&*()-_+=?.,;:"
            )) {
                System.out.println("- Das Passwort muss ein erlaubtes Sonderzeichen enthalten.");
            }

            if (PasswordValidator.isCommonPassword(password)) {
                System.out.println("- Das Passwort ist zu häufig oder zu schwach.");
            }
        }

        scanner.close();;
    }
}
