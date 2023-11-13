package day2;

import day2.player.Player;
import day2.player.PlayerMe;
import day2.player.PlayerOpponent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StrategyTest {
    private Strategy strategy;
    String input;

    @BeforeEach
    void init(){
        PlayerMe me = new PlayerMe();
        Player opponent = new PlayerOpponent();
        Game game = new Game(opponent, me);
        strategy = new Strategy(game);

        input = "A Y\n" +
                "B X\n" +
                "C Z";
    }

    @Test
    public void canParseString(){
        List<char[]> list = strategy.parseInputs(input);

        assertAll("All inputs correctly parsed",
                () -> assertEquals(list.size(),3),
                () -> assertEquals(list.get(0)[0],'A'),
                () -> assertEquals(list.get(0)[1],'Y'),
                () -> assertEquals(list.get(1)[0],'B'),
                () -> assertEquals(list.get(1)[1],'X'),
                () -> assertEquals(list.get(2)[0],'C'),
                () -> assertEquals(list.get(2)[1],'Z')
                );
    }

    @Test
    public void cantParseInvalidString(){
        input = "a 1\n" + "A Y\n" + "! M";
        List<char[]> list = strategy.parseInputs(input);

        assertAll("All inputs correctly parsed",
                () -> assertEquals(list.size(),1),
                () -> assertEquals(list.get(0)[0],'A'),
                () -> assertEquals(list.get(0)[1],'Y')
        );
    }

    @Test
    public void canEvaluateStrategy(){
        strategy.runGames(input);
        int score = strategy.evaluateStrategy();

        assertEquals(score, 12);
    }
}