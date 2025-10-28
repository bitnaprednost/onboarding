package com.bp.aoc.day3;

import java.util.Arrays;

/**
 * @author Ivona Pavela
 */


public class Reorganization {

    public static final int differenceFromUppercase = 38;
    public static final int differenceFromLowercase = 96;

    public static int reorganization(String... lines){
        int priority = 0;
        String duplicates = "";

        for(char letter: lines[0].toCharArray()) {
            boolean inAll = Arrays.stream(lines, 1, lines.length)
                    .allMatch(line -> line.indexOf(letter) != -1);

            if(inAll && duplicates.indexOf(letter) == -1) {
                duplicates += letter;
                priority += Character.isUpperCase(letter)
                        ? (letter - differenceFromUppercase)
                        : (letter - differenceFromLowercase);
            }
        }

        return priority;
    }
}
