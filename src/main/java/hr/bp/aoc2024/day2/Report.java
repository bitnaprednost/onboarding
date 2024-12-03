package hr.bp.aoc2024.day2;

import java.util.List;

public class Report {
    boolean isSafe;
    private List<Integer> levels;

    public Report(List<Integer> levels) {
        this(levels, false);
    }

    public Report(List<Integer> levels, boolean testDampener) {
        this.levels = levels;
        isSafe = checkIfSafe(testDampener);
    }

    private boolean checkIfSafe(boolean testDampener) {
        boolean withoutDampener = isConsistent(levels) && areLevelsSafe(levels);

        if (!withoutDampener && testDampener) {
            return isSafeDampener();
        } else
            return withoutDampener;

    }

    private boolean isSafeDampener() {
        for (int indexToRemove = 0; indexToRemove < levels.size(); indexToRemove++) {
            List<Integer> levelsAfterRemoval = new java.util.ArrayList<>(List.copyOf(levels));
            levelsAfterRemoval.remove(indexToRemove);

            if (isConsistent(levelsAfterRemoval) && areLevelsSafe(levelsAfterRemoval)) {
                return true;
            }
        }
        return false;
    }

    private boolean isConsistent(List<Integer> levels) {
        return isIncreasing(levels) || isDecreasing(levels);
    }

    private boolean isIncreasing(List<Integer> levels) {
        boolean isIncreasing = true;

        for (int i = 0; i < levels.size() - 1; i++) {
            if (levels.get(i) >= levels.get(i + 1))
                isIncreasing = false;
        }
        return isIncreasing;
    }

    private boolean isDecreasing(List<Integer> levels) {
        boolean isDecreasing = true;

        for (int i = 0; i < levels.size() - 1; i++) {
            if (levels.get(i) <= levels.get(i + 1))
                isDecreasing = false;
        }
        return isDecreasing;
    }

    private boolean areLevelsSafe(List<Integer> levels) {
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