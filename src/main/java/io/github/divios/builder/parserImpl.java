package io.github.divios.builder;

import io.github.divios.builder.values.assertValue;
import io.github.divios.builder.values.argument;
import io.github.divios.exceptions.assertException;
import io.github.divios.exceptions.unsatisfiedParameterException;
import io.github.divios.utils.Utils;

import java.util.*;

public class parserImpl implements parser {

    private final List<String> args;
    private final String filter;
    private final Map<Character, assertValue> assertFilters = new HashMap<>();
    private final Map<Character, argument> argsParsed = new HashMap<>();
    private final Map<Character, argument> defaultValues = new HashMap<>();

    protected parserImpl(String[] args, String filter) {
        this(args, filter, Collections.emptyMap());
    }

    protected parserImpl(String[] args, String filter, Map<Character, assertValue> assertFilters) {
        this(args, filter, assertFilters, Collections.emptyMap());
    }

    protected parserImpl(String[] args, String filter, Map<Character, assertValue> assertFilters, Map<Character, argument> defaultValues) {
        this.args = Arrays.asList(args);
        this.filter = filter;
        this.assertFilters.putAll(assertFilters);
        this.defaultValues.putAll(defaultValues);

        parseArgs();
    }

    @Override
    public argument getValue(char value) {
        return argsParsed.get(value);
    }

    @Override
    public Map<Character, argument> getAsMap() {
        return Collections.unmodifiableMap(argsParsed);
    }

    private void parseArgs() {
        Map<Character, Boolean> filterProcessed = new HashMap<>();    // Get filters and store it in a map, the value represents if it needs a parameter
        for (int i = 0; i < filter.length(); i++) {
            char c = filter.charAt(i);
            if (c == ':') continue;
            if (i != filter.length() - 1 && filter.charAt(i + 1) == ':')
                filterProcessed.put(c, true);
            else filterProcessed.put(c, false);
        }

        Map<Character, argument> argsInputtedProcessed = new HashMap<>();   // Formats the args inputted
        for (int i = 0; i < args.size(); i++) {
            String arg = args.get(i);
            if (!arg.startsWith("-")) continue;
            char parameterIndie = arg.substring(1).charAt(0);
            if (i != args.size() - 1 && !args.get(i + 1).startsWith("-"))
                argsInputtedProcessed.put(parameterIndie, argument.ofString(args.get(i + 1)));
            else
                argsInputtedProcessed.put(parameterIndie, null);
        }

        // Check if parameters inputted check filters
        for (Iterator<Map.Entry<Character, argument>> iter = argsInputtedProcessed.entrySet().iterator(); iter.hasNext(); ) {
            Map.Entry<Character, argument> entry = iter.next();
            if (!filterProcessed.containsKey(entry.getKey())) {
                iter.remove();
                continue;
            }
            boolean needsParam = filterProcessed.get(entry.getKey());
            if (needsParam && entry.getValue() == null)
                throw new unsatisfiedParameterException("Param " + entry.getKey() + " needs a parameter");
            if (!needsParam) entry.setValue(argument.ofString("true"));
        }

        assertFilters.forEach((character, assertValue) -> {         // Check asserts
            if (!argsInputtedProcessed.containsKey(character)) return;
            if (!assertValue.test(argsInputtedProcessed.get(character).getAsString()))
                throw new assertException(assertValue.getErrorMsg());
        });

        argsParsed.putAll(argsInputtedProcessed);

        defaultValues.forEach((character, argument) -> {     // Put default value if null or empty
            argument value = argsParsed.get(character);
            if (value == null || !Utils.testThrow(value::getAsObject))
                argsParsed.put(character, argument);
        });

    }

}
