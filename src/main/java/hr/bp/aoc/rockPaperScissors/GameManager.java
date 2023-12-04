package hr.bp.aoc.rockPaperScissors;

import hr.bp.aoc.rockPaperScissors.strategy.Strategy;
import hr.bp.aoc.util.Parser;

import java.io.IOException;
import java.util.List;

/**
 * <p>GameManager class.</p>
 *
 * @author Marko Krišković
 */
public class GameManager {
    private Strategy strategy;
    public GameManager(Strategy strategy) {
        this.strategy = strategy;
    }

    public void runGames(String input) throws IOException {
        String[] linesFromFile = Parser.getLinesFromFile(input);
        List<char[]> parsedInputs = ParserDay2.parseInputs(linesFromFile);

        strategy.resetScore();

        for (char[] round : parsedInputs) {
            strategy.simulateGame(round[0], round[1]);
        }
    }

    public int getScore(){
        return strategy.getScore();
    }

}
