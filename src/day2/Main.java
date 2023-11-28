package day2;

import day2.strategy.Strategy;
import day2.strategy.StrategyImpl1;
import day2.strategy.StrategyImpl2;
import day2.player.Player;
import day2.player.PlayerMe;
import day2.player.PlayerOpponent;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        PlayerMe me = new PlayerMe();
        Player opponent = new PlayerOpponent();

        Strategy strategy = new StrategyImpl1(opponent, me);
        GameManager gameManager = new GameManager(strategy);
        gameManager.runGames("Resources/day2Data.txt");
        System.out.println(gameManager.getScore());

        strategy = new StrategyImpl2(opponent, me);
        gameManager = new GameManager(strategy);
        gameManager.runGames("Resources/day2Data.txt");
        System.out.println(gameManager.getScore());
    }
}
