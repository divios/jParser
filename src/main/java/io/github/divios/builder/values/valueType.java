package io.github.divios.builder.values;

import io.github.divios.utils.Primitives;

import java.util.function.Predicate;

public enum valueType {

    STRING(s -> true),
    INTEGER(Primitives::isInteger),
    LONG(Primitives::isLong),
    BOOLEAN(Primitives::isBoolean),
    DOUBLE(Primitives::isDouble),
    CHAR(Primitives::isChar);

    private final Predicate<String> test;

    valueType(Predicate<String> test) {
        this.test = test;
    }

    public boolean test(String value) {
        return test.test(value);
    }

}
