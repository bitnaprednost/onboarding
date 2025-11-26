package com.bp.aoc.day4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CheckAssignmentsTest {

    @Test
    void testCheckAssignmentsWithBasicInput() {
        List<String> lines = Arrays.asList(
                "2-4,6-8",
                "2-3,4-5",
                "5-7,7-9",
                "2-8,3-7",
                "6-6,4-6",
                "2-6,4-8");

        assertEquals(2, CheckAssignments.checkAssignments(lines,true));
        assertEquals(4, CheckAssignments.checkAssignments(lines, false));
    }

    @Test
    void testCheckAssignmentsWithNonOverlappingInput() {
        List<String> lines = Arrays.asList(
                "1-3,4-5",
                "6-7,8-9");

        assertEquals(0,CheckAssignments.checkAssignments(lines, true));
        assertEquals(0,CheckAssignments.checkAssignments(lines, false));
    }

    @Test
    void testCheckAssignmentsWithFullyContainedLines() {
        List<String> lines = Arrays.asList(
                "1-3,1-3",
                "5-6,5-6");

        assertEquals(2,CheckAssignments.checkAssignments(lines, true));
        assertEquals(2, CheckAssignments.checkAssignments(lines, false));
    }

    @Test
    void testCheckAssignmentsWithEmptyLines() {
        List<String> lines = Collections.emptyList();

        assertEquals(0, CheckAssignments.checkAssignments(lines, true));
        assertEquals(0, CheckAssignments.checkAssignments(lines, false));
    }

    @Test
    void testCheckAssignmentsWithSingleNumbers() {
        List<String> lines = Arrays.asList(
                "5-5,5-5",
                "3-3,2-4"
        );

        assertEquals(2, CheckAssignments.checkAssignments(lines, true));
        assertEquals(2, CheckAssignments.checkAssignments(lines, false));
    }

    @Test
    void testCheckAssignmentsWhenMissingComa() {
        List<String> lines = List.of("1-5 2-4");

        assertThrows(StringIndexOutOfBoundsException.class,
                () -> CheckAssignments.checkAssignments(lines, true));
    }

    @Test
    void testCheckAssignmentsWhenIncompleteRange() {
        List<String> lines = List.of("1-2,2-");

        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> CheckAssignments.checkAssignments(lines, true));
    }

    @Test
    void testCheckAssignmentsWhenNotInteger() {
        List<String> lines = List.of("1-2,2-a");

        assertThrows(NumberFormatException.class,
                () -> CheckAssignments.checkAssignments(lines, true));
    }
}