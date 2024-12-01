package hr.bp.adventofcode.day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class SpringRow {

    private Long differentArrangements;

    private final String springs;

    private final List<Integer> contiguousGroups;

    private List<Integer> differentArrangementsCalculated;

    public SpringRow(String springs, List<Integer> contiguousGroups) {
        this.springs = springs;
        this.contiguousGroups = contiguousGroups;
        this.differentArrangements = countWays(springs, contiguousGroups);
    }

    public static long countWays(String input, List<Integer> groups) {
        int n = input.length();
        int m = groups.size();
        long[][] dp = new long[n + 1][m + 1];
        for (long[] row : dp) Arrays.fill(row, -1); // Fill DP table with -1 to indicate uncomputed states

        return helper(input.toCharArray(), groups, 0, 0, dp);
    }

    private static long helper(char[] input, List<Integer> groups, int pos, int groupIndex, long[][] dp) {
        if (groupIndex == groups.size()) {
            // If all groups are placed, check if the remaining characters are valid
            for (int i = pos; i < input.length; i++) {
                if (input[i] == '#') return 0; // Invalid if any hash sign remains uncovered
            }
            return 1; // Valid placement
        }

        if (pos >= input.length) return 0; // Reached end of string without placing all groups

        if (dp[pos][groupIndex] != -1) return dp[pos][groupIndex]; // Return memoized result

        long ways = 0;
        int groupSize = groups.get(groupIndex);

        // Try placing the current group at all valid positions starting from `pos`
        for (int i = pos; i + groupSize - 1 < input.length; i++) {
            if (canPlaceGroup(input, i, groupSize)) {
                // Temporarily mark the group as placed
                markGroup(input, i, groupSize, true);
                ways += helper(input, groups, i + groupSize + 1, groupIndex + 1, dp);
                // Unmark the group
                markGroup(input, i, groupSize, false);
            }
        }

        dp[pos][groupIndex] = ways; // Memoize result
        return ways;
    }

    private static boolean canPlaceGroup(char[] input, int start, int size) {
        for (int i = start; i < start + size; i++) {
            if (input[i] == '.') return false; // Cannot place group over a dot
        }
        return true; // Valid placement
    }

    private static void markGroup(char[] input, int start, int size, boolean mark) {
        char replacement = mark ? '#' : '?';
        for (int i = start; i < start + size; i++) {
            if (input[i] == '?' || input[i] == '#') {
                input[i] = replacement;
            }
        }
    }

    public static void main(String[] args) {
        String input = "#???..?.?.?";
        List<Integer> groups = Arrays.asList(3, 1, 1);

        long result = countWays(input, groups);
        System.out.println("Number of ways to place groups: " + result);
    }

    public long getDifferentArrangements() {
        return differentArrangements;
    }
}
