package hr.bp.aoc.day5;

public enum AlmanacMapEnum {
    SEED_SOIL("seed-to-soil map:"),
    SOIL_FERTILIZER("soil-to-fertilizer map:"),
    FERTILIZER_WATER("fertilizer-to-water map:"),
    WATER_LIGHT("water-to-light map:"),
    LIGHT_TEMPERATURE("light-to-temperature map:"),
    TEMPERATURE_HUMIDITY("temperature-to-humidity map:"),
    HUMIDITY_LOCATION("humidity-to-location map:");

    private final String stringValue;

    private AlmanacMapEnum(final String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}