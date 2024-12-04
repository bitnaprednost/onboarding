package hr.bp.aoc2024.day4;

import java.util.List;

public class WordSearchParser {
    List<String> wordSearchInput;

    public WordSearchParser(List<String> wordSearchInput) {
        this.wordSearchInput = wordSearchInput;
    }

    public String[][] parseWordSearchInput() {
        int rows = wordSearchInput.size();
        int columns = wordSearchInput.get(0).length();

        String[][] searchTable = new String[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                searchTable[row][column] = getStringAtRowCol(row,column);
            }
        }

        return searchTable;
    }

    private String getStringAtRowCol(int row, int column) {
        return String.valueOf(wordSearchInput.get(row).charAt(column));
    }
}
