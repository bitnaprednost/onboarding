package com.bp.aoc.day5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RearrangementProcedureTest {

    private Map<Integer, Deque<Character>> stacksOfCrates;
    private List<String> procedure;

    @BeforeEach
    void setUp() {
        procedure = List.of(
                "move 1 from 2 to 1",
                "move 3 from 1 to 3",
                "move 2 from 2 to 1",
                "move 1 from 1 to 2"
        );

        List<String> stackLines = Arrays.asList(
                "    [D]    ",
                "[N] [C]    ",
                "[Z] [M] [P]",
                " 1   2   3 "
        );

        CratesInStacks.storingCratesInStacks(stackLines);
        stacksOfCrates = CratesInStacks.getStacksOfCrates();
    }

    @Test
    void testRearrangementProcedureOneByOne() {
        RearrangementProcedure.rearrangeCratesOneByOne(procedure,stacksOfCrates);

        assertEquals('C', stacksOfCrates.get(1).peek());
        assertEquals('M', stacksOfCrates.get(2).peek());
        assertEquals('Z', stacksOfCrates.get(3).peek());
    }

    @Test
    void testRearrangementProcedureInOrder() {
        RearrangementProcedure.rearrangeCratesInOrder(procedure,stacksOfCrates);

        assertEquals('M', stacksOfCrates.get(1).peek());
        assertEquals('C', stacksOfCrates.get(2).peek());
        assertEquals('D', stacksOfCrates.get(3).peek());
    }

    @Test
    void testRearrangementProcedureWithInvalidStackNumber() {
        List<String> invalidProcedure = List.of("move 1 from 5 to 1");

        assertThrows(NullPointerException.class, () ->
                RearrangementProcedure.rearrangeCratesInOrder(invalidProcedure,stacksOfCrates));
    }

    @Test
    void testRearrangementProcedureWithMoreCratesThanPossible() {
        List<String> invalidProcedure = List.of("move 5 from 1 to 2");

        assertThrows(java.util.NoSuchElementException.class, () ->
                RearrangementProcedure.rearrangeCratesInOrder(invalidProcedure,stacksOfCrates));
    }

    @Test
    void testRearrangementProcedureWithInvalidProcedure() {
        List<String> invalidProcedure = List.of("move");

        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                RearrangementProcedure.rearrangeCratesOneByOne(invalidProcedure, stacksOfCrates));
    }

}