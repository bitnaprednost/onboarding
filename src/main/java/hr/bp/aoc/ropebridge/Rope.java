package hr.bp.aoc.ropebridge;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

public class Rope {
    private final List<Point> ropePoints;

    public Rope(int size) {
        if(size<2) throw new IllegalArgumentException("Rope must have at least 2 points: head and tail");

        ropePoints = new LinkedList<>();
        for(int i=0;i<size;i++){
            ropePoints.add(new Point(0, 0));
        }
    }

    public Point getHead() {
        return new Point(ropePoints.getFirst());
    }

    public Point getTail() {
        return new Point(ropePoints.getLast());
    }

    public void moveRight() {
        Point prev = null;
        for(Point current : ropePoints){
            if(current==ropePoints.getFirst()) current.x++;
            else moveRight(prev, current);

            prev = current;
        }
    }

    private void moveRight(Point prev, Point current){
        if(prev.x-current.x > 1){
            current.x++;
            if(current.y != prev.y) current.y=prev.y;
        }
    }

    public void moveLeft() {
        Point prev = null;
        for(Point current : ropePoints){
            if(current==ropePoints.getFirst()) current.x--;
            else moveLeft(prev, current);

            prev = current;
        }
    }

    private void moveLeft(Point prev, Point current){
        if(current.x-prev.x > 1) {
            current.x--;
            if(current.y != prev.y) current.y=prev.y;
        }
    }

    public void moveUp() {
        Point prev = null;
        for(Point current : ropePoints){
            if(current==ropePoints.getFirst()) current.y++;
            else moveUp(prev, current);

            prev = current;
        }
    }

    private void moveUp(Point prev, Point current){
        if(prev.y-current.y > 1) {
            current.y++;
            if (current.x != prev.x) current.x = prev.x;
        }
    }

    public void moveDown() {
        Point prev = null;
        for(Point current : ropePoints){
            if(current==ropePoints.getFirst()) current.y--;
            else moveDown(prev, current);

            prev = current;
        }
    }

    private void moveDown(Point prev, Point current){
        if(current.y-prev.y > 1){
            current.y--;
            if(current.x != prev.x) current.x=prev.x;
        }
    }
}
