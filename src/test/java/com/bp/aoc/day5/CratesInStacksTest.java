package com.bp.aoc.day5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CratesInStacksTest {

    private List<String> stackLines;

    @BeforeEach
    void setUp() {
        stackLines = Arrays.asList(
                "    [D]    ",
                "[N] [C]    ",
                "[Z] [M] [P]",
                " 1   2   3 "
        );
    }

    @Test
    void testSizesOfStacks() {
        CratesInStacks.storingCratesInStacks(stackLines);
        Map<Integer, Deque<Character>> stacksOfCrates = CratesInStacks.getStacksOfCrates();

        assertEquals(3, stacksOfCrates.size());

        assertEquals(2, stacksOfCrates.get(1).size());
        assertEquals(3, stacksOfCrates.get(2).size());
        assertEquals(1, stacksOfCrates.get(3).size());
    }

    @Test
    void testCratesInOrder() {
        CratesInStacks.storingCratesInStacks(stackLines);
        Map<Integer, Deque<Character>> stacksOfCrates = CratesInStacks.getStacksOfCrates();

        assertIterableEquals(List.of('N', 'Z'), stacksOfCrates.get(1));
        assertIterableEquals(List.of('D', 'C', 'M'), stacksOfCrates.get(2));
        assertIterableEquals(List.of('P'), stacksOfCrates.get(3));
    }

    @Test
    void testCratesInStacksWithEmptyLines() {
        List<String> emptyLines = Arrays.asList(" 1 2 3 ");
        CratesInStacks.storingCratesInStacks(emptyLines);
        Map<Integer, Deque<Character>> stacksOfCrates = CratesInStacks.getStacksOfCrates();

        assertEquals(3, stacksOfCrates.size());
        assertTrue(stacksOfCrates.get(1).isEmpty());
        assertTrue(stacksOfCrates.get(2).isEmpty());
        assertTrue(stacksOfCrates.get(3).isEmpty());
    }

}