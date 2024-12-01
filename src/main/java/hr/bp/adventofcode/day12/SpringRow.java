package hr.bp.adventofcode.day12;

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

    public SpringRow(String springs, List<Integer> contiguousGroups) {
        this.springs = springs;
        this.contiguousGroups = contiguousGroups;
        this.differentArrangements = countWays(springs, contiguousGroups);
    }

    public static long countWays(String input, List<Integer> groups) {
        Map<String, Long> cache = new HashMap<>();
        return countWaysHelper(input, 0, groups, 0, cache);
    }

    private static long countWaysHelper(String input, int pos, List<Integer> groups, int groupIndex, Map<String, Long> cache) {
        String key = pos + "," + groupIndex;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        if (groupIndex == groups.size()) {
            for (int i = pos; i < input.length(); i++) {
                if (input.charAt(i) == '#') {
                    return 0;
                }
            }
            return 1;
        }

        if (pos >= input.length()) {
            return 0;
        }

        long result = 0;
        int currentGroup = groups.get(groupIndex);

        if (canPlaceGroup(input, pos, currentGroup)) {
            if (pos + currentGroup == input.length() ||
                    input.charAt(pos + currentGroup) != '#') {
                result += countWaysHelper(input, pos + currentGroup + 1, groups, groupIndex + 1, cache);
            }
        }

        if (input.charAt(pos) != '#') {
            result += countWaysHelper(input, pos + 1, groups, groupIndex, cache);
        }

        cache.put(key, result);
        return result;
    }

    private static boolean canPlaceGroup(String input, int pos, int groupSize) {
        if (pos + groupSize > input.length()) {
            return false;
        }

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
