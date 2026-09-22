# Password Validator

[![CI](https://github.com/codeByFrank/password-validator-training/actions/workflows/ci.yml/badge.svg)](https://github.com/codeByFrank/password-validator-training/actions/workflows/ci.yml)

Dieses Maven-Projekt stellt eine einfache Passwortvalidierung bereit.  
Die Funktionen werden testgetrieben mit JUnit 5 entwickelt.

## Passwort-Policy

Ein Passwort ist gültig, wenn es alle folgenden Kriterien erfüllt:

- Es enthält mindestens 8 Zeichen.
- Es enthält mindestens eine Ziffer von 0 bis 9.
- Es enthält mindestens einen Großbuchstaben.
- Es enthält mindestens einen Kleinbuchstaben.
- Es ist nicht in der internen Liste häufiger oder schwacher Passwörter enthalten.
- `null` ist kein gültiges Passwort.

Beim Vergleich mit der Liste schwacher Passwörter werden führende und
abschließende Leerzeichen sowie die Groß- und Kleinschreibung ignoriert.

Ein Sonderzeichen ist für die Basis-Policy nicht erforderlich.

## Voraussetzungen

- Java 25
- Maven 3

## Build und Tests

Das Projekt wird im Projektordner mit folgendem Befehl gebaut und getestet:

```bash
mvn clean verify
```

Für einen nicht interaktiven Build wie in GitHub Actions:

```bash
mvn -B clean verify
```

Die Tests können auch in IntelliJ über den grünen Pfeil neben der
Testklasse oder einer einzelnen Testmethode gestartet werden.

## Artefakt erstellen

```bash
mvn package
```

Die erzeugte JAR-Datei befindet sich anschließend unter:

```text
target/*.jar
```

## Beispiel

```text
boolean valid = PasswordValidator.isValid("Abcdef1g");
System.out.println(valid);
```

Ausgabe:

```text
true
```

## Continuous Integration

Bei jedem Push und Pull Request führt GitHub Actions automatisch den
folgenden Befehl aus:

```bash
mvn -B clean verify
```

## Bonusaufgaben

Es wurden keine Bonusaufgaben umgesetzt.