package hr.bp.aoc2024.day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static hr.bp.aoc2024.day1.TestUtil.getFinalInput;
import static hr.bp.aoc2024.day1.TestUtil.getTestInput;

class LocationListTest {

    @Test
    void checkTotalDistanceTestInput() {
        ListParser parser = new ListParser(getTestInput());

        LocationList locationList = new LocationList(parser.parseInput());

        long expectedDistance = 11;

        Assertions.assertEquals(expectedDistance, locationList.getTotalDistance());
    }

    @Test
    void checkTotalDistanceFinalInput() {
        ListParser parser = new ListParser(getFinalInput());

        LocationList locationList = new LocationList(parser.parseInput());

        long expectedDistance = 2086478;

        Assertions.assertEquals(expectedDistance, locationList.getTotalDistance());
    }

}