package aoc_2024.day8;

import java.util.*;

public class ResonantHarmonics extends AntennaMap {

    @Override
    protected void findAntinode(List<int[]> locations, Set<String> uniqueAntinodes) {

        for (int i = 0; i < locations.size(); i++) {
            for (int j = i + 1; j < locations.size(); j++) {

                int[] loc1 = locations.get(i);
                int[] loc2 = locations.get(j);

                int dx = loc2[0] - loc1[0];
                int dy = loc2[1] - loc1[1];

                // Extend antinodes in both directions until bounds are reached
                extendAntinodes(loc1[0], loc1[1], -dx, -dy, uniqueAntinodes);
                extendAntinodes(loc2[0], loc2[1], dx, dy, uniqueAntinodes);
            }
        }
    }

    private void extendAntinodes(int startX, int startY, int dx, int dy, Set<String> uniqueAntinodes) {
        int x = startX;
        int y = startY;

        while (x >= 0 && x < rows && y >= 0 && y < cols) {
            uniqueAntinodes.add(x + "," + y);
            x += dx;
            y += dy;
        }
    }
}