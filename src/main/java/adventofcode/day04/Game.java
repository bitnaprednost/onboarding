package adventofcode.day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Ivan Tomičić
 */
public class Game {
    private final List<Scratchcard> scratchcards = new ArrayList<>();

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
        String leftSide = line.split("\\|")[0].split(":")[1].strip();
        String rightSide = line.split("\\|")[1].strip();

        Set<Integer> winningNumbers = splitStringBySpace(leftSide);
        Set<Integer> playersNumbers = splitStringBySpace(rightSide);

        scratchcards.add(new Scratchcard(winningNumbers, playersNumbers));
    }

    private Set<Integer> splitStringBySpace(String numbersString) {
        return Arrays.stream(numbersString.split("\\s+"))
                .map(value -> Integer.parseInt(value.strip()))
                .collect(Collectors.toSet());
    }

    public List<Scratchcard> getScratchcards() {
        return scratchcards;
    }
}
