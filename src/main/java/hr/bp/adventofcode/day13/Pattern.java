package hr.bp.adventofcode.day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

/**
 * @author Ivan Tomičić
 */
public class Pattern {

    private List<String> rows = new ArrayList<>();;

    private List<String> columns = new ArrayList<>();

    private SymmetryLine symmetryLineWithSmudge;

    private final Function<Character, Character> flipper = c -> {
        if (c.equals('.')) return '#';
        else return '.';
    };

    public Pattern() {}

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

    public SymmetryLine getSymmetryLine(boolean withSmudge) {
        SymmetryDirection symmetryDirection = SymmetryDirection.ROW;
        Optional<Integer> symmetryIndex = getSymmetryIndex(rows, withSmudge, symmetryDirection);

        if (symmetryIndex.isEmpty()) {

            symmetryDirection = SymmetryDirection.COLUMN;
            symmetryIndex = getSymmetryIndex(columns, withSmudge, symmetryDirection);

            if (symmetryIndex.isEmpty()) {
                throw new IllegalArgumentException("There is neither row nor column symmetry in the pattern");
            }
        }
        return new SymmetryLine(symmetryIndex.get(), symmetryDirection);
    }

    public SymmetryLine getSymmetryLineWithoutSmudge() {
        this.symmetryLineWithSmudge = getSymmetryLine(true);

        Pattern originalPattern = new Pattern();

        originalPattern.rows = new ArrayList<>(rows);
        originalPattern.columns = new ArrayList<>(columns);

        for (int i = 0; i < rows.size(); i++) {
            for (int j = 0; j < rows.getFirst().length(); j++) {

                flipElement(i, j);
                try {
                    SymmetryLine newSymmetryLine = getSymmetryLine(false);
                    if (!newSymmetryLine.equals(this.symmetryLineWithSmudge)) {
                        return newSymmetryLine;
                    }
                } catch (Exception e) {
                }
                flipElement(i, j);
            }
        }
        return null;
    }

    private void flipElement(int i, int j) {
        flipElementForListAtIndex(i, j, rows);
        flipElementForListAtIndex(j, i, columns);
    }

    private void flipElementForListAtIndex(int i, int j, List<String> list) {
        Character newElement = flipper.apply(list.get(i).charAt(j));

        StringBuilder stringBuilder = new StringBuilder(list.get(i));
        stringBuilder.setCharAt(j, newElement);

        list.set(i, stringBuilder.toString());
    }

    private Optional<Integer> getSymmetryIndex(List<String> pattern, boolean withSmudge, SymmetryDirection direction) {
        for (int i = 0; i < pattern.size() - 1; i++) {
            if (isSymmetricalLineOnIndex(i, pattern)) {
                if (!withSmudge && this.symmetryLineWithSmudge.equals(new SymmetryLine(i, direction))) {
                    continue;
                }
                return Optional.of(i);
            }
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pattern pattern)) return false;
        return Objects.equals(rows, pattern.rows) && Objects.equals(columns, pattern.columns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rows, columns);
    }
}
