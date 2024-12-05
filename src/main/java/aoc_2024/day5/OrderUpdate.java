package aoc_2024.day5;

import java.util.*;

public class OrderUpdate extends PageOrderValidator {

    public OrderUpdate(HashMap<Integer, List<Integer>> rules, List<List<Integer>> printPages) {
        super(rules, printPages);
    }

    @Override
    protected int getValidUpdatesMiddleSum() {
        int sum = 0;

        // Process and fix incorrect updates
        for (List<Integer> update : printPages)
        {
            if (!isUpdateValid(update))
            {
                List<Integer> reorderedUpdate = reorderUpdate(update);
                int middleIndex = reorderedUpdate.size() / 2;
                sum += reorderedUpdate.get(middleIndex);
            }
        }
        return sum;
    }

    private List<Integer> reorderUpdate(List<Integer> update) {
        Map<Integer, Integer> inDegree = new HashMap<>();
        for (int page : update)
        {
            inDegree.put(page, 0);
        }

        for (Map.Entry<Integer, List<Integer>> rule : rules.entrySet()) {
            int x = rule.getKey();
            for (int y : rule.getValue()) {
                if (update.contains(x) && update.contains(y))
                {
                    inDegree.put(y, inDegree.getOrDefault(y, 0) + 1);
                }
            }
        }

        // Perform topological sorting using a queue
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet())
        {
            if (entry.getValue() == 0)
            {
                queue.add(entry.getKey());
            }
        }

        List<Integer> orderedUpdate = new ArrayList<>();
        while (!queue.isEmpty())
        {
            int currentPage = queue.poll();
            orderedUpdate.add(currentPage);

            // Process the next pages dependent on the current page
            for (int nextPage : rules.getOrDefault(currentPage, new ArrayList<>()))
            {
                // Ensure nextPage is in inDegree before updating
                inDegree.put(nextPage, inDegree.getOrDefault(nextPage, 0) - 1);
                if (inDegree.get(nextPage) == 0)
                {
                    queue.add(nextPage);
                }
            }
        }
        return orderedUpdate;
    }
}
