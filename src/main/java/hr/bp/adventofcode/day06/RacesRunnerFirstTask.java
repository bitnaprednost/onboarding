package hr.bp.adventofcode.day06;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class RacesRunnerFirstTask {

    private List<Race> races = new ArrayList<>();

    public RacesRunnerFirstTask(String input) {
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
            races.add(new Race(new RaceRecord(maximumTimes[i], distanceRecords[i])));
        }
    }

    public List<Race> getRacess() {
        return races;
    }

    public long multiplyResultsOfAllRaces() {
        long multiplication = 1;
        for (Race race : races) {
            multiplication *= race.calculateWaysToWinARace();
        }
        return multiplication;
    }
}
