package builder.options;

import builder.parserCompleted;
import builder.values.valueType;

import java.util.function.Predicate;


public interface builderOptions {

    static builderOptions create() {
        return new builderOptionsImpl("");
    }

    static builderOptions create(String filter) {
        return new builderOptionsImpl(filter);
    }

    default builderOptions assertType(Character s, valueType type) {
        return assertOption(s, type::test);
    }

    builderOptions assertOption(Character s, Predicate<String> test);
    parserCompleted parse(String[] args);

}
