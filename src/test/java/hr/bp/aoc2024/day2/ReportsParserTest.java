package hr.bp.aoc2024.day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static hr.bp.aoc2024.day2.TestUtil.getExpectedTest;
import static hr.bp.aoc2024.day2.TestUtil.getTestInput;

class ReportsParserTest {

    @Test
    void correctTestInputTest() {
        ReportsParser parser = new ReportsParser(List.of(getTestInput().split("\\n")));

        List<List<Integer>> expected = getExpectedTest();

        Assertions.assertEquals(expected, parser.parseInput());
    }

}