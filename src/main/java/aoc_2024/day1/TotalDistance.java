package aoc_2024.day1;

import java.util.*;

public class TotalDistance {
    public int calculateTotalDistance (String locationIDs){
        int totalSum = 0;

        // Split the file content into lines
        String[] lines = locationIDs.split(System.lineSeparator());

        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();

        for (String line : lines)
        {
            String[] parts = line.split("\\s+");

            left.add(Integer.parseInt(parts[0].trim()));
            right.add(Integer.parseInt(parts[1].trim()));
        }

        Collections.sort(left);
        Collections.sort(right);

        for (int i = 0; i < left.size(); ++i)
        {
            totalSum += Math.abs((left.get(i) - right.get(i)));
        }

        return totalSum;
    }
}
