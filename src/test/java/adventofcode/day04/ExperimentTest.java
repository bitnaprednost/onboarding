package adventofcode.day04;

import adventofcode.day03.EngineSchematic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static adventofcode.day04.TestUtils.*;


public class ExperimentTest {

    private static int MINIMUM_X = 7;
    private static int MINIMUM_Y = 7;
    private static int MAXIMUM_X = 27;
    private static int MAXIMUM_Y = 27;

    @Test
    public void testParsingOfInput() {
        String input = getTestOneInput();
        Experiment experiment = getExperimentForTheFirstTask(input);

        List<Hailstone> expectedHailstones = expectedHailstonesTestOne;

        List<Hailstone> actualHailstones = experiment.getHailstones();

        Assertions.assertEquals(expectedHailstones, actualHailstones);
    }

    @Test
    public void testParsingOfInputTwo() {
        String input = getTestTwoInput();
        Experiment experiment = getExperimentForTheFirstTask(input);

        List<Hailstone> expectedHailstones = expectedHailstonesTestTwo;

        List<Hailstone> actualHailstones = experiment.getHailstones();

        Assertions.assertEquals(expectedHailstones, actualHailstones);
    }

    @Test
    public void testCalculatingNumberOfIntersectionsWithinTestArea() {
        String input = getTestOneInput();
        Experiment experiment = getExperimentForTheFirstTask(input);

        int expectedNumberOfIntersections = 2;

        int actualNumberOfIntersections = experiment.calculateNumberOfIntersectionsWithinTestArea();

        Assertions.assertEquals(expectedNumberOfIntersections, actualNumberOfIntersections);
    }


    private Experiment getExperimentForTheFirstTask(String input) {
        return new Experiment(input, MINIMUM_X, MINIMUM_Y, MAXIMUM_X, MAXIMUM_Y);
    }
}
