# Password Validator

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