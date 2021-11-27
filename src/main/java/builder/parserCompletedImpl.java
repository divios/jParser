package builder;

import builder.values.parserValue;

import java.util.*;
import java.util.function.Predicate;

public class parserCompletedImpl implements parserCompleted {

    private final List<String> args;
    private final String filter;
    private final Map<Character, Predicate<String>> assertFilters = new HashMap<>();
    private final Map<Character, parserValue> argsParsed = new HashMap<>();

    protected parserCompletedImpl(String[] args, String filter) {
        this(args, filter, Collections.emptyMap());
    }

    protected parserCompletedImpl(String[] args, String filter, Map<Character, Predicate<String>> assertFilters) {
        this.args = List.of(args);
        this.filter = filter;
        this.assertFilters.putAll(assertFilters);

        parseArgs();
    }

    @Override
    public parserValue getValue(char value) {
        return argsParsed.get(value);
    }

    @Override
    public Map<Character, parserValue> getAsMap() {
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

        Map<Character, parserValue> argsInputtedProcessed = new HashMap<>();   // Formats the args inputted
        for (int i = 0; i < args.size(); i++) {
            String arg = args.get(i);
            if (!arg.startsWith("-")) continue;
            char parameterIndie = arg.substring(1).charAt(0);
            if (i != args.size() - 1 && !args.get(i + 1).startsWith("-"))
                argsInputtedProcessed.put(parameterIndie, parserValue.ofString(args.get(i + 1)));
            else
                argsInputtedProcessed.put(parameterIndie, null);
        }

        // Check if parameters inputted check filters
        for (Iterator<Map.Entry<Character, parserValue>> iter = argsInputtedProcessed.entrySet().iterator(); iter.hasNext(); ) {
            Map.Entry<Character, parserValue> entry = iter.next();
            if (!filterProcessed.containsKey(entry.getKey())) {
                iter.remove();
                continue;
            }
            boolean needsParam = filterProcessed.get(entry.getKey());
            if (needsParam && entry.getValue() == null)
                throw new RuntimeException("Param " + entry.getKey() + " needs a parameter");
            if (!needsParam) entry.setValue(parserValue.ofString("true"));
        }

        assertFilters.forEach((character, stringPredicate) -> {         // Check asserts
            if (!argsInputtedProcessed.containsKey(character)) return;
            if (!stringPredicate.test(argsInputtedProcessed.get(character).getAsString()))
                throw new RuntimeException("Parameter " + character);
        });

        argsParsed.putAll(argsInputtedProcessed);

    }

}
