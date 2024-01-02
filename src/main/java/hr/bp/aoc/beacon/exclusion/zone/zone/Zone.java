package hr.bp.aoc.beacon.exclusion.zone.zone;

import hr.bp.aoc.beacon.exclusion.zone.Beacon;
import hr.bp.aoc.beacon.exclusion.zone.util.Line;
import hr.bp.aoc.beacon.exclusion.zone.util.LongPoint;
import hr.bp.aoc.beacon.exclusion.zone.Sensor;

import java.util.*;
import java.util.stream.Collectors;

public class Zone {
    private final Set<Sensor> sensors;
    private final Set<Beacon> beacons;
    private Set<LongPoint> occupiedPoints;


    public Zone(Set<Sensor> sensors, Set<Beacon> beacons) {
        this.sensors=sensors;
        this.beacons=beacons;

        occupiedPoints = new HashSet<>();
    }


    public void calculateOccupiedPositions() {
        for(Sensor sensor : sensors){
            occupiedPoints.addAll(sensor.occupiedPositions());
        }

        Set<LongPoint> beaconPoints = beacons.stream().map(Beacon::point).collect(Collectors.toSet());
        occupiedPoints.removeAll(beaconPoints);
    }

    public void calculateOccupiedPositions(long y) {
        for(Sensor sensor : sensors){
            occupiedPoints.addAll(sensor.occupiedPositions(y));
        }

        Set<LongPoint> beaconPoints = beacons.stream().map(Beacon::point).collect(Collectors.toSet());
        occupiedPoints.removeAll(beaconPoints);
    }

    public Map<LongPoint, Integer> calculateRepeatingEdges(long topCount){
        Map<LongPoint, Integer> repeating = new HashMap<>();

        for(Sensor sensor : sensors){
            Set<LongPoint> edges = sensor.addEdges(topCount);

            for(LongPoint point : edges){
                if(occupiedPoints.contains(point)){
                    if(repeating.containsKey(point)) repeating.put(point, repeating.get(point)+1);
                    else repeating.put(point, 1);
                }
            }

            occupiedPoints.addAll(edges);
        }

        return repeating;
    }

    public Map<Line, Integer> calculateRepeatingLines(){
        Map<Line, Integer> repeating = new HashMap<>();

        for(Sensor sensor : sensors){
            List<Line> edgeLines = sensor.getOutlines();

            for(Line line : edgeLines){
                if(repeating.containsKey(line)) repeating.put(line, repeating.get(line)+1);
                else repeating.put(line, 1);
            }
        }

        return repeating;
    }

    public Beacon findBeacon(long topCount) {
        Map<LongPoint, Integer> map = calculateRepeatingEdges(topCount);

        for(Map.Entry<LongPoint, Integer> entry : map.entrySet()){
            if(entry.getValue()==4) return new Beacon(entry.getKey());
        }

        return null;
    }

    public Beacon findBeaconWithLines(int topCount) {
        Map<Line, Integer> lineMap = calculateRepeatingLines();
        List<Line> sorted = sortLines(lineMap);

        for(int i=0;i<sorted.size();i++){
            for(int j=i+1;j<sorted.size();j++){
                Optional<LongPoint> intersection = Line.calculateIntersection(sorted.get(i), sorted.get(j));

                if(!isInRange(topCount, intersection)) return new Beacon(intersection.get());
            }
        }

        return null;
    }

    private boolean isInRange(int topCount, Optional<LongPoint> intersection) {
        if(intersection.isEmpty()) return true;
        if(intersection.get().x()<0 || intersection.get().x()>topCount || intersection.get().y()<0 || intersection.get().y()>topCount) return true;

        for(Sensor sensor : sensors){
            if(sensor.isInRange(intersection.get())) return true;
        }

        return false;
    }

    private static List<Line> sortLines(Map<Line, Integer> lineMap) {
        return lineMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey)
                .toList();
    }

    public int getOccupiedSize() {
        return occupiedPoints.size();
    }
}
