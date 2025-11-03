package com.bp.aoc.day2;

/**
 * @author Ivona Pavela
 */
public class NumberFromMove {

    public static int getNumberFromMove(String character) {
        return switch (character) {
            case "A", "X" -> 1;
            case "B", "Y" -> 2;
            case "C", "Z" -> 3;
            default -> 0;
        };
    }
}
