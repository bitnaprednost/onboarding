package adventofcode.day03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static adventofcode.day03.TestUtils.getTestOneInput;

public class EngineSchematicTest {

    @Test
    public void testOne() {
        String input = getTestOneInput();
        EngineSchematic engineSchematic = new EngineSchematic();

        int exptectedSum = 4361;

        int actualSum = engineSchematic.calculateSum(input);

        Assertions.assertEquals(exptectedSum, actualSum);
    }
}
