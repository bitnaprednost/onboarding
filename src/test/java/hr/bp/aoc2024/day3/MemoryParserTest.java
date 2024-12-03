package hr.bp.aoc2024.day3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static hr.bp.aoc2024.day3.TestUtil.getExpectedCommandsTestInput;
import static hr.bp.aoc2024.day3.TestUtil.getTestInput;

class MemoryParserTest {

    @Test
    void getCommands_testInput() {
        List<String> expectedCommands = getExpectedCommandsTestInput();

        MemoryParser parser = new MemoryParser(List.of(getTestInput()));

        Assertions.assertEquals(expectedCommands, parser.getCommands());
    }
}