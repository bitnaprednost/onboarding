package adventofcode.day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class Almanac {

    private List<Integer> seeds = new ArrayList<>();

    private List<List<SourceDestinationMap>> listOfMaps = new LinkedList<>();

    public Almanac(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Input cannot be null or blank");
        }
        setSeedsAndMapsFromInput(input);
    }

    private void setSeedsAndMapsFromInput(String input) {
        String[] inputSections = input.split("\n\n");

        parseSeedsInput(inputSections[0]);

        for (int i = 1; i < inputSections.length; i++) {
            parseMap(inputSections[i]);
        }
        System.out.println(listOfMaps);
    }

    private void parseMap(String mapSection) {
        List<SourceDestinationMap> map = new ArrayList<>();

        String[] sourceDestinationLists = mapSection
                .split(":\n")[1].strip()
                .split("\n");

        for (String sourceDestinationLine : sourceDestinationLists) {
            map.add(SourceDestinationMap.createFromInputLine(sourceDestinationLine));
        }

        listOfMaps.add(map);
    }

    private void parseSeedsInput(String seedsSection) {
        String[] seedNumbers = seedsSection.split(":")[1].strip().split("\\s+");
        Arrays.stream(seedNumbers)
                .forEach(
                        e -> seeds.add(Integer.parseInt(e))
                );
    }

    public List<List<SourceDestinationMap>> getListOfMaps() {
        return listOfMaps;
    }

    public List<Integer> getSeeds() {
        return seeds;
    }
}
