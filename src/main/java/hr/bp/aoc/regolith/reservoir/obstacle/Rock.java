package hr.bp.aoc.regolith.reservoir.obstacle;

import java.awt.*;
import java.util.Objects;

public record Rock(Point point) implements Obsticle {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rock rock = (Rock) o;
        return Objects.equals(point, rock.point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point);
    }
}
