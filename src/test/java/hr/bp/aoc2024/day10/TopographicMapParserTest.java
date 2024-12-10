package hr.bp.aoc2024.day10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static hr.bp.aoc2024.day10.TestUtil.getExpectedTestInputTopographicalMap;
import static hr.bp.aoc2024.day10.TestUtil.getTestInput;

class TopographicMapParserTest {

    @Test
    void testCorrectInput() {
        TopographicMapParser parser = new TopographicMapParser(getTestInput());
        int[][] expected = getExpectedTestInputTopographicalMap();

        Assertions.assertArrayEquals(expected, parser.getTopographicalMap());
    }

}