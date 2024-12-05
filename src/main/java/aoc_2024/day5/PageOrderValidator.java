package aoc_2024.day5;

import java.util.*;

public class PageOrderValidator {
    protected HashMap<Integer, List<Integer>> rules;
    protected List<List<Integer>> printPages;

    public PageOrderValidator(HashMap<Integer, List<Integer>> rules, List<List<Integer>> printPages) {
        this.rules = rules;
        this.printPages = printPages;
    }

    protected int getValidUpdatesMiddleSum() {
        int sum = 0;

        for (List<Integer> update : printPages)
        {
            if (isUpdateValid(update))
            {
                int middleIndex = update.size() / 2;
                sum += update.get(middleIndex);
            }
        }
        return sum;
    }

    protected boolean isUpdateValid(List<Integer> update) {
        Map<Integer, Integer> pagePositions = new HashMap<>();
        for (int i = 0; i < update.size(); i++)
        {
            pagePositions.put(update.get(i), i);
        }

        for (Map.Entry<Integer, List<Integer>> rule : rules.entrySet())
        {
            int x = rule.getKey();
            for (int y : rule.getValue())
            {
                if (pagePositions.containsKey(x) && pagePositions.containsKey(y))
                {
                    // Check if the index of x is less than the index of y
                    if (pagePositions.get(x) >= pagePositions.get(y))
                    {
                        return false; // Rule violated
                    }
                }
            }
        }

        return true;
    }

}
