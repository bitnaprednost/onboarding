package hr.bp.aoc.day5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Almanac {
    private ArrayList<Integer> seeds;
    private Map<Integer, AlmanacMap> seedToSoil;
    private Map<Integer, AlmanacMap> soilToFertilizer;
    private Map<Integer, AlmanacMap> fertilizerToWater;
    private Map<Integer, AlmanacMap> waterToLight;
    private Map<Integer, AlmanacMap> lightToTemperature;
    private Map<Integer, AlmanacMap> temperatureToHumidity;
    private Map<Integer, AlmanacMap> humidityToLocation;


    public Almanac() {
        seeds = new ArrayList<>();
        seedToSoil = new HashMap<>();
        soilToFertilizer = new HashMap<>();
        fertilizerToWater = new HashMap<>();
        waterToLight = new HashMap<>();
        lightToTemperature = new HashMap<>();
        temperatureToHumidity = new HashMap<>();
        humidityToLocation = new HashMap<>();
    }

    public int getNearestLocation() {
        ArrayList<Integer> allSeedLocations = getAllLocations();

        allSeedLocations.sort(Comparator.naturalOrder());

        return allSeedLocations.get(0);
    }

    private ArrayList<Integer> getAllLocations() {
        ArrayList<Integer> locations = new ArrayList<>();

        for (int seed : seeds) {
            locations.add(findSeedLocation(seed));
        }

        return locations;
    }

    private int findSeedLocation(int seed) {
        int soil = findDestination(seed, seedToSoil);
        int fertilizer = findDestination(soil, soilToFertilizer);
        int water = findDestination(fertilizer, fertilizerToWater);
        int light = findDestination(water, waterToLight);
        int temperature = findDestination(light, lightToTemperature);
        int humidity = findDestination(temperature, temperatureToHumidity);

        return findDestination(humidity, humidityToLocation);
    }

    private int findDestination(int source, Map<Integer, AlmanacMap> map) {
        AlmanacMap destinationMap = map.get(source);
        int destination = source;

        if (destinationMap != null) {
            destination = destinationMap.getDestinationStart();
        } else {
            for (int mapSoruce : map.keySet()) {
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

    public ArrayList<Integer> getSeeds() {
        return seeds;
    }

    public void setSeeds(ArrayList<Integer> seeds) {
        this.seeds = seeds;
    }

    public Map<Integer, AlmanacMap> getSeedToSoil() {
        return seedToSoil;
    }

    public void setSeedToSoil(Map<Integer, AlmanacMap> seedToSoil) {
        this.seedToSoil = seedToSoil;
    }

    public Map<Integer, AlmanacMap> getSoilToFertilizer() {
        return soilToFertilizer;
    }

    public void setSoilToFertilizer(Map<Integer, AlmanacMap> soilToFertilizer) {
        this.soilToFertilizer = soilToFertilizer;
    }

    public Map<Integer, AlmanacMap> getFertilizerToWater() {
        return fertilizerToWater;
    }

    public void setFertilizerToWater(Map<Integer, AlmanacMap> fertilizerToWater) {
        this.fertilizerToWater = fertilizerToWater;
    }

    public Map<Integer, AlmanacMap> getHumidityToLocation() {
        return humidityToLocation;
    }

    public void setHumidityToLocation(Map<Integer, AlmanacMap> humidityToLocation) {
        this.humidityToLocation = humidityToLocation;
    }

    public Map<Integer, AlmanacMap> getWaterToLight() {
        return waterToLight;
    }

    public void setWaterToLight(Map<Integer, AlmanacMap> waterToLight) {
        this.waterToLight = waterToLight;
    }

    public Map<Integer, AlmanacMap> getLightToTemperature() {
        return lightToTemperature;
    }

    public void setLightToTemperature(Map<Integer, AlmanacMap> lightToTemperature) {
        this.lightToTemperature = lightToTemperature;
    }

    public Map<Integer, AlmanacMap> getTemperatureToHumidity() {
        return temperatureToHumidity;
    }

    public void setTemperatureToHumidity(Map<Integer, AlmanacMap> temperatureToHumidity) {
        this.temperatureToHumidity = temperatureToHumidity;
    }
}