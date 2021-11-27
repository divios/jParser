package io.github.divios.builder;

import io.github.divios.builder.options.builderOptions;

public class builderImpl implements builder {

   protected builderImpl() {

   }

   @Override
   public builderOptions filter(String filter) {
      return builderOptions.create(filter);
   }

}
