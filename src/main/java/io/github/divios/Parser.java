package io.github.divios;

import io.github.divios.builder.builder;
import io.github.divios.builder.parser;
import io.github.divios.builder.values.assertValue;

import java.util.Map;

public class Parser {

    public static builder builder() {
        return builder.create();
    }

    public static parser parse(String[] args, String filter) {
        return parser.create(args, filter);
    }

    public static parser parse(String[] args, String filter, Map<Character, assertValue> filters){
        return parser.create(args, filter, filters);
    }

}
