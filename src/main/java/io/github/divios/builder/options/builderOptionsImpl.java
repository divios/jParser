package io.github.divios.builder.options;

import io.github.divios.builder.parserCompleted;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class builderOptionsImpl implements builderOptions {

    private final String filter;
    private final Map<Character, Predicate<String>> assertList = new HashMap();

    protected builderOptionsImpl(String filter) {
        this.filter = filter;
    }

    @Override
    public builderOptions assertOption(Character s, Predicate<String> test) {
        assertList.put(s, test);
        return this;
    }

    @Override
    public parserCompleted parse(String[] args) {
        return parserCompleted.create(args, filter, assertList);
    }

}
