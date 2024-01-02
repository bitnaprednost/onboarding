package hr.bp.aoc.beacon.exclusion.zone;

import hr.bp.aoc.beacon.exclusion.zone.zone.Zone;
import hr.bp.aoc.beacon.exclusion.zone.zone.ZoneParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZoneParserTest {
    private Zone zone;

    @BeforeEach
    void setUp() {
        String text = """
                Sensor at x=2, y=18: closest beacon is at x=-2, y=15
                Sensor at x=9, y=16: closest beacon is at x=10, y=16
                Sensor at x=13, y=2: closest beacon is at x=15, y=3
                Sensor at x=12, y=14: closest beacon is at x=10, y=16
                Sensor at x=10, y=20: closest beacon is at x=10, y=16
                Sensor at x=14, y=17: closest beacon is at x=10, y=16
                Sensor at x=8, y=7: closest beacon is at x=2, y=10
                Sensor at x=2, y=0: closest beacon is at x=2, y=10
                Sensor at x=0, y=11: closest beacon is at x=2, y=10
                Sensor at x=20, y=14: closest beacon is at x=25, y=17
                Sensor at x=17, y=20: closest beacon is at x=21, y=22
                Sensor at x=16, y=7: closest beacon is at x=15, y=3
                Sensor at x=14, y=3: closest beacon is at x=15, y=3
                Sensor at x=20, y=1: closest beacon is at x=15, y=3
                """;
        String[] lines = text.split("\n");
        zone = ZoneParser.createZone(lines);
    }

    @Test
    void canCreateZone(){
        zone.calculateOccupiedPositions(10);
        int count = zone.getOccupiedSize();

        assertEquals(26, count);
    }

    @Test
    void canFindBeacon(){
        Beacon beacon = zone.findBeacon(20);
        long frequency = beacon.calculateFrequency();

        assertEquals(56000011, frequency);
    }

    @Test
    void canFindBeaconWithLines(){
        Beacon beacon = zone.findBeaconWithLines(20);
        long frequency = beacon.calculateFrequency();

        assertEquals(56000011, frequency);
    }
}