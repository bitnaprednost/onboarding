package hr.bp.aoc2024.day10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static hr.bp.aoc2024.day10.TestUtil.*;

class TopographicalMapTest {

    @Test
    void getTrailheadScore_twoTrailheads() {
        TopographicMapParser parser = new TopographicMapParser(getTestInput());
        TopographicalMap map = new TopographicalMap(parser);

        Assertions.assertEquals(2, map.calculateTrailheadScore());
    }

    @Test
    void getTrailheadScore_fourTrailheads() {
        TopographicMapParser parser = new TopographicMapParser(getFourTrailheadsInput());
        TopographicalMap map = new TopographicalMap(parser);

        Assertions.assertEquals(4, map.calculateTrailheadScore());
    }

    @Test
    void getTrailheadScore_threeTrailheads() {
        TopographicMapParser parser = new TopographicMapParser(getThreeTrailheadsInput());
        TopographicalMap map = new TopographicalMap(parser);

        Assertions.assertEquals(3, map.calculateTrailheadScore());
    }

    @Test
    void getTrailheadScore_finalTestInputTrailheads() {
        TopographicMapParser parser = new TopographicMapParser(getFinalTestTrailheadsInput());
        TopographicalMap map = new TopographicalMap(parser);

        Assertions.assertEquals(36, map.calculateTrailheadScore());
    }

    @Test
    void getTrailheadScore_finalInputTrailheads() {
        TopographicMapParser parser = new TopographicMapParser(getFinalTrailheadsInput());
        TopographicalMap map = new TopographicalMap(parser);

        Assertions.assertEquals(550, map.calculateTrailheadScore());
    }

    @Test
    void getTrailheadScore_distinct_13() {
        TopographicMapParser parser = new TopographicMapParser(getFourTrailheadsInput());
        TopographicalMap map = new TopographicalMap(parser, true);

        Assertions.assertEquals(13, map.calculateTrailheadScore());
    }

    @Test
    void getTrailheadScore_distinct_finalInput() {
        TopographicMapParser parser = new TopographicMapParser(getFinalTrailheadsInput());
        TopographicalMap map = new TopographicalMap(parser, true);

        Assertions.assertEquals(1255, map.calculateTrailheadScore());
    }
}