package aoc_2024.day1;

import java.util.*;

public class TotalDistance {

    public ArrayList<Integer> left = new ArrayList<>();
    public ArrayList<Integer> right = new ArrayList<>();

    public int calculateTotalDistance (String locationIDs){
        int totalSum = 0;

        setLists(locationIDs);

        Collections.sort(left);
        Collections.sort(right);

        for (int i = 0; i < left.size(); ++i)
        {
            totalSum += Math.abs((left.get(i) - right.get(i)));
        }

        return totalSum;
    }

    public void setLists (String locationIDs)
    {
        // Split the file content into lines
        String[] lines = locationIDs.split(System.lineSeparator());

        for (String line : lines)
        {
            String[] parts = line.split("\\s+");

            this.left.add(Integer.parseInt(parts[0].trim()));
            this.right.add(Integer.parseInt(parts[1].trim()));
        }
    }
}
