package aoc_2024.day4;

public class WordSearch2 extends WordSearch {

    @Override
    protected int findX(String[] lines, int i, int j) {

        if (lines[i].charAt(j) != 'A')
        {
            return 0;
        }

        if (isXMAS(lines, i ,j))
        {
            return 1;
        }
        return 0;
    }

    private boolean isXMAS(String[] lines, int i, int j) {
        // Check diagonals for the X-MAS pattern
        return checkDiagonal(lines, i - 1, j - 1, i + 1, j + 1) &&
                checkDiagonal(lines, i - 1, j + 1, i + 1, j - 1);
    }

    private boolean checkDiagonal(String[] lines, int row1, int col1, int row2, int col2) {
        if (row1 < 0 || row2 >= rows || col1 < 0 || col2 >= cols)
        {
            return false;
        }

        // Check if one end is 'M' and the other is 'S'
        char char1 = lines[row1].charAt(col1);
        char char2 = lines[row2].charAt(col2);

        return (char1 == 'M' && char2 == 'S') || (char1 == 'S' && char2 == 'M');
    }
}
