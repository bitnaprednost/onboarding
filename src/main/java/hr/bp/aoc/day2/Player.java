package hr.bp.aoc.day2;

import java.util.List;

public class Player {
    private Bag bag;
    private CubeGameParser parsesr;
    private List<String> gamesPlayed;

    public Player(Bag bag, CubeGameParser parsesr, List<String> gamesPlayed) {
        this.bag = bag;
        this.parsesr = parsesr;
        this.gamesPlayed = gamesPlayed;
    }

    public int allPossibleGamesSum() {
        int sumOfPossibleGames = 0;

        for (String game : gamesPlayed) {
            ConfigurationOfCubes gameConfig = parsesr.parse(game);
            if (bag.isGamePossible(gameConfig)) {
                sumOfPossibleGames += gameConfig.getGameId();
            }
        }
        return sumOfPossibleGames;
    }

}
