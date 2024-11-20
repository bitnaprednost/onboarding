package adventofcode.day05;

import adventofcode.day04.Game;
import adventofcode.day04.Scratchcard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static adventofcode.day05.TestUtils.getInputOne;


/**
 * @author Ivan Tomičić
 */
public class AlmanacTest {
    @Test
    public void constructor_givenValidInput_createsAlmanacWithExpectedValues() {
        String input = getInputOne();

        Almanac almanac = new Almanac(input);

        assertAlmanacOneCreatedCorrectly(almanac);
    }


    private void assertAlmanacOneCreatedCorrectly(Almanac almanac) {
        List<Integer> expectedSeeds = List.of(79, 14, 55, 13);

        List<SourceDestinationMap> expectedSeedToSoilMap = List.of(
                new SourceDestinationMap(50, 98, 2),
                new SourceDestinationMap(52, 50, 48)
        );

        List<SourceDestinationMap> expectedSoilToFertilizerMap = List.of(
                new SourceDestinationMap(0, 15, 37),
                new SourceDestinationMap(37, 52, 2),
                new SourceDestinationMap(39, 0, 15)
        );

        List<SourceDestinationMap> expectedFertilizerToWaterMap = List.of(
                new SourceDestinationMap(49, 53, 8),
                new SourceDestinationMap(0, 11, 42),
                new SourceDestinationMap(42, 0, 7),
                new SourceDestinationMap(57, 7, 4)
        );

        List<SourceDestinationMap> expectedWaterToLightMap = List.of(
                new SourceDestinationMap(88, 18, 7),
                new SourceDestinationMap(18, 25, 70)
        );

        List<SourceDestinationMap> expectedLightToTemperatureMap = List.of(
                new SourceDestinationMap(45, 77, 23),
                new SourceDestinationMap(81, 45, 19),
                new SourceDestinationMap(68, 64, 13)
        );

        List<SourceDestinationMap> expectedTemperatureToHumidityMap = List.of(
                new SourceDestinationMap(0, 69, 1),
                new SourceDestinationMap(1, 0, 69)
        );

        List<SourceDestinationMap> expectedHumidityToLocationMap = List.of(
                new SourceDestinationMap(60, 56, 37),
                new SourceDestinationMap(56, 93, 4)
        );

        Assertions.assertEquals(expectedSeeds, almanac.getSeeds());
        Assertions.assertEquals(expectedSeedToSoilMap, almanac.getSeedToSoilMap());
        Assertions.assertEquals(expectedSoilToFertilizerMap, almanac.getSoilToFertilizerMap());
        Assertions.assertEquals(expectedFertilizerToWaterMap, almanac.getFertilizerToWaterMap());
        Assertions.assertEquals(expectedWaterToLightMap, almanac.getWaterToLightMa());
        Assertions.assertEquals(expectedLightToTemperatureMap, almanac.getLightToTemperatureMap());
        Assertions.assertEquals(expectedTemperatureToHumidityMap, almanac.getTemperatureToHumidityMap());
        Assertions.assertEquals(expectedHumidityToLocationMap, almanac.getHumidityToLocationMap());
    }
}
