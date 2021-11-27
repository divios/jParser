package io.github.divios.builder.values;

import java.util.function.Predicate;

public class assertValue {

    private final Predicate<String> filter;
    private final String errorMsg;

    public static assertValue of(Predicate<String> filter) {
        return new assertValue(filter);
    }

    public static assertValue of(Predicate<String> filter, String errorMsg) {
        return new assertValue(filter, errorMsg);
    }

    private assertValue(Predicate<String> filter) {
        this(filter, "");
    }

    public assertValue(Predicate<String> filter, String errorMsg) {
        this.filter = filter;
        this.errorMsg = errorMsg;
    }

    public boolean test(String s) {
        return filter.test(s);
    }

    public String getErrorMsg() {
        return errorMsg;
    }

}
