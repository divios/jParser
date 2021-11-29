package io.github.divios.builder.options;

import io.github.divios.builder.parser;
import io.github.divios.builder.values.assertValue;
import io.github.divios.builder.values.Argument;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class builderOptionsImpl implements builderOptions {

    private final String filter;
    private final Map<Character, assertValue> assertList = new HashMap();
    private final Map<Character, Argument> defaultValues = new HashMap<>();

    protected builderOptionsImpl(String filter) {
        this.filter = filter;
    }

    @Override
    public builderOptions assertTrue(Character s, Predicate<String> test, String msgErr) {
        assertList.put(s, assertValue.of(test, msgErr));
        return this;
    }

    @Override
    public builderOptions assertDefault(Character s, String defaultValue) {
        defaultValues.put(s, Argument.ofString(defaultValue));
        return this;
    }

    @Override
    public parser parse(String[] args) {
        return parser.create(args, filter, assertList, defaultValues);
    }

}
