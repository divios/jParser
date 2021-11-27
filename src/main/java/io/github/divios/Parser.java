package io.github.divios;

import io.github.divios.builder.builder;
import io.github.divios.builder.parserCompleted;
import io.github.divios.builder.values.assertValue;

import java.util.Map;

public class Parser {

    public static builder builder() {
        return builder.create();
    }

    public static parserCompleted parse(String[] args, String filter) {
        return parserCompleted.create(args, filter);
    }

    public static parserCompleted parse(String[] args, String filter, Map<Character, assertValue> filters){
        return parserCompleted.create(args, filter, filters);
    }

}
