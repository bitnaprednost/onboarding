package adventofcode.day03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static adventofcode.day03.TestUtils.*;

public class EngineSchematicTest {

    @Test
    public void testCalculateSum() {
        String input = getTestOneInput();
        EngineSchematic engineSchematic = new EngineSchematic(input);

        int expectedSum = 4361;

        int actualSum = engineSchematic.calculateSum();

        Assertions.assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testAdjacentToSymbol() {
        String input = getTestOneInput();
        EngineSchematic engineSchematic = new EngineSchematic(input);

        boolean expectedValue = true;

        boolean actualValue = engineSchematic.isAdjacentToSymbol(2, 2, 3);

        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testNotAdjacentToSymbol() {
        String input = getTestOneInput();
        EngineSchematic engineSchematic = new EngineSchematic(input);

        boolean expectedValue = false;

        boolean actualValue = engineSchematic.isAdjacentToSymbol(5, 7, 8);

        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testCalculateSumTwo() {
        String input = getTestTwoInput();
        EngineSchematic engineSchematic = new EngineSchematic(input);

        int expectedSum = 4427;

        int actualSum = engineSchematic.calculateSum();

        Assertions.assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testCalculateSumOfGearRatios() {
        String input = getTestOneInput();
        EngineSchematic engineSchematic = new EngineSchematic(input);

        int expectedSum = 467835;

        int actualSum = engineSchematic.calculateSumOfGearRatios();

        Assertions.assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testCalculateSumOfGearRatiosTwo() {
        String input = getGearRatiosSumTestInputOne();
        EngineSchematic engineSchematic = new EngineSchematic(input);

        int expectedSum = 274;

        int actualSum = engineSchematic.calculateSumOfGearRatios();

        Assertions.assertEquals(expectedSum, actualSum);
    }

}
