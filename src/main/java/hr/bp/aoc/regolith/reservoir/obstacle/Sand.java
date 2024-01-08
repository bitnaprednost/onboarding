package hr.bp.aoc.regolith.reservoir.obstacle;

import java.awt.*;
import java.util.Objects;

/**
 * <p>Sand class.</p>
 *
 * @author Marko Krišković
 */
public class Sand implements Obsticle{
    private Point point;
    public Sand(Point point) {
        this.point=point;
    }

    public Sand(int x, int y) {
        this.point = new Point(x,y);
    }

    public Point getPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sand sand = (Sand) o;
        return Objects.equals(point, sand.point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point);
    }

    @Override
    public String toString() {
        return "Sand{" +
                "point=" + point +
                '}';
    }
}
