package hr.bp.adventofcode.day02;

import java.util.List;
import java.util.Map;

public class Game {
    private final int gameId;
    private final List<Map<ColorEnum, Integer>> subsets;

    public Game(int gameId, List<Map<ColorEnum, Integer>> subsets) {
        this.gameId = gameId;
        this.subsets = subsets;
    }

    public int getGameId() {
        return gameId;
    }

    public boolean isPossibleWithBag(Bag bag) {
        for (Map<ColorEnum, Integer> subset : subsets) {
            if (!bag.canHoldSubset(subset)) {
                return false;
            }
        }
        return true;
    }
}