import io.github.divios.builder.parserCompleted;
import io.github.divios.builder.values.valueType;
import io.github.divios.Parser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class testParser {

    @Test
    public void testParser_1() {
        String[] args = {"-p", "3", "-d"};
        String filter = "p:ldn";
        parserCompleted parser = parserCompleted.create(args, filter);

        Assertions.assertEquals(3, parser.getValue('p').getAsInt());
        Assertions.assertEquals(true, parser.getValue('d').getAsBoolean());
        Assertions.assertEquals(null, parser.getValue('c'));
    }

    @Test
    public void testParser_2() {
        String[] args = {"-p", "-d"};
        String filter = "p:ldn";
        Assertions.assertThrows(Exception.class, () -> parserCompleted.create(args, filter));
    }

    @Test
    public void testParser_3() {
        String[] args = {"-p", "3", "-d", "-n"};

        parserCompleted parser = Parser.builder()
                .filter("p:ldn")
                .assertType('p', valueType.INTEGER)
                .parse(args);

        Assertions.assertEquals(3, parser.getValue("p").getAsInt());
    }


    @Test
    public void testParser_4() {
        String[] args = {"-p", "3S", "-d", "-n"};

        Assertions.assertThrows(Exception.class, () -> {
            Parser.builder()
                    .filter("p:ldn")
                    .assertType('p', valueType.INTEGER)
                    .parse(args);
        });
    }

}
