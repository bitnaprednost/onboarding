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

    public void setSeedsRange(Map<Long, AlmanacMap> seedsRange) {
        this.seedsRange = seedsRange;
    }

    public ArrayList<Long> getSeeds() {
        return seeds;
    }

    public void setSeeds(ArrayList<Long> seeds) {
        this.seeds = seeds;
    }

    public Map<Long, AlmanacMap> getSeedToSoil() {
        return seedToSoil;
    }

    public void setSeedToSoil(Map<Long, AlmanacMap> seedToSoil) {
        this.seedToSoil = seedToSoil;
    }

    public Map<Long, AlmanacMap> getSoilToFertilizer() {
        return soilToFertilizer;
    }

    public void setSoilToFertilizer(Map<Long, AlmanacMap> soilToFertilizer) {
        this.soilToFertilizer = soilToFertilizer;
    }

    public Map<Long, AlmanacMap> getFertilizerToWater() {
        return fertilizerToWater;
    }

    public void setFertilizerToWater(Map<Long, AlmanacMap> fertilizerToWater) {
        this.fertilizerToWater = fertilizerToWater;
    }

    public Map<Long, AlmanacMap> getHumidityToLocation() {
        return humidityToLocation;
    }

    public void setHumidityToLocation(Map<Long, AlmanacMap> humidityToLocation) {
        this.humidityToLocation = humidityToLocation;
    }

    public Map<Long, AlmanacMap> getWaterToLight() {
        return waterToLight;
    }

    public void setWaterToLight(Map<Long, AlmanacMap> waterToLight) {
        this.waterToLight = waterToLight;
    }

    public Map<Long, AlmanacMap> getLightToTemperature() {
        return lightToTemperature;
    }

    public void setLightToTemperature(Map<Long, AlmanacMap> lightToTemperature) {
        this.lightToTemperature = lightToTemperature;
    }

    public Map<Long, AlmanacMap> getTemperatureToHumidity() {
        return temperatureToHumidity;
    }

    public void setTemperatureToHumidity(Map<Long, AlmanacMap> temperatureToHumidity) {
        this.temperatureToHumidity = temperatureToHumidity;
    }
}