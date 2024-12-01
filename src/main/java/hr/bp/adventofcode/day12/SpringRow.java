package hr.bp.adventofcode.day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        // Create cache for dynamic programming
        Map<String, Long> cache = new HashMap<>();
        return countWaysHelper(input, 0, groups, 0, cache);
    }

    private static long countWaysHelper(String input, int pos, List<Integer> groups, int groupIndex, Map<String, Long> cache) {
        // Create cache key
        String key = pos + "," + groupIndex;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        // Base cases
        if (groupIndex == groups.size()) {
            // Check if there are any remaining hash signs
            for (int i = pos; i < input.length(); i++) {
                if (input.charAt(i) == '#') {
                    return 0; // Invalid case: uncovered hash sign
                }
            }
            return 1; // Valid solution found
        }

        if (pos >= input.length()) {
            return 0; // Reached end of string but groups remain
        }

        long result = 0;
        int currentGroup = groups.get(groupIndex);

        // Try placing the current group starting at pos
        if (canPlaceGroup(input, pos, currentGroup)) {
            // If we can place the group, we need to ensure there's a dot or question mark after it
            // (unless it's at the end of the string)
            if (pos + currentGroup == input.length() ||
                    input.charAt(pos + currentGroup) != '#') {
                result += countWaysHelper(input, pos + currentGroup + 1, groups, groupIndex + 1, cache);
            }
        }

        // If current position is not a hash sign, we can skip it
        if (input.charAt(pos) != '#') {
            result += countWaysHelper(input, pos + 1, groups, groupIndex, cache);
        }

        cache.put(key, result);
        return result;
    }

    private static boolean canPlaceGroup(String input, int pos, int groupSize) {
        // Check if there's enough space
        if (pos + groupSize > input.length()) {
            return false;
        }

        // Check if all positions can be part of the group
        for (int i = 0; i < groupSize; i++) {
            char c = input.charAt(pos + i);
            if (c == '.') {
                return false;
            }
        }

        return true;
    }

    public long getDifferentArrangements() {
        return differentArrangements;
    }

    public String getSprings() {
        return springs;
    }

    public List<Integer> getContiguousGroups() {
        return contiguousGroups;
    }
}
