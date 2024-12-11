package hr.bp.aoc2024.day11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class StoneLine {
    private static final Logger log = LoggerFactory.getLogger(StoneLine.class);

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

        log.debug("StoneLine before blink {} ", stoneLine);

        for (int i = 0; i < numBlinks; i++) {
            stoneLine.forEach(stone -> stoneLineAfterBlink.addAll(stone.blink()));
            stoneLine = List.copyOf(stoneLineAfterBlink);
            stoneLineAfterBlink.clear();

            log.debug("StoneLine after blink {} ", stoneLine);
        }
    }

    public List<Stone> getStoneLine() {
        return stoneLine;
    }

    public int getNumberOfStones() {
        return stoneLine.size();
    }

    @Override
    public String toString() {
        return "StoneLine{" +
                "stoneLine=" + stoneLine +
                '}';
    }
}
