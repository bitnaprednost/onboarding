package hr.bp.aoc.day7;

import hr.bp.aoc.day1.Utils;

import java.util.List;

public class TaskOne {
    public static void main(String[] args) {
        List<String> document = Utils.readFromFile("inputDay7.txt");
        GameParser gameParser = new GameParser(document);
        Game game = gameParser.parseGameString();

        System.out.println(game.getTotalWinnings());

    }
}
