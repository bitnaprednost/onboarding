package hr.bp.aoc2024.day11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static hr.bp.aoc2024.day11.TestUtil.*;

class StoneLineTest {

    @Test
    void testInputAfter_1blink() {
        StoneParser parser = new StoneParser(getTestInput());
        StoneLine stoneLine = new StoneLine(parser.parseInput());

        stoneLine.blink(1);

        StoneLine expected = new StoneLine(getStoneLine_1blink());

        Assertions.assertEquals(expected.getStoneLine(), stoneLine.getStoneLine());
    }

    @Test
    void testInputAfter_6blinks() {
        StoneParser parser = new StoneParser(getTestInputTwoStones());
        StoneLine stoneLine = new StoneLine(parser.parseInput());

        stoneLine.blink(6);

        int expectedNumStones = 22;

        Assertions.assertEquals(expectedNumStones, stoneLine.getNumberOfStones());
    }

    @Test
    void testInputAfter_25blinks() {
        StoneParser parser = new StoneParser(getTestInputTwoStones());
        StoneLine stoneLine = new StoneLine(parser.parseInput());

        stoneLine.blink(25);

        int expectedNumStones = 55312;

        Assertions.assertEquals(expectedNumStones, stoneLine.getNumberOfStones());
    }

    @Test
    void testInputAfter_25blinks_final() {
        StoneParser parser = new StoneParser(getFinalInput());
        StoneLine stoneLine = new StoneLine(parser.parseInput());

        stoneLine.blink(25);

        int expectedNumStones = 199986;

        Assertions.assertEquals(expectedNumStones, stoneLine.getNumberOfStones());
    }

}
