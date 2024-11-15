package adventofcode.day02;

import java.util.List;
import java.util.Map;

public class GameRunner {
    private final InputParser inputParser;

    public GameRunner(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    public int calculateSumOfPossibleGameIds(String input, Bag bag) {
        Map<Integer, List<Map<ColorEnum, Integer>>> parsedInput = inputParser.parse(input);

        int sum = 0;
        for (Map.Entry<Integer, List<Map<ColorEnum, Integer>>> entry : parsedInput.entrySet()) {
            Game game = new Game(entry.getKey(), entry.getValue());
            if (game.isPossibleWithBag(bag)) {
                sum += game.getGameId();
            }
        }

        return sum;
    }
}
