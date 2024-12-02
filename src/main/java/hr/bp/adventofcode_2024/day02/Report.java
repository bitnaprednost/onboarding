package hr.bp.adventofcode_2024.day02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class Report {

    private final List<Integer> levels;

    public Report(List<Integer> levels) {
        this.levels = levels;
    }

    public boolean isSafe() {
        boolean isAscending = levels.get(0) < levels.get(1);

        for (int i = 0; i < levels.size() - 1; i++) {
            if (orderIsWrongOrDifferenceTooLarge(levels.get(i), levels.get(i+1), isAscending)) {
                return false;
            }
        }
        return true;
    }

    public boolean isSafeAfterDamping() {
        if (this.isSafe()) return true;

        for (int i = 0; i < levels.size(); i++) {
            List<Integer> newLevels = new ArrayList<>(levels);
            newLevels.remove(i);

            Report newReport = new Report(newLevels);

            if (newReport.isSafe()) return true;
        }
        return false;
    }

    private boolean orderIsWrongOrDifferenceTooLarge(Integer levelOne, Integer levelTwo, boolean isAscending) {
        if (Math.abs(levelOne - levelTwo) > 3) {
            return true;
        }

        if (isAscending) return levelOne >= levelTwo;
        else return levelOne <= levelTwo;
    }
}
