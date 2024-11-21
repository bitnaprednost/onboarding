package adventofcode.day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @author Ivan Tomičić
 */
public class Almanac {

    private List<Long> seeds = new ArrayList<>();

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
                        e -> seeds.add(Long.parseLong(e))
                );
    }

    public List<List<SourceDestinationMap>> getListOfMaps() {
        return listOfMaps;
    }

    public List<Long> getSeeds() {
        return seeds;
    }

    public long findLowestLocationNumber() {
        long lowestLocationNumber = Long.MAX_VALUE;
        for (Long seed : seeds) {
            long seedLocation = getSeedLocation(seed);
            if (seedLocation < lowestLocationNumber) {
                lowestLocationNumber = seedLocation;
            }
        }
        return lowestLocationNumber;
    }

    private long getSeedLocation(Long seed) {
        return processMap(0, seed);
    }

    private long processMap(int mapIndex, long sourceNumber) {
        List<SourceDestinationMap> currentMap = listOfMaps.get(mapIndex);
        long destinationNumber = getDestinationNumberForSource(currentMap, sourceNumber);
        if (mapIndex == listOfMaps.size() - 1) {
            return destinationNumber;
        }
        return processMap(++mapIndex, destinationNumber);
    }

    private long getDestinationNumberForSource(List<SourceDestinationMap> currentMap, long sourceNumber) {
        for (SourceDestinationMap mapping : currentMap) {
            Optional<Long> destinationNumber = findMappedDestination(sourceNumber, mapping);
            if (destinationNumber.isPresent()) {
                return destinationNumber.get();
            }
        }
        return sourceNumber;
    }

    private Optional<Long> findMappedDestination(long sourceNumber, SourceDestinationMap mapping) {
        if ((mapping.sourceStart() <= sourceNumber)
                && mapping.sourceStart() + mapping.rangeLength() > sourceNumber) {
            return Optional.of(mapping.destinationStart() + sourceNumber - mapping.sourceStart());
        }
        return Optional.empty();
    }
}
