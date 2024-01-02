package hr.bp.aoc.beacon.exclusion.zone;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record Sensor(LongPoint point, Beacon beacon) {

    public long getManhattanDistance(){
        return (Math.abs(point.x() - beacon.point().x()) + Math.abs(point.y() - beacon.point().y()));
    }

    public long getManhattanDistance(LongPoint other){
        return (Math.abs(point.x() - other.x()) + Math.abs(point.y() - other.y()));
    }

    public Set<LongPoint> occupiedPositions() {
        Set<LongPoint> occupied = new HashSet<>();

        long distance = getManhattanDistance();
        for(long i=point.y()-distance;i<=point.y()+distance;i++){
            for(long j=point.x()-distance;j<=point.x()+distance;j++){
                LongPoint point = new LongPoint(j,i);
                if(getManhattanDistance(point)<=distance) occupied.add(point);
            }
        }

        return occupied;
    }

    public Set<LongPoint> occupiedPositions(long y) {
        Set<LongPoint> occupied = new HashSet<>();

        long distance = getManhattanDistance();
        for(long j=point.x()-distance;j<=point.x()+distance;j++){
            LongPoint point = new LongPoint(j,y);
            if(getManhattanDistance(point)<=distance) occupied.add(point);
        }

        return occupied;
    }

    private long addPoints(long topCount, long i, long step, Set<LongPoint> occupied) {
        if(i >=0 && i <= topCount) {
            if(point.y()+ step >= 0 && point.y()+ step <= topCount) occupied.add(new LongPoint(i, point.y()+ step));
            if(point.y()- step >= 0 && point.y()- step <= topCount) occupied.add(new LongPoint(i, point.y()- step));
        }
        step++;
        return step;
    }

    public Set<LongPoint> addEdges(long topCount) {
        Set<LongPoint> occupied = new HashSet<>();

        long distance = getManhattanDistance() + 1;

        //adds left to center
        long step = 0;
        for(long i=point.x()-distance;i<=point.x();i++){
            step = addPoints(topCount, i, step, occupied);
        }

        //adds right to center
        step = 0;
        for(long i=point.x()+distance;i>point.x();i--){
            step = addPoints(topCount, i, step, occupied);
        }

        return occupied;
    }

    public List<Line> getOutlines() {
        List<Line> lines = new ArrayList<>();

        long distance = getManhattanDistance() + 1;

        LongPoint left = new LongPoint(point.x() - distance, point.y());
        LongPoint up = new LongPoint(point.x(), point.y() - distance);
        LongPoint right = new LongPoint(point.x() + distance, point.y());
        LongPoint down = new LongPoint(point.x(),point.y() + distance);

        lines.add(new Line(-1, Line.calculateB(left, up)));
        lines.add(new Line(1, Line.calculateB(right, up)));
        lines.add(new Line(1, Line.calculateB(left, down)));
        lines.add(new Line(-1, Line.calculateB(right, down)));

        return lines;
    }

    public boolean isInRange(LongPoint otherPoint) {
        return getManhattanDistance() >= getManhattanDistance(otherPoint);
    }
}
