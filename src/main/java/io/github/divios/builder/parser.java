package io.github.divios.builder;

import io.github.divios.builder.values.Argument;
import io.github.divios.builder.values.assertValue;
import io.github.divios.utils.Primitives;

import java.util.Collections;
import java.util.Map;

public interface parser {

    static parser create(String[] args, String filter) {
        return new parserImpl(args, filter);
    }

    static parser create(String[] args, String filter, Map<Character, assertValue> filters) {
        return create(args, filter, filters, Collections.emptyMap());
    }

    static parser create(String[] args, String filter, Map<Character, assertValue> filters, Map<Character, Argument> defaultValues) {
        return new parserImpl(args, filter, filters, defaultValues);
    }

    default boolean containsValue(Character value) {
        return getValue(value) != null;
    }

    default Argument getValue(String value) {
        return getValue(Primitives.getAsChar(value));
    }

    Argument getValue(char value);

    Map<Character, Argument> getAsMap();

}
