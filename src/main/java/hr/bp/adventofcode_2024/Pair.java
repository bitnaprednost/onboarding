package hr.bp.adventofcode_2024;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Ivan Tomičić
 */
public record Pair<K, V>(K left, V right) {

    public static Collection<Pair<Integer, Integer>> getAllIntegerPairsBetween(int row1, int column1, int row2, int column2) {
        List<Pair<Integer, Integer>> allIntegerPairs = new ArrayList<>();

        for (int row : IntStream.rangeClosed(Math.min(row1, row2), Math.max(row1, row2)).boxed().toList()) {

            for (int column : IntStream.rangeClosed(Math.min(column1, column2), Math.max(column1, column2)).boxed().toList()) {

                allIntegerPairs.add(new Pair<>(row, column));
            }
        }
        return allIntegerPairs;
    }
}
