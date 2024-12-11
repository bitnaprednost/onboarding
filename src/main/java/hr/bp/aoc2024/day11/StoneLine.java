package hr.bp.aoc2024.day11;

import java.util.ArrayList;
import java.util.List;

public class StoneLine {
    List<Stone> stoneLine;

    public StoneLine(List<String> stoneLineString) {
        this.stoneLine = createStoneLine(stoneLineString);
    }

    private List<Stone> createStoneLine(List<String> stoneLineString) {
        List<Stone> stoneLine = new ArrayList<>();

        stoneLineString.forEach(stoneString -> stoneLine.add(new Stone(Long.parseLong(stoneString))));

        return stoneLine;
    }

    public void blink(int numBlinks) {
        List<Stone> stoneLineAfterBlink = new ArrayList<>();

        for (int i = 0; i < numBlinks; i++) {
            stoneLine.forEach(stone -> stoneLineAfterBlink.addAll(stone.blink()));
            stoneLine = List.copyOf(stoneLineAfterBlink);
            stoneLineAfterBlink.clear();
        }
    }

    public List<Stone> getStoneLine() {
        return stoneLine;
    }

    public int getNumberOfStones() {
        return stoneLine.size();
    }
}
