package hr.bp.adventofcode.day07;

import hr.bp.adventofcode.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class Game {

    private final boolean usesJokerCard;

    public List<Pair<Hand, Integer>> getListOfHands() {
        return listOfHands;
    }

    List<Pair<Hand, Integer>> listOfHands = new ArrayList<>();

    public Game(String input, boolean usesJokerCard) {
        this.usesJokerCard = usesJokerCard;

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

        listOfHands.add(new Pair<>(new Hand(cards, usesJokerCard), bidNumber));
    }

    public int calculateActualWinnings() {
        List<Pair<Hand, Integer>> listOfHandsRanked = listOfHands.stream().sorted(Comparator.comparing(Pair::left)).toList();

        int sum = 0;

        for (int i = 0; i < listOfHandsRanked.size(); i++) {
            sum += listOfHandsRanked.get(i).right() * (i+1);
        }

        return sum;
    }
}
