package hr.bp.aoc.rock.paper.scissors;

import hr.bp.aoc.rock.paper.scissors.strategy.Strategy;
import hr.bp.aoc.util.Reader;

import java.io.IOException;
import java.nio.file.Path;
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
        Path path = Path.of(input);
        String[] linesFromFile = Reader.getLinesFromFile(path);
        List<char[]> parsedInputs = ReaderDay2.parseInputs(linesFromFile);

        strategy.resetScore();

        for (char[] round : parsedInputs) {
            strategy.simulateGame(round[0], round[1]);
        }
    }

    public int getScore(){
        return strategy.getScore();
    }

}
