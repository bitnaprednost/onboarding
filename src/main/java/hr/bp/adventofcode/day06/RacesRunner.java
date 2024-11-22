package hr.bp.adventofcode.day06;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class RacesRunner {

    private List<RaceRecord> raceRecords = new ArrayList<>();

    public RacesRunner(String input) {
        parseInput(input);
    }

    private void parseInput(String input) {
        String[] maximumTimes = input
                .split("\n")[0]
                .split(":")[1]
                .strip()
                .split("\\s+");

        String[] distanceRecords = input
                .split("\n")[1]
                .split(":")[1]
                .strip()
                .split("\\s+");

        for (int i = 0; i < maximumTimes.length; i++) {
            raceRecords.add(new RaceRecord(maximumTimes[i], distanceRecords[i]));
        }
    }

    public List<RaceRecord> getRaceRecords() {
        return raceRecords;
    }
}
