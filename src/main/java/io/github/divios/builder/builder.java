package io.github.divios.builder;

import io.github.divios.builder.options.builderOptions;

public interface builder {

    static builder create() {
        return new builderImpl();
    }

    builderOptions filter(String filter);

}
