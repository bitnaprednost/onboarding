package hr.bp.aoc.day2;

import hr.bp.aoc.Utils;

import java.util.List;

public class TaskOne {
    public static void main(String[] args) {
        List<String> gamesPlayed = Utils.readFromFile("inputDay2.txt");

        CubeGameParser parser = new CubeGameParser();
        Bag bag = new Bag(14, 12, 13);

        Player player = new Player(bag, parser, gamesPlayed);

        System.out.println(player.allPossibleGamesSum());
    }
}
