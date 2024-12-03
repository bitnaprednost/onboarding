package hr.bp.adventofcode_2024.day03;

import hr.bp.adventofcode_2024.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static hr.bp.adventofcode_2024.Utils.readInputForDay;

/**
 * @author Ivan Tomičić
 */
public class MemoryTest {

    @Test
    public void parseInput_givenInputOne_correctlyParsesInput() {
        String input = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))";
        Memory memory = new Memory(input);

        Map<Integer, Pair<Integer, Integer>> expectedMultiplicationInstructions = Map.of(
                1, new Pair<>(2,4),
                29, new Pair<>(5,5),
                53, new Pair<>(11,8),
                62, new Pair<>(8,5)
        );

        Map<Integer, Pair<Integer, Integer>> actualMultiplicationInstructions = memory.getMultiplicationInstructions();

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

    @Test
    public void calculateSum_givenTaskInput_returnsCorrectSum() {
        String input = readInputForDay("day03");
        Memory memory = new Memory(input);

        long expectedMultiplicationSum = 166905464;

        long actualMultiplicationSum = memory.sumMultiplications();

        Assertions.assertEquals(expectedMultiplicationSum, actualMultiplicationSum);
    }

    @Test
    public void calculateSumWithConditionalStatements_givenInputOne_returnsCorrectSum() {
        String input = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))";
        Memory memory = new Memory(input);

        long expectedMultiplicationSum = 48;

        long actualMultiplicationSum = memory.sumMultiplicationsWithConditions();

        Assertions.assertEquals(expectedMultiplicationSum, actualMultiplicationSum);
    }

    @Test
    public void calculateSumWithConditionalStatements_givenTaskInput_returnsCorrectSum() {
        String input = readInputForDay("day03");
        Memory memory = new Memory(input);

        long expectedMultiplicationSum = 72948684;

        long actualMultiplicationSum = memory.sumMultiplicationsWithConditions();

        Assertions.assertEquals(expectedMultiplicationSum, actualMultiplicationSum);
    }
}
