package hr.bp.adventofcode.day13;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class ValleyOfPatterns {

    List<Pattern> patterns = new ArrayList<>();

    public ValleyOfPatterns(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Input cannot be null or blank");
        }
        parseInput(input);
    }

    private void parseInput(String input) {
        for (String patternInput : input.split("\\n\\n")) {
            patterns.add(new Pattern(patternInput));
        }
    }

    public int getSummarizationOfNotes() {
        int sum = 0;

        for (Pattern pattern : patterns) {

            SymmetryType symmetryType = pattern.getSymmetryType();
            if (SymmetryDirection.COLUMN.equals(symmetryType.direction())) {
                sum += symmetryType.index() + 1;
            } else if (SymmetryDirection.ROW.equals(symmetryType.direction())) {
                sum += 100 * (symmetryType.index() + 1);
            }
        }
        return sum;
    }

}
