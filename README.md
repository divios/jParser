# jParser
A java module to easily parse console arguments in a similar style as C with getOpt()

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

Replace `Tag` with a release tag for jParser. Example: `1.0`. You can also use `master` as the tag to get the latest version, though you will have to clear your gradle caches in order to update it.

To shade jParser, change the dependency from `compileOnly` to `implementation`, and install the [gradle shadow plugin](https://github.com/johnrengelman/shadow).

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

To shade Jparser, change the scope from `provided` to `compile`.

## Build locally:

For Windows, use Git Bash. For Linux or OSX, just ensure you have Git installed. Navigate to the directory where you want to clone the repository, and run:

```
git clone https://github.com/divios/jparser
cd RedLib
./gradlew jar
```

After running these commands, the jar will be at `build/libs/jParser.jar`.
You may also need to add the jar to your classpath. After that, you should be good to go!

# Usage



