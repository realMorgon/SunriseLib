# SunriseLib
![Minecraft](https://img.shields.io/badge/Minecraft-1.21-brightgreen?logo=minecraft&logoColor=white)
![SpigotMC](https://img.shields.io/badge/Spigot-Plugin-orange?logo=java&logoColor=white)
![Library](https://img.shields.io/badge/Type-Library-blue)
![Java](https://img.shields.io/badge/language-Java-blue)
![License](https://img.shields.io/badge/License-MIT-green)

SunriseLib ist eine Bibliothek für [Spigot](https://www.spigotmc.org/)-Plugins, die Entwicklern dabei hilft, die Entwicklung zu beschleunigen und sauberen, wartbaren Code zu schreiben. Sie bietet nützliche Funktionen und Tweaks, die häufig wiederkehrende Aufgaben erleichtern.

## Features

- **Code-Vereinfachungen**: Reduziert Boilerplate-Code und verbessert die Lesbarkeit.
- **Hilfsfunktionen**: Bietet vordefinierte Methoden und Klassen, die häufig in Spigot-Plugins benötigt werden.
- **Optimierungen**: Beschleunigt die Entwicklung durch vorgefertigte Lösungen für alltägliche Probleme.

## Installation

### Maven
Füge die folgende Abhängigkeit und Repository zu deiner `pom.xml` hinzu:
```xml
<repository>
  <id>jitpack.io</id>
  <url>https://jitpack.io</url>
</repository>
```
```xml
<dependency>
  <groupId>com.github.realMorgon</groupId>
  <artifactId>SunriseLib</artifactId>
  <version>VERSION</version>
</dependency>
```
Tausche "VERSION" mit dem Release aus, den du nutzen möchtest!

### Gradle

```Gradle
repositories { maven { url 'https://jitpack.io' } }
```
Library einbinden (Gradle):
```Gradle
dependencies { implementation 'com.github.realMorgon:SunriseLib:VERSION' }
```

Tausche "VERSION" mit dem Release aus, den du nutzen möchtest!

## Verwendung

Um alle Methoden nutzen zu können muss der Library eine Instanz des Plugins übergeben werden:

```Java
import io.github.realMorgon.sunriseLib.SunriseLib;

public class MyPlugin extends JavaPlugin {

  @Override
  public void onEnable() {
    SunriseLib.setPlugin(this);
  }

}
```

### Anwendungsbeispiel

```Java
Message.sendInArea("Hallo", loc, 5, 5, 5);
```
> Allen Spielern im Umkreis von 5 Blöcken in jede Richtung um die Location 'loc' wird "Hallo" gesendet

## Mitwirken

Beiträge sind willkommen! Um mitzuwirken:

1. Forke das Repository
2. Erstelle einen neuen Branch: `git checkout -b feature/DeinFeature`
3. Nimm deine Änderungen vor und commite sie: `git commit -m 'Beschreibung der Änderung'`
4. Push den Branch: `git push origin feature/DeinFeature`
5. Erstelle einen Pull-Request

## Lizenz

Dieses Projekt steht unter der MIT-Lizenz

---

Vielen Dank, dass du SunriseLib verwendest! Wenn du Fragen oder Probleme hast, eröffne bitte ein Issue oder kontaktiere mich!
Diese ReadMe ist KI-Generiert. Bei Fehlern bitte auch mich kontaktieren.
