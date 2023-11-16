package day2;

import day2.game.Game;
import day2.game.GameImpl1;
import day2.game.GameImpl2;
import day2.player.Player;
import day2.player.PlayerMe;
import day2.player.PlayerOpponent;
import util.Parser;

import java.io.IOException;

public class Main {

    public static void main(String args[]) throws IOException {
        String input = Parser.getTextFromFile("Resources/day2Data.txt");

        PlayerMe me = new PlayerMe();
        Player opponent = new PlayerOpponent();

        Game game = new GameImpl1(opponent, me);
        Strategy strategy = new Strategy(game);
        strategy.runGames(input);
        System.out.println(strategy.evaluateStrategy());

        game = new GameImpl2(opponent, me);
        strategy = new Strategy(game);
        strategy.runGames(input);
        System.out.println(strategy.evaluateStrategy());
    }
}
