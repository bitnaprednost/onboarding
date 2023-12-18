package hr.bp.aoc.rope.bridge;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>Rope class.</p>
 *
 * @author Marko Krišković
 */
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
            else update(prev, current);

            prev = current;
        }
    }

    public void moveLeft() {
        Point prev = null;
        for(Point current : ropePoints){
            if(current==ropePoints.getFirst()) current.x--;
            else update(prev, current);

            prev = current;
        }
    }

    public void moveUp() {
        Point prev = null;
        for(Point current : ropePoints){
            if(current==ropePoints.getFirst()) current.y++;
            else update(prev, current);

            prev = current;
        }
    }

    public void moveDown() {
        Point prev = null;
        for(Point current : ropePoints){
            if(current==ropePoints.getFirst()) current.y--;
            else update(prev, current);

            prev = current;
        }
    }

    private void update(Point prev, Point current){
        if(prev.x-current.x > 1){
            current.x++;
            if(current.y != prev.y) current.y=prev.y;
        }
        else if(current.x-prev.x > 1) {
            current.x--;
            if(current.y != prev.y) current.y=prev.y;
        }
        else if(prev.y-current.y > 1) {
            current.y++;
            if (current.x != prev.x) current.x = prev.x;
        }
        else if(current.y-prev.y > 1){
            current.y--;
            if(current.x != prev.x) current.x=prev.x;
        }
    }

    public String print(int size){
        StringBuilder sb = new StringBuilder();
        for (int i=size;i>-size;i--){
            for (int j=-size;j<size;j++){
                if(i==0 && j==0) sb.append("s");
                else if(ropePoints.contains(new Point(j, i))) sb.append("#");
                else sb.append(".");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
