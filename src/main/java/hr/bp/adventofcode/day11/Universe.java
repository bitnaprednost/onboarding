package hr.bp.adventofcode.day11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class Universe {

    private char[][] image;

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

    public char[][] getImage() {
        return image;
    }

    public void expand() {
        List<Integer> emptyRowIndexes = getEmptyRowIndexes();
        List<Integer> emptyColumnIndexes = getEmptyColumnIndexes();

        char[][] newImage = new char[image.length + emptyRowIndexes.size()][image[0].length + emptyColumnIndexes.size()];
        expandRowsAndThenColumns(newImage, emptyRowIndexes, emptyColumnIndexes);
    }

    private void expandRowsAndThenColumns(char[][] newImage, List<Integer> emptyRowIndexes, List<Integer> emptyColumnIndexes) {
        expandRows(newImage, emptyRowIndexes);
        expandColumns(newImage, emptyColumnIndexes);
    }

    public void expandColumns(char[][] original, List<Integer> indicesToDuplicate) {
        int originalRows = original.length;
        int originalCols = original[0].length;

        char[][] expanded = new char[originalRows][originalCols];

        for (int i = 0; i < originalRows; i++) {
            int newColIndex = 0;
            for (int j = 0; j < originalCols; j++) {
                if (newColIndex + 1 > originalCols) break;
                expanded[i][newColIndex++] = original[i][j];

                for (int index : indicesToDuplicate) {
                    if (j == index) {
                        expanded[i][newColIndex++] = original[i][j];
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
            for (int row = 0; row < image.length; row++) {
                if (image[row][column] == '#') {
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
}
