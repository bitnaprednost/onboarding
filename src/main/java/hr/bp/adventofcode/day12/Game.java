package hr.bp.adventofcode.day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class Game {

    private List<SpringRow> listOfSprings = new ArrayList<>();


    public Game(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Input cannot be null or blank");
        }
        parseInput(input);
    }

    public void unfoldSprings() {
        List<SpringRow> unfoldedListOfSprings = new ArrayList<>();

        for (SpringRow springRow : listOfSprings) {
            String newSprings = (springRow.getSprings() + "?").repeat(5);
            newSprings = newSprings.substring(0, newSprings.length() - 1);

            List<Integer> newContiguousGroups = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                newContiguousGroups.addAll(springRow.getContiguousGroups());
            }
            unfoldedListOfSprings.add(new SpringRow(newSprings, newContiguousGroups));

        }
        this.listOfSprings = unfoldedListOfSprings;

    }

    private void parseInput(String input) {
        for (String line : input.split("\\n")) {
            String springs = line.split("\\s+")[0];
            List<Integer> contiguousGroups = Arrays.stream(line.split("\\s+")[1].split(","))
                    .toList().stream().map(Integer::parseInt).toList();
            listOfSprings.add(new SpringRow(springs, contiguousGroups));
        }
    }

    public long calculateSumOfDifferentArrangements() {
        long sum = 0;
        for (SpringRow springRow : listOfSprings) {
            sum += springRow.getDifferentArrangements();
        }
        return sum;
    }
}
