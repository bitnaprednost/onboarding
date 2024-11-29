package hr.bp.aoc.day7;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Game {
    Set<Hand> hands = new TreeSet<>();

    public Game(Set<Hand> hands) {
        this.hands = hands;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Game game = (Game) o;
        return Objects.equals(hands, game.hands);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(hands);
    }
}
