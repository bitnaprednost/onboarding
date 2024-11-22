package hr.bp.adventofcode.day02;

import hr.bp.adventofcode.day02.color.Color;

import java.util.List;
import java.util.Map;

/**
 * @author Ivan Tomičić
 */
public class GameRunnerPartOne {

    private final InputParser inputParser;

    public GameRunnerPartOne(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    public int calculateSumOfPossibleGameIds(String input, Bag bag) {
        Map<Integer, List<Map<Color, Integer>>> parsedInput = inputParser.parse(input);

        int sum = 0;

        for (Map.Entry<Integer, List<Map<Color, Integer>>> entry : parsedInput.entrySet()) {
            Game game = new Game(entry.getKey(), entry.getValue());

            if (game.isPossibleWithBag(bag)) {
                sum += game.getGameId();
            }
        }
        return sum;
    }
}
