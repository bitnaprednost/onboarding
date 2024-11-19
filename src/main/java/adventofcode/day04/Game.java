package adventofcode.day04;

import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class Game {
    private List<Scratchcard> scratchcards;

    public Game(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Input cannot be null or blank");
        }
        setScratchcardsFromInput(input);
    }

    private void setScratchcardsFromInput(String input) {

    }

    public List<Scratchcard> getScratchcards() {
        return scratchcards;
    }
}
