package hr.bp.adventofcode.day07;

import org.graalvm.collections.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class Game {

    public List<Pair<Hand, Integer>> getListOfHands() {
        return listOfHands;
    }

    List<Pair<Hand, Integer>> listOfHands = new ArrayList<>();

    public Game(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Input cannot be null or blank");
        }
        parseInput(input);
    }

    private void parseInput(String input) {
        String[] lines  = input.split("\n");

        for (String line : lines) {
            createNewHandFromInputLine(line);
        }
    }

    private void createNewHandFromInputLine(String line) {
        String[] symbols = line.split("\\s+")[0].split("");
        Integer bidNumber = Integer.parseInt(line.split("\\s+")[1]);

        List<Card> cards = Arrays.stream(symbols).map(Card::fromSymbol).toList();

        listOfHands.add(Pair.create(new Hand(cards), bidNumber));
    }
}
