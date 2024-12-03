package hr.bp.adventofcode.day14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author Ivan Tomičić
 */
public class Platform {

    char[][] grid;

    public Platform(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Input cannot be null or blank");
        }
        parseInput(input);
    }

    private void parseInput(String input) {
        String[] lines = input.split("\\n");
        grid = new char[lines.length][];

        for (int i = 0; i < lines.length; i++) {
            grid[i] = lines[i].toCharArray();
        }
    }


    public void tilt(PlatformDirection platformDirection) {
        switch (platformDirection) {
            case NORTH, SOUTH -> tiltVertically(platformDirection);
            case EAST, WEST -> tiltHorizontally(platformDirection);
        }
    }

    private void tiltHorizontally(PlatformDirection platformDirection) {
        for (int i = 0; i < grid.length; i++) {
            char[] row = grid[i].clone();
            String[] sections = new String(row).split("#", -1);
            String[] sortedSections = getSortedSections(sections, platformDirection.getComparator());
            char[] sectionsJoined = String.join("#", sortedSections).toCharArray();
            grid[i] = sectionsJoined;
        }
    }

    private void tiltVertically(PlatformDirection platformDirection) {
        for (int i = 0; i < grid[0].length; i++) {
            char[] column = getColumnAt(i);
            String[] sections = new String(column).split("#", -1);
            String[] sortedSections = getSortedSections(sections, platformDirection.getComparator());
            char[] sectionsJoined = String.join("#", sortedSections).toCharArray();
            updateColumn(sectionsJoined, i);
        }
    }

    private char[] getColumnAt(int i) {
        char[] column = new char[grid.length];
        int index = 0;

        for (char[] row : grid) {
            column[index++] = row[i];
        }
        return column;
    }

    private String[] getSortedSections(String[] sections, Comparator<Character> comparator) {
        String[] sortedSections = new String[sections.length];
        int i = 0;

        for (String section : sections) {
            addSortedSectionToArray(comparator, section, sortedSections, i);
            i++;
        }
        return sortedSections;
    }

    private void updateColumn(char[] newColumn, int columnIndex) {
        for (int i = 0; i < grid.length; i++) {
            grid[i][columnIndex] = newColumn[i];
        }
    }

    private static void addSortedSectionToArray(Comparator<Character> comparator, String section, String[] sortedSections, int i) {
        List<Character> charList = new ArrayList<>();
        for (char c : section.toCharArray()) {
            charList.add(c);
        }
        charList.sort(comparator);

        StringBuilder sortedString = new StringBuilder();
        for (char c : charList) {
            sortedString.append(c);
        }
        sortedSections[i] = sortedString.toString();
    }

    public int calculateTotalLoad() {
        int load = 0;
        for (int i = 0; i < grid.length; i++) {
            load += countRoundRocksInRow(i) * (grid.length - i);
        }
        return load;
    }

    private int countRoundRocksInRow(int i) {
        int count = 0;
        for (char c : grid[i]) {
            if (c == 'O') count++;
        }
        return count;
    }

    public int calculateLoadAfterCycles(int numberOfCycles) {
        HashMap<String, List<Integer>> seenStates = new HashMap<>();
        boolean cycleProcessed = false;
        for (int i = 0; i < numberOfCycles; i++) {

            if ((i+1) % 10000 == 0 && !cycleProcessed) {
                Optional<Integer> cycleLength = findCycleLength(seenStates);
                if (cycleLength.isPresent()) {
                    int cycleValue = cycleLength.get();
                    i += cycleValue * (((numberOfCycles - i) / cycleValue) - 1);
                    cycleProcessed = true;
                }
            }
            performCycle();

            String serialized = serializeGrid(grid);

            List<Integer> list = seenStates.getOrDefault(serialized, new ArrayList<>());
            list.add(i);
            seenStates.put(serialized, list);

        }
        return calculateTotalLoad();
    }

    private void performCycle() {
        tilt(PlatformDirection.NORTH);
        tilt(PlatformDirection.WEST);
        tilt(PlatformDirection.SOUTH);
        tilt(PlatformDirection.EAST);
    }

    private Optional<Integer> findCycleLength(HashMap<String, List<Integer>> seenStates) {
        for (Map.Entry<String, List<Integer>> entry : seenStates.entrySet()) {
            List<Integer> indexes = entry.getValue();
            if (indexes.size() > 10) {
                return Optional.of(indexes.get(indexes.size() - 1) - indexes.get(indexes.size() - 2));
            }
        }
        return Optional.empty();
    }

    private static String serializeGrid(char[][] grid) {
        StringBuilder sb = new StringBuilder();
        for (char[] row : grid) {
            sb.append(Arrays.toString(row));
        }
        return sb.toString();
    }

    public char[][] getGrid() {
        return this.grid;
    }
}
