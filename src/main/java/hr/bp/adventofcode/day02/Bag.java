package hr.bp.adventofcode.day02;

import hr.bp.adventofcode.day02.color.Color;

import java.util.Map;

/**
 * @author Ivan Tomičić
 */
public class Bag {

    private final Map<Color, Integer> maxCubes;

    public Bag(int redCubes, int greenCubes, int blueCubes) {
        this.maxCubes = Map.of(
                Color.RED, redCubes,
                Color.GREEN, greenCubes,
                Color.BLUE, blueCubes
        );
    }

    public boolean canHoldSubset(Map<Color, Integer> subset) {
        for (Map.Entry<Color, Integer> entry : subset.entrySet()) {

            int maxAllowed = maxCubes.getOrDefault(entry.getKey(), 0);

            if (entry.getValue() > maxAllowed) {
                return false;
            }
        }
        return true;
    }
}
