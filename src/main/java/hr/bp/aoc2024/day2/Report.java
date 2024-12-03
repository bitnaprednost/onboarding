package hr.bp.aoc2024.day2;

import java.util.List;

public class Report {
    private List<Integer> levels;
    boolean isSafe;

    public Report(List<Integer> levels) {
        this.levels = levels;
        isSafe = checkIfSafe();
    }

    private boolean checkIfSafe() {
        return isConsistent() && areLevelsSafe();
    }

    private boolean isConsistent() {
        return isIncreasing() || isDecreasing();
    }

    private boolean isIncreasing() {
        boolean isIncreasing = true;

        for (int i = 0; i < levels.size() - 1; i++) {
            if (levels.get(i) >= levels.get(i + 1))
                isIncreasing = false;
        }
        return isIncreasing;
    }

    private boolean isDecreasing() {
        boolean isDecreasing = true;

        for (int i = 0; i < levels.size() - 1; i++) {
            if (levels.get(i) <= levels.get(i + 1))
                isDecreasing = false;
        }
        return isDecreasing;
    }

    private boolean areLevelsSafe() {
        boolean levelsSafe = true;

        for (int i = 0; i < levels.size() - 1; i++) {
            int difference = Math.abs(levels.get(i) - levels.get(i + 1));
            if (difference < 1 || difference > 3) {
                levelsSafe = false;
                break;
            }
        }

        return levelsSafe;
    }
}