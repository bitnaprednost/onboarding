package hr.bp.aoc.day8;

/**
 * @author Monika Domiter
 */
public class ScoreUtil {

    public static int highestScenicScore(int[][] treeArray) {
        int numRows = treeArray.length;
        int numCol = treeArray[0].length;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < numRows - 1; i++) {
            for (int j = 1; j < numCol - 1; j++) {
                if (max < score(i, j, treeArray, numRows, numCol)) {
                    max = score(i, j, treeArray, numRows, numCol);
                }
            }
        }
        return max;
    }

    private static int score(int idx1, int idx2, int[][] map, int numRows, int numCol) {
        int scenicScore = 1;
        int count = 0;

        for (int j = idx2 + 1; j < numCol; j++) {
            if (map[idx1][j] >= map[idx1][idx2]) {
                count++;
                break;
            }
            count++;
        }
        if (count > 0) {
            scenicScore *= count;
        }

        count = 0;

        for (int j = idx2 - 1; j >= 0; j--) {
            if (map[idx1][j] >= map[idx1][idx2]) {
                count++;
                break;
            }
            count++;
        }
        if (count > 0) {
            scenicScore *= count;
        }

        count = 0;


        for (int i = idx1 - 1; i >= 0; i--) {
            if (map[i][idx2] >= map[idx1][idx2]) {
                count++;
                break;
            }
            count++;
        }
        if (count > 0) {
            scenicScore *= count;
        }
        count = 0;


        for (int i = idx1 + 1; i < numRows; i++) {
            if (map[i][idx2] >= map[idx1][idx2]) {
                count++;
                break;
            }
            count++;
        }
        if (count > 0) {
            scenicScore *= count;
        }

        return scenicScore;
    }

}
