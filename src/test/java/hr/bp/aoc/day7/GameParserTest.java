package hr.bp.aoc.day7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static hr.bp.aoc.day7.TestUtils.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameParserTest {
    @Test
    void testInputParsing() {
        List<String> input = getTestInputCorrect();
        Game expectedGame = getTestHands();

        GameParser gameParser = new GameParser(input);
        Game actualGame = gameParser.parseGameString();

        Assertions.assertEquals(expectedGame, actualGame);
    }

    @Test
    public void SymbolNotOnCards_InvalidArgumentException() {
        List<String> input = invalidSymbolInput();
        GameParser gameParser = new GameParser(input);

        assertThrows(IllegalArgumentException.class, gameParser::parseGameString);
    }

    @Test
    public void tooMuchCards_InvalidArgumentException() {
        List<String> input = tooMuchCardsInput();
        GameParser gameParser = new GameParser(input);

        assertThrows(IllegalArgumentException.class, gameParser::parseGameString);
    }

    @Test
    public void tooLittleCards_InvalidArgumentException() {
        List<String> input = tooMuchCardsInput();
        GameParser gameParser = new GameParser(input);

        assertThrows(IllegalArgumentException.class, gameParser::parseGameString);
    }

}