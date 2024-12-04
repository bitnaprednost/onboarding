package hr.bp.aoc2024.day4;

public class WordSearch {
    private final String wordToFind = "XMAS";
    private final String wordToFindReversed = "SAMX";

    private String[][] searchTable;

    public WordSearch(String[][] searchTable) {
        this.searchTable = searchTable;
    }

    public int findXMas() {
        int xMasCount = 0;

        for (int row = 0; row < searchTable.length; row++) {
            for (int column = 0; column < searchTable[0].length; column++) {
                String letterFound = searchTable[row][column];

                if (letterFound.equals("A")) {
                    if (checkDiagonalsForXmas(row, column)) {
                        xMasCount += 1;
                    }
                }
            }
        }

        return xMasCount;
    }

    private boolean checkDiagonalsForXmas(int row, int column) {
        return checkDiagonalLRForXmas(row, column) && checkDiagonalRL(row, column);
    }

    private boolean checkDiagonalLRForXmas(int row, int column) {
        if (row - 1 >= 0 && column - 1 >= 0) {
            String wordFound = findWordDiagonalLR(row - 1, column - 1, 3);
            if (wordFound.equals("MAS") || wordFound.equals("SAM"))
                return true;
        }

        return false;
    }

    private boolean checkDiagonalRL(int row, int column) {
        if (row - 1 >= 0 && column + 1 < searchTable[row].length) {
            String wordFound = findWordDiagonalRL(row - 1, column + 1, 3);
            if (wordFound.equals("MAS") || wordFound.equals("SAM"))
                return true;
        }

        return false;
    }

    public int findWordInSearchTable() {
        int foundWordCount = 0;

        for (int row = 0; row < searchTable.length; row++) {
            for (int column = 0; column < searchTable[0].length; column++) {
                String letterFound = searchTable[row][column];

                if (letterFound.equals("X") || letterFound.equals("S")) {
                    foundWordCount += findHorizontalWord(row, column);
                    foundWordCount += findVerticalWord(row, column);
                    foundWordCount += findDiagonalWordRL(row, column);
                    foundWordCount += findDiagonalWordLR(row, column);
                }
            }
        }

        return foundWordCount;
    }

    private int findHorizontalWord(int row, int column) {
        String wordFound = findWordInRow(row, column);
        return ifWordIsFound(wordFound) ? 1 : 0;
    }

    private int findVerticalWord(int row, int column) {
        String wordFound = findWordInCol(row, column);
        return ifWordIsFound(wordFound) ? 1 : 0;
    }

    private int findDiagonalWordRL(int row, int column) {
        String wordFound = findWordDiagonalRL(row, column, wordToFind.length());
        return ifWordIsFound(wordFound) ? 1 : 0;
    }

    private int findDiagonalWordLR(int row, int column) {
        String wordFound = findWordDiagonalLR(row, column, wordToFind.length());
        return ifWordIsFound(wordFound) ? 1 : 0;
    }

    private boolean ifWordIsFound(String wordFound) {
        return wordFound.equals(wordToFind) || wordFound.equals(wordToFindReversed);
    }


    private String findWordDiagonalRL(int row, int column, int wordLength) {
        StringBuilder sb = new StringBuilder();

        for (int i = row, j = column;
             i < searchTable.length && j >= 0 && sb.length() < wordLength;
             i++, j--) {
            sb.append(searchTable[i][j]);
        }

        return sb.toString();
    }

    private String findWordDiagonalLR(int row, int column, int wordLength) {
        StringBuilder sb = new StringBuilder();

        for (int i = row, j = column;
             i < searchTable.length && j < searchTable[row].length && sb.length() < wordLength;
             i++, j++) {
            sb.append(searchTable[i][j]);
        }

        return sb.toString();
    }

    private String findWordInRow(int row, int column) {
        StringBuilder sb = new StringBuilder();

        for (int i = column; i < searchTable[row].length && sb.length() < 4; i++) {
            sb.append(searchTable[row][i]);
        }

        return sb.toString();
    }

    private String findWordInCol(int row, int column) {
        StringBuilder sb = new StringBuilder();

        for (int i = row; i < searchTable.length && sb.length() < 4; i++) {
            sb.append(searchTable[i][column]);
        }

        return sb.toString();
    }
}
