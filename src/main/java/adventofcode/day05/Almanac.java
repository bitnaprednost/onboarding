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
        initializeSeedsAndMaps(input);
    }

    private void initializeSeedsAndMaps(String input) {
        String[] inputSections = input.split("\n\n");

        extractSeedValues(inputSections[0]);

        for (int i = 1; i < inputSections.length; i++) {
            createMapFromSection(inputSections[i]);
        }
    }

    private void createMapFromSection(String mapSection) {
        List<SourceDestinationMap> map = new ArrayList<>();

        String[] sourceDestinationLists = mapSection
                .split(":\n")[1].strip()
                .split("\n");

        for (String sourceDestinationLine : sourceDestinationLists) {
            map.add(SourceDestinationMap.createFromInputLine(sourceDestinationLine));
        }

        listOfMaps.add(map);
    }

    private void extractSeedValues(String seedsSection) {
        String[] seedNumbers = seedsSection.split(":")[1].strip().split("\\s+");
        Arrays.stream(seedNumbers)
                .forEach(
                        e -> seeds.add(Long.parseLong(e))
                );
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

    public long findLowestLocationNumberForTaskTwo() {
        long lowestLocationNumber = Long.MAX_VALUE;
        List<Long> newSeeds = expandSeedsForTaskTwo(seeds);
        for (Long seed : newSeeds) {
            long seedLocation = getSeedLocation(seed);
            if (seedLocation < lowestLocationNumber) {
                lowestLocationNumber = seedLocation;
            }
        }
        return lowestLocationNumber;
    }

    private List<Long> expandSeedsForTaskTwo(List<Long> seeds) {
        List<Long> expandedSeeds = new ArrayList<>();
        for (int i = 0; i < seeds.size(); i += 2) {
            long seedStart = seeds.get(i);
            long range = seeds.get(i + 1);
            for (long j = seedStart; j < seedStart + range; j++) {
                expandedSeeds.add(j);
            }
        }
        return expandedSeeds;
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

    public List<List<SourceDestinationMap>> getListOfMaps() {
        return listOfMaps;
    }

    public List<Long> getSeeds() {
        return seeds;
    }
}
