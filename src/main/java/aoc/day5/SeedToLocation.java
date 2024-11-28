package aoc.day5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SeedToLocation {

    public long seedToLocation(String seedsDocument, ArrayList<Long> seeds) {
        long minLocation = Long.MAX_VALUE;

        // Split the file content into lines
        String[] lines = seedsDocument.split(System.lineSeparator());

        // Parse all the maps
        List<LinkedList<long[]>> listOfMaps = parseMap(lines);

        // Perform transformations
        for (long seed : seeds)
        {
            long soil = transform(seed, listOfMaps.get(0));
            long fertilizer = transform(soil, listOfMaps.get(1));
            long water = transform(fertilizer, listOfMaps.get(2));
            long light = transform(water, listOfMaps.get(3));
            long temperature = transform(light, listOfMaps.get(4));
            long humidity = transform(temperature, listOfMaps.get(5));
            long location = transform(humidity, listOfMaps.get(6));
            minLocation = Math.min(minLocation, location);
        }

        return minLocation;
    }

    public long seedToLocationFromRanges(String seedsDocument, List<Range> seedRanges) {

        // Parse the document into maps
        String[] lines = seedsDocument.split(System.lineSeparator());
        List<LinkedList<long[]>> listOfMaps = parseMap(lines);

        List<Range> sourceRanges = new ArrayList<>();
        List<Range> destinationRanges = new ArrayList<>();

        for (List<long[]> map : listOfMaps)
        {
            for(long[] mapLongs : map)
            {
                sourceRanges.add(new Range(mapLongs[1], mapLongs[1] + mapLongs[2]));
                destinationRanges.add(new Range(mapLongs[0], mapLongs[0] + mapLongs[2]));
            }
            if (!sourceRanges.isEmpty()) {
                List<Range> updatedRanges = Range.mapRanges(seedRanges, sourceRanges, destinationRanges);
                seedRanges = updatedRanges;
            }
            // Reset for the next set of mappings
            sourceRanges.clear();
            destinationRanges.clear();

        }
        Optional<Range> minRange = seedRanges.stream()
                .min(Comparator.comparingLong(r -> r.start));


        return minRange.get().start;
    }


    // Parse all maps
    private List<LinkedList<long[]>> parseMap(String[] lines) {
        LinkedList<long[]> seedToSoil = createMap(lines, "seed-to-soil map:");
        LinkedList<long[]> soilToFertilizer = createMap(lines, "soil-to-fertilizer map:");
        LinkedList<long[]> fertilizerToWater = createMap(lines, "fertilizer-to-water map:");
        LinkedList<long[]> waterToLight = createMap(lines, "water-to-light map:");
        LinkedList<long[]> lightToTemperature = createMap(lines, "light-to-temperature map:");
        LinkedList<long[]> temperatureToHumidity = createMap(lines, "temperature-to-humidity map:");
        LinkedList<long[]> humidityToLocation = createMap(lines, "humidity-to-location map:");

        // Create a list of all maps
        return List.of(
                seedToSoil,
                soilToFertilizer,
                fertilizerToWater,
                waterToLight,
                lightToTemperature,
                temperatureToHumidity,
                humidityToLocation
        );
    }

    // Creates a map for each category based on the provided header
    private static LinkedList<long[]> createMap(String[] lines, String name) {
        LinkedList<long[]> map = new LinkedList<>();
        boolean isParsingMap = false;

        for (String line : lines)
        {
            if (line.trim().equals(name))
            {
                isParsingMap = true; // Start reading after encountering the section name
                continue;
            }

            if (isParsingMap)
            {
                if (line.trim().isEmpty() || line.contains("map:"))
                {
                    break; // Stop if an empty line or another map name is found
                }

                String[] parts = line.trim().split(" ");
                long destStart = Long.parseLong(parts[0]);
                long sourceStart = Long.parseLong(parts[1]);
                long rangeLength = Long.parseLong(parts[2]);
                map.add(new long[]{destStart, sourceStart, rangeLength});
            }
        }
        return map;
    }

    // Transforms a value based on the given map
    private static long transform(long value, LinkedList<long[]> map) {
        for (long[] range : map) {
            long destStart = range[0];
            long sourceStart = range[1];
            long rangeLength = range[2];

            if (value >= sourceStart && value < sourceStart + rangeLength)
            {
                return destStart + (value - sourceStart);
            }
        }
        return value; // If not mapped, it maps to itself
    }
}
