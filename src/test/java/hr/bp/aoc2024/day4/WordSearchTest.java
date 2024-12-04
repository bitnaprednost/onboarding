package hr.bp.aoc2024.day4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static hr.bp.aoc2024.day4.TestUtil.*;

class WordSearchTest {

    @Test
    void testFindAllWords_testInput() {
        WordSearchParser parser = new WordSearchParser(getTestInput());
        WordSearch wordSearch = new WordSearch(parser.parseWordSearchInput());
        int expected = 18;

        Assertions.assertEquals(expected, wordSearch.findWordInSearchTable());
    }

    @Test
    void testFindAllWords_finalInput() {
        WordSearchParser parser = new WordSearchParser(getFinalInput());
        WordSearch wordSearch = new WordSearch(parser.parseWordSearchInput());
        int expected = 2483;

        Assertions.assertEquals(expected, wordSearch.findWordInSearchTable());
    }

    @Test
    void testFindAllWords_allDirections() {
        WordSearchParser parser = new WordSearchParser(getTestInput_allDirections());
        WordSearch wordSearch = new WordSearch(parser.parseWordSearchInput());
        int expected = 5;

        Assertions.assertEquals(expected, wordSearch.findWordInSearchTable());
    }

    @Test
    void testFind_x_mas_testInput() {
        WordSearchParser parser = new WordSearchParser(getTestInput());
        WordSearch wordSearch = new WordSearch(parser.parseWordSearchInput());
        int expected = 9;

        Assertions.assertEquals(expected, wordSearch.findXMas());
    }

    @Test
    void testFind_x_mas_finalInput() {
        WordSearchParser parser = new WordSearchParser(getFinalInput());
        WordSearch wordSearch = new WordSearch(parser.parseWordSearchInput());
        int expected = 1925;

        Assertions.assertEquals(expected, wordSearch.findXMas());
    }

}
