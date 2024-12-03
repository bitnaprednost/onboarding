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

            SymmetryLine symmetryLine = pattern.getSymmetryLine(true);
            if (SymmetryDirection.COLUMN.equals(symmetryLine.direction())) {
                sum += symmetryLine.index() + 1;
            } else if (SymmetryDirection.ROW.equals(symmetryLine.direction())) {
                sum += 100 * (symmetryLine.index() + 1);
            }
        }
        return sum;
    }

    public int getSummarizationOfNotesWithoutASmudge() {
        int sum = 0;

        for (Pattern pattern : patterns) {

            SymmetryLine symmetryLine = pattern.getSymmetryLineWithoutSmudge();
            if (SymmetryDirection.COLUMN.equals(symmetryLine.direction())) {
                sum += symmetryLine.index() + 1;
            } else if (SymmetryDirection.ROW.equals(symmetryLine.direction())) {
                sum += 100 * (symmetryLine.index() + 1);
            }
        }
        return sum;
    }

}
