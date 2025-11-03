package com.bp.aoc.day3;

import java.util.Arrays;

/**
 * @author Ivona Pavela
 */


public class Reorganization {

    public static final int differenceFromUppercase = 38;
    public static final int differenceFromLowercase = 96;

    public static int reorganization(String... lines) {
        int priority = 0;
        StringBuilder duplicates = new StringBuilder();

        for (char letter : lines[0].toCharArray()) {
            boolean inAll = Arrays.stream(lines, 1, lines.length)
                    .allMatch(line -> line.indexOf(letter) != -1);

            if (inAll && duplicates.toString().indexOf(letter) == -1) {
                duplicates.append(letter);
                priority += Character.isUpperCase(letter)
                        ? (letter - differenceFromUppercase)
                        : (letter - differenceFromLowercase);
            }
        }

        return priority;
    }
}
