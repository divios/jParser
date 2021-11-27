package io.github.divios.builder.values;

import io.github.divios.utils.Primitives;

public class parserValue {

    private final String value;

    public static parserValue ofString(String value) {
        return new parserValue(value);
    }

    private parserValue(String value) {
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

}
