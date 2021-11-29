import io.github.divios.builder.parser;
import io.github.divios.builder.values.argType;
import io.github.divios.Parser;
import io.github.divios.exceptions.assertException;
import io.github.divios.exceptions.unsatisfiedParameterException;
import io.github.divios.utils.Primitives;
import io.github.divios.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class testParser {

    @Test
    public void testParser_1() {
        String[] args = {"-p", "3", "-d"};
        String filter = "p:ldn";
        parser parser = io.github.divios.builder.parser.create(args, filter);

        Assertions.assertEquals(3, parser.getValue('p').getAsInt());
        Assertions.assertTrue(parser.getValue('d').getAsBoolean());
        Assertions.assertNull(parser.getValue('c'));
    }

    @Test
    public void testParser_2() {
        String[] args = {"-p", "-d"};
        String filter = "p:ldn";
        Assertions.assertThrows(unsatisfiedParameterException.class, () -> parser.create(args, filter));
    }

    @Test
    public void testParser_noParameter() {
        String[] args = {"-p", "3", "-d", "-n"};

        parser parser = Parser.builder()
                .filter("p:ldn")
                .assertType('p', argType.INTEGER)
                .parse(args);

        Assertions.assertEquals(3, parser.getValue("p").getAsInt());
    }


    @Test
    public void testParser_testAssertType() {
        String[] args = {"-p", "3S", "-d", "-n"};

        Assertions.assertThrows(assertException.class, () -> {
            Parser.builder()
                    .filter("p:ldn")
                    .assertType('p', argType.INTEGER)
                    .parse(args);
        });
    }

    @Test
    public void testParser_testNoAssertType() {
        String[] args = {"-p", "3", "-d", "-n"};

        Assertions.assertDoesNotThrow(() -> {
            Parser.builder()
                    .filter("p:ldn")
                    .assertNoThrows('p', Integer::parseInt)
                    .parse(args);
        });
    }

    @Test
    public void testParser_defaultValues() {
        String[] args = {"-p", "3S", "-d", "-n"};

        parser parser = Parser.builder()
                .filter("p:ldnc")
                .assertDefault('c', 30)
                .parse(args);

        Assertions.assertEquals(true, parser.getValue("n").getAsBoolean());
        Assertions.assertEquals(30, parser.getValue('c').getAsInt());

    }

    @Test
    public void testParser_assertThrow() {
        String[] args = {"-p", "asdf", "-d", "-n"};

        Assertions.assertThrows(Exception.class, () ->
                Parser.builder()
                        .filter("p:ldnc")
                        .assertNoThrows('p', Primitives::getAsBoolean)
                        .assertDefault('c', 30)
                        .parse(args));
    }

    /*@Test
    public void testParser_assertClass() {
        String[] args = {"-p", "3", "-d", "-n"};

        parser parser = Parser.builder()
                .filter("p:ldn")
                .assertType('p', argType.INTEGER)
                .parse(args);

        int port = parser.getValue('p').parse(Integer.class).orElse(5);
        Assertions.assertEquals(3, Integer.class.cast("3"));
    } */

}
