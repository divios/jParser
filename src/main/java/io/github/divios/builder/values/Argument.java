package io.github.divios.builder.values;

import io.github.divios.utils.Primitives;
import io.github.divios.utils.Utils;

import java.util.Optional;

@SuppressWarnings("unused")
public class Argument {

    private final String value;

    public static Argument EMPTY() { return new Argument(); }

    public static Argument ofString(String value) {
        return new Argument(value);
    }

    private Argument() {
        value = null;
    }

    private Argument(String value) {
        this.value = value;
    }

    public String getAsString() {
        return value;
    }

    public int getAsInt() {
        return Primitives.getAsInteger(value);
    }

    public double getAsDouble() {
        return Primitives.getAsDouble(value);
    }

    public long getAsLong() {
        return Primitives.getAsLong(value);
    }

    public boolean getAsBoolean() {
        return Primitives.getAsBoolean(value);
    }

    public char getAsChar() {
        return Primitives.getAsChar(value);
    }

    public Object getAsObject() {
        return value;
    }

    public <T> Optional<T> parse(Class<T> clazz) {
        if (value == null || !Utils.testThrow(() -> clazz.cast(value))) return Optional.empty();
        return Optional.of(clazz.cast(value));
    }

    public String getAsStringOrDefault(String defVal) {
        return value == null ? defVal : value;
    }

    public int getAsIntOrDefault(int defVal) {
        return Utils.testOrDefault(this::getAsInt, defVal);
    }

    public double getAsDoubleOrDefault(double defVal) {
        return Utils.testOrDefault(this::getAsDouble, defVal);
    }

    public long getAsLongOrDefault(long defVal) {
        return Utils.testOrDefault(this::getAsLong, defVal);
    }

    public boolean getAsBooleanOrDefault(boolean defVal) {
        return Utils.testOrDefault(this::getAsBoolean, defVal);
    }

    public char getAsCharOrDefault(char defVal) {
        return Utils.testOrDefault(this::getAsChar, defVal);
    }

    public Object getAsObjectOrDefault(Object defVal) {
        return value == null ? defVal : value;
    }

}
