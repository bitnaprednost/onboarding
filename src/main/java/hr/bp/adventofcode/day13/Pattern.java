package hr.bp.adventofcode.day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Ivan Tomičić
 */
public class Pattern {

    private final List<String> rows = new ArrayList<>();;

    private final List<String> columns = new ArrayList<>();

    public Pattern(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Input cannot be null or blank");
        }
        parseInput(input);
    }

    private void parseInput(String input) {
        rows.addAll(Arrays.asList(input.split("\\n")));
        for (int i = 0; i < rows.get(0).length(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String row : rows) {
                stringBuilder.append(row.charAt(i));
            }
            columns.add(stringBuilder.toString());
        }
    }

    public SymmetryLine getSymmetryType() {
        SymmetryDirection symmetryDirection = SymmetryDirection.ROW;
        Optional<Integer> symmetryIndex = getSymmetryIndex(rows);

        if (symmetryIndex.isEmpty()) {

            symmetryDirection = SymmetryDirection.COLUMN;
            symmetryIndex = getSymmetryIndex(columns);

            if (symmetryIndex.isEmpty()) {
                throw new IllegalArgumentException("There is neither row nor column symmetry in the pattern");
            }
        }
        return new SymmetryLine(symmetryIndex.get(), symmetryDirection);
    }

    private Optional<Integer> getSymmetryIndex(List<String> pattern) {
        for (int i = 0; i < pattern.size() - 1; i++) {
            if (isSymmetricalLineOnIndex(i, pattern)) return Optional.of(i);
        }
        return Optional.empty();
    }

    private boolean isSymmetricalLineOnIndex(int i, List<String> pattern) {
        int shift = 0;
        do {
            String right = pattern.get(i + shift + 1);
            String left = pattern.get(i - shift);
            if (!left.equals(right)) return false;
            shift++;
        }  while (i - shift >= 0 && i + shift + 1 < pattern.size());
        return true;
    }
}
