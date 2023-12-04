package hr.bp.aoc.rockPaperScissors;

import hr.bp.aoc.rockPaperScissors.strategy.Strategy;
import hr.bp.aoc.rockPaperScissors.strategy.StrategyImpl1;
import hr.bp.aoc.rockPaperScissors.strategy.StrategyImpl2;
import hr.bp.aoc.rockPaperScissors.player.Player;
import hr.bp.aoc.rockPaperScissors.player.PlayerMe;
import hr.bp.aoc.rockPaperScissors.player.PlayerOpponent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GameManagerTest {
    private GameManager gameManager;
    private GameManager gameManager2;
    String inputPath;

    @BeforeEach
    void init(){
        PlayerMe me = new PlayerMe();
        Player opponent = new PlayerOpponent();
        Strategy strategy = new StrategyImpl1(opponent, me);
        gameManager = new GameManager(strategy);
        Strategy strategy2 = new StrategyImpl2(opponent, me);
        gameManager2 = new GameManager(strategy2);

        inputPath = "Resources/testDataDay2.txt";
    }
    @Test
    public void canEvaluateStrategy1() throws IOException {
        gameManager.runGames(inputPath);
        int score = gameManager.getScore();

        assertEquals(score, 15);
    }

    @Test
    public void canEvaluateStrategy2() throws IOException {
        gameManager2.runGames(inputPath);
        int score = gameManager2.getScore();

        assertEquals(score, 12);
    }

    @Test
    public void canSimulateConsecutively() throws IOException {
        gameManager.runGames(inputPath);
        gameManager.runGames(inputPath);
        int score = gameManager.getScore();

        assertEquals(score, 15);
    }

}