package hr.bp.adventofcode.day01.text;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Igor Beslic
 */
public class DigitTest {

    @Test
    public void testValueOfString() {
        Assertions.assertEquals(Digit.ONE, Digit.valueOfString("ONE"));
        Assertions.assertEquals(Digit.TWO, Digit.valueOfString("two"));
        Assertions.assertEquals(Digit.THREE, Digit.valueOfString("Three"));
        Assertions.assertEquals(Digit.FOUR, Digit.valueOfString("fouR"));
        Assertions.assertEquals(Digit.FIVE, Digit.valueOfString("fIve"));
        Assertions.assertEquals(Digit.SIX, Digit.valueOfString("sIx"));
        Assertions.assertEquals(Digit.SEVEN, Digit.valueOfString("seveN"));
        Assertions.assertEquals(Digit.EIGHT, Digit.valueOfString("eight"));
        Assertions.assertEquals(Digit.NINE, Digit.valueOfString("nInE"));
        Assertions.assertEquals(Digit.NOT_A_NUMBER, Digit.valueOfString("ON"));
        Assertions.assertEquals(Digit.NOT_A_NUMBER, Digit.valueOfString(""));
        Assertions.assertEquals(Digit.NOT_A_NUMBER, Digit.valueOfString(null));
        Assertions.assertEquals(Digit.NOT_A_NUMBER, Digit.valueOfString("7"));
        Assertions.assertEquals(Digit.NOT_A_NUMBER, Digit.valueOfString("dfdfdfd"));
    }

}
