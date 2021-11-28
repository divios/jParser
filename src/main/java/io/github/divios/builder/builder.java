package io.github.divios.builder;

import io.github.divios.builder.options.builderOptions;

public interface builder {

    static builder create() {
        return new builderImpl();
    }

    default builderOptions filter(String filter) {
        return builderOptions.create(filter);
    }

    default builderOptions filter(String ...filters) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String filter : filters) {
            stringBuilder.append(filter);
        }
        return filter(stringBuilder.toString());
    }

}
