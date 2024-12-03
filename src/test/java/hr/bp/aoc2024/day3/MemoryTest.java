package hr.bp.aoc2024.day3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static hr.bp.aoc2024.day3.TestUtil.getFinalInput;
import static hr.bp.aoc2024.day3.TestUtil.getTestInput;

class MemoryTest {

    @Test
    void testInputMultiplication() {
        MemoryParser parser = new MemoryParser(List.of(getTestInput()));
        Memory memory = new Memory(parser.getCommands());

        long expectedMultiplicationSum = 161;

        Assertions.assertEquals(expectedMultiplicationSum, memory.getMultiplicationSum());
    }

    @Test
    void FinalInputMultiplication() {
        MemoryParser parser = new MemoryParser(List.of(getFinalInput()));
        Memory memory = new Memory(parser.getCommands());

        long expectedMultiplicationSum = 184511516;

        Assertions.assertEquals(expectedMultiplicationSum, memory.getMultiplicationSum());
    }
}