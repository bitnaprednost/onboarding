package aoc_2024.day2;

import java.util.ArrayList;

public class SafeReports {

    public int calculateSafeReports (String reports) {
        int reports_num = 0;

        // Split the file content into lines
        String[] lines = reports.split(System.lineSeparator());

        for (String line : lines)
        {
            String[] parts = line.split("\\s+");

            boolean isDescending = isDescendingOrder(parts);
            boolean isAscending = isAscendingOrder(parts);

            if (isDescending || isAscending)
            {
                // Convert parts to a list of integers for dynamic modification
                ArrayList<Integer> levels = new ArrayList<>();
                for (String part : parts) {
                    levels.add(Integer.parseInt(part));
                }

                if (isSafeSequence(levels, isDescending))
                {
                    reports_num++;
                }
            }
        }

        return reports_num;
    }

    private boolean isDescendingOrder(String[] parts) {
        return Integer.parseInt(parts[0]) > Integer.parseInt(parts[1]);
    }

    private boolean isAscendingOrder(String[] parts) {
        return Integer.parseInt(parts[0]) < Integer.parseInt(parts[1]);
    }

    protected boolean isSafeSequence(ArrayList<Integer> levels, boolean isDescending) {
        for (int i = 1; i < levels.size(); i++)
        {
            int prev = levels.get(i - 1);
            int curr = levels.get(i);

            int difference = isDescending ? prev - curr : curr - prev;

            // Check the safety condition
            if (difference < 1 || difference > 3)
            {
                return false;
            }
        }
        return true;
    }
}

