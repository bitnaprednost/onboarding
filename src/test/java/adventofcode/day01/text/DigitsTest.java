package adventofcode.day01.text;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Igor Beslic
 */
public class DigitsTest {

    @Test
    public void testValueOfString() {
        Assertions.assertEquals(Digits.ONE, Digits.valueOfString("ONE"));
        Assertions.assertEquals(Digits.TWO, Digits.valueOfString("two"));
        Assertions.assertEquals(Digits.THREE, Digits.valueOfString("Three"));
        Assertions.assertEquals(Digits.FOUR, Digits.valueOfString("fouR"));
        Assertions.assertEquals(Digits.FIVE, Digits.valueOfString("fIve"));
        Assertions.assertEquals(Digits.SIX, Digits.valueOfString("sIx"));
        Assertions.assertEquals(Digits.SEVEN, Digits.valueOfString("seveN"));
        Assertions.assertEquals(Digits.EIGHT, Digits.valueOfString("eight"));
        Assertions.assertEquals(Digits.NINE, Digits.valueOfString("nInE"));
        Assertions.assertEquals(Digits.NOT_A_NUMBER, Digits.valueOfString("ON"));
        Assertions.assertEquals(Digits.NOT_A_NUMBER, Digits.valueOfString(""));
        Assertions.assertEquals(Digits.NOT_A_NUMBER, Digits.valueOfString(null));
        Assertions.assertEquals(Digits.NOT_A_NUMBER, Digits.valueOfString("7"));
        Assertions.assertEquals(Digits.NOT_A_NUMBER, Digits.valueOfString("dfdfdfd"));
    }

}
