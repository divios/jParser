import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.Primitives;

public class testPrimitives {

    @Test
    public void testIsShort_1() {
        String shortToTest = "1234";
        Assertions.assertEquals(true, Primitives.isShort(shortToTest));
    }

    @Test
    public void TestIsShort_2() {
        String shortToTest = "1234S";
        Assertions.assertEquals(false, Primitives.isShort(shortToTest));
    }

    @Test
    public void testIsShort_3() {
        String shortToTest = String.valueOf(Short.MAX_VALUE + 1);
        Assertions.assertEquals(false, Primitives.isShort(shortToTest));
    }

    @Test
    public void parseShort_1() {
        String parserShort = "1234";
        Assertions.assertEquals(1234, Primitives.getAsShort(parserShort));
    }

    @Test
    public void testIsInteger_1() {
        String intToTest = "1234";
        Assertions.assertEquals(true, Primitives.isInteger(intToTest));
    }

    @Test
    public void testIsInteger_2() {
        String intToTest = "123S";
        Assertions.assertEquals(true, Primitives.isInteger(intToTest));
    }

    @Test
    public void testIsInteger_3() {
        String intToTest = String.valueOf((long) Integer.MAX_VALUE + 1);
        Assertions.assertEquals(false, Primitives.isInteger(intToTest));
    }

    @Test
    public void testParseInteger_1() {
        String intToParse = "1234";
        Assertions.assertEquals(1234, Primitives.isInteger(intToParse));
    }

    @Test
    public void testIsLong_1() {
        String longToTest = "1234";
        Assertions.assertEquals(true, Primitives.isLong(longToTest));
    }

    @Test
    public void testIsLong_2() {
        String longToTest = "1234S";
        Assertions.assertEquals(false, Primitives.isLong(longToTest));
    }

    @Test
    public void testParseLong_1() {
        String longParser = "1234";
        Assertions.assertEquals(1234, longParser);
    }

    @Test
    public void testIsChar_1() {
        String charToTest = "a";
        Assertions.assertEquals(true, Primitives.isChar(charToTest));
    }

    @Test
    public void testIsChar_2() {
        String charToTest = "3";
        Assertions.assertEquals(true, Primitives.isChar(charToTest));
    }

    @Test
    public void testIsChar_3() {
        String charToTest = ":";
        Assertions.assertEquals(true, Primitives.isChar(charToTest));
    }

    @Test
    public void testIsChar_4() {
        String charToTest = "ap";
        Assertions.assertEquals(false, Primitives.isChar(charToTest));
    }

    @Test
    public void testParseChar_1() {
        String charParsed = "a";
        Assertions.assertEquals('a', Primitives.getAsChar(charParsed));
    }

    @Test
    public void testIsBoolean_1() {
        String booleanToTest = "false";
        Assertions.assertEquals(true, Primitives.isBoolean(booleanToTest));
    }

    @Test
    public void testIsBoolean_2() {
        String booleanToTest = "true";
        Assertions.assertEquals(true, Primitives.isBoolean(booleanToTest));
    }

    @Test
    public void testParseBoolean_1() {
        String parseBoolean = "true";
        Assertions.assertEquals(true, Primitives.getAsBoolean(parseBoolean));
    }

    @Test
    public void testIsBoolean_3() {
        String booleanToTest = "shouldNotBeBoolean";
        Assertions.assertEquals(false, Primitives.isBoolean(booleanToTest));
    }


}
