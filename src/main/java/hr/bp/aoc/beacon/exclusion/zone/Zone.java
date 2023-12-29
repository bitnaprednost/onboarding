package hr.bp.aoc.beacon.exclusion.zone;

import java.util.Set;

public class Zone {
    private final Set<Sensor> sensors;
    private final Set<Beacon> beacons;

    public Zone(Set<Sensor> sensors, Set<Beacon> beacons) {
        this.sensors=sensors;
        this.beacons=beacons;
    }

}
