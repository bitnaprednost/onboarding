package day2;

import day2.player.Player;
import day2.player.PlayerMe;
import day2.player.PlayerOpponent;
import util.Parser;

import java.io.IOException;

public class Main {

    public static void main(String args[]) throws IOException {
        PlayerMe me = new PlayerMe();
        Player opponent = new PlayerOpponent();
        Game game = new Game(opponent, me);
        Strategy strategy = new Strategy(game);

        String input = Parser.getTextFromFile("Resources/day2Data.txt");
        strategy.runGames(input);
        System.out.println(strategy.evaluateStrategy());
    }
}
