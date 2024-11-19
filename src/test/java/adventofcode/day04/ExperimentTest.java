package adventofcode.day04;

import adventofcode.day03.EngineSchematic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static adventofcode.day04.TestUtils.expectedHailstonesTestOne;
import static adventofcode.day04.TestUtils.getTestOneInput;


public class ExperimentTest {
    @Test
    public void testParsingOfInput() {
        String input = getTestOneInput();
        Experiment experiment = new Experiment(input);

        List<Hailstone> expectedHailstones = expectedHailstonesTestOne;

        List<Hailstone> actualHailstones = experiment.getHailstones();

        Assertions.assertEquals(expectedHailstones, actualHailstones);
    }
}
