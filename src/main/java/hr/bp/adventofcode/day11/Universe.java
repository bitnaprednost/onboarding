package hr.bp.adventofcode.day11;

import hr.bp.adventofcode.GridCoordinates;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class Universe {

    private char[][] image;

    private List<GridCoordinates> galaxyLocations = new ArrayList<>();

    public Universe(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Input cannot be null or blank");
        }
        parseImage(input);
    }

    private void parseImage(String input) {
        String[] lines = input.split("\\n");
        image = new char[lines.length][];

        for (int i = 0; i < image.length; i++) {
            image[i] = lines[i].toCharArray();
        }
    }

    public void expand() {
        List<Integer> emptyRowIndexes = getEmptyRowIndexes();
        List<Integer> emptyColumnIndexes = getEmptyColumnIndexes();

        char[][] newImage = new char[image.length + emptyRowIndexes.size()][image[0].length + emptyColumnIndexes.size()];
        expandRowsAndThenColumns(newImage, emptyRowIndexes, emptyColumnIndexes);

        setGalaxyLocations();
    }

    private void setGalaxyLocations() {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                if (image[i][j] == '#') {
                    galaxyLocations.add(new GridCoordinates(i, j));
                }
            }
        }
    }

    public int getSumOfShortestPaths() {
        int sum = 0;
        for (int i = 0; i < galaxyLocations.size() - 1; i++) {
            for (int j = i + 1; j < galaxyLocations.size(); j++) {
                sum += getDistanceBetweenGalaxies(galaxyLocations.get(i), galaxyLocations.get(j));
            }
        }
        return sum;
    }

    private int getDistanceBetweenGalaxies(GridCoordinates coordinates1, GridCoordinates coordinates2) {
        return Math.abs(coordinates1.row() - coordinates2.row()) + Math.abs(coordinates1.column() - coordinates2.column());
    }

    private void expandRowsAndThenColumns(char[][] newImage, List<Integer> emptyRowIndexes, List<Integer> emptyColumnIndexes) {
        expandRows(newImage, emptyRowIndexes);
        expandColumns(newImage, emptyColumnIndexes);
    }

    private void expandColumns(char[][] original, List<Integer> emptyColumnIndexes) {
        int originalRows = original.length;
        int originalCols = original[0].length;

        char[][] expanded = new char[originalRows][originalCols];

        for (int row = 0; row < originalRows; row++) {
            int newColIndex = 0;
            for (int column = 0; column < originalCols; column++) {
                if (newColIndex + 1 > originalCols) break;
                expanded[row][newColIndex++] = original[row][column];

                for (int index : emptyColumnIndexes) {
                    if (column == index) {
                        expanded[row][newColIndex++] = original[row][column];
                        break;
                    }
                }
            }
        }
        image = expanded;
    }

    private void expandRows(char[][] newImage, List<Integer> emptyRowIndexes) {
        int duplicatedRows = 0;
        for (int row = 0; row < image.length; row++) {
            System.arraycopy(image[row], 0, newImage[row + duplicatedRows], 0, image[row].length);
            if (emptyRowIndexes.contains(row)) {
                System.arraycopy(image[row], 0, newImage[row + ++duplicatedRows], 0, image[row].length);
            }
        }
    }

    private List<Integer> getEmptyColumnIndexes() {
        List<Integer> emptyColumnIndexes = new ArrayList<>();

        for (int column = 0; column < image[0].length; column++) {
            boolean columnIsEmpty = true;
            for (char[] row : image) {
                if (row[column] == '#') {
                    columnIsEmpty = false;
                    break;
                }
            }
            if (columnIsEmpty) emptyColumnIndexes.add(column);
        }
        return emptyColumnIndexes;
    }

    private List<Integer> getEmptyRowIndexes() {
        List<Integer> emptyRowIndexes = new ArrayList<>();

        for (int row = 0; row < image.length; row++) {
            boolean rowIsEmpty = true;
            for (int column = 0; column < image[row].length; column++) {
                if (image[row][column] == '#') {
                    rowIsEmpty = false;
                    break;
                }
            }
            if (rowIsEmpty) emptyRowIndexes.add(row);
        }
        return emptyRowIndexes;
    }

    public char[][] getImage() {
        return image;
    }

}
