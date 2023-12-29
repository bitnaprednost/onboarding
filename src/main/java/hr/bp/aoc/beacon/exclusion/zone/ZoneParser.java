package hr.bp.aoc.beacon.exclusion.zone;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ZoneParser {
    private ZoneParser(){}

    private static Sensor parseSensor(String line) {
        String[] split = line.split(",");

        long sensorX = Long.parseLong(split[0].substring("Sensor at x=".length()));
        long sensorY = Long.parseLong(split[1].substring(" y=".length()));

        return new Sensor(sensorX, sensorY);
    }

    private static Beacon parseBeacon(String line) {
        String[] split = line.split(",");

        long beaconX = Long.parseLong(split[0].substring(" closest beacon is at x=".length()));
        long beaconY = Long.parseLong(split[1].substring(" y=".length()));

        return new Beacon(beaconX, beaconY);
    }

    public static Zone createZone(List<String> lines) {
        Set<Sensor> sensors = new HashSet<>();
        Set<Beacon> beacons = new HashSet<>();

        for(String line : lines){
            String[] split = line.split(":");

            for(String subString : split){
                if(subString.startsWith("Sensor at x=")){
                    sensors.add(parseSensor(subString));
                }
                else if(subString.startsWith(" closest beacon is at x=")) {
                    beacons.add(parseBeacon(subString));
                }
                else throw new UnsupportedOperationException();
            }
        }

        return new Zone(sensors, beacons);
    }

}
