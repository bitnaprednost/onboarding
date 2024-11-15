package adventofcode.day02;

import java.util.List;
import java.util.Map;

public class GameRunner {

    private final Map<Integer, List<Map<ColorEnum, Integer>>> gameInformation;

    public GameRunner(Map<Integer, List<Map<ColorEnum, Integer>>> gameInformation) {
        this.gameInformation = gameInformation;
    }

    public Integer runGame() {
        return this.gameInformation.size();
    }



}
