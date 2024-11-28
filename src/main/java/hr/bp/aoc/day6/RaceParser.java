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

        List<Long> times = getTimes(racesString.get(0));
        List<Long> distances = getDistances(racesString.get(1));

        for (int i = 0; i < times.size(); i++) {
            races.add(new Race(distances.get(i), times.get(i)));
        }

        return races;
    }

    private List<Long> getTimes(String timesString) {
        return getData(timesString);
    }

    private List<Long> getDistances(String distancesString) {
        return getData(distancesString);
    }

    private List<Long> getData(String potentialData) {
        List<Long> data = new ArrayList<>();

        if (!kerning) {
            for (String s : potentialData.split(":")[1].split(" ")) {
                if (!s.isEmpty()) {
                    data.add(Long.parseLong(s.strip()));
                }
            }
        } else {
            StringBuilder sb = new StringBuilder();
            for (String s : potentialData.split(":")[1].split(" ")) {
                if (!s.isEmpty()) {
                    sb.append(s);
                }
            }
            data.add(Long.parseLong(sb.toString()));
        }

        return data;
    }
}
