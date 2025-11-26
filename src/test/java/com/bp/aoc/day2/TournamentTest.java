package com.bp.aoc.day2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TournamentTest {

    @Test
    void testPlay() {
        List<String> firstPlayerMoves = List.of("A", "B", "C");
        List<String> secondPlayerMoves = List.of("Y", "X", "Z");
        Tournament tournament = new Tournament(firstPlayerMoves, secondPlayerMoves);

        assertEquals(15, tournament.play(true));
        assertEquals(12, tournament.play(false));
    }

    @Test
    void testPlayWithEmptyMoves() {
        Tournament tournament = new Tournament(List.of(), List.of());

        assertEquals(0, tournament.play(true));
        assertEquals(0, tournament.play(false));
    }

}