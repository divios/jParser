package io.github.divios.builder.options;

import io.github.divios.builder.parserCompleted;
import io.github.divios.builder.values.parserValue;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class builderOptionsImpl implements builderOptions {

    private final String filter;
    private final Map<Character, Predicate<String>> assertList = new HashMap();
    private final Map<Character, parserValue> defaultValues = new HashMap<>();

    protected builderOptionsImpl(String filter) {
        this.filter = filter;
    }

    @Override
    public builderOptions assertTrue(Character s, Predicate<String> test) {
        assertList.put(s, test);
        return this;
    }

    @Override
    public builderOptions assertDefault(Character s, String defaultValue) {
        defaultValues.put(s, parserValue.ofString(defaultValue));
        return this;
    }

    @Override
    public parserCompleted parse(String[] args) {
        return parserCompleted.create(args, filter, assertList, defaultValues);
    }

}
