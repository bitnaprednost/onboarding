package hr.bp.aoc.day5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlmanacReader {
    private List<String> almanacString;
    private Almanac almanac;

    public AlmanacReader(List<String> almanacString) {
        this.almanacString = almanacString;
        this.almanac = new Almanac();
    }

    public Almanac parseAlmanac() {
        almanac.setSeeds(getAlmanacSeeds());
        almanac.setSeedToSoil(getAlmanacMap(AlmanacMapEnum.SEED_SOIL));
        almanac.setSoilToFertilizer(getAlmanacMap(AlmanacMapEnum.SOIL_FERTILIZER));
        almanac.setFertilizerToWater(getAlmanacMap(AlmanacMapEnum.FERTILIZER_WATER));
        almanac.setWaterToLight(getAlmanacMap(AlmanacMapEnum.WATER_LIGHT));
        almanac.setLightToTemperature(getAlmanacMap(AlmanacMapEnum.LIGHT_TEMPERATURE));
        almanac.setTemperatureToHumidity(getAlmanacMap(AlmanacMapEnum.TEMPERATURE_HUMIDITY));
        almanac.setHumidityToLocation(getAlmanacMap(AlmanacMapEnum.HUMIDITY_LOCATION));

        return almanac;
    }

    private Map<Integer, AlmanacMap> getAlmanacMap(AlmanacMapEnum enumKey) {
        Map<Integer, AlmanacMap> almanacMap = new HashMap<>();
        int startIndex = almanacString.indexOf(enumKey.getStringValue());
        putMapToAlmanac(almanacMap, startIndex);

        return almanacMap;
    }

    private void putMapToAlmanac(Map<Integer, AlmanacMap> almanacMap, int startIndex) {
        String mapToEnter = almanacString.get(startIndex+1);

        while(!mapToEnter.isEmpty() && startIndex+1 < almanacString.size()) {
            String[] mapInput = mapToEnter.split(" ");
            int source = Integer.parseInt(mapInput[1]);
            int destination = Integer.parseInt(mapInput[0]);
            int range = Integer.parseInt(mapInput[2]);

            almanacMap.put(source, new AlmanacMap(source, destination, range));
            mapToEnter = almanacString.get(startIndex+1);
            startIndex++;
        }
    }

    private ArrayList<Integer> getAlmanacSeeds() {
        String[] seeds = almanacString.get(0).split(":")[1].split(" ");
        ArrayList<Integer> seedList = new ArrayList<>();

        for (String seed : seeds) {
            if (!seed.isEmpty()) {
                int seedInt = Integer.parseInt(seed.trim());
                seedList.add(seedInt);
            }
        }

        return seedList;
    }

    public int getNearestLocation() {
        parseAlmanac();

        return almanac.getNearestLocation();
    }
}