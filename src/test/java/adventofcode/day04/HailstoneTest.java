package adventofcode.day04;

import org.graalvm.collections.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static adventofcode.day04.TestUtils.*;

public class HailstoneTest {
    @Test
    public void testParallelHailstonesInXYPlane() {
        Hailstone hailstone1 = hailstone1();
        Hailstone hailstone2 = hailstone2();

        boolean expectedIsParallel = true;

        boolean actualIsParallel = hailstone1.isParallelInXYPlaneWith(hailstone2);

        Assertions.assertEquals(expectedIsParallel, actualIsParallel);
    }

    @Test
    public void testCalculationOfIntersectionOfTwoLines() {
        Hailstone hailstone1 = hailstone1();
        Hailstone hailstone3 = hailstone3();

        Pair<Double, Double> expectedIntersection = Pair.create(0.5d, 0.5d);

        Pair<Double, Double> actualIntersection = hailstone1.intersect(hailstone3);

        Assertions.assertEquals(expectedIntersection, actualIntersection);
    }

    @Test
    public void testIntersectionAtDifferentPoint() {
        Hailstone hailstone1 = new Hailstone(
                new Position(0, 1, 0),
                new Velocity(2, 4, 0)
        );
        Hailstone hailstone2 = new Hailstone(
                new Position(1, 0, 0),
                new Velocity(1, 1, 0)
        );

        Pair<Double, Double> expectedIntersection = Pair.create(-2.0d, -3.0d);

        Pair<Double, Double> actualIntersection = hailstone1.intersect(hailstone2);

        Assertions.assertEquals(expectedIntersection, actualIntersection);
    }

    @Test
    public void testParallelLines() {
        Hailstone hailstone1 = new Hailstone(
                new Position(0, 0, 0),
                new Velocity(1, 1, 0)
        );
        Hailstone hailstone2 = new Hailstone(
                new Position(1, 1, 0),
                new Velocity(1, 1, 0)
        );

        Pair<Double, Double> expectedIntersection = Pair.create(Double.NaN, Double.NaN);

        Pair<Double, Double> actualIntersection = hailstone1.intersect(hailstone2);

        Assertions.assertEquals(expectedIntersection, actualIntersection);
    }

    @Test
    public void testCoincidentLines() {
        Hailstone hailstone1 = new Hailstone(
                new Position(0, 0, 0),
                new Velocity(2, 2, 0)
        );
        Hailstone hailstone2 = new Hailstone(
                new Position(0, 0, 0),
                new Velocity(2, 2, 0)
        );

        Pair<Double, Double> expectedIntersection = Pair.create(Double.NaN, Double.NaN);

        Pair<Double, Double> actualIntersection = hailstone1.intersect(hailstone2);

        Assertions.assertEquals(expectedIntersection, actualIntersection);
    }

    @Test
    public void testIntersectionOnNegativeAxes() {
        Hailstone hailstone1 = new Hailstone(
                new Position(-3, -2, 0),
                new Velocity(1, 2, 0)
        );
        Hailstone hailstone2 = new Hailstone(
                new Position(-1, -1, 0),
                new Velocity(-1, -1, 0)
        );

        Pair<Double, Double> expectedIntersection = Pair.create(-4.0d, -4.0d);

        Pair<Double, Double> actualIntersection = hailstone1.intersect(hailstone2);

        Assertions.assertEquals(expectedIntersection, actualIntersection);
    }
}
