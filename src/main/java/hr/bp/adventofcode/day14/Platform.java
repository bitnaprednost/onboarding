package hr.bp.adventofcode.day14;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

        if (platformDirection.equals(PlatformDirection.NORTH) || platformDirection.equals(PlatformDirection.SOUTH)) {
            tiltRows(platformDirection);

        } else if (platformDirection.equals(PlatformDirection.WEST) || platformDirection.equals(PlatformDirection.EAST)) {
            tiltColumns(platformDirection);
        }
    }

    private void tiltColumns(PlatformDirection platformDirection) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void tiltRows(PlatformDirection platformDirection) {
        for (int i = 0; i < grid[0].length; i++) {
            char[] column = getColumnAt(i);
            String[] sections = new String(column).split("#", -1);
            String[] sortedSections = getSortedSections(sections, platformDirection.getComparator());
            char[] sectionsJoined = String.join("#", sortedSections).toCharArray();
            replaceColumn(sectionsJoined, i);
        }
    }

    private void replaceColumn(char[] newColumn, int columnIndex) {
        for (int i = 0; i < grid.length; i++) {
            grid[i][columnIndex] = newColumn[i];
        }
    }

    private String[] getSortedSections(String[] sections, Comparator<Character> comparator) {
        String[] sortedSections = new String[sections.length];
        int i = 0;

        for (String section : sections) {
            addSortedStringToArray(comparator, section, sortedSections, i);
            i++;
        }
        return sortedSections;
    }

    private static void addSortedStringToArray(Comparator<Character> comparator, String section, String[] sortedSections, int i) {
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

    private char[] getColumnAt(int i) {
        char[] column = new char[grid.length];
        int index = 0;

        for (char[] row : grid) {
            column[index++] = row[i];
        }
        return column;
    }

    public char[][] getGrid() {
        return this.grid;
    }

    public int getLoad() {
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
}
