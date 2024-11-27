package hr.bp.aoc.day5;

import java.util.*;

public class AlmanacReader {
    private List<String> almanacString;
    private Almanac almanac;

    public AlmanacReader(List<String> almanacString) {
        this.almanacString = almanacString;
        this.almanac = new Almanac();
    }

    public Almanac parseAlmanac() {
        almanac.setSeeds(getAlmanacSeeds());
        almanac.setSeedsRange(getAlmanacSeedsRange());
        almanac.setSeedToSoil(getAlmanacMap(AlmanacMapEnum.SEED_SOIL));
        almanac.setSoilToFertilizer(getAlmanacMap(AlmanacMapEnum.SOIL_FERTILIZER));
        almanac.setFertilizerToWater(getAlmanacMap(AlmanacMapEnum.FERTILIZER_WATER));
        almanac.setWaterToLight(getAlmanacMap(AlmanacMapEnum.WATER_LIGHT));
        almanac.setLightToTemperature(getAlmanacMap(AlmanacMapEnum.LIGHT_TEMPERATURE));
        almanac.setTemperatureToHumidity(getAlmanacMap(AlmanacMapEnum.TEMPERATURE_HUMIDITY));
        almanac.setHumidityToLocation(getAlmanacMap(AlmanacMapEnum.HUMIDITY_LOCATION));

        return almanac;
    }

    private Map<Long, AlmanacMap> getAlmanacMap(AlmanacMapEnum enumKey) {
        Map<Long, AlmanacMap> almanacMap = new HashMap<>();
        int startIndex = almanacString.indexOf(enumKey.getStringValue());
        putMapToAlmanac(almanacMap, startIndex);

        return almanacMap;
    }

    private void putMapToAlmanac(Map<Long, AlmanacMap> almanacMap, int startIndex) {
        String mapToEnter = almanacString.get(startIndex+1);

        while(!mapToEnter.isEmpty() && startIndex+1 < almanacString.size()) {
            String[] mapInput = mapToEnter.split(" ");
            long source = Long.parseLong(mapInput[1]);
            long destination = Long.parseLong(mapInput[0]);
            long range = Long.parseLong(mapInput[2]);

            almanacMap.put(source, new AlmanacMap(source, destination, range));
            mapToEnter = almanacString.get(startIndex+1);
            startIndex++;
        }
    }
    
    private Map<Long, Long> getAlmanacSeedsRange() {
        String[] seeds = getSeedStrings();
        Map<Long, Long> seedRange = new HashMap<>();

        for (int i = 0; i < seeds.length; i+=2) {
            if (!seeds[i].isEmpty()) {
                long seedStart = Long.parseLong(seeds[i].trim());
                long range = Long.parseLong(seeds[i+1].trim());
                seedRange.put(seedStart, range);
            }
        }
        return seedRange;
    }

    private ArrayList<Long> getAlmanacSeeds() {
        String[] seeds = getSeedStrings();
        ArrayList<Long> seedList = new ArrayList<>();

        for (String seed : seeds) {
            if (!seed.isEmpty()) {
                long seedlong = Long.parseLong(seed.trim());
                seedList.add(seedlong);
            }
        }

        return seedList;
    }

    private String[] getSeedStrings() {
        List<String> seedString = new ArrayList<String>(Arrays.asList(almanacString.get(0).split(":")[1].split(" ")));
        seedString.removeAll(Arrays.asList("", null));

        return seedString.toArray(new String[0]);
    }

    public long getNearestLocation() {
        parseAlmanac();

        return almanac.getNearestLocation();
    }
}