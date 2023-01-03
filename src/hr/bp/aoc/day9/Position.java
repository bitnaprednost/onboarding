package hr.bp.aoc.day9;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void updatePosition(int x, int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public int hashCode() {
        return this.x + this.y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Position) {
            int objX = ((Position) obj).getX();
            int objY = ((Position) obj).getY();
            return this.x == objX && this.y == objY;
        }
        return false;

    }

    @Override
    public String toString() {
        return "x: " + this.x + " y: " + this.y;
    }
}
