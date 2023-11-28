package day2;

import day2.strategy.Strategy;
import util.Parser;

import java.io.IOException;
import java.util.List;

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
