package hr.bp.adventofcode.day15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ivan Tomičić
 */
public class InitializationSequenceTest {

    @Test
    public void calculateSumOfHashes_givenInputOne_returnsCorrectSum() {
        String input = "rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7";
        InitializationSequence initializationSequence = new InitializationSequence(input);

        int expectedSum = 1320;

        int actualSum = initializationSequence.getSumOfHashes();

        Assertions.assertEquals(expectedSum, actualSum);
    }
}
