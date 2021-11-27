package io.github.divios.builder;

import io.github.divios.builder.values.parserValue;
import io.github.divios.utils.Primitives;

import java.util.Collections;
import java.util.Map;
import java.util.function.Predicate;

public interface parserCompleted {

    static parserCompleted create(String[] args, String filter) {
        return new parserCompletedImpl(args, filter);
    }

    static parserCompleted create(String[] args, String filter, Map<Character, Predicate<String>> filters) {
        return create(args, filter, filters, Collections.emptyMap());
    }

    static parserCompleted create(String[] args, String filter, Map<Character, Predicate<String>> filters, Map<Character, parserValue> defaultValues) {
        return new parserCompletedImpl(args, filter, filters, defaultValues);
    }

    default boolean containsValue(Character value) {
        return getValue(value) != null;
    }

    default parserValue getValue(String value) {
        return getValue(Primitives.getAsChar(value));
    }

    parserValue getValue(char value);

    Map<Character, parserValue> getAsMap();

}
