package day2;

import day2.player.Player;
import day2.player.PlayerMe;
import day2.player.PlayerOpponent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static String getTextFromFile(String file) throws IOException {
        String everything = null;
        BufferedReader br = new BufferedReader(new FileReader(file));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
        } finally {
            br.close();
        }

        return everything;
    }
    public static void main(String args[]) throws IOException {
        PlayerMe me = new PlayerMe();
        Player opponent = new PlayerOpponent();
        Game game = new Game(opponent, me);
        Strategy strategy = new Strategy(game);

        String input = getTextFromFile("Resources/day2Data.txt");
        strategy.runGames(input);
        System.out.println(strategy.evaluateStrategy());
    }
}
