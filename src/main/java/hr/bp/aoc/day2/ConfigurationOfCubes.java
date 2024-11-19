package hr.bp.aoc.day2;

public class ConfigurationOfCubes {
    private int blueCubes;
    private int redCubes;
    private int greenCubes;
    private int gameId;

    public ConfigurationOfCubes(int blueCubes, int redCubes, int greenCubes, int gameId) {
        this.blueCubes = blueCubes;
        this.redCubes = redCubes;
        this.greenCubes = greenCubes;
        this.gameId = gameId;
    }

    public int getGameId() {
        return gameId;
    }

    public int getBlueCubes() {
        return blueCubes;
    }

    public int getRedCubes() {
        return redCubes;
    }

    public int getGreenCubes() {
        return greenCubes;
    }
}
