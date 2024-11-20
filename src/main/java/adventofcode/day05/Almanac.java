package adventofcode.day05;

import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class Almanac {

    private List<Integer> seeds;

    private List<SourceDestinationMap> seedToSoilMap;
    private List<SourceDestinationMap> soilToFertilizerMap;
    private List<SourceDestinationMap> fertilizerToWaterMap;
    private List<SourceDestinationMap> waterToLightMap;
    private List<SourceDestinationMap> lightToTemperatureMap;
    private List<SourceDestinationMap> temperatureToHumidityMap;
    private List<SourceDestinationMap> humidityToLocationMap;

    public Almanac(String input) {


    }

    public List<SourceDestinationMap> getTemperatureToHumidityMap() {
        return temperatureToHumidityMap;
    }

    public List<Integer> getSeeds() {
        return seeds;
    }

    public List<SourceDestinationMap> getSeedToSoilMap() {
        return seedToSoilMap;
    }

    public List<SourceDestinationMap> getSoilToFertilizerMap() {
        return soilToFertilizerMap;
    }

    public List<SourceDestinationMap> getFertilizerToWaterMap() {
        return fertilizerToWaterMap;
    }

    public List<SourceDestinationMap> getWaterToLightMap() {
        return waterToLightMap;
    }

    public List<SourceDestinationMap> getLightToTemperatureMap() {
        return lightToTemperatureMap;
    }

    public List<SourceDestinationMap> getHumidityToLocationMap() {
        return humidityToLocationMap;
    }
}
