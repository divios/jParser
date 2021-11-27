package builder;

import builder.values.parserValue;
import utils.Primitives;

import java.util.Map;
import java.util.function.Predicate;

public interface parserCompleted {

    static parserCompleted create(String[] args, String filter) {
        return new parserCompletedImpl(args, filter);
    }

    static parserCompleted create(String[] args, String filter, Map<Character, Predicate<String>> filters) {
        return new parserCompletedImpl(args, filter, filters);
    }

    default parserValue getValue(String value) {
        return getValue(Primitives.getAsChar(value));
    }

    parserValue getValue(char value);

    Map<Character, parserValue> getAsMap();

}
