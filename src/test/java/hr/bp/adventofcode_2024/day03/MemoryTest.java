package hr.bp.adventofcode_2024.day03;

import hr.bp.adventofcode_2024.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class MemoryTest {

    @Test
    public void parseInput_givenInputOne_correctlyParsesInput() {
        String input = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))";
        Memory memory = new Memory(input);

        List<Pair<Integer, Integer>> expectedMultiplicationInstructions = List.of(
                new Pair<>(2,4),
                new Pair<>(5,5),
                new Pair<>(11,8),
                new Pair<>(8,5)
        );

        List<Pair<Integer, Integer>> actualMultiplicationInstructions = memory.getMultiplicationInstructions();

        Assertions.assertEquals(expectedMultiplicationInstructions, actualMultiplicationInstructions);
    }

    @Test
    public void calculateSum_givenInputOne_returnsCorrectSum() {
        String input = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))";
        Memory memory = new Memory(input);

        long expectedMultiplicationSum = 161;

        long actualMultiplicationSum = memory.sumMultiplications();

        Assertions.assertEquals(expectedMultiplicationSum, actualMultiplicationSum);
    }
}
