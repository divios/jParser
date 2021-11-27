package builder;

import builder.options.builderOptions;
import builder.options.builderOptionsImpl;

public class builderImpl implements builder {

   protected builderImpl() {

   }

   @Override
   public builderOptions filter(String filter) {
      return builderOptions.create(filter);
   }

}
