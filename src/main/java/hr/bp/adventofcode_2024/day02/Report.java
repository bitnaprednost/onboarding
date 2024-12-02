package hr.bp.adventofcode_2024.day02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class Report {

    private List<Integer> levels = new ArrayList<>();

    private Boolean isSafe;

    private Boolean isSafeAfterDamping;

    public Report(List<Integer> levels) {
        this.levels = levels;
    }

    public boolean isSafe() {
        if (isSafe == null) {
            setIsSafe();
        }
        return isSafe;
    }

    public boolean isSafeAfterDamping() {
        if (isSafeAfterDamping == null) {
            setIsSafeAfterDamping();
        }
        return isSafeAfterDamping;
    }

    private void setIsSafeAfterDamping() {
        if (this.isSafe()) {
            this.isSafeAfterDamping = true;
            return;
        }

        for (int i = 0; i < levels.size(); i++) {
            List<Integer> newLevels = new ArrayList<>(levels);
            newLevels.remove(i);

            Report newReport = new Report(newLevels);

            if (newReport.isSafe()) {
                isSafeAfterDamping = true;
                return;
            }
        }
        isSafeAfterDamping = false;
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
