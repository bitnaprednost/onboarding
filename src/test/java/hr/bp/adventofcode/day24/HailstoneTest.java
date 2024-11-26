package hr.bp.adventofcode.day24;

import org.graalvm.collections.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static hr.bp.adventofcode.day24.TestUtils.*;

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

    @Test
    public void testIntersectionIsInTheFuture() {
        Hailstone hailstone1 = new Hailstone(
                new Position(-3, -2, 0),
                new Velocity(1, 2, 0)
        );
        Hailstone hailstone2 = new Hailstone(
                new Position(-1, -1, 0),
                new Velocity(-1, -1, 0)
        );

        boolean expectedIsIntersectionIsInTheFutureOfHailstone1 = false;
        boolean expectedIsIntersectionIsInTheFutureOfHailstone2 = true;

        Pair<Double, Double> intersection = hailstone1.intersect(hailstone2);
        boolean actualIsIntersectionIsInTheFutureOfHailstone1 = hailstone1.pointIsInTheFutureOfTheLine(intersection);
        boolean actualIsIntersectionIsInTheFutureOfHailstone2 = hailstone2.pointIsInTheFutureOfTheLine(intersection);

        Assertions.assertEquals(expectedIsIntersectionIsInTheFutureOfHailstone1, actualIsIntersectionIsInTheFutureOfHailstone1);
        Assertions.assertEquals(expectedIsIntersectionIsInTheFutureOfHailstone2, actualIsIntersectionIsInTheFutureOfHailstone2);
    }

    @Test
    public void testIfHailstonesIntersectInTheFuture() {
        int minimumX = 7;
        int minimumY = 7;
        int maximumX = 7;
        int maximumY = 7;
        Hailstone hailstone1 = new Hailstone(
                new Position(-3, -2, 0),
                new Velocity(1, 2, 0)
        );
        Hailstone hailstone2 = new Hailstone(
                new Position(-1, -1, 0),
                new Velocity(-1, -1, 0)
        );

        boolean expectedIntersectInTheFuture = false;

        boolean actualIntersectInTheFuture = hailstone1.intersectsInTheFutureWithinArea(hailstone2, minimumX, minimumY, maximumX, maximumY);

        Assertions.assertEquals(expectedIntersectInTheFuture, actualIntersectInTheFuture);
    }
}
