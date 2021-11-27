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
        return assertType(s, type, "");
    }

    default builderOptions assertType(Character s, valueType type, String msgErr) {
        return assertTrue(s, type::test, msgErr);
    }

    default builderOptions assertTrue(Character s, Predicate<String> test) {
        return assertTrue(s, test, "");
    }

    builderOptions assertTrue(Character s, Predicate<String> test, String msgErr);

    default builderOptions assertThrows(Character s, Consumer<String> consumer) {
        return assertThrows(s, consumer, "");
    }

    default builderOptions assertThrows(Character s, Consumer<String> consumer, String msgErr) {
        return assertTrue(s, s1 -> utils.testThrow(() -> consumer.accept(s1)), msgErr);
    }

    default builderOptions assertThrows(Character s, Runnable runnable, String msgErr) {
        return assertThrows(s, s1 -> runnable.run(), msgErr);
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
