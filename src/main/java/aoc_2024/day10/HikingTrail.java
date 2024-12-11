package aoc_2024.day10;

import java.util.*;

public class HikingTrail {

    private int rows;
    private int cols;

    private ArrayList<int[]> heightMap = new ArrayList<>();

    public long findHikingTrailScore(String input) {

        long score = 0;

        // Split the file content into lines
        String[] lines = input.split(System.lineSeparator());

        rows = lines.length;
        cols = lines[0].length();

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (lines[i].charAt(j) == '0') {
                    findNineHeight(i, j, lines);
                }

                score += getUniqueScore();
                heightMap.clear();
            }
        }

        return score;
    }

    public long findHikingTrailRating(String input) {

        long rating = 0;

        // Split the file content into lines
        String[] lines = input.split(System.lineSeparator());

        rows = lines.length;
        cols = lines[0].length();

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (lines[i].charAt(j) == '0') {
                    findNineHeight(i, j, lines);
                }

                rating += getRating();
                heightMap.clear();
            }
        }

        return rating;
    }

    private void findNineHeight(int x, int y, String[] lines){

        char start = lines[x].charAt(y);

        if (start == '9'){
            heightMap.add(new int[] {x, y});
            return;
        }

        if (x + 1 < rows && lines[x + 1].charAt(y) == start + 1) {
            findNineHeight(x + 1, y, lines);
        }

        if (x - 1 >= 0 && lines[x - 1].charAt(y) == start + 1) {
            findNineHeight(x - 1, y, lines);
        }

        if (y + 1 < cols && lines[x].charAt(y + 1) == start + 1) {
            findNineHeight(x, y + 1, lines);
        }

        if (y - 1 >= 0 && lines[x].charAt(y - 1) == start + 1) {
            findNineHeight(x, y - 1, lines);
        }
    }

    private long getUniqueScore() {
        Set<String> uniquePoints = new HashSet<>();
        for (int[] point : heightMap)
        {
            uniquePoints.add(point[0] + "," + point[1]);
        }
        return uniquePoints.size();
    }

    private long getRating(){
        return heightMap.size();
    }
}
