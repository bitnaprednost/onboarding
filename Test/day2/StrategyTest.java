package day2;

import day2.game.Game;
import day2.game.GameImpl1;
import day2.game.GameImpl2;
import day2.player.Player;
import day2.player.PlayerMe;
import day2.player.PlayerOpponent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class StrategyTest {
    private Strategy strategy;
    private Strategy strategy2;
    String input;

    @BeforeEach
    void init(){
        PlayerMe me = new PlayerMe();
        Player opponent = new PlayerOpponent();
        Game game = new GameImpl1(opponent, me);
        strategy = new Strategy(game);
        Game game2 = new GameImpl2(opponent, me);
        strategy2 = new Strategy(game2);

        input = "A Y\n" +
                "B X\n" +
                "C Z";
    }
    @Test
    public void canEvaluateStrategy1(){
        strategy.runGames(input);
        int score = strategy.evaluateStrategy();

        assertEquals(score, 15);
    }

    @Test
    public void canEvaluateStrategy2(){
        strategy2.runGames(input);
        int score = strategy2.evaluateStrategy();

        assertEquals(score, 12);
    }

    @Test
    public void canSimulateConsecutively(){
        strategy.runGames(input);
        strategy.runGames(input);
        int score = strategy.evaluateStrategy();

        assertEquals(score, 15);
    }

}