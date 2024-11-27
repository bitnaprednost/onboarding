package aoc.day5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SeedToLocation {

    public long seedToLocation(String seedsDocument, ArrayList<Long> seeds) {
        long minLocation = Long.MAX_VALUE;

        // Split the file content into lines
        String[] lines = seedsDocument.split(System.lineSeparator());

        // Parse all the maps
        LinkedList<long[]> seedToSoil = createMap(lines, "seed-to-soil map:");
        LinkedList<long[]> soilToFertilizer = createMap(lines, "soil-to-fertilizer map:");
        LinkedList<long[]> fertilizerToWater = createMap(lines, "fertilizer-to-water map:");
        LinkedList<long[]> waterToLight = createMap(lines, "water-to-light map:");
        LinkedList<long[]> lightToTemperature = createMap(lines, "light-to-temperature map:");
        LinkedList<long[]> temperatureToHumidity = createMap(lines, "temperature-to-humidity map:");
        LinkedList<long[]> humidityToLocation = createMap(lines, "humidity-to-location map:");

        // Perform transformations
        for (long seed : seeds)
        {
            long soil = transform(seed, seedToSoil);
            long fertilizer = transform(soil, soilToFertilizer);
            long water = transform(fertilizer, fertilizerToWater);
            long light = transform(water, waterToLight);
            long temperature = transform(light, lightToTemperature);
            long humidity = transform(temperature, temperatureToHumidity);
            long location = transform(humidity, humidityToLocation);
            minLocation = Math.min(minLocation, location);
        }

        return minLocation;
    }

    // Creates a map for each category based on the provided header
    private static LinkedList<long[]> createMap(String[] lines, String name) {
        LinkedList<long[]> map = new LinkedList<>();
        boolean isParsingMap = false;

        for (String line : lines)
        {
            if (line.trim().equals(name)) {
                isParsingMap = true; // Start reading after encountering the section name
                continue;
            }

            if (isParsingMap) {
                if (line.trim().isEmpty() || line.contains("map:")) {
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

            if (value >= sourceStart && value < sourceStart + rangeLength) {
                return destStart + (value - sourceStart);
            }
        }
        return value; // If not mapped, it maps to itself
    }
}
