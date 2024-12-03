package hr.bp.aoc2024.day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static hr.bp.aoc2024.day1.TestUtil.getExpectedTestText;
import static hr.bp.aoc2024.day1.TestUtil.getTestInput;

class ListParserTest {

    @Test
    void correctReadingFromFile() {
        ListParser parser = new ListParser(getTestInput());

        List<List<Long>> expected = getExpectedTestText();

        Assertions.assertEquals(expected, parser.parseInput());
    }

}