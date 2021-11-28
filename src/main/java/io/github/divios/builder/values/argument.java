package io.github.divios.builder.values;

import io.github.divios.utils.Primitives;

public class argument {

    private final String value;

    public static argument EMPTY() { return new argument(); }

    public static argument ofString(String value) {
        return new argument(value);
    }

    private argument() {
        value = null;
    }

    private argument(String value) {
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
        return (Object) value;
    }

}
