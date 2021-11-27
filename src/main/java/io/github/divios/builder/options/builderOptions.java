package io.github.divios.builder.options;

import io.github.divios.builder.parserCompleted;
import io.github.divios.builder.values.valueType;
import io.github.divios.utils.utils;

import java.util.function.Consumer;
import java.util.function.Predicate;


public interface builderOptions {

    static builderOptions create() {
        return new builderOptionsImpl("");
    }

    static builderOptions create(String filter) {
        return new builderOptionsImpl(filter);
    }

    default builderOptions assertType(Character s, valueType type) {
        return assertTrue(s, type::test);
    }

    builderOptions assertTrue(Character s, Predicate<String> test);

    default builderOptions assertThrows(Character s, Consumer<String> consumer) {
        return assertTrue(s, s1 -> utils.testThrow(() -> consumer.accept(s1)));
    }

    default builderOptions assertThrows(Character s, Runnable runnable) {
        return assertThrows(s, s1 -> runnable.run());
    }

    builderOptions assertDefault(Character s, String defaultValue);

    default builderOptions assertDefault(Character s, short defaultValue) {
        return assertDefault(s, String.valueOf(defaultValue));
    }

    default builderOptions assertDefault(Character s, int defaultValue) {
        return assertDefault(s, String.valueOf(defaultValue));
    }

    default builderOptions assertDefault(Character s, long defaultValue) {
        return assertDefault(s, String.valueOf(defaultValue));
    }

    default builderOptions assertDefault(Character s, double defaultValue) {
        return assertDefault(s, String.valueOf(defaultValue));
    }

    default builderOptions assertDefault(Character s, float defaultValue) {
        return assertDefault(s, String.valueOf(defaultValue));
    }

    default builderOptions assertDefault(Character s, boolean defaultValue) {
        return assertDefault(s, String.valueOf(defaultValue));
    }

    parserCompleted parse(String[] args);

}
