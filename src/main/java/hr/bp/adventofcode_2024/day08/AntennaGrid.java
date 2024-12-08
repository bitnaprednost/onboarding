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

    public int findUniqueAntinodes() {
        for (List<GridCoordinates> listOfAntennas : antennaCoordinates.values()) {
            addUniqueAntinodesForList(listOfAntennas);
        }
        return uniqueAntinodes.size();
    }

    private void addUniqueAntinodesForList(List<GridCoordinates> listOfAntennas) {
        for (int i = 0; i < listOfAntennas.size() - 1; i++) {
            for (int j = i + 1; j < listOfAntennas.size(); j++) {
                addUniqueAntinodesForPair(listOfAntennas.get(i), listOfAntennas.get(j));
            }
        }
    }

    private void addUniqueAntinodesForPair(GridCoordinates antenna1, GridCoordinates antenna2) {
        int dRow = Math.abs(antenna1.row() - antenna2.row());
        int dColumn = antenna1.column() - antenna2.column();

        boolean antenna1ComesBeforeAntenna2 = antenna1.row() < antenna2.row();

        GridCoordinates antinode1 = new GridCoordinates(
                Math.min(antenna1.row(), antenna2.row()) - dRow,
                antenna1ComesBeforeAntenna2 ? antenna1.column() + dColumn : antenna2.column() + dColumn);

        GridCoordinates antinode2 = new GridCoordinates(
                Math.max(antenna1.row(), antenna2.row()) + dRow,
                antenna1ComesBeforeAntenna2 ? antenna2.column() - dColumn : antenna1.column() - dColumn);

        if (isInsideGrid(antinode1)) uniqueAntinodes.add(antinode1);
        if (isInsideGrid(antinode2)) uniqueAntinodes.add(antinode2);
    }

    private boolean isInsideGrid(GridCoordinates antinode) {
        return antinode.row() >= 0 && antinode.row() <= biggestCoordinates.row() && antinode.column() >= 0 && antinode.column() <= biggestCoordinates.column();
    }
}
