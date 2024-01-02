package hr.bp.aoc.beacon.exclusion.zone.zone;

import hr.bp.aoc.beacon.exclusion.zone.Beacon;
import hr.bp.aoc.beacon.exclusion.zone.LongPoint;
import hr.bp.aoc.beacon.exclusion.zone.Sensor;
import hr.bp.aoc.beacon.exclusion.zone.zone.Zone;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ZoneParser {
    private ZoneParser(){}

    private static LongPoint parseSensorPoint(String line) {
        String[] split = line.split(",");

        long sensorX = Long.parseLong(split[0].substring("Sensor at x=".length()));
        long sensorY = Long.parseLong(split[1].substring(" y=".length()));

        return new LongPoint(sensorX, sensorY);
    }

    private static LongPoint parseBeaconPoint(String line) {
        String[] split = line.split(",");

        long beaconX = Long.parseLong(split[0].substring(" closest beacon is at x=".length()));
        long beaconY = Long.parseLong(split[1].substring(" y=".length()));

        return new LongPoint(beaconX, beaconY);
    }

    public static Zone createZone(String[] lines) {
        Set<Sensor> sensors = new HashSet<>();
        Set<Beacon> beacons = new HashSet<>();

        for(String line : lines){
            String[] split = line.split(":");

            LongPoint sensorPoint = null;
            LongPoint beaconPoint = null;
            for(String subString : split){
                if(subString.startsWith("Sensor at x=")) sensorPoint = parseSensorPoint(subString);
                else if(subString.startsWith(" closest beacon is at x=")) beaconPoint = parseBeaconPoint(subString);
                else throw new UnsupportedOperationException();
            }
            Beacon beacon = new Beacon(beaconPoint);
            Sensor sensor = new Sensor(sensorPoint, beacon);
            beacons.add(beacon);
            sensors.add(sensor);
        }

        return new Zone(sensors, beacons);
    }

}
