package hr.bp.aoc.day6;

import java.util.ArrayList;
import java.util.List;

public class RaceParser {
    private final List<String> racesString;
    private boolean kerning;

    public RaceParser(List<String> racesString, boolean kerning) {
        this.racesString = racesString;
        this.kerning = kerning;
    }

    public List<Race> getRacesFromFile() {
        return parseRaceString();
    }

    private List<Race> parseRaceString() {
        List<Race> races = new ArrayList<>();

        List<Integer> times = getTimes(racesString.get(0));
        List<Integer> distances = getDistances(racesString.get(1));

        for (int i = 0; i < times.size(); i++) {
            races.add(new Race(distances.get(i), times.get(i)));
        }

        return races;
    }

    private List<Integer> getTimes(String timesString) {
        return getData(timesString);
    }

    private List<Integer> getDistances(String distancesString) {
        return getData(distancesString);
    }

    private List<Integer> getData(String potentialData) {
        List<Integer> data = new ArrayList<>();

        if (!kerning) {
            for (String s : potentialData.split(":")[1].split(" ")) {
                if (!s.isEmpty()) {
                    data.add(Integer.parseInt(s.strip()));
                }
            }
        } else {
            StringBuilder sb = new StringBuilder();
            for (String s : potentialData.split(":")[1].split(" ")) {
                if (!s.isEmpty()) {
                    sb.append(s);
                }
            }
            data.add(Integer.parseInt(sb.toString()));
        }

        return data;
    }
}
