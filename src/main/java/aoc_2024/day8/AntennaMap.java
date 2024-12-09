package aoc_2024.day8;

import java.util.*;

public class AntennaMap {

    protected int rows;
    protected int cols;

    public int calculateUniqueLocations(String AntennaMap){
        // Split the file content into lines
        String[] lines = AntennaMap.split(System.lineSeparator());

        rows = lines.length;
        cols = lines[0].length();

        Map<Character, List<int[]>> antenna = getAntennaMap(lines);

        return processAntenna(antenna).size();
    }

    private Map<Character, List<int[]>> getAntennaMap(String[] lines){
        Map<Character, List<int[]>> antenna = new HashMap<>();

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                addAntenna(antenna, lines, i ,j);
            }
        }
        return antenna;
    }

    private void addAntenna(Map<Character, List<int[]>> antenna, String[] lines, int i, int j){
        if (Character.isDigit(lines[i].charAt(j)) || Character.isAlphabetic(lines[i].charAt(j)) )
        {
            if (!antenna.containsKey(lines[i].charAt(j)))
            {
                antenna.put(lines[i].charAt(j), new ArrayList<>());
            }
            antenna.get(lines[i].charAt(j)).add(new int[]{i,j});
        }
    }

    private Set<String> processAntenna(Map<Character, List<int[]>> antenna){
        Set<String> uniqueAntinodes = new HashSet<>();

        for (char a : antenna.keySet()) {
            List<int[]> locations = antenna.get(a);
            findAntinode(locations, uniqueAntinodes);
        }
        return uniqueAntinodes;
    }

    protected void findAntinode(List<int[]> locations, Set<String> uniqueAntinodes){

        for (int i = 0; i < locations.size(); i++) {
            for (int j = i + 1; j < locations.size(); j++) {

                int[] loc1 = locations.get(i);
                int[] loc2 = locations.get(j);

                int dx = loc2[0] - loc1[0];
                int dy = loc2[1] - loc1[1];

                // Antinode on one side
                int antinode1X = loc1[0] - dx;
                int antinode1Y = loc1[1] - dy;

                // Antinode on the other side
                int antinode2X = loc2[0] + dx;
                int antinode2Y = loc2[1] + dy;

                // Add valid antinodes to the set
                addAntinodeIfInBounds(uniqueAntinodes, antinode1X, antinode1Y);
                addAntinodeIfInBounds(uniqueAntinodes, antinode2X, antinode2Y);
            }
        }
    }

    protected void addAntinodeIfInBounds(Set<String> uniqueAntinodes, int x, int y) {
        if (x >= 0 && x < rows && y >= 0 && y < cols) {
            uniqueAntinodes.add(x + "," + y);
        }
    }
}