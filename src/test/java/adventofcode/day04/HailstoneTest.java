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
}
