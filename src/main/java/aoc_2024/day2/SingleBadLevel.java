package aoc_2024.day2;

import java.util.ArrayList;

public class SingleBadLevel extends SafeReports{
    public int calculateSafeReports (String reports) {
        int reports_num = 0;

        // Split the file content into lines
        String[] lines = reports.split(System.lineSeparator());

        for (String line : lines)
        {
            String[] parts = line.split("\\s+");

            // Convert parts to a list of integers for dynamic modification
            ArrayList<Integer> levels = new ArrayList<>();
            for (String part : parts)
            {
                levels.add(Integer.parseInt(part));
            }

            if (isSafeSequenceWithBadLevel(levels))
            {
                reports_num++;
            }
        }
        return reports_num;
    }

    private boolean isSafeSequenceWithBadLevel(ArrayList<Integer> levels) {
        // Try removing the "bad" level
        for (int j = 0; j < levels.size(); j++)
        {
            ArrayList<Integer> modifiedLevels = new ArrayList<>(levels);
            modifiedLevels.remove(j);

            // Recursively check the new sequence
            if (isSafeSequence(modifiedLevels, modifiedLevels.get(0) > modifiedLevels.get(1)))
            {
                return true;
            }
        }
        // If no path leads to a safe sequence, return false
        return false;
    }
}