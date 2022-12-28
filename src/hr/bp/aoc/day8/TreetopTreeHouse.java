package hr.bp.aoc.day8;

import java.util.ArrayList;
import java.util.List;

public class TreetopTreeHouse {
    public static void main(String[] args) {
        String filePath = "src/hr/bp/aoc/day8/inputday8.txt";

        List<String> rows = new ArrayList<>();

        for (String line : InputUtil.readLines(filePath)) {
            rows.add(line);
        }

        int[][] treeArray = asArray(rows);
        //printMap(map,numRows,nulCol);

        //Part One
        int numberOfVisible = countVisible(treeArray);
        System.out.println(numberOfVisible);

        //Part Two
        int max = ScoreUtil.highestScenicScore(treeArray);
        System.out.println(max);
    }

    private static int[][] asArray(List<String> rows) {
        int numRows = rows.size();
        int numCol = rows.get(0).length();

        int[][] map = new int[numRows][numCol];

        for (int i = 0; i < numRows; i++) {
            String[] values = rows.get(i).split("");
            for (int j = 0; j < numCol; j++) {
                map[i][j] = Integer.parseInt(values[j]);
            }
        }
        return map;
    }

    private static void printMap(int[][] map, int numRows, int numCol) {
        for (int i = 1; i < numRows; i++) {
            for (int j = 1; j < numCol; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int countVisible(int[][] treeArray) {
        int numRows = treeArray.length;
        int numCol = treeArray[0].length;
        int numberOfVisible = numRows * 2 + (numCol - 2) * 2;
        for (int i = 1; i < numRows - 1; i++) {
            for (int j = 1; j < numCol - 1; j++) {
                if (isVisible(i, j, treeArray, numRows, numCol, "right")) {
                    numberOfVisible++;
                } else if (isVisible(i, j, treeArray, numRows, numCol, "left")) {
                    numberOfVisible++;
                } else if (isVisible(i, j, treeArray, numRows, numCol, "up")) {
                    numberOfVisible++;
                } else if (isVisible(i, j, treeArray, numRows, numCol, "down")) {
                    numberOfVisible++;
                }
            }
        }
        return numberOfVisible;
    }

    private static boolean isVisible(int idx1, int idx2, int[][] map, int numRows, int numCol, String direction) {
        if (direction.equals("right")) {
            for (int j = numCol - 1; j > idx2; j--) {
                if (map[idx1][j] >= map[idx1][idx2]) {
                    return false;
                }
            }
            return true;
        } else if (direction.equals("left")) {
            for (int j = 0; j < idx2; j++) {
                if (map[idx1][j] >= map[idx1][idx2]) {
                    return false;
                }
            }
            return true;
        } else if (direction.equals("up")) {
            for (int i = 0; i < idx1; i++) {
                if (map[i][idx2] >= map[idx1][idx2]) {
                    return false;
                }
            }
            return true;
        } else if (direction.equals("down")) {
            for (int i = numRows - 1; i > idx1; i--) {
                if (map[i][idx2] >= map[idx1][idx2]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }


}

