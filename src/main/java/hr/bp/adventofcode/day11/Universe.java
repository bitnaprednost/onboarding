package hr.bp.adventofcode.day11;

import hr.bp.adventofcode.GridCoordinates;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class Universe {

    private char[][] image;

    private List<GridCoordinates> galaxyLocations;

    private List<Integer> emptyRowsIndexes;

    private List<Integer> emptyColumnsIndexes;

    public Universe(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Input cannot be null or blank");
        }
        parseImage(input);
        setGalaxyLocations();
        setEmptyRowIndexes();
        setEmptyColumnIndexes();
    }

    private void parseImage(String input) {
        String[] lines = input.split("\\n");
        image = new char[lines.length][];

        for (int i = 0; i < image.length; i++) {
            image[i] = lines[i].toCharArray();
        }
    }

    public long getSumOfShortestPathsForExpansionFactor(int expansionFactor) {
        long sum = 0;
        for (int i = 0; i < galaxyLocations.size() - 1; i++) {
            for (int j = i + 1; j < galaxyLocations.size(); j++) {
                sum += getDistanceBetweenGalaxiesForExpansionFactor(galaxyLocations.get(i), galaxyLocations.get(j), expansionFactor);
            }
        }
        return sum;
    }

    private long getDistanceBetweenGalaxiesForExpansionFactor(GridCoordinates coordinates1, GridCoordinates coordinates2, int expansionFactor) {
        long emptyColumnsBetween = emptyColumnsIndexes.stream()
                .filter(columnIndex -> {
                    int rightMostGalaxy = Math.max(coordinates1.column(), coordinates2.column());
                    int leftMostGalaxy = Math.min(coordinates1.column(), coordinates2.column());
                    return columnIndex > leftMostGalaxy && columnIndex < rightMostGalaxy;
                }
                ).count();

        long emptyRowsBetween = emptyRowsIndexes.stream()
                .filter(rowIndex -> {
                            int lowerMostGalaxy = Math.max(coordinates1.row(), coordinates2.row());
                            int upperMostGalaxy = Math.min(coordinates1.row(), coordinates2.row());
                            return rowIndex > upperMostGalaxy && rowIndex < lowerMostGalaxy;
                        }
                ).count();

        long columnDistance = Math.abs(coordinates1.column() - coordinates2.column());
        long rowDistance = Math.abs(coordinates1.row() - coordinates2.row());

        return rowDistance + columnDistance + (expansionFactor - 1) * (emptyRowsBetween + emptyColumnsBetween);
    }

    private void setGalaxyLocations() {
        galaxyLocations = new ArrayList<>();
        for (int rowIndex = 0; rowIndex < image.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < image[rowIndex].length; columnIndex++) {
                if (image[rowIndex][columnIndex] == '#') {
                    galaxyLocations.add(new GridCoordinates(rowIndex, columnIndex));
                }
            }
        }
    }

    private void setEmptyColumnIndexes() {
        List<Integer> emptyColumnIndexes = new ArrayList<>();

        for (int columnIndex = 0; columnIndex < image[0].length; columnIndex++) {
            boolean columnIsEmpty = true;
            for (char[] row : image) {
                if (row[columnIndex] == '#') {
                    columnIsEmpty = false;
                    break;
                }
            }
            if (columnIsEmpty) emptyColumnIndexes.add(columnIndex);
        }
        this.emptyColumnsIndexes = emptyColumnIndexes;
    }

    private void setEmptyRowIndexes() {
        List<Integer> emptyRowIndexes = new ArrayList<>();

        for (int rowIndex = 0; rowIndex < image.length; rowIndex++) {
            boolean rowIsEmpty = true;
            for (int columnIndex = 0; columnIndex < image[rowIndex].length; columnIndex++) {
                if (image[rowIndex][columnIndex] == '#') {
                    rowIsEmpty = false;
                    break;
                }
            }
            if (rowIsEmpty) emptyRowIndexes.add(rowIndex);
        }
        this.emptyRowsIndexes = emptyRowIndexes;
    }

    public char[][] getImage() {
        return image;
    }
}
