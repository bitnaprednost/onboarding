package hr.bp.aoc.beacon.exclusion.zone;

import hr.bp.aoc.beacon.exclusion.zone.util.Line;
import hr.bp.aoc.beacon.exclusion.zone.util.LongPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SensorTest {
    private Sensor sensor;

    @BeforeEach
    void setUp() {
        LongPoint beaconPoint = new LongPoint(2,10);
        LongPoint sensorPoint = new LongPoint(8,7);
        Beacon beacon = new Beacon(beaconPoint);
        sensor = new Sensor(sensorPoint, beacon);
    }

    @Test
    void canCalculateManhattanDistance(){
        long distance = sensor.getManhattanDistance();

        assertEquals(9, distance);
    }

    @Test
    void canGetAllOccupiedPositions(){
        Set<LongPoint> points = sensor.occupiedPositions();

        assertEquals(181, points.size());
    }

    @Test
    void canGetAllOccupiedPositionsOnCertainY(){
        Set<LongPoint> points = sensor.occupiedPositions(10);

        assertEquals(13, points.size());
    }

    @Test
    void canAddAllEdgesAroundOneSensor(){
        Set<LongPoint> points = sensor.addEdges(20);

        assertEquals(32, points.size());
    }

    @Test
    void canGetOutlines(){
        List<Line> lines = sensor.getOutlines();

        assertEquals(4, lines.size());
        assertEquals(new Line(-1, 5), lines.get(0));
        assertEquals(new Line(1, -11), lines.get(1));
        assertEquals(new Line(1, 9), lines.get(2));
        assertEquals(new Line(-1, 25), lines.get(3));
    }
}