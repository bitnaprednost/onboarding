package hr.bp.aoc2024.day11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StoneLine {
    private static final Logger log = LoggerFactory.getLogger(StoneLine.class);

    HashMap<Stone, HashMap<Integer, Long>> memo = new HashMap<>();

    List<Stone> stoneLine;
    private long numberOfStones = 0;
    private int numOfBlinks;

    public StoneLine(List<String> stoneLineString) {
        this.stoneLine = createStoneLine(stoneLineString);
    }

    private List<Stone> createStoneLine(List<String> stoneLineString) {
        List<Stone> stoneLine = new ArrayList<>();

        stoneLineString.forEach(stoneString -> stoneLine.add(new Stone(Long.parseLong(stoneString))));

        return stoneLine;
    }

    public void blink(int numBlinks) {
        numOfBlinks = numBlinks;

        for (Stone stone : stoneLine) {
            blinkHelper(stone, 0);
        }
    }

    private void blinkHelper(Stone stone, int count) {
        if (isStoneInMemo(stone, count)) {
            numberOfStones += memo.get(stone).get(count);
            return;
        }

        if (count == numOfBlinks) {
            numberOfStones++;
            addStoneToMemo(stone, count, 1L);
            return;
        }

        long numberOfStonesBeforeBlinking = numberOfStones;
        Stone stoneBeforeBlinking = new Stone(stone.getNumber());

        Stone rightStone = stone.blink();
        if (rightStone != null) {
            blinkHelper(rightStone, count + 1);
        }
        blinkHelper(stone, count + 1);

        long stonesAddedAfterBlinking = numberOfStones - numberOfStonesBeforeBlinking;
        addStoneToMemo(stoneBeforeBlinking, count, stonesAddedAfterBlinking);
    }

    private void addStoneToMemo(Stone stone, int count, long value) {
        memo.putIfAbsent(stone, new HashMap<>());
        memo.get(stone).put(count, value);
    }

    private boolean isStoneInMemo(Stone stone, int count) {
        return memo.containsKey(stone) && memo.get(stone).containsKey(count);
    }

    public long getNumberOfStones() {
        return numberOfStones;
    }

    @Override
    public String toString() {
        return "StoneLine{" + "stoneLine=" + stoneLine + '}';
    }
}
