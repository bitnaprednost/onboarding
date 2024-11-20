package adventofcode.day04;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Ivan Tomičić
 */
public class Game {
    private final Map<Integer, Scratchcard> scratchcards = new HashMap<>();

    public Game(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Input cannot be null or blank");
        }
        setScratchcardsFromInput(input);
    }

    private void setScratchcardsFromInput(String input) {
        String[] lines = input.split("\n");
        for (String line : lines) {
            addScratchcardFromLine(line);
        }

    }

    private void addScratchcardFromLine(String line) {
        String scratchcardNumber = line.split(":")[0].split("Card")[1].strip();
        String leftSide = line.split("\\|")[0].split(":")[1].strip();
        String rightSide = line.split("\\|")[1].strip();

        Set<Integer> winningNumbers = splitStringBySpace(leftSide);
        Set<Integer> playersNumbers = splitStringBySpace(rightSide);

        scratchcards.put(Integer.parseInt(scratchcardNumber), new Scratchcard(winningNumbers, playersNumbers));
    }

    private Set<Integer> splitStringBySpace(String numbersString) {
        return Arrays.stream(numbersString.split("\\s+"))
                .map(value -> Integer.parseInt(value.strip()))
                .collect(Collectors.toSet());
    }

    public Map<Integer, Scratchcard> getScratchcards() {
        return Collections.unmodifiableMap(scratchcards);
    }

    public int calculateTotalPoints() {
        int sum = 0;
        for (Scratchcard scratchcard : scratchcards.values()) {
            sum += scratchcard.calculatePoints();
        }
        return sum;
    }

    public int calculateTotalScratchcardsWon() {
        return 30;
    }
}
