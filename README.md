# jParser
A java module to easily parse console arguments in a similar style as C with getOpt()

# Usage

jParser provides a very simple command parser abstraction. The main idea is to specify a filter, which is a string with all the parameters to expect. For example "apd" expects a, p and d parameters. Also if a parameter is followed by ":", it means that the parameter requires an argument.

It also comes with a handfull of methods to assert the result of the arguments.

```java
Map<Character, argument> argsMap = Parser.builder()
      .filter("p:s:d")
      .assertType('p', argType.INTEGER, "parameter p needs to be an integer")
      .assertDefault('s', "127.0.0.1")
      .parse(args)
      .getAsMap();
      
String host = argsMap.getValue('s').getAsString();
int port = argsMap.getValue('p').getAsInt();
boolean debug = argsMap.getValue('d).getAsBoolean();

```

# Instalation

To get the jar, either download it from the releases tab either here on [GitHub](https://github.com/divios/jParser/releases) or [build it locally](https://github.com/divios/jParser#build-locally).

## With Jitpack:

Gradle:

```groovy
repositories {
        maven { url 'https://jitpack.io' }
}

```

```groovy
dependencies {
        compileOnly 'com.github.divios:jparser:Tag'
}
```

Maven:

```xml
<repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
</repository>
```

```xml
<dependency>
        <groupId>com.github.divios</groupId>
        <artifactId>jparser</artifactId>
        <version>Tag</version>
        <scope>provided</scope>
</dependency>
```
Replace `Tag` with a release tag for jParser. Example: `1.0`. You can also use `master` as the tag to get the latest version, though you will have to clear your maven caches in order to update it.

## Build locally:

For Windows, use Git Bash. For Linux or OSX, just ensure you have Git installed. Navigate to the directory where you want to clone the repository, and run:

```
git clone https://github.com/divios/jparser
cd RedLib
./gradlew jar
```

After running these commands, the jar will be at `build/libs/jParser.jar`.
You may also need to add the jar to your classpath. After that, you should be good to go!



