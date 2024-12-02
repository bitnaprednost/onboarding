package aoc_2024.day1;

import java.util.Collections;

public class SimilarityScore extends TotalDistance {
    public int calculateSimilarityScore (String locationIDs){
        int totalSum = 0;

        setLists(locationIDs);

        for (int i = 0; i < left.size(); ++i)
        {
            int num = left.get(i);
            int count = Collections.frequency(right, num);

            totalSum += num*count;
        }

        return totalSum;
    }
}
