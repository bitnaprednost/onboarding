package com.bp.aoc.day2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MoveTest {

    static Stream<Arguments> moveFromLetter() {
        return Stream.of(
                Arguments.of("A", Move.ROCK),
                Arguments.of("B", Move.PAPER),
                Arguments.of("C", Move.SCISSORS),
                Arguments.of("X", Move.ROCK),
                Arguments.of("Y", Move.PAPER),
                Arguments.of("Z", Move.SCISSORS)
        );
    }

    @ParameterizedTest
    @MethodSource("moveFromLetter")
    void testGetMoveFromLetter(String letter, Move expected) {
        assertEquals(expected, Move.getMoveFromLetter(letter));
    }

    @Test
    void testGetMoveFromInvalidLetter() {
        assertThrows(IllegalArgumentException.class,
                () -> Move.getMoveFromLetter("G")
        );
    }

}