package io.github.divios;

import io.github.divios.builder.*;

import java.util.Map;
import java.util.function.Predicate;

public class Parser {

    public static builder builder() {
        return builder.create();
    }

    public static parserCompleted parse(String[] args, String filter) {
        return parserCompleted.create(args, filter);
    }

    public static parserCompleted parse(String[] args, String filter, Map<Character, Predicate<String>> filters){
        return parserCompleted.create(args, filter, filters);
    }

}
