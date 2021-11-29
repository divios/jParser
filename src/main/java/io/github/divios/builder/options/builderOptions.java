package io.github.divios.builder.options;

import io.github.divios.builder.parser;
import io.github.divios.builder.values.argType;
import io.github.divios.utils.Utils;

import java.util.function.Consumer;
import java.util.function.Predicate;


public interface builderOptions {

    static builderOptions create() {
        return new builderOptionsImpl("");
    }

    static builderOptions create(String filter) {
        return new builderOptionsImpl(filter);
    }

    default builderOptions assertType(Character s, argType type) {
        return assertType(s, type, "");
    }

    default builderOptions assertType(Character s, argType type, String msgErr) {
        return assertTrue(s, type::test, msgErr);
    }

    default builderOptions assertTrue(Character s, Predicate<String> test) {
        return assertTrue(s, test, "");
    }

    builderOptions assertTrue(Character s, Predicate<String> test, String msgErr);

    default builderOptions assertFalse(Character s, Predicate<String> test, String msgErr) {
        return assertTrue(s, test.negate(), msgErr);
    }

    default builderOptions assertFalse(Character s, Predicate<String> test) {
        return assertFalse(s, test, "");
    }

    default builderOptions assertThrows(Character s, Consumer<String> consumer) {
        return assertThrows(s, consumer, "");
    }

    default builderOptions assertThrows(Character s, Consumer<String> consumer, String msgErr) {
        return assertFalse(s, s1 -> Utils.testThrow(() -> consumer.accept(s1)), msgErr);
    }

    default builderOptions assertThrows(Character s, Runnable runnable, String msgErr) {
        return assertThrows(s, s1 -> runnable.run(), msgErr);
    }

    default builderOptions assertThrows(Character s, Runnable runnable) {
        return assertThrows(s, s1 -> runnable.run());
    }

    default builderOptions assertNoThrows(Character s, Consumer<String> consumer, String msgErr) {
        return assertTrue(s, s1 -> Utils.testThrow(() -> consumer.accept(s1)), msgErr);
    }

    default builderOptions assertNoThrows(Character s, Consumer<String> consumer) {
        return assertNoThrows(s, consumer, "");
    }

    default builderOptions assertNoThrows(Character s, Runnable runnable, String msgErr) {
        return assertNoThrows(s, s1 -> runnable.run(), msgErr);
    }

    default builderOptions assertNoThrows(Character s, Runnable runnable) {
        return assertNoThrows(s, runnable, "");
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

    parser parse(String[] args);

}
