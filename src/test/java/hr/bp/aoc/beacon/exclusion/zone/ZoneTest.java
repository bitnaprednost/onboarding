package hr.bp.aoc.beacon.exclusion.zone;

import hr.bp.aoc.beacon.exclusion.zone.zone.Zone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ZoneTest {
    private Beacon beacon;
    private Sensor sensor;
    private Zone zone;

    @BeforeEach
    void setUp() {
        LongPoint beaconPoint = new LongPoint(2,10);
        LongPoint sensorPoint = new LongPoint(8,7);
        beacon = new Beacon(beaconPoint);
        sensor = new Sensor(sensorPoint, beacon);
        zone = new Zone(new HashSet<>(List.of(sensor)), new HashSet<>(List.of(beacon)));
    }

    @Test
    void canGetAllOccupiedPositions(){
        zone.calculateOccupiedPositions();

        assertEquals(180, zone.getOccupiedSize());
    }

    @Test
    void canGetAllOccupiedPositionsMultiple(){
        Beacon beacon2 = new Beacon(new LongPoint(18,7));
        Sensor sensor2 = new Sensor(new LongPoint(9,7), beacon2);
        zone = new Zone(new HashSet<>(List.of(sensor, sensor2)), new HashSet<>(List.of(beacon, beacon2)));

        zone.calculateOccupiedPositions();

        assertEquals(198, zone.getOccupiedSize());
    }

    @Test
    void canGetOccupiedPositionsOnCertainYCoordinate(){
        zone.calculateOccupiedPositions(10);
        int count = zone.getOccupiedSize();

        assertEquals(12, count);
    }

    @Test
    void canGetOccupiedEdges(){
        zone.calculateRepeatingEdges(20);
        int count = zone.getOccupiedSize();

        assertEquals(32, count);
    }
}