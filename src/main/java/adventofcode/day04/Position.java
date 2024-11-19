package adventofcode.day04;

import java.util.Objects;

public class Position {

    private int x;
    private int y;
    private int z;

    public Position(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Position position)) return false;
        return x == position.x && y == position.y && z == position.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    public Integer getX() {
        return this.x;
    }

    public Integer getY() {
        return this.y;
    }
}
