package adventofcode.day02;

import java.util.Map;

public class Bag {
    private final Map<ColorEnum, Integer> maxCubes;

    public Bag(int redCubes, int greenCubes, int blueCubes) {
        this.maxCubes = Map.of(
                ColorEnum.RED, redCubes,
                ColorEnum.GREEN, greenCubes,
                ColorEnum.BLUE, blueCubes
        );
    }

    public boolean canHoldSubset(Map<ColorEnum, Integer> subset) {
        for (Map.Entry<ColorEnum, Integer> entry : subset.entrySet()) {
            int maxAllowed = maxCubes.getOrDefault(entry.getKey(), 0);
            if (entry.getValue() > maxAllowed) {
                return false;
            }
        }
        return true;
    }
}
