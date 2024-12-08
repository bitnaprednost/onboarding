package hr.bp.adventofcode_2024.day08;

import hr.bp.adventofcode_2024.GridCoordinates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Ivan Tomičić
 */
public class AntennaGrid {

    private char[][] grid;

    private final Map<Character, List<GridCoordinates>> antennaCoordinates = new HashMap<>();

    private final GridCoordinates biggestCoordinates;

    private final Set<GridCoordinates> uniqueAntinodes = new HashSet<>();

    public AntennaGrid(String input) {
        String[] lines = input.replaceAll("\\r", "").split("\\n");

        for (int row = 0; row < lines.length; row++) {
            char[] line = lines[row].toCharArray();
            for (int column = 0; column < line.length; column++) {
                if (line[column] == '.') continue;
                antennaCoordinates.computeIfAbsent(line[column], k -> new ArrayList<>()).add(new GridCoordinates(row, column));
            }
        }
        biggestCoordinates = new GridCoordinates(lines.length - 1, lines[0].length() - 1);
    }

    public int findUniqueAntinodes(boolean useResonantHarmonics) {
        for (List<GridCoordinates> listOfAntennas : antennaCoordinates.values()) {
            addUniqueAntinodesForList(listOfAntennas, useResonantHarmonics);
        }
        return uniqueAntinodes.size();
    }

    private void addUniqueAntinodesForList(List<GridCoordinates> listOfAntennas, boolean useResonantHarmonics) {
        for (int i = 0; i < listOfAntennas.size() - 1; i++) {
            for (int j = i + 1; j < listOfAntennas.size(); j++) {
                addUniqueAntinodesForPair(listOfAntennas.get(i), listOfAntennas.get(j), useResonantHarmonics);
            }
        }
    }

    private void addUniqueAntinodesForPair(GridCoordinates antenna1, GridCoordinates antenna2, boolean useResonantHarmonics) {
        int dRow = Math.abs(antenna1.row() - antenna2.row());
        int dColumn = antenna1.column() - antenna2.column();

        boolean antenna1ComesBeforeAntenna2 = antenna1.row() < antenna2.row();

        int multiplicationFactor = 1;
        boolean searchExhausted;

        do {
            GridCoordinates antinode1 = new GridCoordinates(
                    Math.min(antenna1.row(), antenna2.row()) - dRow * multiplicationFactor,
                    antenna1ComesBeforeAntenna2 ? antenna1.column() + dColumn * multiplicationFactor : antenna2.column() + dColumn * multiplicationFactor);

            GridCoordinates antinode2 = new GridCoordinates(
                    Math.max(antenna1.row(), antenna2.row()) + dRow * multiplicationFactor,
                    antenna1ComesBeforeAntenna2 ? antenna2.column() - dColumn * multiplicationFactor : antenna1.column() - dColumn * multiplicationFactor);

            if (isInsideGrid(antinode1)) uniqueAntinodes.add(antinode1);
            if (isInsideGrid(antinode2)) uniqueAntinodes.add(antinode2);

            searchExhausted = !isInsideGrid(antinode1) && !isInsideGrid(antinode2);
            multiplicationFactor += 1;

        } while (useResonantHarmonics && !searchExhausted);

        if (useResonantHarmonics) {
            uniqueAntinodes.addAll(antennaCoordinates.values().stream().flatMap(List::stream).toList());
        }
    }

    private boolean isInsideGrid(GridCoordinates antinode) {
        return antinode.row() >= 0 && antinode.row() <= biggestCoordinates.row() && antinode.column() >= 0 && antinode.column() <= biggestCoordinates.column();
    }
}
