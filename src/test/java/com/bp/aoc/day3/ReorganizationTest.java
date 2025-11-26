package com.bp.aoc.day3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ReorganizationTest {

    static Stream<Arguments> reorganizationLinesProvider() {
        return Stream.of(
                Arguments.of(new String[]{"a", " "}, 0),
                Arguments.of(new String[]{"a", " ", " "}, 0),
                Arguments.of(new String[]{"vJrwpWtwJgWr", "hcsFMMfFFhFp"}, 16),
                Arguments.of(new String[]{"vJrwpWtwJgWrhcsFMMfFFhFp", "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL", "PmmdzqPrVvPwwTWBwg"}, 18),
                Arguments.of(new String[]{"a", "A"}, 0),
                Arguments.of(new String[]{"a", "A", "a"}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("reorganizationLinesProvider")
    void testSumPrioritiesOfCommonItems(String[] lines, int expectedSum) {
        assertEquals(expectedSum, Reorganization.sumPrioritiesOfCommonItems(lines));
    }

    @Test
    void testSumPrioritiesOfCommonItemsWhenAllLinesAreNull() {
        assertThrows(IllegalArgumentException.class,
                () -> Reorganization.sumPrioritiesOfCommonItems((String[]) null));
    }

    @Test
    void testSumPrioritiesOfCommonItemsWhenAnyLineIsNull() {
        assertThrows(NullPointerException.class,
                () -> Reorganization.sumPrioritiesOfCommonItems("abc", null));
    }

    @Test
    void testSumPrioritiesOfCommonItemsWhenLinesAreEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> Reorganization.sumPrioritiesOfCommonItems());
    }

    @Test
    void testSumPrioritiesOfCommonItemsWhenInvalidLines() {
        assertThrows(IllegalArgumentException.class,
                () -> Reorganization.sumPrioritiesOfCommonItems("a$", "$a"));
    }


}