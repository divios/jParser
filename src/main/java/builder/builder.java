package builder;

import builder.options.builderOptions;

public interface builder {

    static builder create() {
        return new builderImpl();
    }

    builderOptions filter(String filter);

}
