package com.bp.aoc.day3;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Ivona Pavela
 */
public class Reorganization {

    private static final int OFFSET_UPPERCASE = 38;
    private static final int OFFSET_LOWERCASE = 96;

    public static int sumPrioritiesOfCommonItems(String... lines) {
        validateInput(lines);

        Set<Character> common = toCharSet(lines[0]);

        for (int i = 1; i < lines.length && !common.isEmpty(); i++) {
            common.retainAll(toCharSet(lines[i]));
        }

        int total = 0;
        for (char c : common) {
            total += priorityOf(c);
        }

        return total;
    }

    private static int priorityOf(char c) {
        if (c >= 'a' && c <= 'z') return c - OFFSET_LOWERCASE;
        if (c >= 'A' && c <= 'Z') return c - OFFSET_UPPERCASE;
        throw new IllegalArgumentException("Unsupported character for priority: '" + c + "'");
    }

    private static void validateInput(String... lines) {
        if (lines == null || lines.length == 0) {
            throw new IllegalArgumentException("At least one line is required");
        }

        for (int i = 0; i < lines.length; i++) {
            Objects.requireNonNull(lines[i], "Line at index " + i + " is null");
        }
    }

    private static Set<Character> toCharSet(String s) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }

        return set;
    }
}
