package adventofcode.day03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static adventofcode.day03.TestUtils.getTestOneInput;

public class EngineSchematicTest {

    @Test
    public void testOne() {
        String input = getTestOneInput();
        EngineSchematic engineSchematic = new EngineSchematic();

        int expectedSum = 4361;

        int actualSum = engineSchematic.calculateSum(input);

        Assertions.assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testAdjacentToSymbol() {
        String input = getTestOneInput();
        EngineSchematic engineSchematic = new EngineSchematic();

        boolean expectedValue = true;

        boolean actualValue = engineSchematic.isAdjacentToSymbol(2, 2, 3);

        Assertions.assertEquals(expectedValue, actualValue);
    }
}
