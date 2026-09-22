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
- Es enthält mindestens ein erlaubtes Sonderzeichen.
- Es ist nicht in der internen Liste häufiger oder schwacher Passwörter enthalten.
- `null` ist kein gültiges Passwort.

Erlaubte Sonderzeichen:

`!@#$%^&*()-_+=?.,;:`

Beim Vergleich mit der Liste schwacher Passwörter werden führende und
abschließende Leerzeichen sowie die Groß- und Kleinschreibung ignoriert.

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
boolean valid = PasswordValidator.isValid("Abcdef1g!");
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

## CLI starten

Nach dem Erstellen des Projekts kann das CLI über die `Main`-Klasse
gestartet werden:

```bash
mvn package
java -cp "target/*" de.neuefische.Main
```

Das CLI liest ein Passwort ein und gibt aus, ob es gültig ist. Bei einem
ungültigen Passwort werden die Gründe angezeigt.

## Manuelles Kompilieren

Das Projekt wurde zusätzlich einmal ohne Maven mit `javac` kompiliert und
gestartet:

```bash
cd src/main/java
javac -d ../../../target/manual-classes de/neuefische/PasswordValidator.java de/neuefische/Main.java
java -cp ../../../target/manual-classes de.neuefische.Main
```

## Bonusaufgaben

Folgende Bonusaufgaben wurden umgesetzt:

- Sonderzeichen-Policy
- CLI-Tool mit Ausgabe der Validierungsgründe
- Manuelles Kompilieren mit `javac`