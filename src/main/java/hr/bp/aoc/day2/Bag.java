package hr.bp.aoc.day2;

public class Bag {
    private int blueCubes;
    private int redCubes;
    private int greenCubes;

    public Bag(int blueCubes, int redCubes, int greenCubes) {
        this.blueCubes = blueCubes;
        this.redCubes = redCubes;
        this.greenCubes = greenCubes;
    }

    public boolean isGamePossible(ConfigurationOfCubes gameConfig) {
        return gameConfig.getBlueCubes() <= this.blueCubes &&
                gameConfig.getRedCubes() <= this.redCubes &&
                gameConfig.getGreenCubes() <= this.greenCubes;
    }
}
