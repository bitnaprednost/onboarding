package hr.bp.aoc2024.day8;

import java.util.Objects;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coordinate getDistanceFrom(Coordinate other) {
        int newX = this.x - other.x;
        int newY = this.y - other.y;

        return new Coordinate(newX, newY);
    }

    public Coordinate add(Coordinate other) {
        return new Coordinate(this.x + other.x, this.y + other.y);
    }

    public Coordinate subtract(Coordinate other) {
        return new Coordinate(this.x - other.x, this.y - other.y);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
