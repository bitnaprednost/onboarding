package hr.bp.adventofcode_2024.day02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class Report {

    private List<Integer> levels = new ArrayList<>();

    private Boolean isSafe;

    public Report(List<Integer> levels) {
        this.levels = levels;
    }

    public boolean isSafe() {
        if (isSafe == null) {
            setIsSafe();
        }
        return isSafe;
    }

    private void setIsSafe() {
        boolean isAscending = levels.get(0) < levels.get(1);

        for (int i = 0; i < levels.size() - 1; i++) {
            if (orderIsWrongOrDifferenceTooLarge(levels.get(i), levels.get(i+1), isAscending)) {
                isSafe = false;
                return;
            }
        }
        isSafe = true;
    }

    private boolean orderIsWrongOrDifferenceTooLarge(Integer levelOne, Integer levelTwo, boolean isAscending) {
        if (Math.abs(levelOne - levelTwo) > 3) {
            return true;
        }

        if (isAscending) return levelOne >= levelTwo;
        else return levelOne <= levelTwo;
    }

    @Override
    public String toString() {
        return "Report{" +
                "levels=" + levels +
                ", isSafe=" + isSafe +
                '}';
    }
}
