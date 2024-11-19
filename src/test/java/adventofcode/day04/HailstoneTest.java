package adventofcode.day04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static adventofcode.day04.TestUtils.hailstone1;
import static adventofcode.day04.TestUtils.hailstone2;

public class HailstoneTest {
    @Test
    public void testParallelHailstonesInXYPlane() {
        Hailstone hailstone1 = hailstone1();
        Hailstone hailstone2 = hailstone2();

        boolean expectedIsParallel = true;

        boolean actualIsParallel = hailstone1.isParallelInXYPlaneWith(hailstone2);

        Assertions.assertEquals(expectedIsParallel, actualIsParallel);
    }
}
