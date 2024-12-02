package aoc_2024.day1;

import java.util.ArrayList;
import java.util.Collections;

public class SimilarityScore {
    public int calculateSimilarityScore (String locationIDs){
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


        for (int i = 0; i < left.size(); ++i)
        {
            int num = left.get(i);
            int count = Collections.frequency(right, num);

            totalSum += num*count;
        }

        return totalSum;
    }
}
