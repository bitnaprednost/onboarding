package hr.bp.aoc.day5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Almanac {
    private ArrayList<Long> seeds;
    private Map<Long, AlmanacMap> seedsRange;
    private Map<Long, AlmanacMap> seedToSoil;
    private Map<Long, AlmanacMap> soilToFertilizer;
    private Map<Long, AlmanacMap> fertilizerToWater;
    private Map<Long, AlmanacMap> waterToLight;
    private Map<Long, AlmanacMap> lightToTemperature;
    private Map<Long, AlmanacMap> temperatureToHumidity;
    private Map<Long, AlmanacMap> humidityToLocation;


    public Almanac() {
        seeds = new ArrayList<>();
        seedsRange = new HashMap<>();
        seedToSoil = new HashMap<>();
        soilToFertilizer = new HashMap<>();
        fertilizerToWater = new HashMap<>();
        waterToLight = new HashMap<>();
        lightToTemperature = new HashMap<>();
        temperatureToHumidity = new HashMap<>();
        humidityToLocation = new HashMap<>();
    }

    public long getNearestLocation() {
        ArrayList<Long> allSeedLocations = getAllLocations();

        allSeedLocations.sort(Comparator.naturalOrder());

        return allSeedLocations.get(0);
    }

    private ArrayList<Long> getAllLocations() {
        ArrayList<Long> locations = new ArrayList<>();

        for (long seed : seeds) {
            locations.add(findSeedLocation(seed));
        }

        return locations;
    }

    private long findSeedLocation(long seed) {
        long soil = findDestination(seed, seedToSoil);
        long fertilizer = findDestination(soil, soilToFertilizer);
        long water = findDestination(fertilizer, fertilizerToWater);
        long light = findDestination(water, waterToLight);
        long temperature = findDestination(light, lightToTemperature);
        long humidity = findDestination(temperature, temperatureToHumidity);

        return findDestination(humidity, humidityToLocation);
    }

    private long findDestination(long source, Map<Long, AlmanacMap> map) {
        AlmanacMap destinationMap = map.get(source);
        long destination = source;

        if (destinationMap != null) {
            destination = destinationMap.getDestinationStart();
        } else {
            for (long mapSoruce : map.keySet()) {
                if (mapSoruce < source) {
                    destinationMap = map.get(mapSoruce);
                    if (destinationMap.getRange() >= source - mapSoruce) {
                        destination = destinationMap.getDestinationStart() + source - mapSoruce;
                    }
                }
            }
        }
        return destination;
    }

    public long findNearestLocationRange() {
        ArrayList<AlmanacMap> allLocations = getAllLocationsRange();

        return findMinLocation(allLocations);
    }

    private long findMinLocation(ArrayList<AlmanacMap> allLocations) {
        long min = Long.MAX_VALUE;

        for (AlmanacMap location : allLocations) {
            if (min > location.getSourceStart())
                min = location.getSourceStart();
        }

        return min;
    }

    private ArrayList<AlmanacMap> getAllLocationsRange() {
        ArrayList<AlmanacMap> locations = new ArrayList<>();

        for (Long seed : seedsRange.keySet()) {
            ArrayList<AlmanacMap> oneSeedLocations = findSeedLocationRange(seed);
            locations.addAll(oneSeedLocations);
        }

        return locations;
    }

    private ArrayList<AlmanacMap> findSeedLocationRange(Long seed) {
        AlmanacMap seedMap = seedsRange.get(seed);

        ArrayList<AlmanacMap> soilRanges = findDestinationRange(seedMap, seedToSoil);

        ArrayList<AlmanacMap> fertilizerRanges = getAlmanacMaps(soilRanges, soilToFertilizer);
        ArrayList<AlmanacMap> waterRanges = getAlmanacMaps(fertilizerRanges, fertilizerToWater);
        ArrayList<AlmanacMap> lightRanges = getAlmanacMaps(waterRanges, waterToLight);
        ArrayList<AlmanacMap> temperaturesRanges = getAlmanacMaps(lightRanges, lightToTemperature);
        ArrayList<AlmanacMap> humidityRanges = getAlmanacMaps(temperaturesRanges, temperatureToHumidity);
        return getAlmanacMaps(humidityRanges, humidityToLocation);
    }

    private ArrayList<AlmanacMap> getAlmanacMaps(ArrayList<AlmanacMap> ranges, Map<Long, AlmanacMap> mapper) {
        ArrayList<AlmanacMap> destRanges = new ArrayList<>();
        for (AlmanacMap source : ranges) {
            destRanges.addAll(findDestinationRange(source, mapper));
        }
        return destRanges;
    }

    private ArrayList<AlmanacMap> findDestinationRange(AlmanacMap sourceMap, Map<Long, AlmanacMap> map) {
        ArrayList<AlmanacMap> result = new ArrayList<>();

        for (Long mapSource : map.keySet()) {
            AlmanacMap currMap = map.get(mapSource);
            long destinationStart = -1;
            long range = -1;

            if (currMap.contains(sourceMap)) {
                destinationStart = sourceMap.getSourceStart() + currMap.getMapping();

                result.add(new AlmanacMap(destinationStart, 0, sourceMap.getRange()));
            } else if (isSourceRangeOnLeftSide(sourceMap, currMap)) {
                destinationStart = currMap.getDestinationStart();
                range = sourceMap.getSourceEnd() - currMap.getSourceStart();

                result.add(new AlmanacMap(destinationStart, 0, range));
                result.addAll(findDestinationRange(new AlmanacMap(sourceMap.getSourceStart(), 0,
                                sourceMap.getRange() - range),
                        map));
            } else if (isSourceRangeOnRightSide(sourceMap, currMap)) {
                destinationStart = sourceMap.getSourceStart() + currMap.getMapping();
                range = currMap.getSourceEnd() - sourceMap.getSourceStart();

                result.add(new AlmanacMap(destinationStart, 0, range));
                result.addAll(findDestinationRange(new AlmanacMap(currMap.getSourceEnd(), 0,
                                sourceMap.getRange() - range),
                        map));
            } else if (sourceMap.contains(currMap)) {
                result.add(new AlmanacMap(currMap.getDestinationStart(), 0, currMap.getRange()));
            }
        }
        if (result.isEmpty())
            result.add(sourceMap);

        return result;
    }

    private static boolean isSourceRangeOnRightSide(AlmanacMap sourceMap, AlmanacMap currMap) {
        return sourceMap.getSourceEnd() > currMap.getSourceEnd() &&
                sourceMap.getSourceStart() >= currMap.getSourceStart() &&
                sourceMap.getSourceStart() < currMap.getSourceEnd();
    }

    private static boolean isSourceRangeOnLeftSide(AlmanacMap sourceMap, AlmanacMap currMap) {
        return sourceMap.getSourceStart() < currMap.getSourceStart() &&
                sourceMap.getSourceEnd() > currMap.getSourceStart() &&
                sourceMap.getSourceEnd() <= currMap.getSourceEnd();
    }

    public void setSeedsRange(Map<Long, AlmanacMap> seedsRange) {
        this.seedsRange = seedsRange;
    }

    public void setSeeds(ArrayList<Long> seeds) {
        this.seeds = seeds;
    }

    public void setSeedToSoil(Map<Long, AlmanacMap> seedToSoil) {
        this.seedToSoil = seedToSoil;
    }

    public void setSoilToFertilizer(Map<Long, AlmanacMap> soilToFertilizer) {
        this.soilToFertilizer = soilToFertilizer;
    }

    public void setFertilizerToWater(Map<Long, AlmanacMap> fertilizerToWater) {
        this.fertilizerToWater = fertilizerToWater;
    }

    public void setHumidityToLocation(Map<Long, AlmanacMap> humidityToLocation) {
        this.humidityToLocation = humidityToLocation;
    }

    public void setWaterToLight(Map<Long, AlmanacMap> waterToLight) {
        this.waterToLight = waterToLight;
    }

    public void setLightToTemperature(Map<Long, AlmanacMap> lightToTemperature) {
        this.lightToTemperature = lightToTemperature;
    }

    public void setTemperatureToHumidity(Map<Long, AlmanacMap> temperatureToHumidity) {
        this.temperatureToHumidity = temperatureToHumidity;
    }
}