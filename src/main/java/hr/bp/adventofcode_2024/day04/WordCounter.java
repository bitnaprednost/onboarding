package hr.bp.adventofcode_2024.day04;

import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static hr.bp.adventofcode_2024.Utils.parseGridTo2DArray;

/**
 * @author Ivan Tomičić
 */
public class WordCounter {

    private char[][] letters;

    private final Function<Integer, Integer> LR_MOVE_ROW = i -> i + 1;

    private final Function<Integer, Integer> RL_MOVE_ROW = i -> i - 1;

    public WordCounter(String input) {
        parseInput(input);
    }

    private void parseInput(String input) {
        letters = parseGridTo2DArray(input);
    }

    public int countWordOccurrences(String word) {
        int count = 0;

        count += countWordHorizontally(word);
        count += countWordVertically(word);
        count += countWordLRDiagonally(word);
        count += countWordRLDiagonally(word);
        return count;
    }

    private int countWordHorizontally(String word) {
        int count = 0;

        for (char[] row : letters) {
            String rowAsString = String.valueOf(row);
            count += countOccurrencesOfWordInString(word, rowAsString);
        }
        return count;
    }

    private int countWordVertically(String word) {
        int count = 0;

        for (int i = 0; i < letters[0].length; i++) {
            String columnAsString = getColumnAsString(i);
            count += countOccurrencesOfWordInString(word, columnAsString);
        }
        return count;
    }

    private int countWordLRDiagonally(String word) {
        int count = 0;

        for (int i = 0; i < letters[0].length; i++) {
            String diagonalAsString = getDiagonalAsString(0, i, LR_MOVE_ROW);
            count += countOccurrencesOfWordInString(word, diagonalAsString);
        }

        for (int i = 1; i < letters.length; i++) {
            String diagonalAsString = getDiagonalAsString(i, 0, LR_MOVE_ROW);
            count += countOccurrencesOfWordInString(word, diagonalAsString);
        }

        return count;
    }

    private int countWordRLDiagonally(String word) {
        int count = 0;

        for (int i = 0; i < letters[0].length; i++) {
            String diagonalAsString = getDiagonalAsString(letters.length - 1, i, RL_MOVE_ROW);
            count += countOccurrencesOfWordInString(word, diagonalAsString);
        }

        for (int i = 0; i < letters.length - 1; i++) {
            String diagonalAsString = getDiagonalAsString(i, 0, RL_MOVE_ROW);
            count += countOccurrencesOfWordInString(word, diagonalAsString);
        }

        return count;
    }

    private int countOccurrencesOfWordInString(String originalWord, String string) {
        int count = 0;

        String wordReverse = new StringBuilder(originalWord).reverse().toString();

        for (String word : List.of(originalWord, wordReverse)) {

            Pattern pattern = Pattern.compile(word);
            Matcher matcher = pattern.matcher(string);

            while (matcher.find()) count++;
        }
        return count;
    }

    private String getColumnAsString(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char[] row : letters) {
            stringBuilder.append(row[i]);
        }
        return stringBuilder.toString();
    }

    private String getDiagonalAsString(int row, int column, Function<Integer, Integer> rowDirection) {
        StringBuilder stringBuilder = new StringBuilder();

        while (notOutsideOfBounds(row, column)) {
            stringBuilder.append(letters[row][column++]);

            row = rowDirection.apply(row);
        }
        return stringBuilder.toString();
    }

    private boolean notOutsideOfBounds(int row, int column) {
        return row < letters.length && row >= 0 && column < letters[0].length && column >= 0;
    }

    public int countX_MASes() {
        int count = 0;
        for (int row = 1; row < letters.length - 1; row++) {
            for (int column = 1; column < letters[0].length - 1; column++) {
                if (letters[row][column] == 'A') {
                    if (isXShape(row, column)) count++;
                }
            }
        }
        return count;
    }

    private boolean isXShape(int row, int column) {
        return isMAndS(row-1, column-1, row+1, column+1) && isMAndS(row-1, column+1, row+1, column-1);
    }

    private boolean isMAndS(int row1, int column1, int row2, int column2) {
        return (letters[row1][column1] == 'S' && letters[row2][column2] == 'M') ||
                (letters[row1][column1] == 'M' && letters[row2][column2] == 'S');
    }
}
